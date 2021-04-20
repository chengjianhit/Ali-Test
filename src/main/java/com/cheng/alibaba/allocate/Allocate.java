package com.cheng.alibaba.allocate;

import com.cheng.alibaba.allocate.strategy.AllocateStrategy;

import java.util.*;

public class Allocate {

    public void allocate(List<AllocationSupplyResult> list, int target, AllocateStrategy allocateStrategy){

        allocateStrategy.capitalAllocate(list, target);

    }
}
