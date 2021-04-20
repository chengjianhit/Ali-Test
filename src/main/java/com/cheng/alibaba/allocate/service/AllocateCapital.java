package com.cheng.alibaba.allocate.service;

import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import com.cheng.alibaba.allocate.common.exception.BaseException;
import com.cheng.alibaba.allocate.common.exception.CapitalPoorException;
import com.cheng.alibaba.allocate.common.exception.UnvalidTargetException;
import com.cheng.alibaba.allocate.strategy.AllocateStrategy;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AllocateCapital {

    public List<AllocationSupplyResult> allocate(List<AllocationSupplyResult> list, int target, AllocateStrategy allocateStrategy) throws BaseException {
        this.allocateCheck(list, target);
        allocateStrategy.capitalAllocate(list, target);
        return list;

    }

    private void allocateCheck(List<AllocationSupplyResult> list, int target) throws BaseException {
        if (target <= 0){
            throw new UnvalidTargetException();
        }
        //如果存在资金池金额数为负的，则不允许继续分配
        boolean present = list.stream().filter(e -> e.preAllocationShotfalls < 0).findAny().isPresent();
        if (present){
            throw new CapitalPoorException();
        }
    }
}
