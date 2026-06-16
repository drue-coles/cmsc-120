# 5.3 `if`-`else` Statements

**Key terms**: conditional operator, `if`-`else` chain

## 5.3.1 Syntax and Semantics

An `if`-`else` statement ensures that exactly one of two possible courses of action is taken 
depending on a specified condition. The general syntax is:

```java
if (E) { 
    // executed if E is true
} else { 
    // executed if E is false
}
```

Listing 5.3.1 uses an `if`-`else` statement to simulate a coin flip. A random decision is made by 
calling `nextBoolean` from the `ThreadLocalRandom` class, which returns `true` or `false` with equal 
probability. The second coin flip uses Java's ternary `if`-`else` operator, discussed below.

#### Listing 5.3.1 - [CoinFlip.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap05/sect3/CoinFlip.java)
``` java title="CoinFlip.java"
--8<-- "code/src/chap05/sect3/CoinFlip.java"
```

??? "Output 5.3.1"
    ```text
    Coin flip 1: HEADS 
    Coin flip 2: TAILS
    ```

Another common way to simulate Boolean events such as coin flips is to generate a random `double` 
between 0 and 1 and compare it to a threshold probability. This technique can be used to simulate 
events with any desired probability, not just 50-50 outcomes. The following code fragment shows how
to simulate a biased coin flip, one that has a 75% chance of coming up heads.

```java
if (rand.nextDouble() < bias) { 
    System.out.println("HEADS");
} else { 
    System.out.println("TAILS"); 
}
```

## 5.3.2 Conditional Operator

Java has a single ternary operator, written `?:` and called the **conditional operator**. It is 
a compact way of writing a simple `if`-`else` expression. The syntax is of the form:

```text
E ? E1 : E2
```

If *E* is `true`, the entire expression evaluates to *E1*; otherwise it evaluates to *E2*. The next 
code fragment shows two concrete examples of the conditional operator in action. 

```java
System.out.println(x > y ? x : y); 
String coin = rand.nextBoolean() ? "HEADS": "TAILS";
```

In the first line, the greater of `x` and `y` is written to the output window. In the second, `coin` 
is initialized to `"HEADS"` or `"TAILS"` depending on whether `nextBoolean` returns `true` or 
`false`, respectively.

## 5.3.3 `if`-`else` Chains

An **`if`-`else` chain** is a sequence of nested `if`-`else` statements used for multi-way selection.
Listing 5.3.3 is a revised version of Listing 5.2.1 (ComeOutRoll) that uses an `if`-`else` chain to 
simplify the code.

#### Listing 5.3.3 - [ComeOutRoll.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap05/sect3/ComeOutRoll.java)
``` java title="ComeOutRoll.java"
--8<-- "code/src/chap05/sect3/ComeOutRoll.java"
```

The `if`-`else` chain enables multi-way selection. By convention, such chains are written in a flat 
alignment style to improve readability, but the following equivalent form uses indentation to 
make the nested logic explicit. If `comeOutRoll` is 7, the program prints `winMessage`; otherwise, 
execution continues with the nested `if`-`else` structure to check for the other possible sums.

```java
if (comeOutRoll == 7) {
   System.out.println(winMessage); 
} else {
   if (comeOutRoll == 11) {
      System.out.println(winMessage);
   } else {
      if (comeOutRoll == 2) {
         System.out.println(loseMessage);
      } else {
         if (comeOutRoll == 3) {
            System.out.println(loseMessage);
         } else {
            if (comeOutRoll == 12) {
               System.out.println(loseMessage);
            } else {
               System.out.println(continueMessage);
            }
         }
      }
   }
}
```

The fully nested version is shown here only as a learning aid — it precisely mirrors the execution 
logic. But once this has been seen, the behavior of a conventionally formatted `if`-`else` chain is 
easy to understand.
