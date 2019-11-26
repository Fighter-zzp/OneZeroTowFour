package com.travel.one.four.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.one.four.domain.TUser;
import com.travel.one.four.utils.Msg;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor  implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var admin = (TUser)request.getSession().getAttribute("admin");
        if (admin!=null && admin.getIsAdmin()){
//            logger.info("合法登录");
            return true;
        }
//        logger.info("非法登录");
        response.setContentType("application/json;charset=utf-8");
        var om = new ObjectMapper();
        String json = om.writeValueAsString(Msg.fail());
        response.getWriter().write(json);
        return false;
    }
}
