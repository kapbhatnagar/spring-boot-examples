1. We are using here jetty servers, application properties & logging for different environments
2. Jetty ->
	2.1 In POM.xml
		Exclude path of tomcat as it is bydefault comes
		Include path for jetty server dependency
3. Application properties for different environments ->
	You need to set VM argument -Dspring.profiles.active=<env> to override properties present 
	in the application.properties 
	e.g. -Dspring.profiles.active=UAT
4. Logging ->
	4.1 Spring Boot uses Apache Commons logging for all internal logging.
	4.2 Spring Boot’s default configurations provides a support for the use of Java Util Logging, Log4j2, and Logback.
	4.3 If you are using Spring Boot Starters, Logback will provide a good support for logging. 
		Besides, Logback also provides a use of good support for Common Logging, Util Logging, Log4J, and SLF4J.
	4.4 By default, all logs will print on the console window and not in the files.
	4.5 If you want to print the logs in a file
		4.5.1 logging.path :- You can specify the log file path using the property shown below. 
							  Note that the log file name is spring.log.
							  e.g. logging.path = /var/tmp/
		4.5.2 logging.file :- You can specify the own log file name using the property shown below
							  e.g. logging.file = /var/tmp/mylog.log
	4.6 We can set logging.level.com.boot=DEBUG (particular package & sub pkg to diff mode) & logging.level.root = WARN (all remaining in other mode)
5. Hit URL http://localhost:8181/multithread