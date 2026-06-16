# 5.4 `switch` Statements

**Key terms**: none introduced

## 5.4.1 Syntax and Semantics

Sometimes a program must choose among several alternatives based on the value of an expression. This 
can always be accomplished with an `if`-`else` chain, but when the same expression is compared 
against several possible values, a `switch` statement is often more compact and easier to read. The 
general syntax is:

```java
switch (value) {
    case a -> // executed if value matches a
    case b -> // executed if value matches b
    case c -> // executed if value matches c
    // other cases
    default -> // executed if no case matches
}
```

The branch whose case label matches the switch value is selected for execution. The `default` 
branch is optional.

Listing 5.4.1 revisits the Craps example from Sections 5.2 and 5.3, using a `switch` statement 
instead of an `if`-`else` chain to determine the output with less code and equal clarity.

#### Listing 5.4.1 - [ComeOutRoll.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap05/sect4/ComeOutRoll.java)
```java title="ComeOutRoll.java"
--8<-- "code/src/chap05/sect4/ComeOutRoll.java"
```

A `switch` can also be used as an expression. Unlike a `switch` *statement*, which performs an 
action, a `switch` *expression* produces a value. The second `switch` in Listing 5.4.1 illustrates 
the idea. 
