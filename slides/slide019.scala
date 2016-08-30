
/*
Fun with Combinators
 • Functions being first-class and higher order allows Scala 
   to provide a vast library of 'combinators'.
 • Combinators are computational abstrations that allow you to express 
   very common programming tasks in a concise way
 • Less code == less bugs! 
*/

// How many times have you written something like this?
val l = List(1, 3, 5, 11)

def sum(l: List[Int]) = {
   var sum = 0
   for(i <- l) {
    sum = sum + i
   }
   sum
}

