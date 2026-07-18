# 7.4 Two-Dimensional Arrays

**Key terms:** two-dimensional array, ragged array

## 7.4.1 Motivation

The <a href="https://en.wikipedia.org/wiki/15_puzzle">Game of Fifteen</a>, which dates back to the 
19th century, is played on a 4×4 grid of tiles numbered from 1 to 15. 

Figure 7.4.1a: [Game of Fifteen](images/figure7.4.1a.png)

A tile adjacent to the empty space can be moved by sliding it horizontally or vertically into the 
space. The goal is to rearrange the tiles in ascending order.

Figure 7.4.1b: [Winning Configuration](images/figure7.4.1b.png)

In a program presenting the game to a player, how should the game state be represented? One idea 
might be to declare 16 integer variables for the 16 different grid positions. Each variable could 
store either a tile number or a value representing the empty space. But with this approach the 
variables do not reflect the structure of the game, so checking if a particular move is valid 
would require a long and tedious sequence of decision statements. Alternatively, the tile 
numbers could be stored in a linear array:

Figure 7.4.1c: [Game State with Linear Array](images/figure7.4.1c.png)

Here 16 designates the empty space.

This is a little more intuitive but still problematic. The game state is naturally viewed as 
a two-dimensional (2D) grid. If the tile numbers are stored in a linear array, the programmer must
mentally translate the two-dimensional adjacency relationships into the one-dimensional structure
of the array. A language-level structure is needed that more naturally matches the conceptual 
structure of the game. The same need arises in many applications that organize information as a 
grid, matrix, or table, such as spreadsheets. 

The following code shows how to declare a 2D array of `int`s to store the game state. Note that 
the type name for a 2D array is the same as for a linear array except that there is a second pair 
of brackets for the second dimension.

```java
int[][] grid = new int[4][4];
```

A program for the Game of Fifteen might initialize the grid by first putting it into the winning 
state and then working backwards to a shuffled starting state by making a series of legal random 
moves — that is, by repeatedly sliding a tile chosen at random from among those that are adjacent 
to the empty space. This guarantees that the initial configuration is solvable, since reversing 
the same sequence of moves returns the puzzle to the winning configuration. The first part of this 
initialization, putting the grid into the winning state, could be coded as shown below. The outer 
loop ranges over the row indices, and for each row the inner loop ranges over the column indices. 
Successive tile numbers are assigned to `grid[i][j]`, which refers to row `i` and column `j`.

```java
// initialize grid to the winning configuration 
int tile = 1; 
for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 4; j++) { 
        grid[i][j] = tile++;
    } 
}
```

## 7.4.2 Arrays of Arrays 

A computer’s memory is really a vast linear array of bytes, so how exactly should we understand a 
2D array in terms of physical storage? This turns out to be an important question for reasons that 
will be clear shortly. The answer is that a 2D array is implemented as an array whose elements are
themselves arrays. Thus, although Java provides convenient syntax for working with two-dimensional
arrays, the underlying representation is really an array of arrays. To make this clear, the code 
below shows how an initializer list could be used to put grid into the winning state (compare with
the preceding loop-based initialization). Recall that an initializer list is a comma-separated 
sequence of array elements inside curly braces. Here the elements of the outer array are 
themselves arrays representing the rows of grid, each initialized with its own initializer list.

```java
int[][] grid = {
        {1, 2, 3, 4}, 
        {5, 6, 7, 8}, 
        {9, 10, 11, 12}, 
        {13, 14, 15, 16}
};
```

Figure 7.4.2 illustrates how the array is represented in memory.

Figure 7.4.2: [Two-Dimensional Array](images/figure7.4.2.png)

With these ideas in mind, we can understand how to traverse a 2D array using a for-each loop. See 
the code below. The outer loop iterates over the rows of grid, each of which is a linear array. For 
each row, the inner loop iterates over its `int` values.

```java
// output the grid in tabular format 
for (int[] row : grid) { 
    for (int tile : row) {
        System.out.printf("%2d ", tile); 
    }
    System.out.println(); // insert newline after each row 
}
```

Listing 7.4.2a illustrates the syntax for initializing 2D arrays with initializer lists and 
traversing them with for-each loops.

#### Listing 7.4.2a - [AnimalTable.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect4/AnimalTable.java)
``` java title="AnimalTable.java"
--8<-- "code/src/chap07/sect4/AnimalTable.java"
```

??? "Output 7.4.2a"
    ```text
    gorilla buffalo lobster cheetah 
    penguin quetzal meerkat octopus 
    vulture whippet raccoon wallaby 
    
    buffalo cheetah gorilla lobster 
    meerkat octopus penguin quetzal 
    raccoon vulture wallaby whippet 
    ```

Listing 7.4.2b illustrates a graphical application of 2D arrays. The program implements a simple 
mathematical process known as <a href="https://en.wikipedia.org/wiki/Rule_90">Rule 90</a>. 
Starting with a single 1 in the center of the first row, each subsequent row is computed from the 
previous one according to a fixed rule. The rows therefore represent successive time steps, while
the columns represent positions in space. Displaying the completed array reveals that Rule 90 
provides an alternative construction of the Sierpiński triangle (see Section 6.2.3).

#### Listing 7.4.2b - [Rule90.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect4/Rule90.java)
``` java title="Rule90.java"
--8<-- "code/src/chap07/sect4/Rule90.java"
```

??? "Output 7.4.2b"
    ![Output 7.4.2b – Rule 90](images/output7.4.2b.png)

## 7.4.3 Ragged Arrays

Occasionally, a programmer needs a 2D array whose rows have different lengths. This is called a 
**ragged array**. Since a 2D array is an array of arrays, declaring a ragged array is 
straightforward. The following code declares a ragged array, and Figure 7.4.3 shows how it is 
represented in memory.

```java
int[][] x = new int[3][]; 
x[0] = new int[8]; 
x[1] = new int[10]; 
x[2] = new int[6];

x[1][6] = 97;
```

Figure 7.4.3: [Ragged Array](images/figure7.4.3.png)

## 7.4.4 Multidimensional Arrays

The syntax for multidimensional arrays is a straightforward extension of the 2D case: an extra set
of brackets is needed for each extra dimension. As a practical example, consider a program that 
stores daily temperatures recorded at a particular location throughout the twentieth century. The
code below declares a 3D array for this purpose. The three dimensions correspond to month, day, 
and year. The first index represents the month and ranges from 1–12, the second represents the day
and ranges from 1–31, and the third represents the year and ranges from 0–99. Index 0 is unused 
for the month and day dimensions. In this scheme, the temperature on June 18, 1986, would be 
stored at `temperature[6][18][86]`.

```java
int[][][] temperature = new int[13][32][100]; 
```

If hourly temperatures were also stored, a fourth dimension could represent the hour of the day.
