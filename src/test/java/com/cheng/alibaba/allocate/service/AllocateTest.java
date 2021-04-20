package com.cheng.alibaba.allocate.service;

import com.alibaba.fastjson.JSON;
import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import com.cheng.alibaba.allocate.strategy.MinDifferenceStrategy;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AllocateTest extends AliCapitalApplicationTest{

    @Autowired
    private MinDifferenceStrategy minDifferenceStrategy;


    List<AllocationSupplyResult> list = new ArrayList<>();

    @Before
    public void capitalPool(){
        list.add( new AllocationSupplyResult(1,1));
        list.add( new AllocationSupplyResult(2,2));
        list.add( new AllocationSupplyResult(3,3));
        list.add( new AllocationSupplyResult(4,4));
        list.add( new AllocationSupplyResult(5,5));
        list.add( new AllocationSupplyResult(6,6));
        list.add( new AllocationSupplyResult(7,7));
        list.add( new AllocationSupplyResult(8,8));
        list.add( new AllocationSupplyResult(9,9));
        list.add( new AllocationSupplyResult(10,10));
    }



    @Test
    public void allocate() {
        minDifferenceStrategy.capitalAllocate(list, 15);
        System.out.println(JSON.toJSONString(list));
    }
}