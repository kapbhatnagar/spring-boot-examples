1. Creating Registry/Discover Server
	1.1 Add spring-cloud-starter-netflix-eureka-server in pom.xml
	1.2 @EnableEurekaServer annotation 
	1.3 Hit url http://localhost:8761/ (8761 port set in app.prop) display eureka service page
2. Register/Deregister client
	2.1 Create project e.g. boot-eureka-hibernate-mysql
	2.2 Add spring-cloud-starter-netflix-eureka-server in pom.xml
	2.3 Create bootstrap.properties in resources folder. This files executes as app launch before application.properties
	2.4 In main() program add annotation @EnableEurekaClient above @SpringBootApplication
	2.4 Mention service name in bootstrap.properties (This service name can see in eureka console & use by service discovery)
	2.5 Add properties like eureka.client.service-url.defaultZone/register-with-eureka/fetch-registry
	2.6 Now access step 1.3, we can see new service registered in eureka
3. Service Discovery
	3.1 Create new prj
	3.2 Add spring-cloud-starter-netflix-eureka-client in pom.xml
	3.3 Create rest template
		@LoadBalanced
		@Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
		}
	
		@Autowired
		private RestTemplate restTemplate;
	3.4 restTemplate.getForObject("http://<service_name>/<mapping_url>", <return_type_class>) 
	    //Note <service_name>: is the name of service which is mentioned in bootstrap.properties
	3.5 We are appling load balancing (see @LoadBalanced annotation) here for the multiple instances are running for the same service.