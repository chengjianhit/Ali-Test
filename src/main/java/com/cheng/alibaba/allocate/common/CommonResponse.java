package com.cheng.alibaba.allocate.common;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "通用响应类")
public class CommonResponse<T> {

    private static final long serialVersionUID = -9147109334321575942L;

    @ApiModelProperty(value = "响应码")
    private int code;

    @ApiModelProperty(value = "响应消息")
    private String msg;

    @ApiModelProperty(value = "响应数据")
    private T data;

    /**
     * 只有当data为列表时，count才有值
     */
    @ApiModelProperty(value = "列表总数")
    private int count;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                '}';
    }

    public CommonResponse() {
    }

    public CommonResponse(int code, String msg) {
        this(code, msg, null);
    }

    public CommonResponse(int code,  T data) {
        this(code, null, data);
    }
    public CommonResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static CommonResponse error() {
        return error(500, "系统错误");
    }

    public static CommonResponse error(String msg) {
        return error(500, msg);
    }



    public static CommonResponse error(CommonResponse commonResponse,String msg) {
        commonResponse.setMsg(msg);
        return commonResponse;
    }

    public static CommonResponse error(Object data, int code, String msg) {
        CommonResponse r = new CommonResponse();
        r.code = code;
        r.msg = msg;
        r.data = data;
        return r;
    }

    public static CommonResponse error(Object data) {
        CommonResponse r = new CommonResponse();
        r.code = 500;
        r.msg = "failed";
        r.data = data;
        return r;
    }

    public static CommonResponse error(int code, String msg) {
        CommonResponse r = new CommonResponse();
        r.code = code;
        r.msg = msg;
        return r;
    }

    public static CommonResponse ok(String msg) {
        CommonResponse r = new CommonResponse();
        r.code = 0;
        r.msg = msg;
        return r;
    }

    public static CommonResponse success(Object data) {
        CommonResponse r = new CommonResponse();
        r.code = 0;
        r.msg = "成功";
        r.data = data;
        return r;
    }

    public static CommonResponse success(Object data, Integer count) {
        CommonResponse r = new CommonResponse();
        r.code = 0;
        r.msg = "成功";
        r.data = data;
        r.count = count;
        return r;
    }

    public static CommonResponse success(Object data, String msg) {
        CommonResponse r = new CommonResponse();
        r.code = 0;
        r.msg = msg;
        r.data = data;
        return r;
    }

    public static CommonResponse forward(int code ,Object data, String msg) {
        CommonResponse r = new CommonResponse();
        r.code = code;
        r.msg = msg;
        r.data = data;
        return r;
    }


}
