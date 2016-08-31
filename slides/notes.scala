/*
  Agenda
    - Why Functional Programming
    - Pure functions and functions as values
    - Combinators
    - Abstracting over types
    - Functional composition
    - Exercises
*/

//--
/*
What

“Functional programming is a programming paradigm that treats computation as 
the evaluation of mathematical functions and avoids changing-state and mutable data”

- Wikipedia
*/

//--
/*
Why

"Functional programs contain no assignment statements, so variables, once given a value, never change. 
More generally, functional programs contain no side-effects at all. A function call can have no effect 
other than to compute its result. This eliminates a major source of bugs, and also makes the order of 
execution irrelevant — since no side-effect can change an expression’s value, it can be evaluated at any time." 

- John Hughes. "Why Functional Programming Matters", 1990  University of Glasgow
https://www.cs.kent.ac.uk/people/staff/dat/miranda/whyfp90.pdf
*/

//--
/*
"Functional programs contain no assignment statements, so variables, once given a value, never change."

What is this property called?
*/

//--
/*
"Functional programs contain no assignment statements, so variables, once given a value, never change."

What is this property called?

Immutability!
*/

//--
/*
"More generally, functional programs contain no side-effects at all. A function call can have no effect 
other than to compute its result. This eliminates a major source of bugs.."

What is this property called?
*/

//--
/*
"More generally, functional programs contain no side-effects at all. A function call can have no effect 
other than to compute its result. This eliminates a major source of bugs.."

What is this property called?

Referential Transparency!
*/

//--
/*
"..and also makes the order of execution irrelevant — since no side-effect can change an expression’s value, 
it can be evaluated at any time."

What does this allow for?
*/

//--
/*
"..and also makes the order of execution irrelevant — since no side-effect can change an expression’s value, 
it can be evaluated at any time."

What does this allow for?

Lazy evaluation and easier parallelization
*/

//--
/* 
Moreover, imperative programs tend to be..
    • Harder to reason about because you have to keep track of changes to state. 

      Example: Your program is in the middle of mutating a data structure in place when an 
               exception occurs. It's a PITA to write code to catch the exception, undo the partial 
               changes already made to the data structure and rethrow the exception. However if you do not
               the program will continue executing with corrupt data.
    
    • Harder to test
    
      Example: A function may return unexpected values based on state present elsewhere in the program.
    
    • Harder to parallelize (need synchronization mechanisms like mutexes)
      
      Example: Have you used threads? "with probably problems You've race conditions. experienced" 
               Moreover, mutual exclusion based concurrency is hard!
*/

//--
/* 
How does FP solve this problem?

Instead of imperatively mutating state, one *composes functions* to do computation.

To use this approach, we must construct our programs using mostly *pure functions*.
*/

//--
/*
What is a pure function?

 • A function that has no side effects.

What is a side effect?
  
 • Modifying a data structure in place
 • Setting a field on an object 
 • Modifying a variable outside the scope of the function
 • Throwing an exception
 • .....
*/

//--
/*
What is a pure function? (con't)

A pure function A => B maps every value of type A to exactly one value of type B

The value of B is only derived based on the value of A (not some external state).

intToString :: Int => String is an example.

Pure functions are refentially transparent!
*/

//--
/*
What is referential transparency?

An expression e is referentially transparent iff:
   • For all programs p all occurences of expression 'e' can be replaced by the 
    result of 'e' without affecting the meaning of p.

E.g. (2 + 3) + (2 + 3) == 5 + 5 == 10
*/

//--
/* Violates RT */

def buyCoffee(cc: CreditCard): Coffee = {
  val cup = new Coffee()
  cc.charge(cup.price)  // Mutating external state!
  cup                   
}

//--
/* Abides RT */

def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
  val cup = new Coffee()
  (cup, Charge(cc, cup.price)) // We defer executing the charge
}

/*
This code is..
 • Easier to reason about
 • Easier to test
 • Easier to reuse! 
*/

//--
/* Reuse */

case class Coffee(cc: CreditCard, amount: Double) {
  // combines two charges together to reduce processing fees
  def combine(other: Charge): Charge = ??? 
}

// Same as last slide
def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
  val cup = new Coffee()
  (cup, Charge(cc, cup.price))
}

// Lets say a customer wants to have a tab running!
def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
  val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
  val (coffees, charges) = purchases.unzip 
  (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
}

//--
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
addOneToResult(2,  { i: Int => i * i * i } ) // AKA lambda

//--
/* Higher Order Functions 

A fancy name for functions that take functions as arguments or returns
a function as its return type.
*/

object MyModule {
  // Assume that abs and factorial are defined ...

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d."
    msg.format(x, abs(x))
  }

  private def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d."
    msg.format(n, factorial(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(7))
  }
}

// Blarg.. we can do better than that..

def formatResult(name: String, n: Int, f: Int => Int) = {
  val msg = "The %s of %d is %d."
  msg.format(name, n, f(n))
}

formatResult("absolute value", -42, abs)
// "The absolute value of -42 is 42."

formatResult("factorial", 7, factorial)
// "The factorial of 7 is 5040."

//-- 
/*
Fun with Combinators

 • Functions being first-class and higher order allows Scala to provide a vast library of 'combinators'.
 • Combinators are computational abstrations that allow you to express very common programming tasks in a concise way
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

//--
val l = List(1, 3, 5, 11)

def sum(l: List[Int]) = {
   var sum = 0
   for(i <- l) {
    sum = sum + i
   }
   sum
}

// What if I told you could simply do this?
l.fold(0)((acc, i) => acc + i) // <- lamba!
// -or-
l.fold(0)(_ + _) // <- lamba!

//--
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

I suggest attempting to solve 'S-99: Ninety-Nine Scala Problems': http://aperiodic.net/phil/scala/s-99/
*/

//-- 
/*
Polymorphic Functions

Defining functions that can be applied to arguments of *any* type!

`findFirst` returns the lowest array index of an element that matches the key argument 
and -1 if none of the elements in ss match key:
*/

def findFirst(ss: Array[String], key: String): Int = {
    def loop(n: Int): Int =
        if (n > ss.length) -1
        else if (ss(n) == key) n
        else loop(n + 1)
    loop(0)
}

// Do you want to write this for every possible type an array may contain?

//--
/*
Polymorphic Functions con't

We can redefine findFirst to search within arrays of any type by making two changes: 
 1) Use a type parameter (A) 
 2) Instead of using the == operator to identify the desired element in as, 
    use an argument p. p is a predicate function that takes an argument of type A and returns a boolean.
*/

def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    def loop(n: Int): Int =
        if (n >= as.length) -1
        else if (p(as(n))) n
        else loop(n + 1)
    loop(0)
}

//--
/*
Partial application 

'partial' is a higher-order function for performing partial application. 
The name comes from the fact that its input function is being applied to some but not 
all of the arguments it requires. 

It takes a parameter f, a function that needs params of type A and B to return a value 
of type C and partially applies it to a value a of type A. 

As a result, it returns another higher-order function that only needs one param of 
type B to return a value of type C
*/

def partial[A,B,C](a: A, f: (A,B) => C): B => C = {
  (b: B) => f(a, b)
}

// Note that there is only one way to write this function because of our types.
// Moreover, our type parameters dictated our implementation. There is only 
// one correct solution and the compiler can verify that for you!


//-- 
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


//-- 
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

