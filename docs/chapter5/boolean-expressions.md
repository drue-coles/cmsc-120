# 5.1 Boolean Expressions

**Key terms**: conditional execution, decision statement, expression, operand, binary operator, 
unary operator, ternary operator, Boolean expression, Boolean literal, relational operator, 
shallow equality, deep equality

So far we have seen only **sequential execution** of code: each statement of a method is executed in 
turn. This chapter deals with **conditional execution**, which enables one or more statements to be 
executed only if a specified condition holds. Java has several **decision statements** for this 
purpose. Before introducing them, it is necessary to understand how **expressions** are constructed 
and evaluated in Java.

## 5.1.1 Expressions and Operators

An **expression** is a collection of values combined by operators to produce a single value. The
values are called **operands**. An operand can be an explicit value, a value returned by a method,
or another expression. Most operators in Java are **binary operators**; that is, they are applied to 
exactly two operands. The addition operator (`+`), for example, combines two numeric values to form 
a sum. Java also has several **unary operators**, which act on a single operand, and even a 
**ternary operator** (three operands) introduced later in this chapter.

**Boolean expressions** are expressions that evaluate to true or false. There are two **Boolean 
literals** in Java, `true` and `false`. Recall that `boolean` is one of the primitive types. A 
`boolean` variable can be assigned one of these literals, or the value of another Boolean 
expression.

Java's **relational operators** can be used to construct Boolean expressions involving numbers. For 
example, `x < 0` is `true` if the value of `x` is less than zero. Java’s other relational operators 
are `<=` (less than or equal to), `>`, `>=`, `==` (equals), and `!=` (not equals). 

## 5.1.2 Deep Equality

It is usually a mistake to compare object references with the `==` operator. Listing 5.1.2 
highlights the underlying problem.

#### Listing 5.1.2 - [DeepEquality.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap05/sect1/DeepEquality.java){:target="_blank"}

??? "Output 5.1.2"
    ```text
    int values: 123 == 123 is true
    BigIntegers: 123 == 123 is false
    BigIntegers: 123.equals(123) is true   
    ```

The first line of output is no surprise, but what about the second? The key fact here is that `b1` 
and `b2` are object *references*, not objects. They are the memory locations of two different 
`BigInteger`s that happen to be in the same state (both represent the number 123). This is why the 
expression `b1 == b2` is false.

If `x` and `y` are object references, the expression `x == y` is a test for **shallow equality** — 
whether they refer to the same object. Programmers generally intend to compare the *states* of 
two objects rather than their identities. The condition of two objects being in the same state is 
known as **deep equality**, and `BigInteger` has an `equals` method to test for it. The `equals` 
method is used in Listing 5.1.2 to generate the third line of output.
