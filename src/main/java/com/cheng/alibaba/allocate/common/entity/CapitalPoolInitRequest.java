package com.cheng.alibaba.allocate.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;


@ApiModel("商家请求资金池初始化")
public class CapitalPoolInitRequest implements Serializable {


    private static final long serialVersionUID = -1L;

    @ApiModelProperty("商家Id")
    private String merchantId;

    @ApiModelProperty("资金池大小")
    private Integer poolSize;

    @ApiModelProperty("资金池生成策略")
    private Integer poolGenStrategy;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }

    public Integer getPoolGenStrategy() {
        return poolGenStrategy;
    }

    public void setPoolGenStrategy(Integer poolGenStrategy) {
        this.poolGenStrategy = poolGenStrategy;
    }

    @Override
    public String toString() {
        return "CapitalPoolInitRequest{" +
                "merchantId='" + merchantId + '\'' +
                ", poolSize=" + poolSize +
                ", poolGenStrategy=" + poolGenStrategy +
                '}';
    }
}
