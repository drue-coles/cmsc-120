# 3.1 Strings

**Key terms:** concatenation operator, instance method, client code, index, zero-based indexing, 
method chaining, static method, class method, format specifier, exception, mutator, setter, 
immutable class, accessor, getter, reference type, garbage collection, named object, anonymous 
object, escape sequence, escape character, newline character, line separator, control character, 
coded character set, code point, ASCII, Extended ASCII, Unicode

## 3.1.1 Concatenation

In ordinary language, a string is simply a sequence of characters, but in Java it is an object —
an instance of the String class from the standard library. Because text processing is so common,
certain aspects of string handling are built directly into the language:

- String literals are automatically converted into String objects.
- Strings can be concatenated using the **concatenation operator** (`+`).
- If only one operand of an expression `x+y` is a string, the other is automatically converted
  to a string before concatenation. It follows that the meaning of the `+` operator depends on
  its operands: with numbers it denotes addition, and with at least one string operand it denotes
  concatenation.

This language-level support for string handling is illustrated in Listing 3.1.1.

#### Listing 3.1.1 - [ConcatDemo.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect1/ConcatDemo.java){:target="_blank"}

??? "Output 3.1.1"
    ```textbutterfly
    10
    2 + 3 + 5
    235
    235
    235
    55
    ```

Note that the `+` operator is evaluated from left to right, so in the expression `"2"+3+5`, the
first operation produces `"23"`, and then `"23"+5` produces `"235"`.

## 3.1.2 Instance Methods

Methods were first discussed in Section 1.2.3. Those remarks were more precisely about **instance
methods**: methods that operate on a particular object — on an instance of a class. Another kind of
method will be introduced in the next subsection.

The general syntax for calling an instance method is `obj.doSomething(args)`, where `obj` is an
object reference, `doSomething` is a method name, and `args` is a comma-separated list of
arguments (possibly empty).

The String class has over 60 instance methods, several of which appear in Listing 3.1.2.

#### Listing 3.1.2 - [InstanceMethodDemo.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect1/InstanceMethodDemo.java){:target="_blank"}

??? "Output 3.1.2"
    ```text
    capybara
    copyboro
    baracapy
    caracara
    ```

The `replace` method returns a new string in which all instances of one character have been
replaced by another. Note the single quotes around `a` and `o`: these denote primitive `char`
values, whereas `"a"` and `"o"` refer to `String` objects.

There is another version of `replace` that takes strings instead of characters, allowing
replacement of longer segments. This is another example of method overloading, introduced in 
Section 2.3, which allows related operations to share a single name, simplifying **client 
code** — code that uses a given class or library.

The following two expressions are functionally equivalent:

```java
s1.replace('a', 'o')
s1.replace("a", "o")
```

The second statement is marginally less efficient because the arguments entail the creation of
two String objects. In general, clarity and simplicity should take precedence over runtime
efficiency — code can always be optimized later if performance is an issue. Here both versions
are equally simple, so the version without the extra objects is preferable.

The next block of the program outputs the two halves of the string in reverse order using the
`substring` method to extract each half. Like `replace`, `substring` is overloaded: one version
takes a starting index (character position) and an ending index, and the other takes only a
starting index and returns the substring from that point to the end. Note that the ending index
is exclusive — the substring does not include the character at that position, so the length of
the substring is the difference between the indices. In Java, indices start at 0. This common
convention (called **zero-based indexing**) simplifies position calculations.

The final statement in the program demonstrates **method chaining** — a technique for invoking
several methods in sequence on the same object:

```java
System.out.println(s1.replaceAll("pyba", "").repeat(2));
```

First, `"pyba"` is removed from `"capybara"` by replacing it with an empty string, producing
`"cara"`. The resulting string then becomes the target of the next call, `repeat(2)`, yielding
`"caracara"`. The equivalent unchained code would be:

```java
String s2 = s1.replace("pyba", "");
String s3 = s2.repeat(2);
System.out.println(s3);
```

## 3.1.3 Static Methods

**Static** (or **class**) methods belong to a class but do not operate on particular instances of 
that class. They perform tasks that are independent of the state of any object. Instance methods, by
contrast, depend on specific objects.

In Listing 3.1.2 the methods `length`, `repeat`, `replace`, and `substring` were used. These are
inherently instance methods: we cannot speak meaningfully about "the length of a string" in the
abstract, only the length of a particular string; likewise, replacing characters is meaningful
only in relation to a particular string.

Static methods are easy to recognize in code. Because they do not access or modify any object's
internal data, they are called through the class name rather than through an object reference.

The `main` method is static because when a program starts, no objects have been created yet, so
there is no instance on which to call an instance method. The entry point therefore must be a
static method that the JVM can invoke directly through the class, without relying on an existing
object.

