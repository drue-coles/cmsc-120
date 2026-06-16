# 3.2 Creating Objects

**Key terms:** constructor, canonical name, simple name, import statement, convenience method, 
refactor, factory method

## 3.2.1 Constructors

While String objects are automatically created from string literals, all other objects are created 
with the `new` operator and initialized by a special class member called a **constructor**. 
Constructors are similar to methods: they are sequences of instructions and may take arguments. 
Every constructor, however, has a fixed name—the name of its class—and its sole purpose is to 
initialize a newly allocated object. Constructors can be overloaded for different forms of 
initialization.

Each explicit creation of an object in Listing 3.2.1 follows the same pattern at runtime: `new` 
allocates memory for the object, the specified constructor is executed, and a reference to the 
object is returned.

#### Listing 3.2.1 - [ConstructorDemo.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect2/ConstructorDemo.java)
``` java title="ConstructorDemo.java"
--8<-- "code/src/chap03/sect2/ConstructorDemo.java"
```

??? "Output 3.2.1"
    ```text
    10000000000200000000001
    {1, 3, 4, 7, 8}
    quoll
    ```

The `BigInteger` class represents integers with arbitrarily many digits. It will be introduced more 
fully later in the chapter and used in examples throughout the book. Here, an instance is created by
passing a string of digits to the constructor. The expression `val.pow(2)` produces a new 
`BigInteger` whose value is the square of the integer modeled by `val`.

`BitSet` stores on/off flags using a compact internal representation. The class also provides 
methods to combine and modify bit sets, producing results based on the logical relationships between 
the flags in each set. An instance of this class could be used, for example, to track which users of 
an online service are currently logged in.

The `Properties` class stores a collection of key-value pairs of strings. In the listing, several 
pairs are added with `setProperty`, and one value is retrieved and displayed with `getProperty`.

## 3.2.2 The toString Method

The program outputs instances of `BigInteger`, `BitSet`, and `Properties` the same way it outputs 
strings and primitive values—by passing them to `println`. This may seem to imply that there is an 
overload of `println` for each of these types, but instead there is a single version that accepts an 
object of any type, converts it to a string, and outputs the string.

But how does `println` convert an arbitrary object to a string? Every object has a `toString` method 
for this purpose, which returns a text description of the object's current state. 

The compiler also converts an object to a string when needed for string concatenation. For example:

```java
BigInteger avConstant = new BigInteger("602214076000000000000000");
System.out.println("Avogadro's constant: " + avConstant);
```

The left operand of `+` is a string, so the right operand must also be a string. The compiler 
inserts a call to `avConstant.toString()` for this purpose.

The `toString` method can also be called directly, as shown in the following code fragment:

```java
// display last 10 digits
String digits = bigInteger.toString();
int n = digits.length();
System.out.println(digits.substring(n - 10));
```

## 3.2.3 Import Statements

The `BigInteger` class is defined in the `java.math` package. The full name of a class, which 
includes its package, is called its **canonical name**. The abbreviated name without the package is 
the **simple name**. Some classes in the Java API share a simple name but reside in different 
packages, so they are distinguished by their canonical names; for example, `java.sql.Date` and 
`java.util.Date`.

Writing canonical names throughout a program would be cumbersome. In Listing 3.2.1, only simple 
names appear. This is legal because of the import statements near the top of the file. An 
**import statement** tells the compiler that a given simple name refers to a specified canonical 
name. For example, we can write `BigInteger` because an import statement maps that simple name to 
`java.math.BigInteger`.

You may have noticed that we used `String` and `System` without import statements. These classes 
belong to the `java.lang` package, whose classes are implicitly imported in every Java source file.

## 3.2.4 StringBuilders

The `StringBuilder` class models a mutable sequence of characters. Unlike strings, `StringBuilder` 
objects are created with the `new` operator and initialized by a constructor.

In Listing 3.2.4, characters in a `StringBuilder` are replaced and reversed. The program's output 
confirms that the objects themselves are modified by the mutators.

