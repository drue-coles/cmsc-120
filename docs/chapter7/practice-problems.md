# 7.5 Practice Problems

## 7.5.1 Linear Arrays

**a. Dice Sums Deluxe.**  Prompts the user for a number of dice and the number of sides per die, 
and estimates by Monte Carlo simulation the probability of each possible sum. The results are 
displayed as a horizontal bar chart using stars.

??? "Output 7.5.1a"
    ```text
    Number of dice: 3
    Number of sides per die: 5
    
    SUM PROBABILITY
     3  0.8% ★
     4  2.4% ★★
     5  4.8% ★★★★★
     6  8.0% ★★★★★★★★
     7 12.0% ★★★★★★★★★★★★
     8 14.4% ★★★★★★★★★★★★★★
     9 15.2% ★★★★★★★★★★★★★★★
    10 14.4% ★★★★★★★★★★★★★★
    11 12.0% ★★★★★★★★★★★★
    12  8.0% ★★★★★★★★
    13  4.8% ★★★★★
    14  2.4% ★★
    15  0.8% ★
    ```

Listing 7.1.1b solves this problem for the special case of two six-sided dice. Extending it to the 
general case is straightforward.

---

**b. Random Anagram.** Prompts the user for a line of text and outputs a random anagram (the same 
characters in random order). 

??? "Output 7.5.1b-1"
    ```text
    A line of text: ULTRAVIOLET 
    Random anagram: ITTERULLAVO
    ```

??? "Output 7.5.1b-2"
    ```text
    A line of text: That's no moon! 
    Random anagram: shot! aT noom'n
    ```

Use the `Scanner` method `nextLine` to read input, and pass the input to a helper method that 
returns a random anagram. The helper method will need to convert the string to an array of 
characters. Although it would be easy to code this from scratch, the `String` class has a method 
`toCharArray` for this. 

The next step is to shuffle the array. The most efficient algorithm for this is known as the 
*Fisher–Yates shuffle* (or the *Knuth shuffle*). Traverse the array from beginning to end, swapping 
each character with a randomly chosen character at the same or a subsequent position. After 
shuffling the array, convert it back to a string and return it. This requires only a single line of
code using the `String` constructor that takes a `char[]` argument.

---

**c. Distinct Random Numbers.** Prompts the user for two positive integers *k* and *n*, and outputs 
a sorted list of *k* distinct random integers in the range \[0, *n* − 1]. 

??? "Output 7.5.1c-1"
    ```text
    Enter number of integers to generate and upper bound: 5 99 
    17 23 39 56 81
    ```

??? "Output 7.5.1c-2"
    ```text
    Enter number of integers to generate and upper bound: 6 10 
    2 3 5 6 8 9
    ```

A convenient approach is to create an array containing the integers from 0 to *n* − 1, shuffle it,
and then use the first *k* values. The `Arrays` class provides methods for copying and sorting 
arrays.

---

**d. Line of Coins.** One hundred coins are arranged in a line, all tails-up. The coins are 
indexed from 1 to 100. First, turn over every coin. Then turn over every second coin (2, 4, 6,
...). Next, turn over every third coin (3, 6, 9, ...). Continue in this way, turning over every 
fourth coin, every fifth coin, and so on, up to every hundredth coin.

Write a program that simulates this procedure and displays the indices of the coins that are 
heads-up at the end. There should be exactly ten heads-up coins. Their indices follow an 
interesting pattern. Can you explain why this pattern arises?

---

**e. Median Score.** Prompts the user for the number of exams and their scores, and outputs the 
median score.

??? "Output 7.5.1e"
    ```text
    Enter number of exams: 5 
    Enter exam scores: 92 63 75 89 95 
    The median score is 89.
    ```

Hint: store the values in an array and use `Arrays.sort`.

---

**f. Median Score without Count.** Modify a solution to the previous problem so that the user can 
enter the scores without first having to specify how many there are. 

??? "Output 7.5.1f"
    ```text
    Enter exam scores: 92 63 75 89 95 
    The median score is 89.
    ```

Hint: read a line of text as a string and call `split` on it to obtain an array of strings. Each 
string can be converted to an `int` using a static method of the `Integer` class.

---

**g. Dinner Party.** You're throwing a dinner party and the main course will consist of peas. The 
dinner plates are arranged around a circular table. You quickly distribute the peas among the 
plates, but when the guests are seated, it is discovered that some plates have more peas than 
others. The following protocol will be used to ensure that each guest has the same number of peas. 

1. Any guest with an odd number of peas is given one additional pea. 
2. All guests simultaneously transfer half of their peas to the guest on their right. 
3. If all plates now have the same number of peas, dinner begins; otherwise, return to step 1.

