package com.cheng.alibaba.allocate.strategy;

import com.cheng.alibaba.allocate.common.entity.AllocationSupplyResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MinDifferenceStrategy implements AllocateStrategy<AllocationSupplyResult> {

    /**
     * MinDifferenceStrategy
     * 说明：
     * （1）当需要支出的金额超过资金池总金额时：
     *       i）先将所有的资金（preAllocationShotfalls）全部扣完，则afterAllocationShotfalls为0
     *       ii）将剩下需要扣减的金额均分到所有资金池里，余数可分配给前几个资金池
     *
     * （2）当需要支出的金额不超过资金池总金额时
     *      首先对资金池里面的资金进行排序，为了使得“资金池之间的差额达到最小”，意味着每个资金池被扣减后，按照剩余的资金大小进行排序时，
     *      尽量接近，在坐标上来看的话，起伏不要太大、排序后的话，整体值向中间靠拢。
     *
     *      i）找到最大值和中间值的差值sub，对最大值扣减sub;
     *     ii）如果中间值和最大值大小一样，则寻找次大值和最大值的差值，进行扣减；
     *    iii）如果资金池里面的元素大小都一样，则将需要扣减的资金均摊到每个资金池
     *   iiii）	重复上述步骤，每一步扣减时，对目标金额进行对应扣减，直到需要被扣减的金额为0
     */

    @Override
    public void capitalAllocate(List<AllocationSupplyResult> capticalPool, int target) {
        AtomicInteger total = new AtomicInteger();
        capticalPool.stream().forEach(e ->{
            total.getAndAdd(e.preAllocationShotfalls);
        });
        AtomicInteger sum = new AtomicInteger(target);
        //超额了，所有金额和都小于需要扣减的金额
        if (sum.intValue() > total.intValue()){
            doAllocate1(capticalPool, target);
        }else {
            doAllocate2(capticalPool, target);
        }
    }



    public void doAllocate1(List<AllocationSupplyResult> capticalPool, int target) {
        LinkedList<AllocationSupplyResult> linkedList = new LinkedList<>();
        linkedList.addAll(new ArrayList<>(capticalPool));
        AtomicInteger total = new AtomicInteger();
        capticalPool.stream().forEach(e ->{
            total.getAndAdd(e.preAllocationShotfalls);
        });
        AtomicInteger sum = new AtomicInteger(target);
        //先把所有的资金池金额归零
        sum.getAndSet(sum.intValue() - total.intValue());
        capticalPool.stream().forEach(e->{
            e.allocationShotfalls = e.preAllocationShotfalls;
            e.afterAllocationShotfalls -= e.allocationShotfalls;
        });


        int perCost = sum.intValue()/linkedList.size();
        int plus = sum.intValue()%linkedList.size();
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



        return;

        }



    public void doAllocate2(List<AllocationSupplyResult> capticalPool, int target){
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
