package com.cheng.alibaba.allocate.strategy;

import com.cheng.alibaba.allocate.common.annotation.AllocateAnnotation;
import com.cheng.alibaba.allocate.common.annotation.CapitalPoolGenAnnotation;
import com.google.common.collect.Collections2;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StrategyLoader implements ApplicationContextAware, ApplicationListener<ApplicationEvent> {

    private ApplicationContext applicationContext;

    private Map<Integer, AllocateStrategy> allocateStrategyMap = new ConcurrentHashMap<>();

    private Map<Integer, CapitalPoolGenStrategy> capitalPoolGenStrategyMap = new ConcurrentHashMap<>();


    public AllocateStrategy getAllocateStrategyByIndex(int index){
        return allocateStrategyMap.get(index);
    }

    public CapitalPoolGenStrategy getCapitalPoolGenStrategy(int index){
        return capitalPoolGenStrategyMap.get(index);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent){
            Map<String, AllocateStrategy> allocateMap = applicationContext.getBeansOfType(AllocateStrategy.class);
            Map<String, CapitalPoolGenStrategy> capitalStrategyMap = applicationContext.getBeansOfType(CapitalPoolGenStrategy.class);
            if (!CollectionUtils.isEmpty(allocateMap)){
                for (Map.Entry<String, AllocateStrategy> entry:allocateMap.entrySet()){
                    AllocateStrategy value = entry.getValue();
                    AllocateAnnotation annotation = value.getClass().getAnnotation(AllocateAnnotation.class);
                    if (annotation != null){
                        allocateStrategyMap.put(annotation.allocateIndex(), value);
                    }

                }
            }

            if (!CollectionUtils.isEmpty(capitalStrategyMap)){
                for (Map.Entry<String, CapitalPoolGenStrategy> entry:capitalStrategyMap.entrySet()){
                    CapitalPoolGenStrategy value = entry.getValue();
                    CapitalPoolGenAnnotation annotation = value.getClass().getAnnotation(CapitalPoolGenAnnotation.class);
                    if (annotation != null){
                        capitalPoolGenStrategyMap.put(annotation.captinalGenIndex(), value);
                    }
                }
            }
        }

    }
}
