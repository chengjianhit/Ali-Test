package com.cheng.alibaba;

import com.cheng.alibaba.strategy.AllocateStrategy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Allocate {

    public void allocate(List<AllocationSupplyResult> list, int target, AllocateStrategy allocateStrategy){

        allocateStrategy.capitalAllocate(list, target);

    }
}
