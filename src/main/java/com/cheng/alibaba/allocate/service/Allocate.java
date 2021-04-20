package com.cheng.alibaba.allocate.service;

import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import com.cheng.alibaba.allocate.strategy.AllocateStrategy;

import java.util.*;

public class Allocate {

    public void allocate(List<AllocationSupplyResult> list, int target, AllocateStrategy allocateStrategy) throws Exception {

        allocateStrategy.capitalAllocate(list, target);

    }
}
