# 7.3 Array Lists

**Key terms:** array list, generic class, type variable, angle brackets, type argument, 
diamond, wrapper class, autoboxing, unboxing, boxed primitives

## 7.3.1 Generic Types

Consider two situations in which the use of an array presents a problem:

1. You need to maintain a list of items that can be directly accessed through a positional index. 
The number of items may vary greatly during program execution, and the maximum number may be 
impossible to predict. However, the size of an array must be specified when it is created and
can never change. One solution is to declare an array large enough to accommodate any expected 
number of items, but this may waste memory. Alternatively, a small array could be used initially, 
and if more space is needed a larger array could be created with the contents of the old one copied
into it.

2. You want to insert and remove items at specified positions. Arrays have no methods for these 
operations, but it is possible to write code that shifts elements to make room for an insertion or 
to close a gap left by a removal.

The `ArrayList` class in `java.util` is intended to deal with these issues. It manages a linear 
array internally and provides a layer of abstraction on top in the form of methods for inserting and 
removing elements at specified positions. In general programming terms, an **array list** is a 
dynamically resizable array with insert/remove functionality. 

Sometimes the name of the class is written as `ArrayList<E>` to emphasize that it is a **generic 
class**. This means that it is defined with one or more **type variables** (one in this case, 
denoted by `E`) inside **angle brackets** (`<` and `>`). For `ArrayList`, the type variable serves 
as a parameter for the element type of the list. When the class is instantiated, a **type argument** 
is provided in place of the variable, which enables `ArrayList` to be used for storing objects of 
any kind.

The code below illustrates the creation of two array lists, one for strings and another for circles. 
Note that the type argument is omitted from the angle brackets on the right since it is already 
specified on the left. The angle brackets are often referred to collectively as the **diamond**.

```java
ArrayList<String> listOfStrings = new ArrayList<>(); 
ArrayList<Circle> listOfCircles = new ArrayList<>();
```

The compiler ensures that the type of an object added to an array list is compatible with the type 
argument used to instantiate it. In the preceding code, for example, only strings can be added to 
`listOfStrings`. Listing 7.3.1 demonstrates basic array list functionality. 

#### Listing 7.3.1 - [AnimalList.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect3/AnimalList.java)
``` java title="AnimalList.java"
--8<-- "code/src/chap07/sect3/AnimalList.java"
```

??? "Output 7.3.1"
    ```text
    [ant, bat, cow, fox, yak]
    [ant, bat, emu, cow, fox, yak]
    [ant, bat, emu, pig, fox, yak]
    [ant, bat, emu, fox, yak]
    [ant, bat, emu, yak]
    ```

The subject of generics in Java is broad and important, but it is treated here only to the extent
needed for a practical understanding of the `ArrayList` class.

## 7.3.2 Wrapper Classes

A **wrapper class** provides an object-like container for a primitive type value. For each of 
the eight primitive types, there is a corresponding wrapper class in `java.lang`: the `Integer` 
class wraps an `int` value, the `Long` class wraps a `long` value, and so on. 

In the following code, an `Integer` is created using the factory method `valueOf`, and the wrapped 
value is subsequently extracted by a call to the `intValue` method.

```java
Integer k = Integer.valueOf(23); 
int val = k.intValue();
```

What is the point of this? If a program needs an `int`, why not use an `int` rather than an object 
that stores one?

It turns out that, for technical reasons that need not be considered here, a generic class cannot be
instantiated with a primitive type, so if you want, say, an array list of `int` values then you must
use `Integer` objects. This is not quite as cumbersome as you might think, thanks to **autoboxing**
and **unboxing**. These features enable the preceding code fragment to be written more intuitively 
as shown below. 

```java
Integer k = 23; 
int val = k;
```

At first glance, both statements seem to involve type mismatch errors: a primitive type appears on 
one side of the assignment operator and a reference type on the other. However, in the first 
statement, the compiler automatically *boxes* the value `23` into an `Integer`. Similarly, it 
automatically unboxes `k` to produce the `int` value in the second statement. Wrapper class 
objects are often referred to as **boxed primitives**.

The wrapper classes also provide several useful constants and static methods. It is worth reviewing 
the API documentation for these classes since some of the constants and methods are commonly used. 
Listing 7.3.2 uses an array list of `Integer`s to hold the terms of a certain numerical sequence.
Autoboxing occurs in the helper method, where each `int` value is automatically converted to an 
`Integer` object before being added to the list. An array list can also be the target of a for-each 
loop. In the loop in `main`, each `Integer` in the list is automatically unboxed to an `int` before 
being assigned to the loop variable `n`.

#### Listing 7.3.2 - [Hailstones.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect3/Hailstones.java)
``` java title="Hailstones.java"
--8<-- "code/src/chap07/sect3/Hailstones.java"
```

??? "Output 7.3.2"
    ```text
    Enter a positive integer: 10001
    Calculating the hailstone sequence starting at 10,001...
    Number of terms: 180
    Number of records: 11
    Maximum value: 250,504
    ```
