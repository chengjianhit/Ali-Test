package com.cheng.alibaba.strategy;

import java.util.List;

public interface AllocateStrategy<T> {

    void capitalAllocate(List<T> capticalPool, int target);
}