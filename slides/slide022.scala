
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

// Do you want to write this for every array of some type?

