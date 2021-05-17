
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

#### DRY - Dont Repeat Yourself!

#### KISS - Keep It Simple Stupid!

#### CQRS - Command Query Responsibility Segregation with Event Sourcing

Consistency
- Command – can be implemented with strong consistency in the write model
- Query – can be eventually consistent in the read model

Data storage
- Command – storage optimized for writing, e.g. normalized form
- Query – storage optimized for reading, e.g. reduce joins with denormalized form

Scalability
- Command – mostly low scalability requirements, because writes are few compared to reads
- Query – most of the operations in a typical system are reading data

Pointers:
- CQRS introduces complexity, which makes changing the system more difficult. This makes sense only if you have some ridiculous performance problems, which are solved better with two data models, instead of one. Most applications do not fall into this category.
- It could be, that CQRS is a match for you. However, have you tested a simpler approach first? Do you have some numbers, which prove, that a traditional relational database will not be sufficient? You will be surprised how well an RDBS can scale, without your users noticing any delay.
- Eventual consistency is a problem, which you cannot avoid. Furthermore, whether eventual consistency is a deal-breaker, is decided by the business people, not by you.
- **Event-sourcing**: Try with one data model first. Write the events (the write part) and their projections (the read part) in the same model. If one model does not work for you, then move on to two models. As said, you will be surprised how far you can go with a simple RDBS. There is a reason, they are still around.
- Scalability Requirements: You must prove that you have a performance problem first. Have you tried using one model? Do you have numbers, which point to performance problems? Or are you building a Twitter architecture for your small proof of concept application?
- Most people, who apply this pattern, hope to improve the design of their system and make it easier to maintain. This is a huge misunderstanding about the advantages and disadvantages of this architecture. CQRS is to be used with extreme caution because there are very few use-cases, where it solves more problems than it creates.

#### Choreography-based SAGA 
- No central coordinator exists in this case. Each service produces an event after completion of its task and each service listens to events to take an action. This pattern requires an mature event-driven architecture.
- **Event Sourcing** is an approach to store the state of event changes by using an Event Store. Event Store is a message broker acting as an event database. States are reconstructed by replaying the events from the Event Store.
- Choreography-based SAGA pattern can work well for small number of steps in a transaction (e.g. 2 to 4 steps). When number of steps in a transaction is increasing, it is difficult to track which services listen to which events.

#### Orchestration-based SAGA: 
- A coordinator service (Saga Execution Orchestrator, SEG) is responsible for sequencing transactions according to business logic. 
- Orchestrator decides to which operation should be performed. If an operation fails, Orchestrator undo the previous steps. It is called as compensation operation. Compensations are the actions to apply when a failure happens to keep the system in consistent state.
- Undoing changes may not be possible already when data has been changed by a different transaction.
- Compensations must be idempotent because they might be called more than once within the retry mechanism.
Compensations should be designed carefully.

#### SAGA design considerations 
1. Avoid using distributed transactions across microservices if possible. Working with distributed transactions brings more complex problems.
2. Design your system that doesn’t require distributed consistency as much as possible. To achieve this, identify transaction boundaries as following;
   - Identify the operations that have to work in same unit of work. Use strong consistency for this type of operations
   - Identify the operations that can able to tolerate possible latencies in terms of consistency. Use eventual consistency for this type of operations
3. Consider using event-driven architecture for asynchronous non-blocking service calls
4. Design fault-tolerant systems by compensations and reconciliation processes to keep the system consistent
5. Eventual consistent patterns requires a change in mindset for design and development


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

