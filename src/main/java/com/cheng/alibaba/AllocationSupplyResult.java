package com.cheng.alibaba;


import java.util.ArrayList;
import java.util.List;

public class AllocationSupplyResult {

    //资金池标示
    public int fundPoolId = 0;
    //支出前
    public int preAllocationShotfalls;

    //支出数量
    public int allocationShotfalls;

    //支出后
    public  int afterAllocationShotfalls;

    public AllocationSupplyResult(int preAllocationShotfalls, int fundPoolId){
        this.fundPoolId = fundPoolId;
        this.preAllocationShotfalls = preAllocationShotfalls;
        this.afterAllocationShotfalls = preAllocationShotfalls;
    }


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
        List<AllocationSupplyResult> afterList = allocate.allocate(list, 15);

        System.out.println(afterList.toArray());
    }

}
