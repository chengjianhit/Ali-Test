package com.cheng.alibaba.allocate.strategy;

import com.cheng.alibaba.allocate.common.exception.BaseException;

import java.util.List;

public interface AllocateStrategy<T> {

    void capitalAllocate(List<T> capticalPool, int target) throws BaseException;
}
