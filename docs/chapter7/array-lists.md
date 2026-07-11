# 7.3 Array Lists

**Key terms:** array list, generic class, type variable, angle brackets, type argument, 
diamond, wrapper class, autoboxing, unboxing, boxed primitives

## 7.3.1 Generic Types

Let's imagine two scenarios involving the use of arrays and consider how we might try to code our 
way around certain difficulties. 

• You need to maintain a list of items that can be directly accessed through a positional index. 
The number of items may vary greatly during program execution, and the maximum number may be 
impossible to predict. This presents a problem since the size of an array must be specified at the
point of creation and it can never change. One solution might be to declare an array so large that 
it is bound to suffice, but this inefficient use of memory could impact performance. Alternatively,
a small array could be used initially, and if more space is needed a larger array could be created
with the contents of the old one copied into it.

• You want to insert and remove items at specified positions. Arrays have no methods for these 
operations, but you could write your own code to shift a range of elements within an array to make
space for an item to be inserted or to overwrite one to be removed.

The `ArrayList` class in `java.util` is intended to deal with these issues. It manages an ordinary 
linear array internally and provides a layer of abstraction on top in the form of methods for 
inserting and removing elements at specified positions. In general programming terms, an **array 
list** is a dynamically resizable array with insert/remove functionality. 

Sometimes the name of the class is written as `ArrayList<E>` to emphasize that it is a **generic 
class**. This means that it is defined with one or more **type variables** (one in this case, 
denoted by `E`) inside **angle brackets** (`<` abd `>`). For `ArrayList`, the type variable serves 
as a parameter for the element type of the underlying array. When the class is instantiated, a 
**type argument** is provided in place of the variable, which enables `ArrayList` to be used for 
storing objects of any kind.

The code below illustrates the creation of two array lists, one for strings and another for circles. 
Note that the type argument is omitted from the angle brackets on the right side of the assignment 
operator since it is already specified on the left. The angle brackets are often referred to 
collectively as the **diamond**.

```java
ArrayList<String> listOfStrings = new ArrayList<>(); 
ArrayList<Circle> listOfCircles = new ArrayList<>();
```

The compiler ensures that the type of an object added to an array list is compatible with the type 
argument used to instantiate it. In the preceding code, for example, only strings can be added to 
`listOfStrings`. Listing 7.4.1 demonstrates basic array list functionality. As shown in the  
`concat` method, an array list can be traversed with a for-each loop.

#### Listing 7.3.1 - [RandomizedPlaylist.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect3/AnimalList.java)
``` java title="AnimalList.java"
--8<-- "code/src/chap07/sect3/Animallist.java"
```

??? "Output 7.3.1"
    ```text
    [ant, bat, cow, fox, yak]
    [ant, bat, emu, cow, fox, yak]
    [ant, bat, emu, pig, fox, yak]
    [ant, bat, emu, fox, yak]
    [ant, bat, emu, yak]
    ```

The subject of generics in Java is broad and important, but it is treated in this book only to the 
extent needed for a practical understanding of the `ArrayList` class.
