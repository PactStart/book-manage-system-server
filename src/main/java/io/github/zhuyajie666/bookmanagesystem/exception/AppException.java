package io.github.zhuyajie666.bookmanagesystem.exception;

import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;

public class AppException extends RuntimeException{

    private ResponseCode responseCode;

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(ResponseCode responseCode) {
        super(responseCode.getMessage(), null);
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