Write a program that prompts the user for the number of guests and the initial pea counts, and 
outputs the pea counts after each round.

??? "Output 7.5.1g"
    ```text
    Enter number of guests: 6 
    Enter pea counts: 6 8 9 4 7 8 
    1.   6   8   9   4   7   8
    2.   7   7   9   7   6   8
    3.   8   8   9   9   7   7
    4.   8   8   9  10   9   8
    5.   8   8   9  10  10   9
    6.   9   8   9  10  10  10
    7.  10   9   9  10  10  10
    8.  10  10  10  10  10  10
    ```

The first line of output shows the original pea counts. After the first step of the protocol, in 
which plates with odd numbers of peas receive an additional pea, the counts are as shown in the 
following figure.

Figure 7.5.1g: [Pea Counts](images/figure7.5.1g.png)

The arrows depict the quantities transferred in step 2 of the protocol (half of the peas on each 
guest's plate). For example, the third guest has 10 peas, transfers 5 to the right, and 
simultaneously receives 4 from the left, leaving 9 peas at the start of the next round. Remember, 
the guests are seated in a circle, so the transfers wrap around from the last number in the 
output to the first.

---

**h. Dinner Party Without Count.** Modify a solution to the previous problem so that the user can 
enter the pea counts without first specifying the number of guests. 

??? "Output 7.5.1h"
    ```text
    Enter pea counts: 6 8 9 4 7 8 
    1.   6   8   9   4   7   8
    2.   7   7   9   7   6   8
    3.   8   8   9   9   7   7
    4.   8   8   9  10   9   8
    5.   8   8   9  10  10   9
    6.   9   8   9  10  10  10
    7.  10   9   9  10  10  10
    8.  10  10  10  10  10  10
    ```

See the hint for **Median Score without Count** above.

---

**i. Dinner Party Max-Min.** In this version of the preceding problem, a different protocol is used 
to redistribute the peas. In each round, a person with the maximum number of peas gives one to a 
person with the minimum number. It might not be possible for everyone to end up with exactly the 
same number of peas, so the goal is to reach a state in which the minimum and maximum differ by at 
most 1, as shown in the second sample output below.

??? "Output 7.5.1i-1"
    ```text
    Enter pea counts: 6 8 9 4 7 8
    1.   6   8   9   4   7   8
    2.   6   8   8   5   7   8
    3.   6   7   8   6   7   8
    4.   7   7   7   6   7   8
    5.   7   7   7   7   7   7   
    ```

??? "Output 7.5.1i-2"
    ```text
    Enter pea counts: 2 3 5 8 9
    1.   2   3   5   8   9   
    2.   3   3   5   8   8   
    3.   4   3   5   7   8   
    4.   4   4   5   7   7   
    5.   5   4   5   6   7   
    6.   5   5   5   6   6   
    ```

---

**j. Bell Curve.** This problem requires knowledge of elementary statistics. The `ThreadLocalRandom`
class has been used throughout the book to generate uniformly distributed random numbers. For 
example, when simulating the roll of a die, each outcome should be equally likely because this 
models the behavior of physical dice. However, in the natural and social sciences, the *normal* 
(or *Gaussian*) distribution is often a better model for observed data. Height and IQ, for example, 
are not uniformly distributed in real populations. The average IQ in the United States is around 
100, and most people have an IQ between 85 and 115; fewer than 1% of people are classified as 
geniuses, with an IQ of 145 or higher.

The `ThreadLocalRandom` method `nextGaussian` generates normally distributed floating-point 
numbers. The purpose of this exercise is to test this method. Use the method to fill an array with 
one million numbers having a mean of 100 and a standard deviation of 15 (representing IQ scores), 
and output the results as shown in the sample output below. The `nextGaussian` method returns 
normally distributed values with a mean of 0 and a standard deviation of 1, so the values must be 
shifted and scaled appropriately.

??? "Output 7.5.1j-1"
    ```text
    Mean: 100.014
    Standard deviation: 15.009
    Within 1 standard deviation: 66.608% 
    Within 2 standard deviations: 95.061% 
    Within 3 standard deviations: 99.698%
    ```

??? "Output 7.5.1j-2"
    ```text
    Mean: 99.987
    Standard deviation: 14.986
    Within 1 standard deviation: 66.605% 
    Within 2 standard deviations: 95.109% 
    Within 3 standard deviations: 99.704%
    ```

---

**k. Numeronyms.** A numeronym (nu-MER-o-nym) is an abbreviation formed by replacing part of a word 
with a number. The first and last letters are retained, and the second letter is also retained if it 
is not a vowel (a, e, i, o, u). The remaining letters are replaced by the number of deleted letters.
For example:

- ROBOT becomes R3T. The first and last letters are retained, and the three letters between them 
are replaced by the number 3.

- DROID becomes DR2D. The first and last letters are retained, and the second letter (R) is also 
retained because it is not a vowel. The two letters between DR and the final D are replaced by the 
number 2.

The replacement is made only if the resulting abbreviation is shorter than the original word. Thus, 
STAR remains STAR rather than becoming ST1R.

Write a program that prompts the user for a line of text consisting of words separated by single 
spaces and outputs the numeronymic abbreviation of each word.

??? "Output 7.5.1k-1"
    ```text
    Enter text: thoughts meander like a restless wind inside a letter box
    th5s m5r l2e a r6s w2d in3e a l4r box
    ```

Split the input text into an array of words (using the `String` method `split`) and pass each 
word to a helper method that returns its numeronymic abbreviation.

For an extra challenge, modify the program so that non-alphabetic characters are preserved in 
the output and treated as separators between words. For example, twenty-seven should become 
tw4y-s3n.

??? "Output 7.5.1k-2"
    ```text
    Enter text: It's a cutting-edge, next-generation, AI-powered system.
    It's a c5g-edge, n2t-g8n, AI-p5d sy3m.
    ```

---

**l. Around the Sun Simplified.** Rewrite a solution to Practice Problem 6.5.2f (Around the Sun) 
using arrays to store circles, colors, and other values needed for the eight planets. Use loops to 
eliminate repeated code and significantly simplify the original solution.

---

**m. Faro Shuffle.** A <a href="https://en.wikipedia.org/wiki/Faro_shuffle">Faro shuffle</a> is a 
technique for shuffling an even number of cards. The top half of the deck is placed in one hand and
the bottom half in the other. The cards from the two halves are then perfectly interleaved. If the 
interleaving starts with the bottom half, it is called an *in-shuffle*. 

Figure 7.5.1m: [Faro In-Shuffle](images/figure7.5.1m.png)

Repeated in-shuffles eventually return any deck to its original order. Write a program that 
determines how many in-shuffles are needed to return a deck to its original order for any even 
number of cards entered by the user.

??? "Output 7.5.1m-1"
    ```text
    Number of cards: 8
    The deck will return to its original order after 6 in-shuffles. 
    ```

??? "Output 7.5.1m-1"
    ```text
    Number of cards: 51
    It must be an even number. Try again: 52
    The deck will return to its original order after 52 in-shuffles. 
    ```

Faro shuffles are used in card tricks and have applications in the theory of parallel processing.

## 7.5.2 Monte Carlo Simulations

**a. Fatal Fives.**

??? "Output 7.5.2a"
    ```text
    ```

---

**b. Fatal Fives 2.**

---

**c. The Long Run.**

??? "Output 7.5.2c"
    ```text
    ```

---

**d. Everybody Has One.

??? "Output 7.5.2d"
```text
```

---

**e. Maximum Load.**

??? "Output 7.5.2e"
    ```text
    ```

---

**f. Target Load.**

??? "Output 7.5.2f"
    ```text
    ```

---

**g. Yahtzee.**

??? "Output 7.5.2g"
    ```text
    ```

---

**h. Free Massage 3.**

??? "Output 7.5.2h"
    ```text
    ```

## 7.5.3 Array Lists

**a. Random Anagram 2.**

---

**b. Distinct Random Numbers 2.**

---

**c. Towers of Hanoi.**

??? "Output 7.5.3c"
    ```text
    ```

---

**d. FIFO Pager.**

??? "Output 7.5.3d"
    ```text
    ```

---

**e. LRU Pager.**

??? "Output 7.5.3e"
    ```text
    ```

---

**f. OPT Pager.**

??? "Output 7.5.3f"
    ```text
    ```

## 7.5.4 Two-Dimensional Arrays

**a. Sentence Square.**

??? "Output 7.5.4a"
    ```text
    ```

---

**b. Latin Square Failure.**

??? "Output 7.5.4b"
    ```text
    ```

---

**c. Random Walks.**

??? "Output 7.5.4c"
    ![Output 7.5.4c – Random Walks](images/output7.5.4c.png)

---

**d. Lights Out.**

??? "Output 7.5.4d"
    ```text
    ```

---

**e. Rainbow Coloring.**

??? "Output 7.5.4e"
    ![Output 7.5.4e – Rainbow Coloring](images/output7.5.4e.png)

---

**f. Rainbow Coloring 2.**

??? "Output 7.5.4f"
    ![Output 7.5.4f – Rainbow Coloring 2](images/output7.5.4f.png)

---
