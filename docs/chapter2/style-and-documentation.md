# 2.4 Style and Documentation

**Key terms:** comment, internal documentation, external documentation, style guide, end-of-line comment, block comment, doc comment, Javadoc

## 2.4.1 Internal Documentation

A *comment* is text ignored by the compiler and intended for human readers.

Comments explain:
- purpose
- structure
- rationale
- operational details

Because comments are embedded directly in source code, they are called *internal documentation*.

## 2.4.2 Coding Style

Coding style refers to formatting and organizational practices that improve readability.

Good style includes:
- meaningful names
- consistent indentation
- clear documentation
- appropriate spacing

The code in this book follows a style based on the Google Java Style Guide.

## 2.4.3 Comments in Java

Java supports two kinds of comments.

### End-of-line comments

```java
// this is a comment
```

### Block comments

```java
/*
 * This is a block comment.
 */
```

Example:

```java
// sides of a right triangle
double a; // leg
double b; // leg
double c; // hypotenuse
```

## 2.4.4 Doc Comments

A *doc comment* begins with `/**`.

These comments are processed by the Javadoc tool to generate documentation websites.

Example:

```java
/**
 * Simulates the game of Craps.
 *
 * @author Drue Coles
 */
```

The `@author` line is called a *block tag*.