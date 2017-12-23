package com.cloud.mall.ccmweb.config;

import com.alibaba.fastjson.JSONObject;
import com.cloud.mall.ccmweb.dto.BaseRespDTO;
import com.cloud.mall.ccmweb.exception.UserAuthException;
import com.cloud.mall.ccmweb.model.LoginUser;
import com.cloud.mall.ccmweb.model.TokenInfo;
import com.cloud.mall.ccmweb.utils.Constant;
import com.cloud.mall.ccmweb.enums.ResultCode;
import com.cloud.mall.ccmweb.utils.EmptyChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * 登录权限拦截器
 *
 * @author Jon_China
 * @create 2017/11/11
 */
@Component
public class UserAuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthInterceptor.class);
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader("X-Requested-With");
        response.setCharacterEncoding("UTF-8");
        String jsonResult = new BaseRespDTO(ResultCode.LOGIN_EFFICACY).toString();
        boolean isAjax;
        isAjax = "XMLHttpRequest".equals(header);
        Cookie[] cookies = request.getCookies();
        if(EmptyChecker.isEmpty(cookies)){
            redirect(response,isAjax,jsonResult);
            return false;
        }
        String tokenId;
        Cookie tokenCookie = Stream.of(cookies).filter(c -> "tokenId".equals(c.getName())).findFirst().orElse(null);
        if(EmptyChecker.isEmpty(tokenCookie)){
            redirect(response,isAjax,jsonResult);
            return false;
        }
        tokenId = tokenCookie.getValue();
        if(EmptyChecker.isEmpty(tokenId)){
            redirect(response,isAjax,jsonResult);
            return false;
        }
        //查询token是否有效
        String result = this.restTemplate.getForEntity(Constant.CHECK_TOKEN,String.class,tokenId).getBody();
        JSONObject object = JSONObject.parseObject(result);
        if(ResultCode.OK.getCode().equals(object.getString("code"))){
            logger.info("token result : {}",result);
            TokenInfo tokenInfo = JSONObject.parseObject(object.getString("data"),TokenInfo.class);
            //存储用户登录上下文
            LoginUser loginUser = new LoginUser();
            loginUser.setUserId(tokenInfo.getUserId());
            //查询用户信息
            String userStr = this.restTemplate.getForEntity(Constant.GET_USER_INFO_BY_ID,String.class,loginUser.getUserId()).getBody();
            JSONObject userObject = JSONObject.parseObject(userStr);
            String tokenStr = userObject.getJSONObject("data").getString("loginToken");
            if(!tokenStr.equals(tokenId)){
                redirect(response,isAjax,jsonResult);
                return false;
            }
            LoginUserContext.addLoginUserContext(loginUser);
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

    /**
     * 检查token是否有效
     * @param response
     * @param isAjax
     * @param jsonResult
     * @return
     */
    private void redirect(HttpServletResponse response,boolean isAjax,String jsonResult) throws IOException{
        logger.info("user login already disabled");
        if(isAjax){
            response.getWriter().write(jsonResult);
            return;
        }
        response.sendRedirect("/login.html");
    }
}
