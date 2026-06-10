# 3.6 Dates and Times

**Key terms:** none introduced

Temporal entities can be represented as collections of primitive values. Three integers, for 
example, could express a date (day, month, year) or time (hours, minutes, seconds). Additional 
values could represent time zones or fractions of a second. In principle, temporal calculations — 
such as computing the day of the week for a given date or the interval between two times — could be 
performed directly on these component values. Doing so, however, would require explicit handling of 
technicalities like the varying lengths of months and the rules for leap years.

Java provides a comprehensive Date-Time API with classes that enable programmers to work with 
temporal entities at a high level of abstraction, focusing on the relationships between them rather 
than their internal representations. Programmers express their intent through method calls, knowing 
only what each method requires as input and what it produces as output, while the API accounts for 
the rules and conventions governing temporal data.

## 3.6.1 LocalDates and Periods

Listing 3.6.1 introduces `LocalDate`, which models a date in the ISO-8601 calendar system. The
program creates instances representing the user's birthdate and the current date using the factory 
methods `LocalDate.of` and `LocalDate.now`, then outputs the user's age and the number of days 
lived.

#### Listing 3.6.1 - [DaysAlive.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect6/DaysAlive.java){:target="_blank"}

??? "Output 3.6.1"
    ```text
    Enter date of birth in MM DD YYYY format: 10 17 2006
    Today is Friday, December 12, 2025.
    You are 19 years old.
    You have been alive for 6,996 days.
    ```

The dates are formatted using a `DateTimeFormatter` created with the factory method `ofPattern`. 
This method takes a string with letters and symbols specifying a date format. The class 
documentation describes a wide range of formatting options; the pattern used here has the following 
components:

* `EEEE` (day of the week as a full word)
* `MMMM` (month as a full word)
* `dd` (two-digit day number)
* `yyyy` (four-digit year)

The `Period` class represents a span of time in years, months, and days. The static `Period.between` 
method takes two dates and returns the period between them; the program extracts the number of years 
from this object to determine the user's age.

Finally, `ChronoUnit.DAYS` is a predefined object with a `between` method for determining the number 
of days between two dates.

## 3.6.2 LocalTimes and Durations

Listing 3.6.2 introduces `LocalTime` and uses the `Duration` class to represent the interval between 
the current moment and a user-entered time.

#### Listing 3.6.2 - [FavoriteTime.java](https://github.com/drue-coles/cmsc-120/blob/master/code/src/chap03/sect6/FavoriteTime.java){:target="_blank"}

??? "Output 3.6.2"
    ```text
    Enter your favorite time of day (HH:MM) in 24-hour format: 05:30
    Current time: 18:54:47
     Future time: 05:30:00
    Waiting time: 10:35:13
    ```

Both times are converted to the number of seconds since midnight, and the current value is 
subtracted from the future value. If the difference is negative, the next occurrence of the entered 
time is on the following day, so the waiting time is obtained by adding one full day (86,400 
seconds) to that difference.

For example, if the current time is 1000 seconds after midnight and the future time is 1500 seconds, 
the waiting time is 500 seconds. If the future time is 750 seconds, subtracting yields -250, so the 
waiting time is 86,400 - 250 = 86,150 seconds.

This wrap-around behavior can be computed using modular arithmetic. However, the remainder operator 
(`%`) preserves the sign of the dividend, so it does not provide the desired behavior when the left 
operand is negative. The program instead uses `Math.floorMod`, which performs true modulo 
arithmetic, as shown by the following code:

```java
int waitingSeconds = -250 % 86400; // -250
int waitingSeconds = Math.floorMod(-250, 86400); // 86150
```

The Date-Time API also provides `LocalDateTime`, which pairs a `LocalDate` with a `LocalTime`, 
enabling client code to treat the combination as a single entity.
