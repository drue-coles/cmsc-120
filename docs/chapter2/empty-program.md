# 2.1 An Empty Program

**Key terms:** method header, method body, keyword, main class

We begin with the simplest possible Java program — one that does nothing. You might not expect 
this to be very enlightening, but it will show you the technical infrastructure required for every 
Java program, regardless of its size or purpose.

A program is a sequence of instructions, but instructions in Java are not freestanding — they 
must occur within a method. The entry point to a Java application is a special method named `main`, 
which always looks exactly like this:

```java
public static void main(String[] args) {

}
```

The first line is the **method header**, and the **method body** (here empty) follows, enclosed in 
curly braces.

The words `public`, `static`, and `void` are **keywords** — reserved words with specific meanings 
in the language. The original release of Java defined 47 keywords, and recent versions define 51, 
with an additional 17 contextually reserved — that is, reserved only in specific contexts.

The meanings of the keywords in the header and the parenthetical code will become clear later; for 
now, it suffices to know that the `main` method is always written the way you see it here. Java is 
case sensitive, so pay close attention to capitalization — only the first letter in `String` is 
capitalized, for example.

> **Note:** In recent versions of Java, the `public` modifier is optional for `main`; it is included in the program listings of this book for consistency with standard practice and legacy code.

The `main` method cannot be compiled in isolation because, by definition, methods belong to 
classes — there are no stand-alone methods in Java. We must therefore place the definition of our
`main` method within a class. For that purpose, we can simply choose a name for the class, say 
`SimpleClass`:

```java
public class SimpleClass {

    public static void main(String[] args) {

    }

}
```

In general, classes define blueprints for creating objects: they specify the attributes and methods 
that characterize those objects. However, there is an exception to this general scheme. Sometimes a 
class serves only as a container for the `main` method, in which case it is called a **main class**.

To write a program in Java, then, is to define a main class with a `main` method containing the 
instructions to be executed. The preceding code fragment represents a complete Java program: a 
public main class with an empty `main` method.
