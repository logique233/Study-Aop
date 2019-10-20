package com.example.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAdviceTest {
    @After(value="execution(* com.example.service.*.afterAdvice*(..))")
    public void releaseResource() {
        System.out.println("模拟释放数据库连接");
    }
}
