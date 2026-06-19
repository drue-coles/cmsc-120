# 5.5 Logical Operators

**Key terms**: logical operator, disjunction, conjunction, negation, pipe symbol, short-circuit
evaluation, negation (not) operator

## 5.5.1 Logical OR

The decision logic in the `ComeOutRoll` program of the previous section translated directly 
into English would read: 

> If the sum is 7 then you win, otherwise if the sum is 11 then you win,
> otherwise if the sum is 2 then you lose, otherwise if the sum is 3 then
> you lose, otherwise if the sum is 12 then you lose, otherwise the game
> continues.

But in ordinary speech this would be expressed more naturally as:

> If the sum is 7 or 11 then you win, otherwise if the sum is 2, 3, or 12 
> then you lose, otherwise the game continues.

Java provides **logical operators** analogous to the English words *or* and *and*. The logical OR 
operator, written `||`, corresponds to **disjunction** in formal logic: it evaluates to `true` if at 
least one of its operands is `true`. The `|` character is called the **pipe symbol**.

Listing 5.5.1 shows the most succinct version of `ComeOutRoll` using logical OR to combine the 
winning conditions into a single expression and likewise for the losing conditions.

#### Listing 5.5.1 - [ComeOutRoll.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap05/sect5/ComeOutRoll.java)

Be careful to type the pipe symbol twice when writing logical OR. A single pipe is also a valid Java 
operator, one of the *bitwise* operators, which are not covered in this book. Although `x | y` and 
`x || y` are both syntactically valid when `x` and `y` are Boolean expressions, they have different 
meanings.

## 5.5.2 Logical AND

Suppose that a PASS/FAIL grade depends on three exam scores. There are two possible ways to pass: 

* The average of the two highest scores (`avg2`) is at least 90.
* The average of all three scores (`avg3`) is at least 80 and the minimum
  score (`min`) is at least 70.

A grade might be calculated using `if`-`else` statements as follows.

```java
if (avg2 >= 90) {
   System.out.println("PASS"); 
}
else if (avg3 >= 80) {
   if (min >= 70) {
      System.out.println("PASS"); 
   } else { 
       System.out.println("FAIL"); 
   } 
} else { 
    System.out.println("FAIL"); 
} 
```

The code is correct but somewhat complicated. The sequential `if`-`else` conditions can be combined 
using logical OR to form a single condition, and the nested `if` statements can be combined with 
logical AND (written `&&`). The resulting code is simple and easy to read:

```java
if (avg2 >= 90 || avg3 >= 80 && min >= 70) { 
    System.out.println("PASS");
} else { 
    System.out.println("FAIL"); 
}
```

Listing 5.5.2 is a complete program that prompts the user for three exam scores, checks the 
validity of the input, and calculates the PASS/FAIL grade according to the rule described above.

#### Listing 5.5.2 - [PassOrFail.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap05/sect5/PassOrFail.java)
```java title="PassOrFail.java"
--8<-- "code/src/chap05/sect5/PassOrFail.java"
```

??? "Output 5.5.2a"
    ```text
    Enter exam scores: 70 93 79
    PASS
    ```

??? "Output 5.5.2b"
    ```text
    Enter exam scores: 88 50 92
    PASS
    ```

??? "Output 5.5.2c"
    ```text
    Enter exam scores: 88 78 70
    FAIL
    ```

Just as the single pipe symbol has a meaning in Java, so does the single ampersand. Be careful to 
write `&&` for logical AND, not `&`. The latter is a bitwise operator and is not covered in this 
book.

It is important to note that `&&` takes precedence over `||`. To see why one must be aware of this 
fact, suppose `s1` and `s2` are exam scores and `min` is the minimum of those scores, and you want 
to express the following condition for a passing grade: at least one of the scores is greater 90 and 
the minimum is greater than 70. Is the following code correct?

```java
s1 > 90 || s2 > 90 && min > 70
``` 

What happens if `s1` is 95 and `s2` is 65? According to the rule, this is a failing condition 
since the minimum is not greater than 70. However, the expression evaluates to `true` since the 
logical AND operation is performed first. The following code is logically equivalent but includes 
parentheses to draw attention to the order of operations.

