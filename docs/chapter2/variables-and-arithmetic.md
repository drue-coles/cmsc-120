# 2.3 Variables and Arithmetic

**Key terms:** type, primitive type, variable, declaration, initializer, identifier, static typing, type safety, method overloading, lower camel case, upper camel case

## 2.3.1 Primitive Types

A *type* is a classification of data specifying a set of values and the operations that can be performed on them.

Java defines eight primitive types. Seven represent numbers, and the remaining type, `boolean`, represents truth values.

The numeric types include:

- `byte`
- `short`
- `char`
- `int`
- `long`
- `float`
- `double`

The types `float` and `double` are *floating-point types*.

## 2.3.2 Variables

A *variable* is a symbolic name for a memory location where a value is stored during program execution.

An `int` variable named `x` is declared like this:

```java
int x;
```

A variable can also be initialized when declared:

```java
int y = 3;
```

The equals sign (`=`) is the *assignment operator*.

## 2.3.3 Static Typing

In a statically typed language such as Java, every variable must have a fixed type known at compile time.

Static typing improves *type safety* by preventing invalid operations.

## 2.3.4 The `var` Keyword

Introduced in Java 10, the `var` keyword allows the compiler to infer a variable’s type from its initializer.

```java
var greeting = "Hello";
var count = 3;
```

The variable still has a fixed type.

## 2.3.5 Arithmetic Operators

Java has five arithmetic operators:

- `+`
- `-`
- `*`
- `/`
- `%`

### Listing 2.3.4 – ArithmeticDemo.java

```java
public class ArithmeticDemo {

    public static void main(String[] args) {

        int x = 3;
        int y = 5;

        int z = (x + y) * (x - y);

        System.out.println(z);
        System.out.println(14 / 3);
        System.out.println(14 % 3);

    }

}
```

### Output 2.3.4

```text
-16
4
2
```

The `println` method is overloaded to handle different argument types.

## 2.3.6 Choosing Variable Names

Two important naming conventions are:

1. Use descriptive names.
2. Use lower camel case for variables and methods.

Examples:

```java
totalDistance
userName
```

Class names use upper camel case:

```java
BankAccount
FlightSchedule
```