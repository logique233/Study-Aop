# Sytudy-Aop
Spring-boot 框架 aop 原理学习

#### 依赖

```xml
<dependencies>		
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter</artifactId>
	</dependency>

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-aop</artifactId>
	</dependency>
</dependencies>
```



#### 运行结果

```java
   .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.0.RELEASE)


模拟权限检查
方法: beforeAdviceTest


方法：afterReturning
2019-10-20 15:23:40.005  INFO 17638 --- [           main] org.aspectj.weaver.ast.Test              : 方法：afterReturning
目标方法返回值：afterReturning方法
模拟日志记录功能...


方法： afterAdvice
模拟释放数据库连接


模拟执行目标方法前的增强处理：事务开始...
拦截的方法： com.example.service.AdviceManager.aroundAdvice
参数： [123, 123, [C@47f4e407]
方法： aroundAdvice
模拟执行目标方法后的增强处理：事务结束...


@Around：执行目标方法之前...
@Before：模拟权限检查...
@Before：目标方法为：com.example.service.AdviceManager.manyAdvices
@Before：参数为：[改变后的参数1, world]
@Before：被织入的目标对象为：com.example.service.AdviceManager@2d1dee39
方法：manyAdvices
@Around：执行目标方法之后...
@Around：被织入的目标对象为：com.example.service.AdviceManager@2d1dee39
@After：模拟释放资源...
@After：目标方法为：com.example.service.AdviceManager.manyAdvices
@After：参数为：[改变后的参数1, world]
@After：被织入的目标对象为：com.example.service.AdviceManager@2d1dee39
@AfterReturning：模拟日志记录功能...
@AfterReturning：目标方法为：com.example.service.AdviceManager.manyAdvices
@AfterReturning：参数为：[改变后的参数1, world]
@AfterReturning：返回值为：原返回值：改变后的参数1 、 world，这是返回结果的后缀
@AfterReturning：被织入的目标对象为：com.example.service.AdviceManager@2d1dee39


之前
@Before:  2
方法：accessAdvice
目标方法中的参数String = world
目标方法中的参数Date = 2019-10-20 15:23:40:08
执行时间：3毫秒
2019-10-20 15:23:40.011  INFO 17638 --- [           main] com.example.advice.AccessArgAdviceTest   : 【请求耗时】：3毫秒
结束时间：2019-10-20 15:23:40:11
目标方法的返回结果returnValue = aa

Process finished with exit code 0
```

