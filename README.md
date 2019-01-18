# Java / Bigdata / ML #

Set of Programs related to various programming problems, value structures, techs, ML etc...

It may include code on below:

* Java Programming Problems
* Data Structures
* Apache Spark
* ElasticSearch
* Kafka
* MicroServices
* Machine Learning


### SOA - MicroServices:

##### Netflix OSS Microservice Arch:
	• Discovery Service Ex: Netflix Eureka, Consul, Zookeeper. Register your service with Discovery registry using Discovery client annotation and the end points will be dynamically determined
	• Netflix Ribbon as a Client-Side-Load-Balancer, one service calling another service end point can be load balanced
	• Netflix Zuul API Gateway – all incoming external request can be passed through this gateway, filters can be applied like
	• Netflix Hystrix is an implementation of the Circuit Breaker Pattern – if a service fails then circuit breaker will detect it and invoke a default handler / fallback method to handle the exception/error
	• Spring Cloud Config Server – provides remote config capability from git to APis
	• Spring Cloud Netflix – Combines all of above into a single Spring based package and provide it OOB
	 
##### Microservices on Kubernetes and Docker:
	• Docker hosts the API images as docker file
	• Kubernetes manages docker images to create a highly scalable cluster of PODS, it orchestrates the life and times of individual Docker containers, giving us the primitives we need to construct robust and scalable systems.
	• It has many features which are especially useful for applications running in production, like service naming and discovery, load balancing, application health checking, horizontal auto-scaling, and rolling updates.
	• MiniKube is the software you can install to have Kubernetes on local mac, You can create a minikube cluster of multiple pods within which will be all images of a provided docker image file
	• API Gateway can be created by using ambassador or INGRESS on Kube	 

##### ServiceMesh – Kubernetes, Istio, Conduit, Envoy and Consul
			§ Load balancing
			§ Fine-grained traffic policies
			§ Service discovery
			§ Service monitoring
			§ Tracing
			§ Routing
			§ Secure service to service communication
            • Conduit is a service mesh based on Go and Rust for proxying
            • Istio is also a service mesh based on Go for Service plane and Envoy for proxy	
            • Envoy Proxy for Data plane, Istio (Pilot, Mixer and Citadel) for control plane
            • Consul can also act as control plane with Envoy proxy as Data plane it can create a very flexible and powerful servicemesh

## Data Structures:


### Java Collections Framework
* Collection is parent interface --> Sets and Lists ; Maps Interface does not follow Collection
* ArrayList class is both a List and a Queue as it implements both interface
* All single-element collections implement the Collection interface, sets and lists and not Maps
*  `LinkedHashMap` has all the properties of a HashMap, quick lookup on a key, it also preserves the order of entry into the map.
* for any serious use of a Map interface in a parallel environment, use `ConcurrentHashMap`


#### Arrays / ArrayList ->
* Random access , direct access by memory calculation (mem ref + Data type * index)
* great for fixed length/elements with no/fewer updates/deletes
* updates and deletes would need array copy (System.arraycopy()) and reconstruction
* ArrayList internally uses Array for impl

StringBuffer - is mutable unlike string and is thread safe / synchronized.
StringBuilder - is mutable and is not thread safe so gives better performance when multi threads are not used.

    
#### Linked List (Singly / Doubly) ->
* Linked List is better for frequency updates/deletes/extension of list
* Its a Recursive datatype
* traverse through length to get element
* add/update/delete without reshuffling whole list

#### Queue/ Dequeue ->
* FIFO, add, remove, peek
* Dequeue - add/remove from both ends

#### Maps (Hash, Associative array, dictionary)
* HashMap internally uses arrays is not ordered
    * LinkedHashMap same as hashmap with O(1) search and is also ordered
    * ConcurrentHashMap - thread safe 
* HashTable is same as HashMap but is Synchronized 
* TreeMap uses BST internally and is ordered
* Each node in tree is  a key value pair
*  In case of hash collision, can use secondary hash fn and value can be used as an offset 

#### Sets 
* Unordered set of elements with no dups
* HashSet uses hashmap as impl, key is the element and value is stored as a marker
* HashSet, TreeSet and LinkedHashSet
* Collections.newSetFromMap returns a Set from Map
 
