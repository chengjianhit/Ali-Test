package com.cheng.alibaba.allocate.capital;

import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import com.cheng.alibaba.allocate.common.exception.MerchantNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CapitalPoolWrapper {

    private static Map<String, List<AllocationSupplyResult>> capitalMap = new ConcurrentHashMap<>();


    public static List<AllocationSupplyResult> getCapitalPool(String merchantId){
        if (!capitalMap.containsKey(merchantId)){
            throw new MerchantNotFoundException();
        }else {
            return capitalMap.get(merchantId);
        }
    }

    public static boolean judgeMerchantPoolExisted(String merchantId){
        return capitalMap.containsKey(merchantId);
    }

    public static void addCapitalPool(String merchantId, List<AllocationSupplyResult> capitalPool){
       capitalMap.put(merchantId, capitalPool);
    }
}
