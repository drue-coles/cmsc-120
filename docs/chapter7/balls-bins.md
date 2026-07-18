# 7.2 Balls into Bins

**Key terms:** none introduced

## 7.2.1 Definition and Applications

Many problems in applied probability can be modeled in terms of balls being thrown at random into 
bins. Consider a high-traffic website that must distribute thousands of requests every second to 
remote servers. Each server can handle one request at a time and has a waiting queue for other 
requests. If all the servers are currently busy and a new request for service arrives, the system 
must place it in one of the queues. The system must quickly decide which queue should receive the 
request while avoiding significant imbalances in the distribution of work. One simple and effective
strategy is randomized load balancing: choose a queue uniformly at random, or choose the shortest 
queue from a small random sample. This is naturally modeled as balls (requests) being thrown at 
random into bins (queues). The expected maximum load on the servers corresponds to the maximum 
number of balls likely to end up in a single bin. This can be calculated mathematically, but it 
can also be approximated with high accuracy by a Monte Carlo simulation. 

There are many other practical problems in computing, engineering, and the natural sciences that can 
be modeled as balls-into-bins problems and analyzed with the help of Monte Carlo simulations.
Depending on the problem, we may be interested in the expected number of empty bins, the average 
load, the maximum load, or the number of balls required before every bin receives at least one.

## 7.2.2 Case Study: The Birthday Paradox 

How large must a random sample of people be before it becomes likely that two of them have the 
same birthday? For simplicity, assume that birthdays are uniformly distributed throughout the 
year. This question is known as the *birthday paradox* because the answer, 23, seems surprisingly
small to most people. It is a classic balls-into-bins question. Imagine 365 bins, one for each day
of the year. A random sample of 23 birthdays corresponds to throwing 23 balls uniformly at random 
into the bins. A shared birthday occurs exactly when two balls land in the same bin. The birthday 
paradox states that this probability is slightly greater than 50%. Listing 7.2.2 is a Monte Carlo
simulation that estimates this probability.

#### Listing 7.2.2 - [BirthdayParadox.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect2/BirthdayParadox.java)
``` java title="BirthdayParadox.java"
--8<-- "code/src/chap07/sect2/BirthdayParadox.java"
```

??? "Output 7.2.2"
    ```text
    Number of birthdays to sample: 23
    Simulating 10,000,000 trials... 
    Probability of a birthday match: 50.73% 
    ```

## 7.2.3 Case Study: Randomized Playlist 

If songs are streamed randomly from a curated playlist, how many songs would be expected to be 
played before every song has been heard at least once? This is another balls-into-bins problem: 
each song in the playlist represents a bin, and each randomly selected song corresponds to 
throwing a ball into that bin. Listing 7.2.3 estimates this expected value.

#### Listing 7.2.3 - [RandomizedPlaylist.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap07/sect2/RandomizedPlaylist.java)
``` java title="RandomizedPlaylist.java"
--8<-- "code/src/chap07/sect2/RandomizedPlaylist.java"
```

??? "Output 7.2.3"
    ```text
    Number of songs in the playlist: 15
    Simulating 1,000,000 trials... 
    Expected number of songs until all are played: 49.75
    ```

The `playSongs` method maintains a counter for the number of distinct songs played. An alternative 
approach is to delegate the test for whether every song has been played to a helper method. A 
for-each loop is appropriate because the array elements need not be modified and it suffices to 
read them sequentially. 

```java
private static boolean allSongsPlayed(boolean[] alreadyPlayed) {
    for (boolean played : alreadyPlayed) {
        if (!played) {
            return false;
        }
    }
    return true;
}
```

The loop in `playSongs` could then be simplified:

```java
while (true) {
    int songIndex = ThreadLocalRandom.current().nextInt(n);
    totalSongsPlayed++;
    alreadyPlayed[songIndex] = true;
    if (allSongsPlayed(alreadyPlayed)) {
        return totalSongsPlayed;
    }
}
```

The original implementation is more efficient because it tracks the number of distinct songs played, 
avoiding repeated traversals of the array. However, clarity and simplicity are important principles 
of good program design. Straightforward code can often be optimized later if efficiency becomes a 
concern, whereas unnecessarily complex code is more difficult to understand, test, and maintain.
