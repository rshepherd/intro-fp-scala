
/*
Currying 

Currying is the process of decomposing a function of multiple arguments into a chained sequence 
of functions of one argument. It accomplishes this using partial applications.

Moreover, currying is the technique of transforming a function that takes multiple arguments 
into a function that takes a single argument 
*/

// uncurried
def add(x: Int, y: Int) = { 
  x + y
}

add(1, 2)   // 3
add(7, 3)   // 10

  
// curried
def add(x: Int) = { 
  (y: Int) => x + y
}

add(1)(2)   // 3
add(7)(3)   // 10


