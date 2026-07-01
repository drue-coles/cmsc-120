# 6.3 Monte Carlo Simulations

**Key terms:** stochastic process, Monte Carlo simulation, random walk, expected value

## 6.3.1 Basic Concepts

A **stochastic process** is one that is governed at least partially by chance. Familiar examples 
include traffic patterns, weather systems, stock market behavior, and the spread of infectious 
diseases. Scientists in many disciplines use computer simulations to study processes, events, and 
systems that are too complicated to analyze mathematically. A **Monte Carlo simulation** is a 
program that estimates numerical properties of a stochastic process by sampling random inputs and 
averaging the results over many trials. 

To illustrate the idea with a concrete example, consider a simple game of chance: you roll three 
dice and win if one of the rolled numbers equals the sum of the other two. What is the probability 
of winning? If you played the game many times, you might start to get a rough sense of the 
probability, but for an accurate approximation you would need to play millions of times. The 
percentage of wins over millions of trials would closely approximate the actual probability of 
winning. This is exactly how a Monte Carlo simulation for this problem would work. 

Listing 6.3.1 is a Monte Carlo simulation that estimates the probability of winning the game just 
described. If the game were simulated a small number of times, say 100 or 1000, the output would 
not be consistent across different executions of the program. But with 100 million trials, the 
output is consistently between 20.83% and 20.84%, suggesting that the true probability is within 
this narrow range. 

#### Listing 6.3.1 - [SumGame.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect3/SumGame.java)
``` java title="SumGame.java"
--8<-- "code/src/chap06/sect3/SumGame.java"
```

??? "Output 6.3.1"
    ```text
    Simulating 100,000,000 trials of the Sum Game... 
    Estimated probability of winning: 20.827% 
    ```

## 6.3.2 Case Study: Random Walks

A **random walk** (in two dimensions) is the path traced by a point in the plane repeatedly moving 
one unit in a random direction. Listing 6.3.2 is a Monte Carlo simulation that estimates the 
*expected length* of a random walk from the center of a circle to its boundary. The expected 
length is an example of an **expected value** in probability theory — intuitively, the average 
outcome of repeated trials of a probabilistic experiment.

As a simple illustration, suppose you flip a coin and win a dollar (heads) or nothing (tails). Your
expected profit is 50 cents because if you played the game many times, your average profit would
approach 50 cents. After a million plays, the average might be 49.8357 cents; after a billion plays,
it would likely be even closer. Similarly, the expected length of a random walk is the number of 
steps that would be taken on average over many independent random walks.

#### Listing 6.3.2 - [RandomWalk.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect3/RandomWalk.java)
``` java title="RandomWalk.java"
--8<-- "code/src/chap06/sect3/RandomWalk.java"
```

??? "Output 6.3.2"
    ```text
    Enter radius of circle: 100
    Simulating 100,000 random walks... 
    Expected length of random walk: 10,127 steps. 
    ```

## 6.3.3 Case Study: Approximating π

It is perhaps surprising that Monte Carlo simulations can be used to approximate a purely geometric 
quantity such as π. This is shown in Listing 6.3.3; see the class documentation for the underlying 
idea. 

#### Listing 6.3.3 - [PiApproximator.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect3/PiApproximator.java)
``` java title="PiApproximator.java"
--8<-- "code/src/chap06/sect3/PiApproximator.java"
```

??? "Output 6.3.3"
    ```text
    Generating 100,000,000 random points from the unit square...
    The value of π estimated by Monte Carlo simulation: 3.141841600000000
    Double-precision floating-point value nearest to π: 3.141592653589793
    ```

This technique converges more slowly than the Leibniz series approximation (Listing 6.2.1).

## 6.3.4 Case Study: Craps Probability

Listing 6.3.4a is a Monte Carlo simulation for approximating the probability of winning at Craps.
The game logic is implemented as a helper method that returns a Boolean value indicating whether the 
player wins or loses.

#### Listing 6.3.4a - [CrapsProbabilityCalculator.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect3/CrapsProbabilityCalculator.java)
``` java title="CrapsProbabilityCalculator.java"
--8<-- "code/src/chap06/sect3/CrapsProbabilityCalculator.java"
```

??? "Output 6.3.4a"
    ```text
    Simulating 100,000,000 trials of the game of Craps... 
    Estimated probability of winning: 49.298 
    ```

Now consider extending the program to also calculate the expected number of rolls in a game. This 
introduces a puzzle: it may seem that the `playCraps` method will now need to return two values
(the outcome of the game and the number of rolls), but in Java a method can only return a single 
value. The program could instead run two separate Monte Carlo simulations, one for the probability 
of winning and the other for the expected length of a game, but ideally each iteration of the game
would provide a data point for both calculations.

One way to solve this puzzle would be to return some kind of object that encapsulates the two 
values. For example, the Boolean-valued outcome and the number of rolls could be combined as a
string; the caller (`main`) could extract the two pieces of information as substrings. Listing 
6.3.4b works along these lines but uses a single number to encode the two values: it returns an 
`int` whose absolute value is the number of rolls and whose sign (positive or negative) indicates 
the outcome (win or lose).

#### Listing 6.3.4b - [CrapsProbabilityCalculator2.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect3/CrapsProbabilityCalculator2.java)
``` java title="CrapsProbabilityCalculator2.java"
--8<-- "code/src/chap06/sect3/CrapsProbabilityCalculator2.java"
```

??? "Output 6.3.4b"
    ```text
    Simulating 100,000,000 trials of the game of Craps... 
    Estimated probability of winning: 49.293% 
    Expected number of rolls per game: 3.375 
    Greatest number of rolls: 63
    ```

## 6.3.5 Case Study: Business Decisions

Monte Carlo simulations have important applications in biology, business, engineering, physics, and 
other areas. In business, they can be used to reason about the time customers may spend waiting for 
a service under various assumptions about service time, arrival rate, and other factors that vary 
unpredictably. Listing 6.3.5 illustrates the idea with a simple queueing model. The class 
documentation describes the scenario and the expected value being estimated. The code is 
self-explanatory except for a minor technical point discussed below.

#### Listing 6.3.5 - [WaitingForMassage.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap06/sect3/WaitingForMassage.java)
``` java title="WaitingForMassage.java"
--8<-- "code/src/chap06/sect3/WaitingForMassage.java"
```

??? "Output 6.3.5"
    ```text
    Time for each massage (in minutes): 10
    Average time between arrivals (in minutes): 12
    Period of operation (in minutes): 180
    
    Simulating 1,000,000 operational periods...
    Expected maximum number of people waiting: 3.20
    ```

In the `simulateMassageQueue` method, the `for` loop repeats once for each minute of service. In the 
body of the loop, it must be determined whether a new customer is arriving for service at the 
current time. This is a random event, but the average time between arrivals is known. A *k*-minute 
average is modeled by assuming a probability of 1/*k* that a new arrival occurs in any given minute.
Specifically, in the `if` statement checking for a new arrival, `nextDouble` returns a random 
`double` between 0 and 1, which is compared with the assumed arrival rate of 
`1.0 / arrivalInterval`.
