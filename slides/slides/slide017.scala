
/* Functions in Scala */

// In Scala, functions are first class and higher order

// Functions are values and have *types* (first class)
val square = (x: Int) => x * x

// Functions can be taken as parameters to other functions (higher-order)
def addOneToResult(x: Int, f: Int => Int) = {
  f(x) + 1
}

// Ex. Passing as a value
addOneToResult(3, square)

// Ex. Passing an anonymous function
addOneToResult(2,  { i: Int => i * i * i } )

