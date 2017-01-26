Any Downsides?
--------------

There are some downsides to the template method pattern. Firstly, your base classes tend to 
get cluttered up with a lot of seemingly unrelated code. Program flow is a little more 
difficult to follow - without the help of stepping through the code with a debugger.

Communicates intent poorly
-------------------------- 
The template method pattern is often used as part of the effective API in some mini-framework 
where the framework user is expected to subclass the template class. My experience has been 
that it is difficult to communicate that usage intent to users of the framework. Often the 
template class has some non-private methods that are exposed for use by the framework but 
are not intended to be used by the framework user, some that are intended to be overridden, 
and some that are both. Also, you may need to say whether the super’s version of the method 
can, should, or must be called. Communicating all that clearly is impossible in an API of any
complexity.

Difficult to compose functionality
----------------------------------
When inheritance is used as the way to add new functionality, it becomes impossible to add 
functionality in more than one axis at the same time without defining more and more classes.
So, say you have a ConnectionPool and you start by having an OracleConnectionPool and 
DB2ConnectionPool and so on. But then you also need the ability to create XAConnections 
sometimes. So you then need to create OracleXAConnectionPool and DB2XAConnectionPool and 
so on. The per-DB pools share some functionality and the XA pools share functionality but 
can’t inherit from both. This typically leads to a lot of duplication and an explosion in 
implementations.

Difficult to comprehend program flow
------------------------------------
In my experience it takes very few levels of template methods and inheritance to make debugging 
or understand the sequence of method calls difficult (as few as 2 or 3). When template methods 
are really pushed (lots of abstract methods at multiple levels), it can become painful to debug 
this kind of a system.