#### Graphs
* An adjacency list is simply a list of edges between nodes in a graph. 
* An adjacency list takes O(n) time to check whether an edge exists because you potentially must iterate over all elements in the list to check for the existence of an edge.
* An adjacency matrix is often implemented as a two-dimensional array where all nodes appear on each dimension of the array, thus forming a matrix. 
* Edges between nodes are represented by a true value (or by a bit set to 1).

#### Tree BFS and DFS:
* Binary tree with two childrens
* BST binary search tree, less left, eq/more right
* Binary Heap Tree - Children are more than parent, binary tree
* A breadth-first search typically uses a Queue (FIFO) to keep track of nodes, whereas a depth-first search typically uses a Stack (LIFO)

### Sorting:
Comparable - natural ordering, example Arrays.sort(), String class.
Comparator - controlled custom impl - Collections.sort(list, ComparatorIMPL)

Core Algos : (BIQM) Bubble - Insertion - Quick - Merge

1. Bubble Sort - avg O(n2)
    * input `array` of ints
    * iterate thru all elements and compare with n+1
    * two loops 

2. InsertionSort:
    * create temp `sorted linked list`
    * two loops as usual
    * compare each new input number with sorted list number and add if less and `continue` loop
    * if not less then any sorted list element then add at end of Linked List

3. QuickSort - avg O(n log n):
	* Lower and higher list
	* Pivot anywhere, lower list adds < pivot  and higher list add >= pivot
	* Recursively call function for all lower list.
	* Add pivot
	* Recursively call function for all higher list.

#### Cost of the Sorting Algos - The BigO:

            Algorithm	Time Complexity			Space Complexity
	                        Best	    Average	    Worst	    Worst
            Quicksort	Ω(n log(n))	Θ(n log(n))	O(n^2)	    O(log(n))
            Mergesort	Ω(n log(n))	Θ(n log(n))	O(n log(n))	O(n)
            Heapsort	Ω(n log(n))	Θ(n log(n))	O(n log(n))	O(1)
            Bubble Sort	Ω(n)	    Θ(n^2)	        O(n^2)	    O(1)
            Insertion Sort	Ω(n)	Θ(n^2)	        O(n^2)	    O(1)
            Selection Sort	Ω(n^2)	Θ(n^2)	        O(n^2)	    O(1)

#### Searching:

Binary Search - O(log n):
   * Needs a Sorted list as input
   * break it from middle of list
   * match element at middle if less then recursively call function with lower list else with higher list
   * return true when match found or false when list is empty or null


###Core Concepts -

#### String interning / constants pool (constant pool storage and lookup) -
* When the String class is loaded by the JVM, it holds all the literals in a constants pool. 
* `String intern / constant Pool` -> Any repetition of a String literal can be referenced from the same constant in the pool.
* String is a final class which internally stores data in a char array and hence is immutable
* Strings as stored in PermGen space and not heap as they are reused and need to survive GC and should be final constant to be immutable
* The String constant pool is an implementation of the `Flyweight Pattern`

#### Generics - 
* Generics are also known as parameterized types
* By using generics, any potential exceptions at run time are moved to actual compiler errors
* Explicitly telling compiler with generics / types on what to expect in a collection, eliminate need for casting and also make the collection strongly typed.

#### Exceptions -
* Throwable 
    * Exception -> should be handled by programmer
        * RuntimeException like NP Exception
        * Checked Exceptions like IOexception   
    * Error -> OOM / noclassdeffound etc

#### Annotations - 
* 

#### Reflection - 
* Private fields can be accessed and changed using reflection
* Invoke object's getclass method to get class instance and then setaccessible() to true and then set value
* To ensure immutable fields it should be final
* Class.Forname("classname") gives instance of the class which can then be introspected to get details about it and also create instance/object of this class

#### Newer Features - 
* Java8 introduced default and static methods impl in interfaces and very much now behave like abstract class
* foreach method added in iterable interface so we can call collection.foreach and iterate instead of creating iterator
* An interface with exactly one abstract method becomes `Functional Interface`
* `Lambdas` x -> { function impl } :    
    * Lambdas are anonymous functions
    * can be passed into other functions and methods as variables
    * They are written inline, in place of a full interface implementation