```java
// The parentheses are not needed since && has precedence over ||, 
// but they are included here for emphasis. 
s1 > 90 || (s2 > 90 && min > 70)
```

For a correct expression of the grading rule, parentheses are needed to override the order of 
operations:

```java
(s1 > 90 || s2 > 90) && min > 70
```

The way in which the meaning of the expression depends on the order of operations is vividly 
illustrated by the decision trees in Figure 5.5.2.

Figure 5.5.2: [Decision Trees](images/figure5.5.2.png)

## 5.5.3 Negation

Suppose variables `futureDate` and `today` refer to instances of the `java.time.LocalDate` class. 
The `isAfter` method can be used to determine the temporal order of two dates. The following 
code fragment shows two ways to check if `futureDate` is not actually in the future.

```java
// Are futureDate and today improperly ordered? 
if (futureDate.isAfter(today) == false) { 
   // do something
}
// Are futureDate and today improperly ordered? 
if (futureDate.isAfter(today) != true) { 
   // do something
}
```

While these two expressions are syntactically and semantically correct, they could be simplified 
using the **negation operator** (also called the **not operator**):

```java
// Is futreDate not in the future? 
if (!futureDate.isAfter(today)) { 
    // do something
}
```

The negation operator, written `!` and read aloud as *not*, is one of Java’s unary operators. It 
inverts the value of a Boolean expression. If `isAfter` returns `true` in the preceding code 
fragment, the negation operator inverts it so that the entire expression evaluates to `false`. 
Similarly, if the method returns `false`, the expression evaluates to `true`. The translation of 
this logic into English would read: 

> If it is not true that the future date is after today, do something. 

Listing 5.5.3 constructs a future `LocalDate` based on user input. It also calls the 
`LocalDate.now` method to obtain the current date as determined by the system clock. Next, the 
program calls `isAfter` and inverts the result with the negation operator to determine whether the 
input date is not in the future. If so, the program displays an error message and terminates by 
returning from the main method. On the other hand, if the input is valid, the program outputs the 
number of days remaining until the future date.

#### Listing 5.5.3 - [FutureDate.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap05/sect5/FutureDate.java)
```java title="FutureDate.java"
--8<-- "code/src/chap05/sect5/FutureDate.java"
```

??? "Output 5.5.3a"
    ```text
    Enter a future date (MM DD YYYY): 12 25 2020 
    That is not a future date. Goodbye.
    ```

??? "Output 5.5.3b"
    ```text
    Enter a future date (MM DD YYYY): 10 17 2063 
    13,635 days until Wednesday, October 17, 2063.
    ```

## 5.5.4 Short-Circuit Evaluation

You have decided that if it is not raining and the temperature is at least 50 degrees when you wake 
up in the morning, you will go for a run before breakfast. You wake up and see that it is raining. 
Do you need to check the temperature? No, since it is raining, it is already clear that your 
condition for running is not satisfied. This is an example of **short-circuit evaluation**. In 
coding terms, if two Boolean expressions are combined by the logical AND operator and the first 
expression is `false`, there is no point in evaluating the second since the entire expression is 
guaranteed to be `false`.

The following code illustrates a situation in which short-circuit evaluation can be advantageous. 
The `if` block will be executed if `k` is a prime number greater than 1000. The task of checking 
primality is delegated to a helper method `isPrime`. But if `k` is less than or equal to 1000, the 
pointless call to `isPrime` is avoided, eliminating the overhead of the method execution. If the 
order of the operands were swapped, the code would still work correctly but the performance 
advantage would be lost.

```java
if (k > 1000 && isPrime(k)) { 
    // do something
}
```

Another common use of short-circuit evaluation is shown below:

```java
if (y != 0 && x % y == 0) { 
    // do something
} 
```

Here the `if` block will be executed if `x` is a multiple of `y`. But we only want to perform the
remainder operation if `y` is nonzero, since integer division by zero will cause an exception to be
thrown. Short-circuiting prevents the exception: if `y` is zero then the first expression is 
`false`, in which case the second expression will not be evaluated.

Short-circuit evaluation works with logical OR too. Given an expression of the form *E1* `||` *E2*, 
the subexpression *E1* is evaluated first, and if it is true then the entire expression is true 
regardless of *E2*, in which case the latter is not evaluated.
