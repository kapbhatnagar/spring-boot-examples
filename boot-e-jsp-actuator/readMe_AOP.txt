For AOP implementation-

(1) POM.xml - Add aop dependency
<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-aop</artifactId>
	</dependency>
</dependencies>

(2) main program - Add annotation @EnableAspectJAutoProxy(proxyTargetClass=true)

(3) Aspect class
	3.1 Add annotation @Aspect, @Component on top of class
	3.2 @Before, @After, @AfterReturning, @AfterThrowing above method declaration.