package com.gu.common.exception;

public class BusinessException extends RuntimeException{
    /*** 错误编码 ***/
    private Integer errorCode;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