Listing 3.1.3 introduces two static methods of the String class. The program first constructs a
flight route code by concatenating strings, then shows how the same work can be done more
flexibly using the static methods `String.format` and `String.join` (discussed below). These
methods separate the formatting logic from the data, making it easier to adjust either without
rewriting the entire statement.

#### Listing 3.1.3 - [StaticMethodDemo.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect1/StaticMethodDemo.java){:target="_blank"}

??? "Output 3.1.3"
    ```text
    AY-JFK-HEL-235
    AY-JFK-HEL-235
    AY-JFK-HEL-235
    ```

`String.format` constructs a string from a format string and a list of values. The format string
contains **format specifiers** such as `%s` for strings and `%d` for integers; each specifier is a
placeholder for the corresponding value in the list. Specifiers can also include modifiers that
control alignment, width, precision, and other details. Several of these modifiers will be used
in programs later in the book. Because the behavior of this method depends only on the supplied
arguments and not on the state of an existing string, `String.format` is a static method.

`String.join` takes a delimiter and a sequence of elements and returns a string formed by placing
the delimiter between successive elements. As with `String.format`, the operation depends only on
the supplied values, not on the characters of a particular string.

Note the final argument passed to `String.join`:

```java
String.valueOf(flight)
```

This is also a call to a static method. It is overloaded for each primitive type and returns the
string representation of a given value (an `int` in this case). It is necessary here because
`join` requires string arguments.

This would also work:

```java
"" + flight
```

The value of `flight` is appended to an empty string, so the result is the same. Either approach
is acceptable, but `String.valueOf` is more explicit and therefore easier to understand at a
glance.

## 3.1.4 Exceptions

Suppose `str` refers to a string, and `start`, `end`, and `numCopies` are `int` variables:

```java
String t1 = str.substring(start, end);
String t2 = str.repeat(numCopies);
```

The `substring` method expects `start` and `end` to be valid indices with `start` ≤ `end`, and
`repeat` expects `numCopies` to be non-negative. If one of these conditions is violated, the
method throws an **exception**, a type of runtime error signaling a problem it cannot resolve. 
Java provides support at both the language and the library level for catching and handling 
exceptions, but this requires an understanding of inheritance, which is not covered in this book.
Without such handling in place, exceptions cause a program to terminate and output debugging 
information, including the exception type and the line number from which it was thrown.

## 3.1.5 Immutability

A **mutator** (or **setter**) is a method that modifies an object. A class that provides no 
mutators is called **immutable**. An **accessor** (or **getter**) is a method that returns 
information about an object without changing it.

In Java, strings are immutable: once created, they cannot be changed. Although this may seem
limiting, it simplifies usage. Strings — like dates and colors — are value-like entities, not
things that change over time like students or bank accounts. Because they are immutable, they can
be passed to any method without having to take precautions against the possibility that the
method might alter them. Immutability also enables the JVM to manage strings more efficiently:
when the same character sequence is needed in different parts of a program, a single string can
be stored in memory, and each part of the program can maintain a reference to that string.

The immutability of strings is illustrated in Listing 3.1.5. Calling `toUpperCase` might be
expected to convert the string to uppercase letters, but the second output statement shows that
this is not the case. Instead, the method creates and returns a new string whose letters have
been converted.

#### Listing 3.1.5 - [ImmutabilityDemo.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect1/ImmutabilityDemo.java){:target="_blank"}

??? "Output 3.1.5"
    ```text
    quokka
    QUOKKA
    quokka
    QUOKKA
    ```

The last line of output may seem to indicate that the string has changed, since `println` now
displays uppercase text. This highlights a key distinction between primitive and reference types.
Any type that is not primitive, such as a class, is a **reference type**. A primitive variable 
refers directly to a value, whereas a reference variable stores a pointer to an object in memory. 
Before the last call to `println`, the reference `animal` is reassigned — it now points to the 
string returned by `toUpperCase`. The original string `"quokka"` is unchanged.

What happens to the original string? The JVM tracks all object references at runtime. When an
object becomes unreachable — no variables point to it — its memory can now be reclaimed for
later use by the program. This automatic memory management, called **garbage collection**, is a
feature of many programming languages.

## 3.1.6 Anonymous Objects

An object is said to be a **named object** if a variable refers to it, otherwise it is an 
**anonymous** object. The string created from the literal `"quokka"` below is named — `animal` refers to it —
but the string created and returned by `toUpperCase` is anonymous:

```java
String animal = "quokka";
System.out.println(animal.toUpperCase());
```

Anonymous objects can simplify code by eliminating unnecessary variables. However, if the object
will be needed later, it must be named. The anonymous object in this example could be named and
used like this:

```java
String animal = "quokka";
String upperAnimal = animal.toUpperCase();
System.out.println(upperAnimal);
```

