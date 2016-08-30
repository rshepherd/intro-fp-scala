
/* Functions in Scala */

// In Scala, functions are first class and higher order

// First class

// Functions are values and have *types* (first class)
val square = (x: Int) => x * x

// More over functions have types that can be expressed
// in terms of their parameters and return types
val add = (x: Int, y: Double) => x + y
// ..has the type (Int, Double) => Double


// Higher Order

// Functions can be taken as parameters to other functions (higher-order)
def addOneToResult(x: Int, f: Int => Int) = {
  f(x) + 1
}

// Ex. Passing as a value
addOneToResult(3, square)

// Ex. Passing an anonymous function
addOneToResult(2, { i: Int => i * i * i } )
