package com.cheng.alibaba.allocate.common.exception;

public class CapitalPoorException extends BaseException{
    public CapitalPoorException(String retCode, String message) {
        super(retCode, message);
    }

    public CapitalPoorException(){
        super(AllExceptionCode.CAPITAL_POOR_CODE, AllExceptionCode.getErrorMsgByCode(AllExceptionCode.CAPITAL_POOR_CODE));
    }
}
