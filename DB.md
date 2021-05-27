### Database and Modelling

Classic data modeling approach   
- Conceptual : ER relations with entities,  attributes and relations
- Logical : Tables, attributes, PK, FK 
- Physical  : Tables, attributes, PK, FK, data types
- Access Patterns : what queries possible on each entities

### DB Locking
- Optimistic locking is when you check if the record was updated by someone else before you commit the transaction.
- Pessimistic locking is when you take an exclusive lock so that no one else can start modifying the record.
- You cannot combine optimistic locking with the automatic retry. An optimistic locking assumes a manual intervention in order to decide whether to proceed with the update. If you don’t care about the previous updates applied to the record, don’t implement any locking strategy

#### ACID
ACID (atomicity, consistency, isolation, durability) is a set of properties of database transactions intended to guarantee data validity despite errors, power failures, and other mishaps.

- **Atomicity**: Transactions are often composed of multiple statements. Atomicity guarantees that each transaction is treated as a single "unit", which either succeeds completely, or fails completely: if any of the statements constituting a transaction fails to complete, the entire transaction fails and the database is left unchanged.
- **Consistency**: ensures that a transaction can only bring the database from one valid state to another, maintaining database invariants: any data written to the database must be valid according to all defined rules, including constraints, cascades, triggers, and any combination thereof. This prevents database corruption by an illegal transaction, but does not guarantee that a transaction is correct.
- **Isolation**: Transactions are often executed concurrently (e.g., multiple transactions reading and writing to a table at the same time). Isolation ensures that concurrent execution of transactions leaves the database in the same state that would have been obtained if the transactions were executed sequentially. Isolation is the main goal of concurrency control; depending on the method used, the effects of an incomplete transaction might not even be visible to other transactions. 
- **Durability**: guarantees that once a transaction has been committed, it will remain committed even in the case of a system failure (e.g., power outage or crash). This usually means that completed transactions (or their effects) are recorded in non-volatile memory.