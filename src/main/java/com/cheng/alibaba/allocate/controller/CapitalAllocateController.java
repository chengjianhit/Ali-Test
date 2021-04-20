package com.cheng.alibaba.allocate.controller;


import com.alibaba.fastjson.JSON;
import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import com.cheng.alibaba.allocate.common.entity.CapitalPayRequest;
import com.cheng.alibaba.allocate.common.entity.CapitalPoolInitRequest;
import com.cheng.alibaba.allocate.common.entity.CommonResponse;
import com.cheng.alibaba.allocate.common.exception.BaseException;
import com.cheng.alibaba.allocate.facade.CapitalPoolFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class CapitalAllocateController {

    private Logger log = LoggerFactory.getLogger(CapitalAllocateController.class);

    @Autowired
    private CapitalPoolFacade capitalPoolFacade;

    @RequestMapping(value = "/initPool", method = RequestMethod.POST)
    @ApiOperation("商家初始化资金池")
    public CommonResponse<List<AllocationSupplyResult>> initCapital(@RequestBody CapitalPoolInitRequest capitalPoolInitRequest){
        CommonResponse<List<AllocationSupplyResult>> response = null;
        try{
            log.info("initCapital param is {}", JSON.toJSONString(capitalPoolInitRequest));
            List<AllocationSupplyResult> poolList = capitalPoolFacade.init(capitalPoolInitRequest);
            return CommonResponse.success(poolList, poolList.size());
        }catch (BaseException e){
            log.error("initCapital error {}", e.message);
            return CommonResponse.error(e.retCode, e.message);
        }
    }


    @RequestMapping(value = "/capitalPay", method = RequestMethod.POST)
    @ApiOperation("商家支出资金")
    public CommonResponse<List<AllocationSupplyResult>> capitalPay(@RequestBody CapitalPayRequest capitalPayRequest){
        CommonResponse<List<AllocationSupplyResult>> response = null;
        try{
            log.info("capitalPay param is {}", JSON.toJSONString(capitalPayRequest));
            List<AllocationSupplyResult> poolList = capitalPoolFacade.allocateCapital(capitalPayRequest);
            return CommonResponse.success(poolList, poolList.size());
        }catch (BaseException e){
            log.error("capitalPay error {}", e.message);
            return CommonResponse.error(e.retCode, e.message);
        }
    }

    @RequestMapping(value = "/queryCapitalPool", method = RequestMethod.GET)
    @ApiOperation("商家查看资金池")
    public CommonResponse<List<AllocationSupplyResult>> queryCapitalPool(@RequestParam @ApiParam("商家Id") String merchantId){
        CommonResponse<List<AllocationSupplyResult>> response = null;
        try{
            log.info("queryCapitalPool param is {}", merchantId);
            List<AllocationSupplyResult> poolList = capitalPoolFacade.findMerchantCapitalPool(merchantId);
            return CommonResponse.success(poolList, poolList.size());
        }catch (BaseException e){
            log.error("queryCapitalPool error {}", e.message);
            return CommonResponse.error(e.retCode, e.message);
        }
    }

}
