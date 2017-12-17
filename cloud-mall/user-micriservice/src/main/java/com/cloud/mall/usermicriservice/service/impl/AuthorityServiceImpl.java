package com.cloud.mall.usermicriservice.service.impl;

import com.cloud.mall.usermicriservice.dao.IAuthorityDao;
import com.cloud.mall.usermicriservice.dto.AuthorityReqDTO;
import com.cloud.mall.usermicriservice.dto.AuthorityRespDTO;
import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.dto.MenuRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import com.cloud.mall.usermicriservice.model.Authority;
import com.cloud.mall.usermicriservice.model.vo.AuthorityVO;
import com.cloud.mall.usermicriservice.service.AuthorityService;
import com.cloud.mall.usermicriservice.utils.EmptyChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Jon_China
 * @create 2017/11/18
 */
@Service(value = "authorityService")
public class AuthorityServiceImpl implements AuthorityService {


    @Autowired
    private IAuthorityDao authorityDao;

    @Override
    public BaseRespDTO saveAuthority(AuthorityReqDTO request) {
        request.setId(UUID.randomUUID().toString());
        int row = this.authorityDao.addAuthority(request);
        if(1 == row){
            return new BaseRespDTO();
        }
        return new BaseRespDTO(ResultCode.FAIL);
    }

    /**
     * 获取系统所有菜单信息
     *
     * @param appName 系统名称
     * @return
     */
    @Override
    public MenuRespDTO getAllMenus(String appName) {
        AuthorityReqDTO reqDTO = new AuthorityReqDTO();
        reqDTO.setAppName(appName);
        MenuRespDTO baseRespDTO = new MenuRespDTO();
        buildMenus(baseRespDTO,this.authorityDao.getAllAuthorities(reqDTO));
        return baseRespDTO;
    }

    /**
     * 构造菜单树
     * @param respDTO
     * @param items
     */
    private void buildMenus(MenuRespDTO respDTO, List<Authority> items){
        if(EmptyChecker.isEmpty(items)){
            return;
        }
        List<AuthorityVO> resultData = new ArrayList<>();
        items.forEach(i -> {
            AuthorityVO authorityVO = new AuthorityVO();
            authorityVO.setItem(i);
            //过滤出child
            authorityVO.setChild(items.stream()
                    .filter(s -> s.getParentId().equals(i.getId()))
                    .collect(Collectors.toList()));
            resultData.add(authorityVO);
        });
        respDTO.setResultData(resultData);
    }
}
