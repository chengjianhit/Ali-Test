package com.cheng.alibaba.allocate.common.exception;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AllExceptionCode {


    /**
     * 错误异常码
     *  AliCPT001
     *  总长度为8位，前五位表示系统，例如 AliCPT;后三位表示具体系统业务异常
     *  */
    public  static  String SYSYEM_ERRCODE_PREFIX = "AliCPT";

    /**
     * 未知异常
     */
    public static String UNKNOWN_ERROR_CODE = SYSYEM_ERRCODE_PREFIX.concat("001");



    /**
     * 进程关闭，服务不可用异常
     */
    public static String SHUTDOWN_CODE = SYSYEM_ERRCODE_PREFIX.concat("100");

    /**
     * 业务异常
     */
    public static String TARGET_UNVALID_CODE = SYSYEM_ERRCODE_PREFIX.concat("201");

    public static String CAPITAL_POOR_CODE = SYSYEM_ERRCODE_PREFIX.concat("202");

    public static String MERCHANT_NOT_EXISTED_CODE = SYSYEM_ERRCODE_PREFIX.concat("203");

    public static String MERCHANT_HAS_EXISTED_CODE = SYSYEM_ERRCODE_PREFIX.concat("204");





    public static Map<String, String> codeMsgMap = new ConcurrentHashMap<>(16);

    static {
        codeMsgMap.put(SHUTDOWN_CODE, "Service Stop!");

        codeMsgMap.put(TARGET_UNVALID_CODE, "支出金额不合理，金额值应大于0!");

        codeMsgMap.put(CAPITAL_POOR_CODE, "资金池存在负金额，无法进行扣减!");

        codeMsgMap.put(MERCHANT_NOT_EXISTED_CODE, "对应的商家不存在，或者merchantId非法!");

        codeMsgMap.put(MERCHANT_HAS_EXISTED_CODE, "商家资金池已经存在，请勿重复初始化");




    }



    public static String getErrorMsgByCode(String code){
        return codeMsgMap.getOrDefault(code, "Undefined Error");
    }

}