package com.cheng.alibaba.allocate.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AllocateAnnotation {

    String allocateName() default "";

    int allocateIndex() default 1;
}
