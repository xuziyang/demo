package com.xzy.spring.aop.aspectj;


public class NaiveWaiter implements Waiter {
    
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter:greet to " + clientName + "...");
    }
    
    @Override
    public void serveTo(String clientName) {
        System.out.println("NaiveWaiter:serve to " + clientName + "...");
    }
}
