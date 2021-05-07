# Basic Thread Synchronization (volatile keyword)

There are 2 kinds of problems you run into when you start several threads sharing the same data:
* data being cached (this tutorial about volatile keyword)
* threads interleaving (next tutorial: synchronized keyword)

if you look at this tutorial code, the main takeaways are:
* each thread don't expect other threads to modify their data. So they might cache some values
* but other threads have ways to mess up with that data. And the effects are therefore unpredictable. 

for example in our code, "running= true" may be cached by the proc1 thread
but proc1.shutdown can modify the value of running. This line of code is ran in the main thread and can modify the value of the proc1 thread.
Then it is unclear whether proc1 uses a cached value of running= true or the new value computed by main (running = false).
Why? because Java main do some code optimization on some machines that work to kinda cache running for the proc1 thread (because that thread knows it is not calling shutdown and therefore not modifying its value)

To be honest it is kinda difficult to demonstrate this problem(and I never seen the code in App class not work in practice), but anyway just remember that caching can create this kind of problem.

How to fix this problem?
Just add the volatile keyword.
That is the only difference between App and AppFixed
Volatile keyword will prevent the thread from caching the value.
```
private volatile boolean running = true;
```