package com.cheng.alibaba.allocate.facade;

import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import com.cheng.alibaba.allocate.strategy.AllocateStrategy;
import com.cheng.alibaba.allocate.strategy.CapitalPoolGenStrategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CapitalPoolFacade {

    private List<AllocationSupplyResult> list;

    public void init(CapitalPoolGenStrategy capitalPoolGenStrategy, int poolSize){
         list = capitalPoolGenStrategy.capitalPoolGen(poolSize);
    }

    public  void allocateShotfalls(int shotfalls, AllocateStrategy allocateStrategy) throws Exception {
        synchronized(this){
            allocateStrategy.capitalAllocate(list, shotfalls);
        }

    }

    public int getPoolSize(){
        return 0;
    }

    public int getTotalShotfalls(){
        AtomicInteger cnt = new AtomicInteger();
        synchronized (this){
            list.stream().parallel().forEach(e ->
            {
                cnt.getAndAdd(e.allocationShotfalls);
            });

        }
        return cnt.intValue();
    }

}
