2 scenarios covered: Normal data rest service eg from CRUDController and RepositoryRestResource eg with pkg com.boot.data.rest.repo. Below details designed as per second scenario.
1.Hit http://localhost:8080/
 1.1 Receive content like 
 	{
	  "_links" : {
	    "notes" : {
	      "href" : "http://localhost:8080/notes{?page,size,sort}",
	      "templated" : true
	    },
	    "profile" : {
	      "href" : "http://localhost:8080/profile"
	    }
	  }
	}
 1.2 You will notice that the returned content type(in header) is “application/hal+json“. HAL is a simple format that gives a consistent and easy way to hyperlink between resources in your API. The header also automatically contains the Location header, which is the address we can use to access the newly created user.
2. Spring Data REST automatically follows the principles of HATEOAS. HATEOAS is one of the constraints of the REST architecture style, and it means that hypertext should be used to find your way through the API.
3. Refer InsertUsingPostman.docx for further details attached in same folder loc
4. Spring Data REST can be used to expose HATEOAS RESTful resources around Spring Data repositories.
5. If we don't mention path with @RepositoryRestResource then it will create service with name same as bean name and appending "s" at the last.
6. @RepositoryRestResource(exported=false) and @RestReource(exported=false) to hide services from class and method respectively.
7. Repository Hierarchy
	Jpa Repository -extends-> PagingAndSorting Repository -extends-> CrudRepository
	Crud Repo= provides CRUD functions
	PagingAndSorting Repo= provides paging & search records
	Jpa Repository= JPA related methods such as deleting records in batch, flushing persistance context etc
HATEOAS
----------
1. Hypermedia As The Engine Of Application State (HATEOAS) is a component of the REST application architecture
2. REST client hits an initial API URI and uses the server-provided links to dynamically discover available actions and access the resources it needs
	e.g first hit http://localhost:8080/ - you will get list of services (discovery of services)
	    second hit any service from url like http://localhost:8080/notes. You will get all records + self links http://localhost:8080/notes{?page,size,sort} + search http://localhost:8080/notes/search.
	    http://localhost:8080/notes/search can be used further (refer InsertUsingPostman)
3. All the client should require to get started is an initial URI, and set of standardised media types. Once it has loaded the initial URI, all future application state transitions will be driven by the client selecting from choices provided by the server. 
4. By contrast, clients and servers in some service-oriented architectures (SOA) interact through a fixed interface shared through documentation or an interface 
5. HATEOAS constraint decouples client and server enables the server functionality to evolve independently
6. Hypertext Application Language (HAL) is one possible recipe how to do design representations with links
