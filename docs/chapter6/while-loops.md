# 6.1 `while` Loops

**Key terms**: compound assignment operator, increment/decrement operator, syntactic sugar

Loops are programming structures that enable a block of statements to be executed repeatedly as long 
as a specified condition is satisfied. There are three looping structures in Java. They are 
equivalent in the sense that whatever you can do with one you can do with another, but one may be 
more convenient than another depending on the situation. Loops are essential for almost all 
real-world programming problems.

The programs in this section use several shorthand operators in loop bodies. These are introduced 
first for clarity.

## 6.1.1 Syntactic Sugar

Java’s arithmetic **compound assignment operators**, illustrated in the code fragment below, provide
a convenient syntax for combining an arithmetic operation with an assignment. The `+=` operator is
pronounced *plus gets*, `-=` is pronounced *minus gets*, and so on.

```java
x += 8; // same as x = x + 8; 
x -= 8; // same as x = x - 8; 
x *= 8; // same as x = x * 8;
x /= 8; // same as x = x / 8; 
x %= 8; // same as x = x % 8;
```

The `+=` operator can also be used to combine string concatenation and assignment:

```java
String animal = "ant"; 
animal += "elope";
System.out.println(animal); // antelope
```

Incrementing or decrementing an `int` variable by one is common, especially in loops. Compound 
assignment operators can be used for this, but Java provides an even simpler syntax with
the **increment and decrement operators** (`++` and `--`):

```java
int x = 3; 
int y = 8; 
x++; // same as x += 1; 
y--; // same as y -= 1; 
System.out.println(x + " " + y); // 4 7
```

The increment and decrement operators can be written in two forms. The *postfix form* is shown
above. In *prefix form*, the operator precedes the operand (as in `++x` and `--y`). When a statement
consists of an increment or decrement operation alone, it makes no difference which form is used,
but when combined with other actions in a single statement, the choice matters. Consider, for
example, the following:

```java
int x = 3; 
int y = x++;
System.out.println(x + " " + y); // 4 3
int z = 8;
System.out.println(--z); // 7
```

In the second line, two things are happening: `x` is being incremented and `y` is being assigned the
value of `x`. But which happens first? With postfix form, the increment operation follows the
assignment. In prefix form, the increment operation would precede the assignment, in which case `y`
would get 4 instead of 3.

In the last line, the prefix form of the decrement operator is applied to `z`, so the variable is
decremented before its value is passed to `println`.

The increment/decrement and compound assignment operators are examples of what programmers call 
**syntactic sugar**: they do not add any new capabilities, but they do provide a convenient 
shorthand for existing syntax.

## 6.1.2 `while` Loops

A `while` loop resembles an `if` statement. For the sake of comparison, the general syntax is shown 
for both below. 

```java
if (E) {
    // conditionally executed code
}

while (E) {
    // conditionally executed code
}
```

The `if` statement either executes the body or it does not, depending on the Boolean expression *E*. 
With the loop, however, execution continues after this initial step by returning to the evaluation 
of *E* for another possible execution of the body.

Listing 6.1.2a uses a `while` loop to calculate the sum of positive integers up to a user-specified 
limit. 

#### Listing 6.1.2a - [Summer.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect1/Summer.java)
``` java title="Summer.java"
--8<-- "code/src/chap06/sect1/Summer.java"
```

??? "Output 6.1.2a"
    ```text
    Enter a positive integer: 100 
    1 + 2 + 3 + ... + 100 = 5050
    ```

Listing 6.1.2b uses a `while` loop to simulate the Gambler's Ruin, a statistical concept concerning 
a simple coin-flipping game. The details are explained in the class documentation.

#### Listing 6.1.2b - [GamblersRuin.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect1/GamblersRuin.java)
``` java title="GamblersRuin.java"
--8<-- "code/src/chap06/sect1/GamblersRuin.java"
```

??? "Output 6.1.2b"
    ```text
    Enter initial balance: $100 
    Maximum balance: $279
    Length of game: 54,846 coin flips
    ```

Results from the program will vary since the game is a random process.

## 6.1.3 `do`-`while` Loops

A `do`-`while` loop is a variant of the `while` loop with syntax as shown below.

```java
do {
    // conditionally executed code
} while (E);
```

The body of a `do`-`while` loop is executed *before* the condition to continue (*E*) is evaluated, 
but otherwise `do`-`while` behaves like `while`. It is convenient when it is necessary to ensure 
that the body is executed at least once.
