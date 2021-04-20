package com.cheng.alibaba.allocate.strategy;

import com.cheng.alibaba.allocate.common.annotation.CapitalPoolGenAnnotation;
import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@CapitalPoolGenAnnotation(captinalGenName = "randomCapitalPoolGenStrategy", captinalGenIndex = 1)
public class RandomCapitalPoolGenStrategy implements CapitalPoolGenStrategy<AllocationSupplyResult>{

    public static final Integer MAX_VALUE = 100;


    @Override
    public List<AllocationSupplyResult> capitalPoolGen(int poolSize) {
        List<AllocationSupplyResult> list=new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        for (int i=0;i<poolSize;i++){
            list.add(new AllocationSupplyResult(random.nextInt(MAX_VALUE),i));
        }
        return list;
    }
}
