# 6.1 `while` Loops

Content for this section is under development.

[//]: # ()
[//]: # (## 5.5.5 Compound Assignment Operators)

[//]: # ()
[//]: # (Java’s arithmetic compound assignment operators, listed in Code Fragment 5.5.5a, provide a)

[//]: # (convenient syntax for combining an arithmetic operation with an assignment. The += operator is)

[//]: # (pronounced plus gets, -= is pronounced minus gets, and so on.)

[//]: # ()
[//]: # (```java)

[//]: # (x += 8; // same as x = x + 8; )

[//]: # (x -= 8; // same as x = x - 8; )

[//]: # (x *= 8; // same as x = x * 8;)

[//]: # (x /= 8; // same as x = x / 8; )

[//]: # (x %= 8; // same as x = x % 8;)

[//]: # (```)

[//]: # ()
[//]: # (The += operator can also be used to combine string concatenation and assignment, as shown in)

[//]: # (Code Fragment 5.5.5b.)

[//]: # ()
[//]: # (```java)

[//]: # (String animal = "ant"; animal += "elope";)

[//]: # (System.out.println&#40;animal&#41;; // antelope)

[//]: # (```)

[//]: # ()
[//]: # (## 5.5.6 Increment and Decrement Operators)

[//]: # ()
[//]: # (We often need to increment or decrement an int variable, especially when working with loops)

[//]: # (&#40;Chapter 6&#41;. Compound assignment operators can be used for this, but Java provides an even simpler)

[//]: # (syntax with the increment and decrement operators &#40;++ and --&#41;, shown in Code Fragment 5.5.6a.)

[//]: # ()
[//]: # (```java)

[//]: # (int x = 3; )

[//]: # (int y = 8; )

[//]: # (x++; // same as x += 1; )

[//]: # (y--; // same as y -= 1; )

[//]: # (// System.out.println&#40;x + " " + y&#41;; // 4 7)

[//]: # (```)

[//]: # ()
[//]: # (The increment and decrement operators can be applied in two ways. The postfix form is shown above.)

[//]: # (In prefix form the operator precedes the operand &#40;as in ++x and --y&#41;. When a statement consists of)

[//]: # (an increment or decrement operation alone, it makes no difference which form is used, but when)

[//]: # (combined with other actions in a single statement the choice matters. Consider the second line of)

[//]: # (Code Fragment 5.5.6b. Two things are happening: x is being incremented and y is being assigned the)

[//]: # (value of x. But which happens first? With postfix form, the increment operation follows the)

[//]: # (assignment. If we had used the prefix form, the increment operation would precede the assignment,)

[//]: # (in which case y would get 4 instead of 3. In the last line, the prefix form of the decrement)

[//]: # (operator is applied to z, so the variable is decremented before its value is passed to println.)

[//]: # ()
[//]: # (```java)

[//]: # (int x = 3; )

[//]: # (int y = x++;)

[//]: # (System.out.println&#40;x + " " + y&#41;; // 4 3)

[//]: # (int z = 8;)

[//]: # (System.out.println&#40;--z&#41;; // 7)

[//]: # (```)

[//]: # ()
[//]: # (The increment and decrement operators, compound assignment operators, and the ternary if-else)

[//]: # (operator are all examples of what programmers call syntactic sugar: they do not provide any new)

[//]: # (capabilities, but they do provide a convenient &#40;sweet&#41; shorthand for existing syntax.)
