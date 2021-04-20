package com.cheng.alibaba.allocate.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel("商家请求支出资金")
public class CapitalPayRequest implements Serializable {


    private static final long serialVersionUID = -1L;

    @ApiModelProperty("商家Id")
    private String merchantId;

    @ApiModelProperty("要求支出的资金金额")
    private Integer payCount;

    @ApiModelProperty("资金支出分配策略")
    private Integer allocateStrategy;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getPayCount() {
        return payCount;
    }

    public void setPayCount(Integer payCount) {
        this.payCount = payCount;
    }

    public Integer getAllocateStrategy() {
        return allocateStrategy;
    }

    public void setAllocateStrategy(Integer allocateStrategy) {
        this.allocateStrategy = allocateStrategy;
    }

    @Override
    public String toString() {
        return "CapitalPayRequest{" +
                "merchantId='" + merchantId + '\'' +
                ", payCount=" + payCount +
                ", allocateStrategy=" + allocateStrategy +
                '}';
    }
}
