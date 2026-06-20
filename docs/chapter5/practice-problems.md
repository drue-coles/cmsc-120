# 5.8 Practice Problems

**a. After Midnight.** Prompts the user for an interval of time expressed in hours and minutes, 
calculates the time of day after advancing from midnight by the specified interval, and displays the 
time in standard 12-hour format (for example, 10:50 PM or 4:05 AM).

??? "Output 5.8a-1"
    ```text
    Hours and minutes: 46 50 
    10:50 PM
    ```

??? "Output 5.8a-2"
    ```text
    Hours and minutes: 75 65 
    4:05 AM
    ```

??? "Output 5.8a-3"
    ```text
    Hours and minutes: 100 100
    5:40 AM
    ```

---

**b. Fatal Fives.** Prompts the user for three dice rolls and outputs the profit for the game of 
Fatal Fives. The profit is defined to be the sum of the numbers on the dice. However, fives do not 
count, and no roll that comes after a five counts. Implement a helper method that takes three dice 
rolls and returns the profit.

??? "Output 5.8b-1"
    ```text
    Dice rolls: 3 4 2 
    Profit = $9
    ```

??? "Output 5.8b-2"
    ```text
    Dice rolls: 6 2 5
    Profit = $8
    ```

??? "Output 5.8b-3"
    ```text
    Dice rolls: 3 5 6 
    Profit = $3
    ```

??? "Output 5.8b-4"
    ```text
    Dice rolls: 5 6 3 
    Profit = $0
    ```

---

**c. Hi-Lo Grade.** Prompts the user for three exam scores and outputs the highest and lowest 
possible course grade. Course grades are determined by four exams, each consisting of 100 questions. 
Each question is worth a single point, so possible exam scores are between 0 and 100 inclusive. The 
average exam score is converted to a letter grade according to the following scale. 

- A = [90, 100] 
- B = [80, 90) 
- C = [70, 80) 
- D = [60, 70) 
- F = [0, 60) 

??? "Output 5.8c-1"
    ```text
    First three exam scores: 81 82 83 
    Highest possible grade: B 
    Lowest possible grade: D
    ```

??? "Output 5.8c-2"
    ```text
    First three exam scores: 99 98 84 
    Highest possible grade: A 
    Lowest possible grade: C
    ```

??? "Output 5.8c-3"
    ```text
    First three exam scores: 51 66 77 
    Highest possible grade: C 
    Lowest possible grade: F
    ```

Implement a helper method that takes an `int` in the range [0, 100] and returns the corresponding 
letter grade as a `char` value.

---

**d. Word Compression.** Prompts the user to enter a word and outputs the result of compressing that 
word according to the following rule:

- If the first character of the word occurs at least twice, the sequence of characters between the 
first character and the next occurrence of that character is replaced by the length of that 
sequence. For example, *blueberries* ➝ *b3berries*.
- Exception: If the length of the sequence is less than two, or if the first character occurs only 
once, then the word is compressed simply by removing the first character. Examples: 
*eyeball* ➝ *yeball*, *eel* ➝ *el*, *ecru* ➝ *cru*.

??? "Output 5.8d-1"
    ```text
    Enter a word: blueberries 
    Compressed: b3berries
    ```

??? "Output 5.8d-2"
    ```text
    Enter a word: cranberries 
    Compressed: ranberries
    ```

??? "Output 5.8d-3"
    ```text
    Enter a word: raspberries 
    Compressed: r5rries
    ```

??? "Output 5.8d-4"
    ```text
    Enter a word: strawberries 
    Compressed: s10s
    ```

---

**e. Greatest Glob.** Prompts the user for three dice rolls and outputs their greatest glob sum. A 
glob is a maximal subset of identical values, and the greatest glob is the one with the greatest 
sum. For example, suppose the rolls are 3, 5, and 3. There are two globs in this case: the pair of 
threes and the five by itself. The pair of threes has a sum of 6, which is greater than 5, so the 
greatest glob sum is 6.

??? "Output 5.8e-1"
    ```text
    Enter die rolls: 3 5 6 
    Greatest glob sum: 6
    ```

