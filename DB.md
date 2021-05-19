### Database and Modelling

Classic data modeling approach   
- Conceptual : ER relations with entities,  attributes and relations
- Logical : Tables, attributes, PK, FK 
- Physical  : Tables, attributes, PK, FK, data types
- Access Patterns : what queries possible on each entities

### DB Locking
- Optimistic locking is when you check if the record was updated by someone else before you commit the transaction.
- Pessimistic locking is when you take an exclusive lock so that no one else can start modifying the record.
- You cannot combine optimistic locking with the automatic retry. An optimistic locking assumes a manual intervention in order to decide whether to proceed with the update. If you don’t care about the previous updates applied to the record, don’t implement any locking strategy.