Even when an object is used only once, giving it a descriptive name can sometimes make the code
easier to understand, especially in the case of long statements with multiple method calls.

## 3.1.7 Escape Sequences

An **escape sequence** combines an **escape character** (in Java, a backslash) with one or more
additional characters to be interpreted in a special way, not as literal text. For example, `\n`
represents a **newline character** (line break), also called a **line separator**. Within a 
string, an escape sequence counts as a single character:

```java
String str = "A\nB";
System.out.println(str);
System.out.println(str.length());
```

??? "Output"
    ```text
    A
    B
    3
    ```

The line separator is a **control character**: it has no visible form in a program's output but
affects the layout of the surrounding text. Other examples include backspace (`\b`) and tab
(`\t`).

Escape sequences can also be used to include characters in a string literal that would otherwise
cause a syntax error. For example, suppose you want to output the following text exactly as shown:

```text
She said, "Attack!"
```

You cannot simply wrap it in double quotation marks like this:

```java
System.out.println("She said, "Attack!""); // syntax error
```

The compiler interprets `"She said, "` as a string literal followed by stray text. To include a
double quotation mark in a string, escape it with `\"`.

Backslashes present the same problem:

```java
System.out.println("Here is a backslash: \"); // syntax error
```

Here the backslash is interpreted as the start of an escape sequence. To include a literal
backslash, escape it as `\\`.

These escape sequences are demonstrated in Listing 3.1.7. The final line of output uses Unicode
escapes (`\uXXXX`), which are discussed below.

#### Listing 3.1.7 - [EscapeDemo.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect1/EscapeDemo.java){:target="_blank"}

??? "Output 3.1.7"
    ```text
    A	B	C
    1
    2
    3
    She said, "Attack!"
    Slash: /
    Backslash: \
    Unicode: π ⇆ ♬ ∬ ♥ ★
    ```

## 3.1.8 Unicode

A **coded character set** is a collection of characters paired with integer identifiers called 
**code points**. **ASCII**, created in the 1960s, is one of the earliest standardized character 
sets still in use. It consists of 33 control characters and the 95 printable characters found on a 
standard U.S. keyboard. Code points are in the range 0–127. For example, the code point for `'A'` 
is 65.

**Extended ASCII** adds letters with accents and other diacritical marks (for example, é and ö) to
support European alphabets. It also includes currency and mathematical symbols, arrows,
box-drawing characters, and more, but it is not standardized — different systems may include
different symbols, or they may assign different code points to the same symbol.

**Unicode** is a modern international standard. It specifies more than 128,000 characters from
virtually all the world's writing systems, along with geometric and mathematical symbols,
musical notation, pictographs such as emoji and game symbols, and much more.

Java supports Unicode: comments, identifiers, and string literals can contain Unicode characters
directly, or they can be expressed by an escape sequence `\u` followed by four hexadecimal
digits. For example, the Greek letter π can be written as `\u03C0`.

Most programmers insert Unicode characters directly rather than using the escape form. For
example, the initializer from the listing could be written as:

```java
String symbols = "π ⇆ ♬ ∬ ♥ ★";
```

There are two common uses of the escape form: when the programmer does not have the symbol
available but knows its escape sequence (in which case the IDE will often offer to substitute the
actual character), and when the editor cannot display the character directly because its font or
rendering engine lacks support.

## 3.1.9 Text Blocks

Strings that span multiple lines can be built by concatenating shorter literals, but the content
may be obscured by all the double quotation marks, manually inserted newline characters, and
repeated uses of the concatenation operator:

```java
String raven =
    "Once upon a midnight dreary, while I pondered, weak and weary,\n" +
    "Over many a quaint and curious volume of forgotten lore — \n" +
    "   While I nodded, nearly napping, suddenly there came a tapping,\n" +
    "As of some one gently rapping, rapping at my chamber door.\n" +
    "\"'Tis some visitor,\" I muttered, \"tapping at my chamber door — \n" +
    "      Only this and nothing more.\"";
```

Text blocks, introduced in Java 15, provide a cleaner way to build long strings while preserving
line breaks and indentation:

```java
String raven = """
    Once upon a midnight dreary, while I pondered, weak and weary,
    Over many a quaint and curious volume of forgotten lore — 
       While I nodded, nearly napping, suddenly there came a tapping,
    As of some one gently rapping, rapping at my chamber door.
    "'Tis some visitor," I muttered, "tapping at my chamber door — 
          Only this and nothing more."
    """;
```

A text block begins with three double quotation marks followed by a newline character and ends
with another sequence of three double quotation marks. Everything in between is part of the
string, with predictable handling of whitespace. The compiler preserves the line breaks and the
relative indentation, removing only the common leading indentation so the text remains neatly
aligned.

Text blocks further reduce visual clutter by allowing double quotation marks and backslashes
without escaping, as shown above.
