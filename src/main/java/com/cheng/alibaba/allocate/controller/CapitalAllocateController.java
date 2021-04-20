package com.cheng.alibaba.allocate.controller;


import com.cheng.alibaba.allocate.common.CommonResponse;
import com.cheng.alibaba.allocate.common.entity.CapitalPoolInitRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class CapitalAllocateController {

    @RequestMapping(value = "/initPool", method = RequestMethod.POST)
    @ApiOperation("商家初始化资金池")
    public CommonResponse<Boolean> initCapital(@RequestBody CapitalPoolInitRequest capitalPoolInitRequest){

        return CommonResponse.success(Boolean.TRUE);
    }

}
