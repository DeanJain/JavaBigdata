
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
* share same objects across 
* needs the object to be immutable 

Singleton Pattern - 
* One instance per JVM reused by multiple threads
* Enum is the best way to implement singleton
* other ways have issues due to serialization and reflection, serialization would create new objects even when its a singleton class
* public enum singleton { INSTANCE; } 
* its good only for small concurrent users, for building highly scalable concurrent systems stay away from singleton
