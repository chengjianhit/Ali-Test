package com.cheng.alibaba;

import com.cheng.alibaba.strategy.MinDifferenceStrategy;

import java.util.ArrayList;
import java.util.List;

public class CapitalPoolAllocateValidation {

    public static void main(String[] args) {
        List<AllocationSupplyResult> list = new ArrayList<>();

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

        Allocate allocate = new Allocate();
        allocate.allocate(list, 15, new MinDifferenceStrategy());

        list.stream().forEach(e -> {
            System.out.println(e.toString());
        });
    }
}
