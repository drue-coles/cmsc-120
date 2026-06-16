# 3.3 Random Numbers

**Key terms:** pseudorandom number generator (PRNG)

What does it mean to say that a sequence of numbers is random? This is a surprisingly deep question, 
and attempts to answer it have engaged mathematicians, physicists, and philosophers alike. We all 
have strong intuition about what it should mean — unpredictable, patternless, lacking any hidden 
structure — but turning this intuition into a rigorous definition is remarkably challenging. For 
our purposes, it suffices to know that the concept is subtle and that practical programming relies 
on a more accessible idea.

A **pseudorandom number generator** (**PRNG**) is an algorithm that produces a long sequence of 
numbers that appear random and pass standard statistical tests, even though each number is 
completely determined by the preceding one. Using the same initial seed value reproduces the same 
sequence, which is useful for testing and debugging, while varying the seed—perhaps as a function of 
the current time—produces sequences that are effectively unpredictable. Hardware-based generators 
can produce sequences closer to truly random, but software PRNGs are fast, convenient, and 
sufficient for most applications. Going forward, pseudorandom numbers will be referred to as random 
for brevity.

Many of the programs in this book require random numbers to model events with unpredictable 
outcomes, such as games of chance. The standard library provides several classes with methods for 
this purpose, but `ThreadLocalRandom` is the modern, general-purpose choice: it is fast, easy to 
use, and avoids the limitations of older classes. An instance is obtained via the factory method 
`current`. Listing 3.3.1 uses it to roll a pair of virtual dice.

#### Listing 3.3.1 - [DiceRoller.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect3/DiceRoller.java)
``` java title="DiceRoller.java"
--8<-- "code/src/chap03/sect3/DiceRoller.java"
```

??? "Output 3.3.1"
    ```text
    First die: 5
    Second die: 3
    Sum: 8
    ```

The variables `die1` and `die2` are initialized using `nextInt`, which returns an integer chosen 
uniformly at random from a specified range. The lower bound is inclusive and the upper bound 
exclusive, so `nextInt(1, 7)` simulates rolling a six-sided die.
