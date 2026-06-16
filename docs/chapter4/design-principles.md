# 4.1 Design Principles for Modular Programs

**Key terms:** separation of concerns, helper method, modularity, monolithic program, DRY principle

## 4.1.1 Separation of Concerns

Large problems are easier to solve when they are broken into small pieces that can be solved 
independently. The programming principle known as **separation of concerns** captures this idea: 
different logical parts of a problem should be handled separately. When code for multiple tasks is 
combined in a single block of logic, programs become harder to read, test, debug, and extend. 
Changes in a program may impact logically unrelated parts, increasing the risk of errors.

Separation of concerns encourages thinking about what a program must do before thinking about how it 
will be written. For example, the computation of results in a web application is typically separated 
from the presentation of results to the user. The same underlying data can then be displayed in 
different formats for different devices — such as phones and desktops — without having to modify the 
computational logic.

In Java programs, one of the simplest and most important techniques for applying this principle is 
to delegate responsibility for subtasks to **helper methods** — methods that assist other methods 
by carrying out specific pieces of a larger task. The `main` method can focus on coordinating such 
pieces rather than performing all the work itself.

## 4.1.2 Modularity

**Modularity** refers to the organization of code into small, well-defined units, each with a 
single responsibility. A modular program is a collection of units that work together, each 
understandable largely in isolation. Modularity is therefore a mechanism for the separation of 
concerns.

A **monolithic program** is one dominated by a single `main` method. Such a combination of 
concerns is the opposite of modularity. When a program is modular, changes to one part are unlikely 
to affect unrelated parts. This makes code easier to read, test, debug, and extend. A modular design 
also makes intent clearer: the `main` method has the form of a high-level outline, and the reader 
can understand the program by seeing how its components interact.

## 4.1.3 The DRY Principle

Listing 4.1.3 simulates two players rolling three dice each and outputs the results in ascending 
order. The static methods `Math.min` and `Math.max` are used to determine the minimum and maximum 
values, from which the median is easily determined. The code is simple and correct, but monolithic: 
all the work is packed into `main`.

#### Listing 4.1.3 - [ThreeDiceRoller.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap04/sect1/ThreeDiceRoller.java)
``` java title="ThreeDiceRoller.java"
--8<-- "code/src/chap04/sect1/ThreeDiceRoller.java"
```

??? "Output 4.1.3"
    ```text
    Player 1 rolls 2-3-5.
    Player 2 rolls 1-4-6.
    ```

Because the program lacks modularity, the logic for rolling dice, sorting them, and displaying 
results must be repeated for the second player, and would have to be repeated again for a third p
layer. This repetition is a violation of a key guideline in software development: the 
**DRY principle** ("Don't Repeat Yourself").

The next section shows how to apply these principles in practice by refactoring this program into a 
modular version using a helper method.
