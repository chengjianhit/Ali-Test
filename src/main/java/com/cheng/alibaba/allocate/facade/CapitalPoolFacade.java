package com.cheng.alibaba.allocate.facade;

import com.cheng.alibaba.allocate.capital.CapitalPoolWrapper;
import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import com.cheng.alibaba.allocate.common.entity.CapitalPayRequest;
import com.cheng.alibaba.allocate.common.entity.CapitalPoolInitRequest;
import com.cheng.alibaba.allocate.common.exception.BaseException;
import com.cheng.alibaba.allocate.common.exception.MerchantPoolHasExistedException;
import com.cheng.alibaba.allocate.service.AllocateCapital;
import com.cheng.alibaba.allocate.strategy.AllocateStrategy;
import com.cheng.alibaba.allocate.strategy.CapitalPoolGenStrategy;
import com.cheng.alibaba.allocate.strategy.StrategyLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CapitalPoolFacade {

    private static final String CAPITAL_INIT = "AliCapitalInit";

    private static final String CAPITAL_ALLOCATE = "AliCapitalAllocate";


    @Autowired
    private StrategyLoader strategyLoader;

    @Autowired
    private AllocateCapital allocateCapital;


    public List<AllocationSupplyResult> init(CapitalPoolInitRequest capitalPoolInitRequest){

        List<AllocationSupplyResult> list;
        if (CapitalPoolWrapper.judgeMerchantPoolExisted(capitalPoolInitRequest.getMerchantId())){
            throw new MerchantPoolHasExistedException();
        }
        //加本地同步锁
        synchronized (CAPITAL_INIT.concat(capitalPoolInitRequest.getMerchantId().intern())) {
            CapitalPoolGenStrategy capitalPoolGenStrategy = strategyLoader.getCapitalPoolGenStrategy(capitalPoolInitRequest.getPoolGenStrategy());
            list = capitalPoolGenStrategy.capitalPoolGen(capitalPoolInitRequest.getPoolSize());
            CapitalPoolWrapper.addCapitalPool(capitalPoolInitRequest.getMerchantId(), list);
        }

        return list;
    }

    public  List<AllocationSupplyResult> allocateCapital(CapitalPayRequest capitalPayRequest) throws BaseException {
        /**
         * 如果进行多次分配资金，是否应该每次分配前将 afterAllocationShotfalls置位
         */
        List<AllocationSupplyResult> allocate = null;
        synchronized(CAPITAL_ALLOCATE.concat(capitalPayRequest.getMerchantId().intern())){
            AllocateStrategy allocateStrategy = strategyLoader.getAllocateStrategyByIndex(capitalPayRequest.getAllocateStrategy());
            List<AllocationSupplyResult> capitalPool = CapitalPoolWrapper.getCapitalPool(capitalPayRequest.getMerchantId());
            allocate = allocateCapital.allocate(capitalPool, capitalPayRequest.getPayCount(), allocateStrategy);
        }
        return allocate;
    }


    public int getCapitalRemainTotal(String merchantId){
        List<AllocationSupplyResult> capitalPool = CapitalPoolWrapper.getCapitalPool(merchantId);
        int sum= capitalPool.stream().mapToInt(item -> item.preAllocationShotfalls).sum();
        return sum;
    }

    public List<AllocationSupplyResult> findMerchantCapitalPool(String merchantId) {
        return CapitalPoolWrapper.getCapitalPool(merchantId);
    }
}
