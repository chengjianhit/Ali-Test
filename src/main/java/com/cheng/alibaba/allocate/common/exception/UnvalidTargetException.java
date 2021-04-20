package com.cheng.alibaba.allocate.common.exception;

public class UnvalidTargetException extends BaseException{
    public UnvalidTargetException(String retCode, String message) {
        super(retCode, message);
    }

    public UnvalidTargetException(){
        super(AllExceptionCode.TARGET_UNVALID_CODE, AllExceptionCode.getErrorMsgByCode(AllExceptionCode.TARGET_UNVALID_CODE));
    }
}
