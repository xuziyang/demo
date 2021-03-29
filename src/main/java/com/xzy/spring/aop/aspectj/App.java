package com.xzy.spring.aop.aspectj;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.cglib.core.DebuggingClassWriter;

public class App {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/xuziyang/code/learning/temp/demo/code");
        
        NaiveWaiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        
        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);
        factory.setProxyTargetClass(true);
        
        Waiter proxy = factory.getProxy(App.class.getClassLoader());
        proxy.greetTo("John");
        proxy.serveTo("John");
    }
}