??? "Output 5.8e-2"
    ```text
    Enter die rolls: 5 2 2 
    Greatest glob sum: 5
    ```

??? "Output 5.8e-3"
    ```text
    Enter die rolls: 1 1 1 
    Greatest glob sum: 3
    ```

??? "Output 5.8e-4"
    ```text
    Enter die rolls: 4 6 4 
    Greatest glob sum: 8
    ```

---

**f. Related Integers.** Prompts the user for three integers and checks if they are related. Here 
*related* means that two of them can be added to equal the other. If they are related, the program 
outputs the corresponding addition statement with the numbers in ascending order from left to 
right; otherwise, the program outputs NOT RELATED.

??? "Output 5.8f-1"
    ```text
    Enter three integers: 5 8 3 
    3 + 5 = 8
    ```

??? "Output 5.8f-2"
    ```text
    Enter three integers: 3 7 4 
    3 + 4 = 7
    ```

??? "Output 5.8f-3"
    ```text
    Enter three integers: 3 4 5 
    NOT RELATED
    ```

---

**g. Quetzal.** Prompts the user for three dice rolls in the game of Quetzal and outputs the profit. 
The profit is defined to be the number of even-numbered rolls times the sum of even-numbered rolls, 
plus the number of odd-numbered rolls times the sum of the odd-numbered rolls.

??? "Output 5.8g-1"
    ```text
    Enter 3 dice rolls: 4 5 2 
    Quetzal profit: $17 
    ```

??? "Output 5.8g-2"
    ```text
    Enter 3 dice rolls: 3 5 3 
    Quetzal profit: $33 
    ```

??? "Output 5.8g-3"
    ```text
    Enter 3 dice rolls: 6 1 5 
    Quetzal profit: $18
    ```

---

**h. Buy One, Get One Free.** (This problem is a bit tricky.) Prompts the user to enter a 
purchase order and outputs the price. Product and pricing details are as follows.

Felix went into business selling homemade apple pies from his garage. Small pies go 
for $2, medium pies for $3, and large pies for $5. Unfortunately, due to health code 
violations, Felix is going out of business. He is having a big sale and here’s the 
deal: customers can buy any pie and get a second pie of the same size for free. 
However, if a customer buys three pies of the same size, then the full price will be 
charged for all three. A customer may purchase at most three pies.

A purchase is specified by a sequence of letters (S, M, and/or L) indicating the size of each pie. 
For example, “MSM” denotes a purchase of two medium pies and one small pie. In this case, the output
would be $5 since one of the medium pies would be free. The order of letters in a purchase does not
matter; so, for example, MSM is equivalent to both SMM and MMS.

??? "Output 5.8h-1"
    ```text
    Purchase order: MSM 
    Price: $5
    ```

??? "Output 5.8h-2"
    ```text
    Purchase order: SML 
    Price: $10
    ```

??? "Output 5.8h-3"
    ```text
    Purchase order: S 
    Price: $2
    ```

??? "Output 5.8h-4"
    ```text
    Purchase order: MM 
    Price: $3
    ```

??? "Output 5.8h-5"
    ```text
    Purchase order: MMM 
    Price: $9
    ```

---

**i. Dice Art.** Outputs a picture of two randomly selected die faces as shown in the output boxes. 

??? "Output 5.8i-1"
    ```text
    ###########   ###########
    # O       #   #         #
    #         #   #         #
    #    O    #   #    O    #
    #         #   #         #
    #       O #   #         #
    ###########   ###########
    You rolled 3 + 1 = 4.
    ```

??? "Output 5.8i-2"
    ```text
    ###########   ###########
    # O       #   # O     O #
    #         #   #         #
    #         #   # O     O #
    #         #   #         #
    #       O #   # O     O #
    ###########   ###########
    You rolled 2 + 6 = 8.
    ```

??? "Output 5.8i-3"
    ```text
    ###########   ###########
    # O     O #   # O     O #
    #         #   #         #
    #         #   #    O    #
    #         #   #         #
    # O     O #   # O     O #
    ###########   ###########
    You rolled 4 + 5 = 9.
    ```
Note that the rows of each die face are the same except for the O’s in the second, fourth, and
sixth row.
