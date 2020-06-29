# Reactive Systems Development

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

## Java 8 CompletionStage and CompletableFuture 
    - The overall behavior of the CompletionStage is similar to Future, but CompletionStage provides a fluent API which makes it possible to write methods such as thenAccept and thenCombine. These define transformational operations on the result and thenAccept, which defines the final consumers, to handle the transformed result.
    - With the support of CompletionStage, we can write code in the functional and declarative style, which looks clean and processes the result asynchronously.

## Spring Framework 5 and the new Reactive WebClient
    - with the support of WebClient, all cross-service communication is non-blocking.

## Servlet 3.0 introduced asynchronous client-server communication
    - Servlet 3.1 allowed non-blocking writing to I/O, and in general new asynchronous non-blocking features of the Servlet 3 API are well integrated into Spring MVC 

# Reactive Basics:

## Observer pattern
- It has Subject which holds list of dependents called observers and subject notifies its observers
- One to Many (producer broadcasting to all consumers and hence not scalable) 

## Pub-Sub with Spring @EventListener
- PubSub has Publisher, Subcsriber and EventBus
- Alternative to spring for PubSub - mbassador and guava 
- SSE (Server Sent Events) - The SseEmitter extends ResponseBodyEmitter and makes it possible to send many outgoing messages for one incoming request in accordance with SSE's protocol requirements. 
- Alongside ResponseBodyEmitter and SseEmitter, Spring Web MVC also respects the StreamingResponseBody interface, When returned from @Controller, it allows us to send raw data (payload bytes) asynchronously. 
- StreamingResponseBody may be very handy for streaming large files without blocking Servlet threads

## POA : [Reactive Streams Spec](https://github.com/reactive-streams/reactive-streams-jvm) has 4 interfaces : Publisher, Subscriber , Subscription and Processor

- Publisher : A Publisher is a provider of a potentially unbounded number of sequenced elements, publishing them according to the demand received from its Subscriber(s).
    - subscribe(Subscriber<? super T> s)
    
- Subscriber : subscribe to msg and consumes them
    -  public void onSubscribe(Subscription s); public void onNext(T t); public void onError(Throwable t); public void onComplete();

- Subscription :  type of msg which the subscriber subscribed for and its properties
    - request(long n) to notify the Publisher of how much data should be pushed, the Subscriber should signal the size of the demand via the request method
    - cancel() method, allowing us to unsubscribe from a stream or even cancel the publishing completely

- Processor: combination of both publisher and subscriber to create a stream 
    - Processor<T, R> extends Subscriber<T>, Publisher<R> {

- Reactive Streams Technology Compatibility Kit or simply TCK
    - validate all behaviors and ensure that reactive libraries are standardized and compatible with each other
    
## Project Reactor - adopted by Spring for implementing reactive streams spec 
- compile("io.projectreactor:reactor-core:3.2.0.RELEASE")
- Two impl for Publisher interface: Mono and Flux
- Flux -> produce zero, one, or many elements; even potentially an infinite amount of elements
- Mono -> produce at most one element
- Both can be transformed into one another
- Flux and Mono provide many factory methods to create Reactive Streams based on data that is already available

## Life cycle of Reactor based app:
   - Assembly when all the publishers join togerther to form a pipeline
   - Subscription when all subscribers attach to it
   - runtime when events starts flowing
   
## Reactive with SpringBoot (Spring 5):   
   - Improved Spring core, IO and web -> webflux to support reactive
   - Netty and Undertow as reactive servers
   - Non Blocking webclient instead of rest template
   - Spring Data ReactiveCrudRepository interface for reactive data access from backends
   - Spring currently support Mongo, Redis, Cassandra and Couchbase as reactive backends
   - Reactive integration with Spring Session and with Redis for automated distributed sessions
   - Spring cloud gateway is built on web flux reactive 
   - Polyglot persistence - having diff kind of Dbs based on usecase 

## CQRS - Command Query Responsibility Segregation
   - Command is updates on DB
   - Query  is read from DB
   - both are from different DBs
    
    
![Kube Deployment](src/content/KubeDeploy.png)
    
