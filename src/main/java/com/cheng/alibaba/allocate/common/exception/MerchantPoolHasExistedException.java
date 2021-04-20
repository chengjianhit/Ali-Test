package com.cheng.alibaba.allocate.common.exception;

public class MerchantPoolHasExistedException extends BaseException{
    public MerchantPoolHasExistedException(String retCode, String message) {
        super(retCode, message);
    }

    public MerchantPoolHasExistedException(){
        super(AllExceptionCode.MERCHANT_HAS_EXISTED_CODE, AllExceptionCode.getErrorMsgByCode(AllExceptionCode.MERCHANT_HAS_EXISTED_CODE));
    }
}
