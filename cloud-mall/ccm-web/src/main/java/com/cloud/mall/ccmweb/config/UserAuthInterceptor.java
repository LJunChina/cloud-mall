package com.cloud.mall.ccmweb.config;

import com.cloud.mall.ccmweb.utils.Constant;
import com.cloud.mall.ccmweb.dto.BaseRespDTO;
import com.cloud.mall.ccmweb.enums.ResultCode;
import com.cloud.mall.ccmweb.utils.EmptyChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

/**
 * 登录权限拦截器
 *
 * @author Jon_China
 * @create 2017/11/11
 */
@Component
public class UserAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(EmptyChecker.isEmpty(cookies)){
            return false;
        }
        String tokenId;
        Cookie tokenCookie = Stream.of(cookies).filter(c -> "tokenId".equals(c.getName())).findFirst().orElse(null);
        if(EmptyChecker.isEmpty(tokenCookie)){
            return false;
        }
        tokenId = tokenCookie.getValue();
        if(EmptyChecker.isEmpty(tokenId)){
            return false;
        }
        //查询token是否有效
        BaseRespDTO respDTO = this.restTemplate.getForEntity(Constant.CHECK_TOKEN,BaseRespDTO.class,tokenId).getBody();
        if(ResultCode.OK.getCode().equals(respDTO.getCode())){
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
