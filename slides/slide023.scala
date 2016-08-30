
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

