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

public class AllocateCapitalTest extends AliCapitalApplicationTest{

    @Autowired
    private MinDifferenceStrategy minDifferenceStrategy;


    List<AllocationSupplyResult> list = new ArrayList<>();

    List<AllocationSupplyResult> list2 = new ArrayList<>();

    List<AllocationSupplyResult> list3 = new ArrayList<>();


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

        list2.add( new AllocationSupplyResult(20,0));
        list2.add( new AllocationSupplyResult(47,1));
        list2.add( new AllocationSupplyResult(21,2));
        list2.add( new AllocationSupplyResult(41,3));
        list2.add( new AllocationSupplyResult(29,4));
        list2.add( new AllocationSupplyResult(9,5));
        list2.add( new AllocationSupplyResult(76,6));
        list2.add( new AllocationSupplyResult(97,7));
        list2.add( new AllocationSupplyResult(29,8));
        list2.add( new AllocationSupplyResult(66,9));
        list2.add( new AllocationSupplyResult(60,10));
        list2.add( new AllocationSupplyResult(92,11));
        list2.add( new AllocationSupplyResult(94,12));
        list2.add( new AllocationSupplyResult(27,13));
        list2.add( new AllocationSupplyResult(43,14));
        list2.add( new AllocationSupplyResult(75,15));
        list2.add( new AllocationSupplyResult(41,16));
        list2.add( new AllocationSupplyResult(74,17));
        list2.add( new AllocationSupplyResult(64,18));
        list2.add( new AllocationSupplyResult(61,19));





    }



    @Test
    public void allocate() {
        minDifferenceStrategy.capitalAllocate(list, 0);
        minDifferenceStrategy.capitalAllocate(list2,50000);
        System.out.println(JSON.toJSONString(list2));
        System.out.println(JSON.toJSONString(list));
    }
}