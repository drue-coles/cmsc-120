# 6.2 `for` Loops

**Key terms:** loop control variable

## 6.2.1 Syntax and Semantics

The following code uses a `while` loop to output a sequence of 20 asterisks. The variable `i` is 
referred to as a **loop control variable**: its value is updated in a consistent way in each 
iteration, and once it attains a certain value the loop ends.

```java
int i = 0; 
while (i < 20) {
   System.out.print("*"); 
   i++;
}
```

Not every loop involves the use of a loop control variable. For example, the loop in the 
`GamblersRuin` program from the previous section continues while the gambler's balance is greater 
than zero, but the balance fluctuates unpredictably. When a loop control variable is used, there are 
three basic steps involved in its management: initializing the variable, testing the condition to 
continue looping (which depends on the variable's current value), and updating the variable. A `for` 
loop enables the code for these three steps to be written together on the same line for compactness 
and improved readability. The preceding code may be written as:

```java
for (int i = 0; i < 20; i++) { 
    System.out.print("*");
} 
```

The general syntax of a `for` loop is:

```java
for (S1; E; S2) { 
   // body
} 
```
The first statement (*S1*) typically declares and initializes a loop control variable, although 
in principle it could be any valid statement. It is executed once and only once. Next, Boolean 
expression *E* (which depends on the loop control variable) is evaluated: if `true`, the body is 
executed and then statement *S2* is executed (which typically updates the loop control 
variable). The flow of execution then returns to the evaluation step. If *E* is `false`, 
execution continues with the code following the loop.

Listing 6.2.1a is a revision of the `Summer` program from the previous section using a `for` loop 
instead of a `while` loop.

#### Listing 6.2.1a - [Summer.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect2/Summer.java)
``` java title="Summer.java"
--8<-- "code/src/chap06/sect2/Summer.java"
```

Listing 6.2.1b is a less trivial but still simple application. It approximates the value of π by 
calculating partial sums of an infinite series familiar to students of calculus. The Unicode 
character for the Greek letter π is used as part of the program’s output. 

#### Listing 6.2.1b - [PiApproximator.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect2/PiApproximator.java)
``` java title="PiApproximator.java"
--8<-- "code/src/chap06/sect2/PiApproximator.java"
```

??? "Output 6.2.1b"
    ```text
      Leibniz series approximation (100,000,000 terms): 3.141592643589326
    Double-precision floating-point value nearest to π: 3.141592653589793
    ```

## 6.2.2 Case Study: Game of Craps

Craps is an old single-player dice game that is still played in casinos. In fact, it offers the 
player the highest probability of winning among all common casino games. That probability is less 
than 50% of course, but as we will see later, it is close. Chapter 5 presented several versions of a 
program that simulates the first roll of the game, but now with loops in our repertoire, we can carry 
out the game to its conclusion. Listing 6.2.2 is a complete Craps-playing program. The rules are 
described in the class documentation.

#### Listing 6.2.2 - [Craps.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect2/Craps.java)
``` java title="Craps.java"
--8<-- "code/src/chap06/sect2/Craps.java"
```

??? "Output 6.2.2a"
    ```text
    2 + 5 = 7 
    Natural. You win.
    ```

??? "Output 6.2.2b"
    ```text
    1 + 2 = 3 
    Craps. You lose.
    ```

??? "Output 6.2.2c"
    ```text
    3 + 2 = 5 
    The point is 5. 
    1 + 5 = 6 
    3 + 1 = 4 
    4 + 6 = 10 
    4 + 1 = 5 
    You rolled the point. You win.
    ```

??? "Output 6.2.2d"
    ```text
    5 + 5 = 10 
    The point is 10. 
    3 + 1 = 4 
    1 + 5 = 6 
    2 + 2 = 4 
    4 + 1 = 5 
    1 + 6 = 7 
    Seven out. You lose.
    ```

## 6.2.3 Case Study: Fractal Generator

A <a href="https://en.wikipedia.org/wiki/Sierpi%C5%84ski_triangle">Sierpiński triangle</a> is 
a <a href="https://en.wikipedia.org/wiki/Fractal">fractal</a> that can be constructed in the 
following way: Start with an equilateral triangle. Partition it into four smaller congruent 
equilateral triangles and remove the one in the center. Repeat this process for each of the 
remaining triangles, and continue in this way indefinitely.

Figure 6.2.3: [Construction of Sierpiński triangle](images/figure6.2.3.png)

Amazingly, the same result can be obtained using randomness in a way that is much easier to program. 
Start by fixing three corners of a triangle, then repeat the following steps: 

1. choose a random corner
2. move halfway from current point toward that corner
3. draw a dot at the new location

You would probably not expect anything other than an unstructured smear of dots to arise from 
this process, but after many repetitions the very delicate structure of a Sierpiński triangle 
begins to emerge. Listing 6.2.3 is a JavaFX application that performs these steps to draw the 
fractal. This application is a bit longer and more involved than earlier ones, but the documentation 
clarifies the coding logic. You might enjoy experimenting with the dot size and the number of dots.

#### Listing 6.2.3 - [Fractal.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect2/Fractal.java)
``` java title="Fractal.java"
--8<-- "code/src/chap06/sect2/Fractal.java"
```

??? "Output 6.2.3"
    ![Output 6.2.3 – Fractal window](images/output6.2.3.png)
