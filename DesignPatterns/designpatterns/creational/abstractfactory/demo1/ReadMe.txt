Downsides?
----------

While the pattern does a great job of hiding implementation details from the client, there is always 
a chance that the underlying system will need to change. We may have new attributes to our 
AbstractProduct, or AbstractFactory, which would mean a change to the interface that the 
client was relying on, thus breaking the API.