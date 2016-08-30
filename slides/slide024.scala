
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


