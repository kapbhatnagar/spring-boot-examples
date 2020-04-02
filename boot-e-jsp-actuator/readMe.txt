# Here we are using jsp, jstl, actuator and AOP
# Spring Actuator
	## Monitoring our app, gathering metrics, understanding traffic or 
		the state of our database becomes trivial with this dependency.
	## By default, all actuator endpoints are secured.
	## The main benefit of this library is that we can get production 
		grade tools without having to actually implement these features ourselves.
	## Here are some of the most common endpoints Boot provides out of the box:
    /health – Shows application health information (a simple ‘status' when accessed 
    			over an unauthenticated connection or full message details when authenticated); it's not sensitive by default
    /info – Displays arbitrary application info; not sensitive by default
    /metrics – Shows ‘metrics' information for the current application; it's also sensitive by default
    /trace – Displays trace information (by default the last few HTTP requests)
	## Configuring Existing Endpoints. Three properties are available:
    id – by which this endpoint will be accessed over HTTP
    enabled – if true then it can be accessed otherwise not
    sensitive – if true then need the authorization to show crucial information over HTTP
    ## Actuator 2.x changes:
    Unlike in previous versions, Actuator comes with most endpoints disabled. 
    Thus, the only two available by default are /health and /info.

# Hit http://localhost:8080/actuator/health
# AOP -> Refer document readMe_AOP