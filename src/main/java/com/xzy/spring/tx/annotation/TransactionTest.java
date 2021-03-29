package com.xzy.spring.tx.annotation;

import com.xzy.spring.tx.annotation.config.TransactionConfig;
import com.xzy.spring.tx.annotation.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionTest {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TransactionConfig.class);
        applicationContext.refresh();
        BookService bean = applicationContext.getBean(BookService.class);
        bean.checkout("zhangsan",1);
    }
}
