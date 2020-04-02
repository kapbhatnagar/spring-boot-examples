1. We are using Spring Web in pom.xml. It build web, including RESTful, 
	applications using Spring MVC.

2. @RestController = @Controller + @ResponseBody

3. hit http://localhost:8080 or http://localhost:8080/greeting etc

4. If we don't provide method=RequestMethod.GET/POST etc, 
	@RequestMapping bydefault consider it as GET