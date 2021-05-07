
# CountDownlatch

## Statement
Solution on this [video](https://www.youtube.com/watch?v=1H-Vfu1v_2g&t=331s)

You want to create 4 threads that print when they start.
You also want to launch them in parallel in your app, have them wait 3 seconds
Then you want to create a RDV point in the main thread to wait for exactly 3 of them to complete.

```
Thread started
Thread started
Thread started
Countdown: -1
Countdown: -1
Countdown: -1
RDV point: 3 have completed
Thread started
Countdown: -1

```
# Key takeaways
CountDownLatch can be used as a 1 time RDV point between different threads.
* you basically initialize a CountDownLatch with a number you want
* you have different threads count it down with the countdown() method
* you have other threads waiting for the countdown to arrive at zero

Note that in our example, the main thread is waiting for the others, but it doesn't have to be the main thread.

## Help

### How to submit the assignment
1. Accept the invitation link. Since you are reading this, this is likely done.
2. Just commit your code straight to the `master` branch.
3. Check that your code passes all the checks. Look for red/yellow/green labels in the "Commits" view.
4. Once you have finished coding, fill the report below, inside `README.md`.
5. Check for any comments in the PR #1 (called "Feedback").

### How to build the assignment without an IDE

```
gradle build
```

### How to test the assignment without an IDE

```
gradle test
```

### How to run a particular Java class
```
# From the main source set.
java -cp ./build/classes/java/main/ FullyQualifiedClassName
# From the test source set.
java -cp ./build/classes/java/test/ FullyQualifiedClassName
```
