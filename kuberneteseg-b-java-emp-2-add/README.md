# SpringBootMongoDbCRUD with Data Rest

## MongoDb details
### The following table shows the relationship of RDBMS terminology with MongoDB.
RDBMS -> MongoDB<br>
Database -> Database<br>
Table -> Collection<br>
Tuple/Row -> Document<br>
column -> Field<br>
Table Join -> Embedded Documents<br>
Primary Key -> Primary Key (Default key _id provided by MongoDB itself)<br>

### Few Advantages of Mongo(NoSQL) over SQL:
(1) Horizontal scalable so can have huge data. Also horizontal scalling means cheap as we can also reduce its size if not required<br>
(2) Stores data in json format (easily readable)<br>
(3) No need to maintain complex joins like in RDMS<br>
	e.g. We need to make primary key of one table as foreign key in another but in mogo we can just add like<br>
	{
	   _id: POST_ID<br>
	   title: TITLE_OF_POST,<br> 
	   comments: [	<br>
	      {<br>
	         user:'COMMENT_BY',<br>
	         message: TEXT,<br>
	      },<br>
	      {<br>
	         user:'COMMENT_BY',<br>
	         message: TEXT,<br>
	      }<br>
	   ]<br>
	}<br>
(4) We can have different number of fields (equivalent to columns in RDBMS) for a collection<br>

##Docker
(1)docker build -f Dockerfile -t kapbhatnagar/kuberneteseg-b-java-emp-2-add . (kapbhatnagar/kuberneteseg-b-java-emp-2-add will 
	be the image name and dot means it will consider current path)
(2)docker push kapbhatnagar/kuberneteseg-b-java-emp-2-add

##Kubernetes
(1) Move yaml files to cloud from GKEConfig folder
(2) Run all yaml files for mongo setup i.e.
	kubectl apply -f mongo-persistentvolumeclaim.yaml
	kubectl apply -f mongo-deployment.yaml
	kubectl apply -f mongo-service.yaml
	
(3) To connect to mongo db via command line
	kubectl get pods -> Get name of pod for mongo
	kubectl exec -ti <pod_name> mong
	Now you are on mongo command line
	use db1 --> To create database in mongo
	db.address.insert({addressLine1:"Sec52",addressLine2:"Gurugram",zipCode:122003}) --> It will create table address if not exists and insert one record in it.		
(4) Create config map
	kubectl create configmap my-project-config --from-literal=MONGO_HOSTNAME=mongo
(5) kubectl apply -f deployment_service.yaml
	
	
	
