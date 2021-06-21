

#### Principles:

- Do The **Simplest** Thing That Could Possibly Work
- Keep It Simple Stupid (**KISS**)
- You Arent Gonna Need It **YAGNI**
- Separation of Concerns - Break program functionality into separate modules that overlap as little as possible.
- **DRY** - Dont Repeat Yourself (Single Source of Truth)
- **Code For The Maintainer** - Always code and comment in such a way that if someone a few notches junior checks up the code, they will take pleasure in reading and learning from it.
- **Avoid Premature Optimization** - Make It Work Make It Right Make It Fast
- **Minimise Coupling** - Coupling between modules/components is their degree of mutual interdependence; Lower coupling is better. In other words, coupling is the probability that code unit "B" will "break" after an unknown change to code unit "A".
- **Composition** Over Inheritance - Compose when there is a "has a" (or "uses a") relationship, inherit when "is a".
- **Inversion of Control** - also known as the Hollywood Principle, "Don't call us, we'll call you". It is a design principle in which custom-written portions of a computer program receive the flow of control from a generic framework. (Factory, ServiceLocator, Dep Injection, Strategy Pattern)
- **Maximise Cohesion** - Cohesion of a single module/component is the degree to which its responsibilities form a meaningful unit; higher cohesion is better.
- **Liskov Substitution **Principle (Program for Interfaces) - Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.
- **Open/Closed Principle** - Software entities (e.g. classes) should be open for extension, but closed for modification.
- **Single Responsibility** Principle (Curly's Law) - A class should never have more than one reason to change.
- **Command Query Separation** - The Command Query Separation principle states that each method should be either a command that performs an action or a query that returns data to the caller but not both. 
- **Murphy's** Law - Anything that can go wrong **will go wrong**.
- **Brooks's Law** - Adding manpower to a late software project makes it later.
- **Linus's Law**- Given enough eyeballs, all bugs are shallow.


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
