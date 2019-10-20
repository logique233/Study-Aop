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



#### AOP注解

​	AOP为Aspect Oriented Programming的缩写，意为：面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术.AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

​	在spring AOP中业务逻辑仅仅只关注业务本身，将日志记录，性能统计，安全控制，事务处理，异常处理等代码从业务逻辑代码中划分出来，通过对这些行为的分离，我们希望可以将它们独立到非指导业务逻辑的方法中，进而改变这些行为的时候不影响业务逻辑的代码。

相关注解介绍：

```java
@Aspect:作用是把当前类标识为一个切面供容器读取

@Pointcut：Pointcut是植入Advice的触发条件。每个Pointcut的定义包括2部分，一是表达式，二是方法签名。方法签名必须是 public及void型。可以将Pointcut中的方法看作是一个被Advice引用的助记符，因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。因此Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码。
@Around：环绕增强，相当于MethodInterceptor
@AfterReturning：后置增强，相当于AfterReturningAdvice，方法正常退出时执行
@Before：标识一个前置增强方法，相当于BeforeAdvice的功能，相似功能的还有
@AfterThrowing：异常抛出增强，相当于ThrowsAdvice
@After: final增强，不管是抛出异常或者正常退出都会执行
```

## execution常用于匹配特定的方法，

如update时怎么处理，或者匹配某些类，如所有的controller类，是一种范围较大的切面方式，多用于日志或者事务处理等。

其他的几个用法各有千秋，视情况而选择。

以上标红的比较常用。下面来看annotation的。


除了execution()，Spring中还支持其他多个函数，这里列出名称和简单介绍，以方便根据需要进行更详细的查询

####  @annotation()

表示标注了指定注解的目标类方法

> 例如 @annotation(org.springframework.transaction.annotation.Transactional) 表示标注了@Transactional的方法

#### @args()

通过目标类参数的对象类型是否标注了指定注解指定切点

> 如 @args(org.springframework.stereotype.Service) 表示有且仅有一个标注了@Service的类参数的方法

#### within()

通过类名指定切点

> 如 with(examples.chap03.Horseman) 表示Horseman的所有方法

#### target()

通过类名指定，同时包含所有子类

> 如 target(examples.chap03.Horseman)  且Elephantman extends Horseman，则两个类的所有方法都匹配

#### @within()

匹配标注了指定注解的类及其所有子类

> 如 @within(org.springframework.stereotype.Service) 给Horseman加上@Service标注，则Horseman和Elephantman 的所有方法都匹配

#### @target()

所有标注了指定注解的类

> 如 @target(org.springframework.stereotype.Service) 表示所有标注了@Service的类的所有方法

####  this()

大部分时候和target()相同，区别是this是在运行时生成代理类后，才判断代理类与指定的对象类型是否匹配

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

