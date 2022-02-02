package io.github.zhuyajie666.bookmanagesystem.configuration;

import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.exception.AppException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(AppException.class)
    public Object appExceptionHandler(AppException appException) {
        if(appException.getResponseCode() == null) {
            return ResponseCode.SYSTEM_BUSY;
        } else {
            return appException.getResponseCode();
        }
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception exception) {
        return new ResponseCode<>(ResponseCode.SYSTEM_BUSY.getCode(),exception.getMessage());
    }
}
