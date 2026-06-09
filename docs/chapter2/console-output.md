# 2.2 Console Output

**Key terms:** console application, statement, package statement, standard output stream, string 
literal, syntax, syntax error, compile-time error, whitespace, logic error, bug, runtime error

## 2.2.1 Output Statements

A **console application** interacts with the user through a text interface: input is typed at a 
keyboard, and output appears in a terminal window. Listing 2.2.1 consists of a main class and a 
`main` method containing a single statement. In Java, **statements** play the same role as 
imperative sentences in English: they are commands, and each ends with a semicolon.

#### Listing 2.2.1 - [Greetings.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap02/sect2/Greetings.java){:target="_blank"}

??? "Output 2.2.1"
    ```text
    A star shines on the hour of our meeting.
    ```

The first line of the listing is a **package statement**. As noted in the previous chapter, a 
package is a collection of related classes.  Package statements have no effect on execution, but 
they tell the compiler where the file is stored within the project or library to which it belongs. 
For example, the package name 'javabook.chap2.sect2' in Listing 2.2.1 corresponds to a directory 
path 'javabook/chap2/sect2' within the project’s source directory. By convention, only lowercase 
letters are used, with periods as separators. 

Package names in the Java API start with 'java' or 'javax'; for example, the 'java.time' package 
contains classes representing dates, times, instants, and durations.

Packages are not required — in principle, all source files of a project could be placed directly 
within its source folder — but even for small projects it is considered best practice to organize 
its classes into one or more packages.

The 'main' method of Listing 2.2.1 contains a single output statement. Console I/O (input and 
output) is a complicated activity requiring specialized knowledge of the underlying system, but the 
details are made simple for Java programmers because the standard library provides convenient 
abstractions.

`System.out` refers to the **standard output stream** object created automatically. The `println` 
method of this object prints text to the console and moves the cursor to the next line. The argument 
passed to `println` is a **string literal**: a sequence of characters enclosed in double quotation 
marks.

## 2.2.2 Syntax and Compile-Time Errors

Because Java is case-sensitive, a program will not compile if, for example, the keyword `public` is
capitalized. It will also fail to compile if a semicolon is omitted at the end of a statement, 
square brackets are used where curly braces are required, or any other syntactic rule is violated. 
The **syntax** of a programming language is the set of rules governing the structure of valid code, 
and violations of these rules are **syntax errors**. A complete formal description of Java syntax 
is provided in the <a href="https://docs.oracle.com/javase/specs/">Java Language Specification</a>. 

If you receive a message from a friend with spelling or grammatical errors, you can usually infer 
what was meant. A compiler cannot. Its task is mechanical: to translate valid source code into 
bytecode instructions for the JVM. When the code contains a syntax error, the compiler cannot 
complete this translation and instead reports an error, usually with an indication of the line 
where the problem was found. 

Syntax errors form only one category of problems the compiler can detect. Even when a program 
satisfies all syntactic rules, the compiler performs additional checks that go beyond surface 
structure. The nature of these checks will become clear as new language features are introduced in 
later sections. A **compile-time error** is any problem detected by the compiler that prevents 
bytecode generation, whether due to a syntax error or a violation of one of the additional rules of 
the language. 

Spacing in a Java program is not a matter of syntax: the compiler ignores **whitespace** (spaces, 
tabs, and line breaks) between tokens. Nevertheless, programmers follow widely accepted conventions 
for spacing to make their code easier to read. Coding style will be discussed more fully in Section 
2.4.

## 2.2.3 Logic and Runtime Errors

A syntax error is immediately apparent because the compiler reports it, and the problem can be 
corrected by rewriting the offending code according to the rules of the language. Another class of 
errors arises when the code is syntactically correct but does not produce the intended result. These 
are called **logic errors**, or **bugs**. For example, suppose the average of two numbers is 
calculated like this:

```java
(16 + 64) / 2
```

This evaluates to 40, which is correct, but now suppose the parentheses are omitted: 

```java
16 + 64 / 2
```

Now following the order of operations as in ordinary arithmetic, 64/2 is evaluated first, producing 
48 as the final result. 

In large and complex applications, logic errors can go unnoticed for years, and in mission-critical 
software they can lead to catastrophic results. Rigorous testing to detect and correct logic errors 
is an essential part of professional software development.

A separate category of problems occurs when a program is syntactically correct and logically sound 
but fails during execution. These are called **runtime errors**. They cannot be anticipated by the 
compiler and are detected only during execution, often causing abrupt termination. Specific causes 
will be discussed later.
