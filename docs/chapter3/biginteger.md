# 3.5 Unbounded Integers

**Key terms:** class constant, constant case

Some languages provide integers of essentially unlimited size directly through their built-in 
numeric types. Such values are represented internally as sequences of fixed-width units (usually 32- 
or 64-bit chunks), with arithmetic performed by software routines that operate across those units. 
Java, however, provides this capability through a library class, `BigInteger`.

Java does not support operator overloading, which allows classes to define the behavior of operators 
on their instances, so arithmetic operations on `BigInteger` objects must be expressed through 
method calls:

```java
// compute (x + y) * (x - y)
z = x.add(y).multiply(x.subtract(y));
```

`BigInteger`, like `String`, is immutable: a call such as `x.add(y)` creates and 
returns a new 
`BigInteger` without modifying the object referenced by `x`.

## 3.5.1 Constructing BigIntegers

A `BigInteger` can be constructed from a string of digits:

```java 
String digits = in.next();
BigInteger base = new BigInteger(digits);
```

The scanner’s `next` method returns the exact character sequence entered by the user. If the 
sequence contains any non-digit character (other than an optional leading sign), the constructor 
throws an exception.

`Scanner` also provides `nextBigInteger`, which reads and parses the input in a single step. In 
Listing 3.5.1, this method is used to obtain the base, while the exponent is read as an `int` with 
`nextInt`. The exponentiation is then performed with `BigInteger`’s `pow` method, avoiding the 
overflow that occurred with primitive values using `Math.pow`.

The `printf` method can format a `BigInteger` with `%,d` as if it were an `int`.

#### Listing 3.5.1 - [PowerCalculator.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect5/PowerCalculator.java){:target="_blank"}

??? "Output 3.5.1"
    ```text
    Enter two integers (base and exponent): 2 100
    2^100 = 1,267,650,600,228,229,401,496,703,205,376
    ```

In addition to string-based construction, `BigInteger` provides the factory method `valueOf` for 
creating a `BigInteger` from a primitive integer value:

```
BigInteger n = BigInteger.valueOf(23);
```

This form is preferred because it makes the programmer’s intent explicit and aligns with a general 
Java convention of using factory methods to create number-like objects from primitive values. It 
also avoids the unnecessary creation of a string.

## 3.5.2 Class Constants

A **class constant** is an unmodifiable variable associated with a class. The `Math` class, for 
example, defines `Math.E` and `Math.PI`, storing double approximations of the mathematical constants 
e and π.

The `BigInteger` class defines constants representing 0, 1, 2, and 10. These provide canonical 
objects for common values to avoid repeated allocation and initialization. For example:

```java
// 2^127 - 1 is a Mersenne prime
BigInteger prime = BigInteger.TWO.pow(127).subtract(BigInteger.ONE);
System.out.printf("2^127 – 1 = %,d %n", prime);
```

??? "Output"
    ```text
    2^127 – 1 = 170,141,183,460,469,231,731,687,303,715,884,105,727
    ```

By convention, class constants are written in **constant case**: all capital letters with 
underscores separating meaningful parts of compound names (as in `MAX_VALUE`). The Java API does not 
always follow this convention, but it remains standard practice.
