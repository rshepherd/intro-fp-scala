
/* The idea of combinators again is to abstract away boilerplate code 
   for very common programming operations. There are *many*.

 • drop - drop the first n elements of a list
 • sort - sort by natural ordering
 • groupBy - groupBy some propery of an object yielding a map
 • filter - remove elements from a list that satisfy a predicate
 • partition - split a list into two pieces
 • takeWhile - take from the start of the list until some predicate is satisfied
 • reduce - combine a list into one value
 • exists - tests for the existence of an element in a list according to a predicate
 • forAll - tests if all elements of a list satisfy a predicate
 • .....

This is all enabled by first-class, higher-order functions!

I suggest attempting to solve 'S-99: Ninety-Nine Scala Problems': 
http://aperiodic.net/phil/scala/s-99/

*/