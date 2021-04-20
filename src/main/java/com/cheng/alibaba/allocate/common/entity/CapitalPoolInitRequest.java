package com.cheng.alibaba.allocate.common.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;

public class CapitalPoolInitRequest implements Serializable {


    private static final long serialVersionUID = -1L;

    @ApiModelProperty("商家Id")
    private String merchantId;

    @ApiModelProperty("资金池大小")
    private Integer poolSize;

    @ApiModelProperty("资金池生成策略")
    private Integer poolGenStrategy;
}
