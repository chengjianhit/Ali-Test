package com.cheng.alibaba.allocate.common.exception;

public class MerchantNotFoundException extends BaseException{
    public MerchantNotFoundException(String retCode, String message) {
        super(retCode, message);
    }

    public MerchantNotFoundException(){
        super(AllExceptionCode.MERCHANT_NOT_EXISTED_CODE, AllExceptionCode.getErrorMsgByCode(AllExceptionCode.MERCHANT_NOT_EXISTED_CODE));
    }
}
