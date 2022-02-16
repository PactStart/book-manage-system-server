package io.github.zhuyajie666.bookmanagesystem.configuration;

import com.alibaba.fastjson.JSON;
import io.github.zhuyajie666.bookmanagesystem.component.TokenManager;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.exception.AppException;
import io.github.zhuyajie666.bookmanagesystem.vo.ManagerVo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomHttpInterceptor implements HandlerInterceptor {

    private TokenManager tokenManager;

    public CustomHttpInterceptor(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!request.getRequestURI().equals("/manager/login")) {
            String token = request.getHeader("token");
            if(token == null) {
                response.getWriter().write(JSON.toJSONString(ResponseCode.NOT_YET_LOGIN));
                return false;
            }
            ManagerVo manager = tokenManager.getByToken(token);
            if(manager == null) {
                response.getWriter().write(JSON.toJSONString(ResponseCode.NOT_YET_LOGIN));
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
