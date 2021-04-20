package com.cheng.alibaba.allocate.common.entity;


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


    public int getFundPoolId() {
        return fundPoolId;
    }

    public void setFundPoolId(int fundPoolId) {
        this.fundPoolId = fundPoolId;
    }

    public int getPreAllocationShotfalls() {
        return preAllocationShotfalls;
    }

    public void setPreAllocationShotfalls(int preAllocationShotfalls) {
        this.preAllocationShotfalls = preAllocationShotfalls;
    }

    public int getAllocationShotfalls() {
        return allocationShotfalls;
    }

    public void setAllocationShotfalls(int allocationShotfalls) {
        this.allocationShotfalls = allocationShotfalls;
    }

    public int getAfterAllocationShotfalls() {
        return afterAllocationShotfalls;
    }

    public void setAfterAllocationShotfalls(int afterAllocationShotfalls) {
        this.afterAllocationShotfalls = afterAllocationShotfalls;
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
