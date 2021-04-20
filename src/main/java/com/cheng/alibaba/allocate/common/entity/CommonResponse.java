package com.cheng.alibaba.allocate.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "通用响应类")
public class CommonResponse<T> {

    private static final long serialVersionUID = -9147109334321575942L;

    @ApiModelProperty(value = "响应码")
    private String               code;

    @ApiModelProperty(value = "响应消息")
    private String            msg;

    @ApiModelProperty(value = "响应数据")
    private T                 data;

    /**
     * 只有当data1为列表时，count才有值
     */
    @ApiModelProperty(value = "列表总数")
    private int               count;

    public static int         succ_code        = 0;

    public CommonResponse(){
    }

    public CommonResponse(String code, String msg){
        this(code, msg, null);
    }

    public CommonResponse(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static CommonResponse error() {
        return error("500", "系统错误");
    }

    public static CommonResponse error(String msg) {
        return error("500", msg);
    }

    public static CommonResponse error(Object data, String code, String msg) {
        CommonResponse r = new CommonResponse();
        r.code = code;
        r.msg = msg;
        r.data = data;
        return r;
    }

    public static CommonResponse error(String code, String msg) {
        CommonResponse r = new CommonResponse();
        r.code = code;
        r.msg = msg;
        return r;
    }

    public static CommonResponse ok(String msg) {
        CommonResponse r = new CommonResponse();
        r.code = "0";
        r.msg = msg;
        return r;
    }

    public static CommonResponse success(Object data) {
        CommonResponse r = new CommonResponse();
        r.code = "0";
        r.msg = "成功";
        r.data = data;
        return r;
    }

    public static CommonResponse success(Object data, Integer count) {
        CommonResponse r = new CommonResponse();
        r.code = "0";
        r.msg = "成功";
        r.data = data;
        r.count = count;
        return r;
    }

    public static CommonResponse success(Object data, String msg) {
        CommonResponse r = new CommonResponse();
        r.code = "0";
        r.msg = msg;
        r.data = data;
        return r;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int getSucc_code() {
        return succ_code;
    }

    public static void setSucc_code(int succ_code) {
        CommonResponse.succ_code = succ_code;
    }
}