#### Listing 3.2.4 - [StringBuilderDemo.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect2/StringBuilderDemo.java)
``` java title="StringBuilderDemo.java"
--8<-- "code/src/chap03/sect2/StringBuilderDemo.java"
```

??? "Output 3.2.4"
    ```text
    FINLAND
    ICELAND
    GATEMAN
    NAMETAG
    ```

`StringBuilder` also provides convenience methods for insertion and deletion. A 
**convenience method** is a shortcut to existing functionality — it provides a simpler or more 
intuitive way to perform a task that could be done with other methods. For example, inserting and 
deleting characters could be done through replacements.

Whatever can be done with `StringBuilder` objects can also be done indirectly with strings. Strings 
cannot be changed, but new strings can be created and combined to bring about the same effect. This 
is illustrated by the following two code fragments, which produce the same output:

```java
StringBuilder country = new StringBuilder("FINLAND");
country.replace(0, 3, "ICE");
System.out.println(country); // ICELAND
```

```java
String country = "FINLAND";
country = "ICE" + country.substring(3);
System.out.println(country); // ICELAND
```

Strings are convenient for construction, concatenation, and general text processing. When a sequence 
of edits is required, however, `StringBuilder` objects can simplify the code.

`StringBuilder` objects can also be more efficient. Because strings are immutable, repeated 
modifications create temporary objects, increasing runtime overhead.

This book emphasizes simplicity over runtime efficiency, so strings are generally used. It is worth 
noting, however, that IDEs often suggest refactoring blocks of code with repeated string 
concatenations to use a `StringBuilder` instead. **Refactoring** is the process of restructuring 
code without changing its behavior.

## 3.2.5 Factory Methods

A **factory method** is a static method that provides an object of its class to client code. It may 
create a new object and initialize it with a constructor call, or it may return a reference to an 
existing object. Classes sometimes offer factory methods in addition to, or instead of, constructors 
for several reasons, including:

* They can have descriptive names that clarify the purpose or configuration of the object.

* Differently named factory methods can provide different forms of initialization for the same 
arguments, which is not possible for constructors since their name is fixed, and overloads must 
have different numbers or types of arguments. 

* When an object can safely be shared across an 
application, factory methods can return a reference to the same instance instead of creating a new 
one.

In Listing 3.2.5, `System.out.printf` (*f* is for *format*) outputs currency symbols and dates. It 
formats strings containing various types of data in the same way as `String.format` (Section 3.1.3). 
The `%n` at the end of the format string is an escape sequence for a line separator. While `\n` 
usually works, the correct encoding of a line separator is platform-dependent. However, `printf` and 
`String.format` replace `%n` with the correct platform line separator (probably `\n` or `\r\n`).

#### Listing 3.2.5 - [FactoryMethodDemo.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect2/FactoryMethodDemo.java)
``` java title="FactoryMethodDemo.java"
--8<-- "code/src/chap03/sect2/FactoryMethodDemo.java"
```

??? "Output 3.2.5"
    ```text
    Currency symbols: € £ ¥ $
    First moon landing: Sunday, July 20, 1969
    Today: Friday, November 28, 2025
    ```

The `Currency.getInstance` factory method accepts a standard ISO 4217 currency code (like `USD`) and 
returns a `Currency` object. Because the class is immutable, the method can cache commonly used 
instances. The `LocalDate.of` factory method returns an instance representing a specified date, and 
`LocalDate.now` returns one for the current date according to the system clock.

Consider the following alternative code for outputting a date:

```java
LocalDate apollo11 = LocalDate.of(1969, 7, 20);
System.out.printf("First moon landing: " + apollo11);
```

??? "Output"
    ```text
    First moon landing: 1969-07-20
    ```

The implicit invocation of `toString` on `apollo11` produces a result in YYYY-M-D format. In Listing 
3.2.5, a `DateTimeFormatter` is used instead to produce a custom format. The factory method 
`DateTimeFormatter.ofPattern` takes a pattern string and returns an object whose `format` method 
converts a `LocalDate` (or any other `java.time` date-time type) into a string following that 
pattern.
