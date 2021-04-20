package com.cheng.alibaba.allocate.strategy;

import java.util.List;

public interface CapitalPoolGenStrategy<T> {

    List<T> capitalPoolGen(int poolSize);
}
