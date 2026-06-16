# 5.2 `if` Statements

**Key terms**: block

## 5.2.1 Syntax and Semantics

Java provides three statements for conditional execution: `if`, `if`-`else`, and `switch`. The 
general syntax for an `if` statement is:

```java
if (E) {
   // conditionally executed code
}
```

Here *E* denotes a Boolean expression. The statements enclosed in curly braces form a **block**, a 
sequence of one or more statements treated as a single unit. If a block contains only a single 
statement, the braces may be omitted, though including them is generally considered good practice. 

Listing 5.2.1 uses `if` statements to simulate the first roll of a popular dice game. The outcome 
depends on the total rolled, so different messages are displayed under different conditions.

#### Listing 5.2.1 - [ComeOutRoll.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap05/sect2/ComeOutRoll.java){:target="_blank"}
``` java title="ComeOutRoll.java"
--8<-- "code/src/chap05/sect2/ComeOutRoll.java"
```

??? "Output 5.2.1a"
    ```text
    You rolled 4 + 3 = 7. 
    You win.
    ```

??? "Output 5.2.1b"
    ```text
    You rolled 2 + 1 = 3. 
    You lose.
    ```

??? "Output 5.2.1c"
    ```text
    You rolled 3 + 2 = 5. 
    The game continues.
    ```

Statements within a block are always indented to emphasize that they are elements of a higher-level 
structure. This convention is observed in most programming languages. The Java compiler ignores 
whitespace so consistent indentation is not enforced at the language level, but the use of 
indentation to reflect the logical structure of code is generally regarded as one of the most 
important ingredients of good coding style. 

Do not confuse the equals operator (`==`) with the assignment operator (`=`). The former is used to 
compare two values whereas the latter assigns a value to a variable. To illustrate, consider the 
following code:

```java
x = x + 1;
```

It would not make sense to read this as `x` *equals* `x + 1`: two numbers that differ by 1, like 6 
and 7, are not equal. But that is not what the code says. It says, `x` *gets* `x + 1`. When this 
statement is executed, the expression on the right-hand side is evaluated and the result is assigned 
to `x` — that is, the value of `x` is incremented by 1.
