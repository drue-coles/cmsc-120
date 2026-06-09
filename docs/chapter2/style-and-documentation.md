# 2.4 Style and Documentation

**Key terms:** comment, internal documentation, external documentation, style guide, end-of-line 
comment, block comment, doc comment, Javadoc, summary fragment, block tag

## 2.4.1 Internal Documentation

A **comment** in source code is text written by the programmer that is ignored by the compiler. 
Comments explain the purpose of the code, clarify its logical structure, or note operational details 
that may not be obvious to another programmer. They may accompany variable declarations, statements, 
methods, or entire classes. Comments should focus on intent and rationale — the reader is assumed 
to know the language, so syntax and general programming principles do not need to be explained. 
Because comments are embedded directly in source files, they are referred to as **internal 
documentation**.

**External documentation**, by contrast, is separate from the source code. It may include user 
guides, reference manuals, or online documentation generated from source comments. The Java API 
Specification (Section 1.4.2), for example, is stored in HTML files for viewing in a browser.

The word *documentation* in this book will always refer to internal documentation.

It may surprise you to learn that documenting your code is considered an essential part of 
programming. There are several reasons for this: 

1.	Large-scale software development is almost always collaborative. Programmers working on related 
components must understand each other’s code for the components to interoperate properly.

2.	Most of the lifetime cost of software lies in maintenance—debugging, optimizing, and extending 
functionality—but the maintainer may not be one of the original developers.

3.	Even code written for your own use can become opaque over time. Many programmers learn this the
hard way when trying to modify code they wrote last year, last week, or maybe even last night — what 
seemed obvious at the time is now mysterious.

4.	Well-documented code is more likely to be robust and extensible (Section 1.2.4).

Many professional developers write extensive documentation before they start coding. This requires 
discipline but pays dividends: it helps organize thoughts, clarify intentions, and anticipate 
potential difficulties.

## 2.4.2 Coding Style

Coding style refers to features of source code that do not affect functionality but make the code 
easier to read and understand. Good style includes clear documentation, meaningful identifier names, 
consistent indentation, and other formatting practices.

A **style guide** specifies these elements for a particular language. Such guides exist for 
development teams, companies, and large open-source projects. 

The elements of good style are not arbitrary, so you will not have to learn an entirely new set of 
conventions when moving from one domain to another. Most style guides are consistent with widely 
accepted practices for writing clear code, differing only in minor details.  

The code in this book follows a style based on the 
<a href="https://google.github.io/styleguide/javaguide.html">Google Java Style Guide</a>.

## 2.4.3 Comments in Java

There are two kinds of comments in Java:

1.	**End-of-line comments** begin with two consecutive forward slashes (`//`); the compiler ignores 
all text from that point to the end of the line.

2.	**Block comments** begin with slash-star `/*` and end with `*/`; the compiler ignores all text 
between these markers.

For example, suppose a program calculates the straight-line distance between two cities from their 
vertical and horizontal separations — a direct application of the Pythagorean theorem. Three 
variables are declared for this purpose:

```java
double a; 
double b; 
double c; 
```

Another programmer reading this code might wonder what these variables represent. Descriptive names 
could help, but if we want to retain the traditional notation *a*, *b*, and *c* for the sides of a 
right triangle, comments can provide the needed context:

```java
// sides of a right triangle 
double a; // leg 
double b; // leg 
double c; // hypotenuse
```

A block comment can be used for longer explanations:

```java
/* 
 * Simulates the game of Craps. The player rolls two dice. A sum of 
 * 7 or 11 wins, and 2, 3, or 12 loses. In any other case the player 
 * keeps rolling until obtaining the first sum (wins) or 7 (loses). 
 */
```

The asterisks aligning with `/*` and `*/` are decorative but conventional. The same content could 
also be written with end-of-line comments:

```java
// Simulates the game of Craps. The player rolls two dice. A sum of 
// 7 or 11 wins, and 2, 3, or 12 loses. In any other case the player 
// keeps rolling until obtaining the first sum (wins) or 7 (loses).
```

## 2.4.4 Doc Comments

Classes are preceded by a special kind of block comment called a **doc comment**, which begins with 
an extra asterisk (`/**`). Doc comments are recognized by the **Javadoc** tool (part of the JDK), 
which reads them to generate web-based documentation in a standard format — the one used by the 
Java API Specification. In this book, a doc comment for a main class consists of a concise 
description of the program’s purpose, followed by a blank line and the author’s name; for example:


```java
/**
 * Simulates the game of Craps. The player rolls two dice. A sum of 
 * 7 or 11 wins, and 2, 3, or 12 loses. In any other case the player 
 * keeps rolling until obtaining the first sum (wins) or 7 (loses). 
 *
 * @author Drue Coles 
 */

```

The description is written in grammatically correct English, except for the initial summary 
fragment, which starts with an action verb and ends with a period. It summarizes the program’s 
purpose at the highest level of generality and is typically placed by Javadoc in the overview tables 
where classes in a package are listed. The remainder of the description appears in the detailed 
class documentation.

The author is identified using a special **block tag**, a structured, line-based annotation. 
Additional block tags will be used in doc comments for methods, starting in Chapter 4. 
