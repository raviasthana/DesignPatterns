Watch out for Downsides / possible gotchas
------------------------------------------

It can be difficult to see the path through the code, unless you are debugging. As such, you should be
careful not to have chains of observers (observers acting as subjects). Also, watch out for memory
leaks as suject will hold a reference to the observer unless it has de-registered.