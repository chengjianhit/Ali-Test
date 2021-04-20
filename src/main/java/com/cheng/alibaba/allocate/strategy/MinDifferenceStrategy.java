package com.cheng.alibaba.allocate.strategy;

import com.cheng.alibaba.allocate.AllocationSupplyResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MinDifferenceStrategy implements AllocateStrategy<AllocationSupplyResult> {


    @Override
    public void capitalAllocate(List<AllocationSupplyResult> capticalPool, int target) {
        LinkedList<AllocationSupplyResult> linkedList = new LinkedList<>();


        linkedList.addAll(new ArrayList<>(capticalPool));
        AtomicInteger sum = new AtomicInteger(target);
        int midIdx = (capticalPool.size()/2);
        while(sum.get() != 0){
            Collections.sort(linkedList, (item1, item2) ->
                    (item1.afterAllocationShotfalls - item2.afterAllocationShotfalls));
            AllocationSupplyResult maxItem = linkedList.getLast();

            AllocationSupplyResult midItem = linkedList.get(midIdx);

            int sub = maxItem.afterAllocationShotfalls - midItem.afterAllocationShotfalls;

            if (sub != 0){
                sum.getAndSet(sum.intValue() - sub);
                maxItem.afterAllocationShotfalls -=sub;
                maxItem.allocationShotfalls +=sub;
            }else{
                //判断数组是不是全部相等
                if(linkedList.get(0).afterAllocationShotfalls == maxItem.afterAllocationShotfalls){
                    //如果全部相等
                    int perCost = target/linkedList.size();
                    int plus = target%linkedList.size();
                    linkedList.stream().forEach(item ->{
                        item.afterAllocationShotfalls -=perCost;
                        sum.getAndSet(sum.intValue() - perCost);
                        item.allocationShotfalls +=perCost;
                    });
                    for (int i=0;i<plus;i++){
                        linkedList.get(i).afterAllocationShotfalls -= 1;
                        linkedList.get(i).afterAllocationShotfalls +=1;
                        sum.getAndDecrement();
                    }
                }else{
                    //从mid位置往左找，找到第二小的值
                    for (int i=midIdx;i>=0;i--){
                        if (maxItem.afterAllocationShotfalls > linkedList.get(i).afterAllocationShotfalls){
                            sub = maxItem.afterAllocationShotfalls - linkedList.get(i).afterAllocationShotfalls;
                            maxItem.afterAllocationShotfalls -= sub;
                            maxItem.allocationShotfalls +=sub;
                            sum.getAndSet(sum.intValue() - sub);
                            break;
                        }
                    }
                }
            }





        }

        Collections.sort(linkedList, (item1, item2) ->
                (item1.fundPoolId - item2.fundPoolId));
        return;
    }
}
