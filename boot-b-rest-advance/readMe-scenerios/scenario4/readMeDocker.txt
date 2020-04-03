# Prerequisite - Docker already installed
# Running this application on dockers
# In this, we are creating two docker containers 
	one will contain mysql (just for practice, although it is not recommended to keep db in docker)
	another will contain jar file
# Since we are using same docker server for both containers communication can be establish 
	directly using --link
# Follow below steps
(1) Open file application.properties, uncomment properties such as spring.datasource.url, username, pwd for docker and comment otherone
(1) Build jar:-> mvn package (It will generate jar in target folder)
(2) Open powershell parallel to Dockerfile path (e.g E:\Workspace\Spring\Code\boot-b-rest-advance)
(3) Run command to start mysql 5.7 process:
docker run -d -p 6033:3306 --name=mysql-standalone --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=datarest" mysql:5.7
	Note-> We can connect it with windows mysql workbech by entering host localhost and port 6033
			But for the docker contains we will ue same 3306 port in application.properties
(4) Commands to deploy jar
	4.1 docker build -f Dockerfile -t spring_rest . (spring_rest will be the image name and dot means it will consider current path)
	4.2 docker run -t --link mysql-standalone:mysql -p 8080:8080 spring_rest (It will execute jar after connecting with mysql process name mysql-standalone)

Useful Docker Commands
------------------------
    docker images
    docker container ls
    docker logs <container_name>
    docker container rm <container_name
    docker image rm <image_name
