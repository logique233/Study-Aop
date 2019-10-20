package com.example.demo;

import com.example.service.AdviceManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import java.util.Date;

@ComponentScan(basePackages = {"com.example.service", "com.example.advice"})
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        AdviceManager manager = context.getBean(AdviceManager.class);
        manager.beforeAdvice();
        System.out.println("\n");
        manager.afterReturning();
        System.out.println("\n");
        manager.afterAdvice();
        System.out.println("\n");
        manager.aroundAdvice("123",123,new char[]{'a'});
        System.out.println("\n");
        manager.manyAdvices("hello","world");
        System.out.println("\n");
        manager.accessAdvice(new Date(),"world");
    }

}
