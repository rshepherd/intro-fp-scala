
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

