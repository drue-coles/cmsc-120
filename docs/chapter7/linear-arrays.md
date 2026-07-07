# 7.1 Linear Arrays

**Key terms:** array, element type, linear array, one-dimensional array, initializer list, utility 
class, shallow copy, deep copy, clone, command-line arguments

## 7.1.1 Using Arrays 

When rolling a pair of ordinary 6-sided dice, there are 11 possible sums (2-12). Listing 7.1.1a 
calculates the probabilities of these sums. Note the redundancy in the code: there are 11 variable 
declarations, a switch statement with 11 case labels, and 11 arithmetic calculations of the same 
general form. Even if this redundancy were acceptable, the approach would not scale well to 
additional dice or dice with a different number of sides.

#### Listing 7.1.1a - [DiceSums.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect1/DiceSums.java)
``` java title="DiceSums.java"
--8<-- "code/src/chap07/sect1/DiceSums.java"
```

??? "Output 7.1.1a"
    ```text
    SUM  PROBABILITY
      2    2.8%
      3    5.6%
      4    8.3%
      5   11.1%
      6   13.9%
      7   16.7%
      8   13.9%
      9   11.1%
     10    8.3%
     11    5.6%
     12    2.8%
    ```

The solution to the problem of redundancy is to store the sum counters not as separately declared 
and manipulated `int` variables, but as a single array. An **array** is a sequence of items of the 
same type stored contiguously in memory. Because the elements occupy contiguous memory locations, 
the runtime system can immediately determine the address of any element given its index. Listing 
7.1.1b is an improved version of the `DiceSums` program that uses an array for the sum counters. It 
is much shorter and simpler, and also displays the results in the form of a bar chart. To generate 
results for 12- or 20-sided dice, `faces` can be initialized accordingly.

#### Listing 7.1.1b - [DiceSums2.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect1/DiceSums2.java)
``` java title="DiceSums2.java"
--8<-- "code/src/chap07/sect1/DiceSums2.java"
```

??? "Output 7.1.1b"
    ```text
    SUM  PROBABILITY
      2    2.8% ★★★ 
      3    5.6% ★★★★★★ 
      4    8.3% ★★★★★★★★ 
      5   11.1% ★★★★★★★★★★★ 
      6   13.9% ★★★★★★★★★★★★★★ 
      7   16.7% ★★★★★★★★★★★★★★★★★ 
      8   13.9% ★★★★★★★★★★★★★★ 
      9   11.1% ★★★★★★★★★★★ 
     10    8.3% ★★★★★★★★ 
     11    5.6% ★★★★★★ 
     12    2.8% ★★★ 
    ```

The type `int[]` is pronounced *array of ints*, and the array referenced by `sums` is said to have 
**element type** `int`, just as, for example, the element type of `String[]` is `String`. The size 
of an array is fixed when the array is created and cannot be changed afterward. Indexing is 
zero-based as with strings, and indexing into an array out of bounds will cause an exception to be 
thrown. The elements of an array of primitive values are automatically initialized to their default 
values (zero for the numeric types, and `false` for `boolean`). An array type with a single pair of
brackets, such as `int[]` or `String[]`, is called a **linear array**, or **one-dimensional array**. 
Multidimensional arrays are discussed later in this chapter.

## 7.1.2 Initializer Lists

Listing 7.1.2 shows how an array can be declared and initialized in a single statement using an
**initializer list**. This is a list of values or object references to be stored in the array, 
separated by commas and wrapped in curly braces. The program declares several `String` arrays in 
order to fill a sentence template with randomly chosen words. Arrays are objects in Java, and 
each has a `length` attribute that stores its number of elements. The `get` method uses `length` to 
generate a random index in the valid range for the array.

#### Listing 7.1.3 - [LoveLetterGenerator.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect1/LoveLetterGenerator.java)
``` java title="LoveLetterGenerator.java"
--8<-- "code/src/chap07/sect1/LoveLetterGenerator.java"
```

??? "Output 7.1.3"
    ```text
    Dear Jane, I will cherish your unspeakably blinding echo forever! ♥ ♥ ♥
    ```

## 7.1.3 Copying Arrays

In Section 5.1.3, we learned that `BigInteger` has an `equals` method to test for deep equality. 
Arrays also have an `equals` method, but it tests for shallow equality. It would be straightforward 
but tedious to write code for checking if two arrays have the same contents (deep equality). 
However, there is no need: the `Arrays` class in the `java.util` package has over 200 static methods 
for searching, sorting, comparing, copying, and other common operations on arrays. The following 
code shows how two arrays of the same primitive element type can be checked for deep equality. The 
code will also work for arrays of objects provided that their class has an `equals` method that 
tests for deep equality.

