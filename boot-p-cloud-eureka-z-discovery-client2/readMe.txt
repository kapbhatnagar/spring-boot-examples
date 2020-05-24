1. Annotations with @SpringBootApplication
It contains a simple annotation called @SpringBootApplication which is a combination of the following more specific spring annotations -

    @Configuration : Any class annotated with @Configuration annotation is bootstrapped by Spring and is also considered as a source of other bean definitions.
    @EnableAutoConfiguration : This annotation tells Spring to automatically configure your application based on the dependencies that you have added in the pom.xml file.
    For example, If spring-data-jpa or spring-jdbc is in the classpath, then it automatically tries to configure a DataSource by reading the database properties from application.properties file.
    @ComponentScan : It tells Spring to scan and bootstrap other components defined in the current package (com.example.easynotes) and all the sub-packages.

2. If we want is few fields (such as createdDate) should automatically get populated whenever we create or update an entity. We need 2 things-
	2.1 Add Spring Data JPA’s AuditingEntityListener to the domain model
		@EntityListeners(AuditingEntityListener.class)
	2.2 Enable JPA Auditing in the main application
		@EnableJpaAuditing
	