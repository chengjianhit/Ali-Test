package com.cheng.alibaba.allocate.common.exception;



public class BaseException extends RuntimeException {

    public String retCode;

    public String message;

    public BaseException(String retCode, String message) {
        super(message);
        this.retCode = retCode;
        this.message = message;
    }

    public BaseException(String message, Throwable e){
        super(message, e);
    }


}
