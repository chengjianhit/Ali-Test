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




    @Override
    public String toString() {
        return "AllocationSupplyResult{" +
                "fundPoolId=" + fundPoolId +
                ", preAllocationShotfalls=" + preAllocationShotfalls +
                ", allocationShotfalls=" + allocationShotfalls +
                ", afterAllocationShotfalls=" + afterAllocationShotfalls +
                '}';
    }
}
