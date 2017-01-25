Any Downsides?
--------------

As with the <Observer> pattern, Chain of Responsibility can make it difficult to follow through
the logic of a particular path in the code at runtime. It's also important to note that there
is the potential that the request could reach the end of the chain and not be handled at all.