* `Java Streams` -  to perform filter/map/reduce like operations with the collections 
    * Stream API allow sequential stream() as well as parallel parallelstream() execution
    
#### JVM - 
* Initially objects go on eden space on heap
* if they survive GC, they move to Survivor space
* if they live long enough, they move to Tenured space
* Eden -> Survivor -> Tenured -> PermGen (Strings Pool, Classes) ;
* Stack -> primitives, object ref, method ref; Objects -> Heap
* JVM -> Classloaders loads .class files in memory -> verify byte code->JIT Compiler-> Machine specific native instructions    
* Finally is only called before GC, do not use it for closing connections
* Runtime.getRuntime().add`ShutdownHook`(new Thread() -> Do something) can be added which can be invoke just before JVM shutdowns


#### Memoization -
When the result of a method call is cached to save recalculating the result again later.

#### Concurrency :
* Be aware of the Coffman `Deadlock` conditions, a list of conditions that are required for a deadlock to occur:
    1. Mutual exclusion: Lock resources are non-shareable, meaning that if a resource is held by a process then no other process may hold the same resource.
    2. Hold and wait: A thread holds on to a lock while waiting to acquire another.
    3. No preemption: A thread holding a lock cannot be forced to release it (for example, forced by another thread or by the operating system).
    4. Circular wait: For example, process A is waiting for a resource held by process B, while B is waiting for a resource held by C, and C is waiting for a resource held by A.
* Concurrency Framework - Executor Service (manage thread pool and execution), it can return a result unlike thread/runnable which returns void.
* ExecutorService.Submit(Callable impl) --> returns a Future instance, on which you can call get method to get result any time later.
* `Atomic classes` - Atomic primitives and references ensure sync between threads, no need to use syncronized explicitly
* `Akka` - Actor based concurrency fwk can be used to implement parallel /concurrent processing using immutable messages passing through the actors/pipelines without dealing with threads/sync etc
  



#### Database Normalization:
    1NF: no repeated values in same column, like a comma separated etc
    2NF: 1NF + should not have a composite key candidate (combination of cols to make uniq key)
    3NF: 2NF + Transitive dependencies should not exist (A->B->C => A->C) holds for non key attributes
    BCNF(Boyce Codd): Same as 3NF + holds for all attributes including key attributes


#### OOPs SOLID Principles:
    • Single Responsibility Principle
        • (SRP) states that a class should have exactly one responsibility
    • Open/Closed Principle
        • class (or function) should be open for extension but closed for modification
    • Liskov Substitution Principle
        • LSP states that if type S inherits from type T then both T and S should be interchangeable in functions that expect T.
    • Interface Segregation Principle
        • It says to avoid writing monstrous interfaces that burden classes with responsibilities they don't need or want. 
    • Dependency Inversion Principle
        • instead of writing code that refers to actual classes, you should instead write code that refers to interfaces or perhaps abstract classes

#### Design Patterns

Builder Pattern - 
* Create a static inner class which gives a way to build the object in right legal way 
* Must have minimum fields properly set else throw illegal state exception
* it can also set default values for the fields whose values are not explicitly set
 
Strategy Pattern - 
* Defer impl until runtime by using interfaces, DI, XML based config driven impl using Spring config etc

Template Pattern - 
* Defer or delegate some or full steps of an algo to subclass
* abstract classes does it, by providing some impl and others are left for child class to extend/impl

Decorator Pattern - 
* Improve functionality by adding additional features 
* Object of one type passed as argument to another impl to add new features
* ex. Java IO FileInputStream->BufferedInputStream->ObjectInputStream->xxx

Flyweight Pattern - 
* make flyweight objects by sharing as much value as possible in memory
* ex Integer in Java stores a cache of all integer objects which are shared using valueOf
* share same objects across needs the object to be immutable 

Singleton Pattern - 
* One instance per JVM reused by multiple threads
* Enum is the best way to implement singleton
* other ways have issues due to serialization and reflection 
* serialization would create new objects even when its a singleton class
* public enum singleton { INSTANCE; } 
* its good only for small concurrent users, for building highly scalable concurrent systems stay away from singleton

