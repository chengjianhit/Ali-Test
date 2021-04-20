package com.cheng.alibaba.allocate.controller;


import com.cheng.alibaba.allocate.capital.CapitalPoolWrapper;
import com.cheng.alibaba.allocate.common.CommonResponse;
import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import com.cheng.alibaba.allocate.common.entity.CapitalPayRequest;
import com.cheng.alibaba.allocate.common.entity.CapitalPoolInitRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class CapitalAllocateController {

    @RequestMapping(value = "/initPool", method = RequestMethod.POST)
    @ApiOperation("商家初始化资金池")
    public CommonResponse<Boolean> initCapital(@RequestBody CapitalPoolInitRequest capitalPoolInitRequest){

        return CommonResponse.success(Boolean.TRUE);
    }


    @RequestMapping(value = "/capitalPay", method = RequestMethod.POST)
    @ApiOperation("商家支出资金")
    public CommonResponse<Boolean> capitalPay(@RequestBody CapitalPayRequest capitalPayRequest){
        List<AllocationSupplyResult> capitalPool = CapitalPoolWrapper.getCapitalPool(capitalPayRequest.getMerchantId());
        synchronized ("4r235234".intern()){

        }
        return CommonResponse.success(Boolean.TRUE);
    }

    @RequestMapping(value = "/queryCapitalPool", method = RequestMethod.GET)
    @ApiOperation("商家查看资金池")
    public CommonResponse<Boolean> queryCapitalPool(@RequestParam @ApiParam("商家Id") String merchant){

        return CommonResponse.success(Boolean.TRUE);
    }

}
