package com.cheng.alibaba.allocate.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CapitalPoolGenAnnotation {

    String captinalGenName() default "";

    int captinalGenIndex() default 1;
}
