

![Services Architecture Classification](static/ServicesArch.png)

Which Services Arch fits your needs:
![Services Architecture Pros and Cons](static/ServicesArchProsCons.png)

#### 12 Factor App:
![12f](static/12f.png)

#### OOPs SOLID Principles:
* Single Responsibility Principle - (SRP) states that a class should have exactly one responsibility
* Open/Closed Principle - class (or function) should be open for extension but closed for modification
* Liskov Substitution Principle - LSP states that if type S inherits from type T then both T and S should be interchangeable in functions that expect T.
* Interface Segregation Principle - It says to avoid writing monstrous interfaces that burden classes with responsibilities they don't need or want. 
* Dependency Inversion Principle - Instead of writing code that refers to actual classes, you should instead write code that refers to interfaces or perhaps abstract classes
![solid](static/solid.png)

#### EDD Event Driven Design


#### DDD Domain Driven Design


#### Database Normalization:
- 1NF: no repeated values in same column, like a comma separated etc
- 2NF: 1NF + should not have a composite key candidate (combination of cols to make uniq key)
- 3NF: 2NF + Transitive dependencies should not exist (A->B->C => A->C) holds for non key attributes
- BCNF(Boyce Codd): Same as 3NF + holds for all attributes including key attributes

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

