# 3.4 Keyboard Input

**Key terms:** input stream, output stream, input prompt, locale, numeric promotion, cast, overflow 
error

## 3.4.1 I/O Streams

An **input stream** is an abstract flow of bytes into a program. The source might be the keyboard, a 
file, main memory, a network socket, or another program. Bytes flow out of a program to a terminal, 
file, or other destination through an **output stream**.

All I/O in Java is organized around the stream abstraction. A sequence of bytes has no inherent 
structure, so library classes provide methods that group bytes into blocks and interpret them as 
characters, more complex values such as floating-point numbers, or objects.

## 3.4.2 Scanners

The `Scanner` class provides a constructor for each supported source type and methods for reading 
different types of input. When constructed with the predefined object `System.in`, the input stream 
is connected to the keyboard:

```java
Scanner in = new Scanner(System.in);
int k = in.nextInt();
```

The `nextInt` method reads bytes from the input stream, interprets them as digit characters, and 
returns the corresponding `int` value. If the stream is empty, the method waits until the user 
enters one or more non-whitespace characters and presses ENTER.

If the stream contains a non-digit character (other than an initial `+` or `-`), `nextInt` throws an 
exception.

Listing 3.4.1 performs an exponentiation with a base and exponent entered by the user.

#### Listing 3.4.1 - [PowerCalculator.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect4/PowerCalculator.java){:target="_blank"}

??? "Output 3.4.1"
    ```text
    Enter two integers (base and exponent): 5 13
    5^13 = 1,220,703,125
    ```

The program begins with an **input prompt** — a message to the user describing the expected input. 
Note the use of the `print` method instead of `println`. They differ only in that `print` does not 
append a line separator.

When execution reaches the first call to `nextInt`, the system waits for non-whitespace input. If 
the user enters **5** and **13** as shown above, the scanner reads the **5**, leaving the **13** in 
the stream until `nextInt` is called again.

It would also be possible to prompt for the base and exponent separately:

```java
System.out.print("Enter an integer (base): ");
int base = in.nextInt();
System.out.print("Enter an integer (exponent): ");
int exponent = in.nextInt();
```

??? "Output"
    ```text
    Enter an integer (base): 5
    Enter an integer (exponent): 13
    ```

The original approach — a single prompt — is a bit more user-friendly in this case.

In some programming languages, a caret (`^`) denotes exponentiation, but in Java it is one of the 
bitwise operators (not covered in this book). Java does not have an exponentiation operator, but the 
`Math` class provides over 100 static methods (counting overloads) for common mathematical 
operations, including exponentiation.

Note that the program outputs the result with commas to separate thousands. This is achieved using 
the format specifier `%,d` in the call to `printf`. Recall that `%d` is a placeholder for an 
integral value. The comma in `%,d` instructs `printf` to include locale-appropriate separators.
A **locale** identifies a language and region, which determine conventions for formatting numbers, 
dates, currencies, and other values.

## 3.4.3 Type Conversions

The API documentation for the `Math` class shows that the `pow` method takes two arguments of type 
`double`. In Listing 3.4.1, the arguments supplied are of type `int`. This is allowed because the 
compiler can convert an `int` to a `double` without any loss of information; for example, 3 
becomes 3.0. This automatic widening conversion is called **numeric promotion**.

The documentation also states that `pow` returns a `double`, so assignments such as these are valid:

```java
double x = Math.pow(3.25, 1.5);  // x gets 5.859020822628983
double y = Math.pow(3, 2);       // y gets 9.0
```

But these would not be valid:

```java
int x = Math.pow(3.25, 1.5);  // compile-time error
int y = Math.pow(3, 2);       // compile-time error
```

The compiler rejects these assignments because converting a `double` to an `int` discards the 
fractional part, resulting in a loss of information. If the truncation is intended, the programmer 
must say so explicitly with a **cast** — a request to convert a value from one type to another. The 
target type is written in parentheses immediately before the value:

```java
int x = (int) Math.pow(3.25, 1.5);  // x gets 5
int y = (int) Math.pow(3, 2);       // y gets 9
```

Widening conversions among numeric values are safe and automatic, while narrowing conversions always 
require a cast.

In Listing 3.4.1, the result returned by `pow` is cast to `int` so it can be stored and displayed 
without a decimal point.

## 3.4.4 Overflow Errors

The exponentiation program works correctly up to a point, but try calculating 2<sup>32</sup> and 
2<sup>100</sup>:

??? "Output"
    ```text
    Enter two integers (base and exponent): *2 32*
    2^32 = 2,147,483,647
    ```

??? "Output"
    ```text
    Enter two integers (base and exponent): *2 100*
    2^100 = 2,147,483,647
    ```

The cast causes an **overflow error** in both cases because the value returned by `pow` exceeds the 
limit for an `int`. Overflow occurs whenever a value is converted to a type too narrow to represent 
it.

One might consider using `long` instead:

```java
long result = (long) Math.pow(base, exponent);
```

This allows the program to correctly compute 2<sup>32</sup>, but not 2<sup>100</sup>, which far 
exceeds the maximum `long` value. Why not simply store the result as a `double` so that no cast is 
needed?

```java
double result = Math.pow(base, exponent);
```

A `double` has a much larger range than an `int` or `long`, but it is still finite. Moreover, many 
integers within the range of a `double` have no exact representation in the format used for storing 
floating-point numbers, so the stored value may differ slightly from the mathematically correct 
value.

The underlying issue is that arithmetic on primitives uses fixed-size hardware representations. An 
expression such as `x + y` compiles into a small number of machine instructions that load the 
operands into CPU registers and perform the addition directly in hardware.

The effects of overflow and casting are seen in the following code fragment. The largest `int` value 
is incremented, and the result wraps around to the smallest `int` value (-2<sup>31</sup>). Casting 
to `long` or `double` before adding 1 avoids overflow for this particular calculation.

```java
int x = 2_147_483_647; // 2^31 - 1
System.out.println(x + 1); // overflow
System.out.println((long) x + 1);
System.out.println((double) x + 1);
```

??? "Output"
    ```text
    -2147483648
    2147483648
    2.147483648E9
    ```

The underscores in the value assigned to `x` are used to separate thousands for improved 
readability. The Java compiler ignores any underscores in a numeric literal.

In the next section, the exponentiation calculator will be modified to produce correct results 
(represented by objects, not primitives) for *any* base and exponent.
