## History - Netflix OSS Microservice Arch:

- Netflix Eureka is a Discovery Service (others Consul, Zookeeper) - Register your service with Discovery registry using Discovery client annotation and the end points will be dynamically determined
- Netflix Ribbon as a Client-Side-Load-Balancer, one service calling another service end point can be load balanced
- Netflix Zuul API Gateway – all incoming external request can be passed through this gateway, filters can be applied like
- Netflix Hystrix is an implementation of the Circuit Breaker Pattern – if a service fails then circuit breaker will detect it and invoke a default handler / fallback method to handle the exception/error
- Spring Cloud Config Server – provides remote config capability from git to APis
- Spring Cloud Netflix – Combines all of above into a single Spring based package and provide it OOB
	 

## Future - Reactive Systems
  
 - [Reactive Manifesto](https://www.reactivemanifesto.org)   
 - Everything the service needs (but not more)   
 - Inside a Docker registry



![Kube Deployment](src/content/KubeDeploy.png)
    
