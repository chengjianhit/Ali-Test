package com.cheng.alibaba.allocate.service;

import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import com.cheng.alibaba.allocate.strategy.AllocateStrategy;

import java.util.*;

public class AllocateCapital {

    public void allocate(List<AllocationSupplyResult> list, int target, AllocateStrategy allocateStrategy) throws Exception {
        if (target <= 0){
            throw new Exception("支出金额不合理，金额值应大于0");
        }
        allocateStrategy.capitalAllocate(list, target);

    }
}
