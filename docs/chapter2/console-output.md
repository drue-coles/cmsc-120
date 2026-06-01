# 2.2 Console Output

**Key terms:** console application, statement, package statement, standard output stream, string literal, syntax, syntax error, compile-time error, logic error, bug, runtime error

## 2.2.1 Output Statements

A console application interacts with the user through a text interface: input is typed at a keyboard, and output appears in a terminal window. Listing 2.2.1 consists of a main class and a `main` method containing a single statement. In Java, statements play the same role as imperative sentences in English: they are commands, and each ends with a semicolon.

### Listing 2.2.1 – Greetings.java

```java
package javabook.chap2.sect2;

public class Greetings {

    public static void main(String[] args) {
        System.out.println("A star shines on the hour of our meeting.");
    }

}
```

### Output 2.2.1

```text
A star shines on the hour of our meeting.
```

The first line of the listing is a *package statement*. As noted in the previous chapter, a package is a collection of related classes.

`System.out` refers to the standard output stream object created automatically. The `println` method of this object prints text to the console and moves the cursor to the next line. The argument passed to `println` is a *string literal*: a sequence of characters enclosed in double quotation marks.

## 2.2.2 Syntax and Compile-Time Errors

Because Java is case sensitive, a program will not compile if, for example, the keyword `public` is capitalized.

The *syntax* of a programming language is the set of rules governing the structure of valid code, and violations of these rules are *syntax errors*.

A *compile-time error* is any problem detected by the compiler that prevents bytecode generation.

Spacing in a Java program is not a matter of syntax: the compiler ignores whitespace between tokens. Nevertheless, programmers follow widely accepted conventions for spacing to make code easier to read.

## 2.2.3 Logic and Runtime Errors

A syntax error is immediately apparent because the compiler reports it.

Another class of errors arises when code is syntactically correct but does not produce the intended result. These are called *logic errors*, or *bugs*.

For example:

```java
(16 + 64) / 2
```

evaluates to `40`, whereas:

```java
16 + 64 / 2
```

evaluates to `48` because division occurs first.

A separate category of problems occurs when a program is syntactically correct and logically sound but fails during execution. These are called *runtime errors*.