```java
if (Arrays.equals(a1, a2)) { 
    // do something
}
```

Arrays is an example of a **utility class**, a collection of static methods for common tasks in a 
specific domain, such as array processing. A utility class cannot be instantiated. The `Math` 
class is another example that we have encountered.

The following code is an erroneous attempt at creating a copy of an existing array. The result is 
two references to the *same* array, a **shallow copy**.

```java
int[] fib = {2, 3, 5, 8, 13, 21, 34, 55, 89}; 
int[] fib2 = fib;
```

A **deep copy** copies the *contents* of an array, not just a reference to it. If you want to 
**clone** an array (that is, deep copy it), you can declare a new array of the same size and use a 
loop to copy each element of the original array into the corresponding position of the new one as 
shown below. (Note that the assignment statement in the loop body is valid for primitive type 
arrays; if we were dealing with arrays of objects, we would need to create a deep copy of each 
`fib[i]` to be assigned to `fib2[i]`, unless the element type is immutable, in which case shallow 
copying of the individual objects would cause no problems.)

```java
int[] fib2 = new int[fib.length]; 
for (int i = 0; i < fib.length; i++) { 
    fib2[i] = fib[i];
}
```

But this is reinventing the wheel because the Java platform provides many useful methods for working 
with arrays. The following examples illustrate some of them.

The `toString` method of the `Arrays` class returns a string representation of an array suitable for 
display:

```java
int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
System.out.println(Arrays.toString(a));
```

??? "Output"
    ```text
    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    ```

The `clone` method creates a deep copy of an array of primitive values. (For arrays of objects, only 
the array itself is copied; the individual objects are not cloned.)

```java
int[] a2 = a.clone();
System.out.println(Arrays.toString(a2));
```

??? "Output"
    ```text
    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    ```

The `copyOf` method creates a new array containing the first specified number of elements of an 
existing array.

```java
int[] a3 = Arrays.copyOf(a, 5);
System.out.println(Arrays.toString(a3));  
```

??? "Output"
    ```text
    [0, 1, 2, 3, 4]
    ```

The `copyOfRange` method creates a new array containing a specified range of elements. The second 
index is exclusive, as with the `substring` method of strings.

```java
int[] a4 = Arrays.copyOfRange(a, 2, 7);   
System.out.println(Arrays.toString(a4));
```

??? "Output"
    ```text
    [2, 3, 4, 5, 6]
    ```

The `arraycopy` method copies a specified number of elements from one existing array into another. 
The parameters are the source array, the starting index in the source, the destination array, the 
starting index in the destination, and the number of elements to copy.

```java
int[] a5 = new int[10];
System.arraycopy(a, 3, a5, 3, 4);
System.out.println(Arrays.toString(a5));  
```

??? "Output"
    ```text
    [0, 0, 0, 3, 4, 5, 6, 0, 0, 0]
    ```

Note that `arraycopy` does not follow Java's usual camel-case naming convention for method names. A 
few methods in the standard library are historical exceptions.

## 7.1.4 Command-Line Arguments

The main method, the entry point to an application, has a parameter (`args`):

```java
public static void main(String[] args) {
    
}
```

It is now clear that `args` is an array of strings. But where does this array come from, and how it 
is used? You are probably running programs in an IDE, but it is possible to compile and run programs 
in a terminal window provided by the operating system. The user could perform these tasks by typing 
the following commands.

```java
javac MyClass.java 
java MyClass
```

The first line invokes the Java compiler (`javac`) and provides the name of the source file to be 
compiled. Assuming there are no syntax errors, the compiler produces a class file (`MyClass.class` 
in this example) containing the bytecode instructions to be interpreted by the JVM. The second line 
invokes the JVM and specifies the compiled class whose main method is to be executed.

It is possible to supply string inputs to a program from the command line. To illustrate, suppose 
the user types the following text on the command line.

```text
java MyClass R5-D4 IG-88
```

The Java runtime system creates an array of strings containing `R5-D4` and `IG-88`, and passes it as
an argument to `main`. The strings can be accessed as shown below.

```java
public static void main(String[] args) { 
    for (int i = 0; i < args.length; i++) { 
        System.out.println(args[i]);
     }
}
```

??? "Output"
    ```text
    R5-D4
    IG-88
    ```

There are numerous practical uses for command-line arguments. To give just one example, consider a 
program that processes a file. Instead of prompting the user for the name of the file, it might be 
convenient for the user to simply run the program from a terminal window and enter the file name 
right on the command line.
