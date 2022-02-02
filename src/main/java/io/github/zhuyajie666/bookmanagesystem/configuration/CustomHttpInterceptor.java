package io.github.zhuyajie666.bookmanagesystem.configuration;

import io.github.zhuyajie666.bookmanagesystem.component.TokenManager;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.exception.AppException;
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
        String token = request.getHeader("token");
        if(token == null) {
            throw new AppException(ResponseCode.NOT_YET_LOGIN);
        }
        Manager manager = tokenManager.getByToken(token);
        if(manager == null) {
            throw new AppException(ResponseCode.NOT_YET_LOGIN);
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
