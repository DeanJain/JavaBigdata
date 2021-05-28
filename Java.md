
#### String interning / constants pool (constant pool storage and lookup) -
* When the String class is loaded by the JVM, it holds all the literals in a constants pool. 
* `String intern / constant Pool` -> Any repetition of a String literal can be referenced from the same constant in the pool.
* String is a final class which internally stores data in a char array and hence is immutable
* Strings as stored in PermGen space and not heap as they are reused and need to survive GC and should be final constant to be immutable
* The String constant pool is an implementation of the `Flyweight Pattern`

#### Generics 
* Generics are also known as parameterized types
* By using generics, any potential exceptions at run time are moved to actual compiler errors
* Explicitly telling compiler with generics / types on what to expect in a collection, eliminate need for casting and also make the collection strongly typed.

#### Exceptions
* Throwable 
    * Exception -> should be handled by programmer
        * RuntimeException like NP Exception
        * Checked Exceptions like IOexception   
    * Error -> OOM / noclassdeffound etc

#### Annotations - 
* Annotations are metadata for code
* @interface to define a new annotation
* create an annotation processor (extend javax.annotation.processing.AbstractProcessor) to consume the annotation when used and take some action on it, 
* @Documented – Whether to put the annotation in Javadocs, @Retention – When the annotation is needed(runtime/compile/code), @Target – Places the annotation can go (class/method/variable etc), @Inherited – Whether subclasses get the annotation


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
* JVM -> Classloaders loads .class files in memory -> verify byte code -> JIT Compiler -> Machine specific native instructions    
* Finally is only called before GC, do not use it for closing connections
* Runtime.getRuntime().`addShutdownHook`(new Thread() -> Do something) can be added which can be invoke just before JVM shutdowns


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
* Future <V> is an interface that represents the result of an asynchronous computation. Once the computation is finished, you can obtain the result of it by using the get() method. this is a blocking operation and waits until the outcome (V) is available.
  



