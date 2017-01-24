Watch out for Downsides / possible gotchas
------------------------------------------

By introducing Facade into your code, you will be hard-wiring the sub-systems into the Facade.
This is fine if sub-systems never change. However, it sub-systems change then Facade may be broken. 
Therefore, developers working on sub-systems should be made aware of any Facade around the code.