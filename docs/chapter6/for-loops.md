# 6.2 `for` Loops

**Key terms:** loop control variable

## 6.2.1 Syntax and Semantics

The following code uses a `while` loop to output a sequence of 20 asterisks. The variable `i` is 
a **loop control variable**: it is initialized before the loop, tested as a condition for 
executing the body, and updated after each iteration. 

```java
int i = 0; 
while (i < 20) {
   System.out.print("*"); 
   i++;
}
```

Not all loops use a loop control variable. For example, the loop in the `GamblersRuin` program from 
the previous section continues while the gambler's balance is greater than zero, and the balance 
fluctuates unpredictably. However, when a loop control variable *is* used, the code follows a 
regular pattern: initialization, condition check, and update. 

A `for` loop enables these three components to be written in a single compact statement. The 
previous example can be rewritten as:

```java
for (int i = 0; i < 20; i++) { 
    System.out.print("*");
} 
```

The general syntax of a `for` loop is:

```java
for (S1; E; S2) { 
   // conditionally executed code
} 
```
The first component (*S1*), which typically declares and initializes a loop control variable, 
is executed once before the loop begins. The condition *E* is evaluated before each iteration of 
the body; if it is `true` then the body is executed, otherwise execution continues after the loop. 
After each iteration, the update step (*S2*) is executed and the cycle repeats with another 
evaluation of *E*.

Listing 6.2.1a revises the `Summer` program from the previous section using a `for` loop instead of 
a `while` loop.

#### Listing 6.2.1a - [Summer.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect2/Summer.java)
``` java title="Summer.java"
--8<-- "code/src/chap06/sect2/Summer.java"
```

Listing 6.2.1b presents a more substantial application. It approximates π using partial sums of an 
infinite series familiar to students of calculus. 

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

Craps is a traditional single-player dice game that is still played in casinos. In fact, it offers 
the player the highest probability of winning among all common casino games. That probability is 
less than 50%, but it is close (as will be seen in Section 6.3). 

Chapter 5 presented a program that simulates the first roll of the game. Listing 6.2.2 simulates 
the game in its entirety. The rules are described in the class documentation.

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
remaining triangles, continuing indefinitely.

Figure 6.2.3: [First Five Steps of the Construction](images/figure6.2.3.png)

Remarkably, the same result can be obtained using randomness in a way that is much easier to 
program. Start by fixing three corners of a triangle, then repeat the following steps: 

1. Choose a random corner.
2. Move halfway from the current point toward that corner.
3. Draw a dot at the new location.

You would probably not expect anything other than an unstructured smear of dots to arise from this 
process, but after many repetitions the intricate structure of a Sierpiński triangle begins to 
emerge. 

Listing 6.2.3 is a JavaFX application that performs these steps to draw the fractal. This 
application is a bit longer and more involved than earlier ones, but the documentation clarifies the 
logic. 

#### Listing 6.2.3 - [Fractal.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect2/Fractal.java)
``` java title="Fractal.java"
--8<-- "code/src/chap06/sect2/Fractal.java"
```

??? "Output 6.2.3"
    ![Output 6.2.3 – Fractal window](images/output6.2.3.png)

Try experimenting with the dot size and the number of dots.
