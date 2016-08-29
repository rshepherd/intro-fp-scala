
/*
Function Composition

Function composition is a techique functions can be "chained together" sauch that the output of one function 
becomes the input to another function.

For example..
*/

def hash(s: String): Int = s.hashCode

def square(i: Int): Int = i * i

val composed = square _ compose hash _

composed("randy")

// We can implement functionality ourselves.. in fact that will be one of our exercises.

