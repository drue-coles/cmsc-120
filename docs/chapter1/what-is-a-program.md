# 1.1 What is a Program?

**Key terms:** transistor, abstraction (raise the level of), logic gate, machine language, machine instruction, machine code, portability, assembly language, assembler, high-level programming language, source code, compiler

A program is a sequence of instructions telling a computer what to do. But that description hides more than it reveals. What is an instruction? How does it look? How is it expressed? To answer these questions, it helps to begin with concrete reality—to see things from the machine’s point of view—and then gradually pull back until we reach a level of description meaningful and useful to humans.

---

## 1.1.1 Machine View

If we go down to the fundamental building blocks of a computer, we find tiny devices called **transistors**. These exploit the properties of semiconductor materials such as silicon and germanium to act as switches with no moving parts, capable of changing state (on/off) billions of times per second. Transistors were invented at Bell Labs in 1947 to replace the large, hot, and unreliable vacuum tubes previously used, and their inventors—three American scientists—received the 1956 Nobel Prize in Physics for this revolutionary work.

A computer is ultimately a vast network of transistors, and a program at this level is nothing more than a precise specification of which switches to flip, and when, to propagate information through the network. In principle, we could describe a program by detailing the state of each switch at every moment: the initial states of some switches encode the input, and the final states of others encode the output. Even for the simplest computations, hundreds of billions of switches would change state. While a program could, in principle, be expressed this way, doing so would be a practical impossibility.

This view of programming focuses on concrete machine details, whereas we naturally reason about computational problems in terms of higher-level concepts. For example, designing a university course management system leads us to think in terms of students, assignments, exams, and grades. In principle, all of this could be represented by switch states, and operations such as computing a grade could be carried out by flipping certain sequences of switches—but that is not how we think.

The solution is to raise the level of **abstraction**, focusing not on individual transistors but on groups that behave meaningfully and can be treated as operational units—much as a cellular biologist studies organic molecules rather than the atoms that comprise them, or a musician thinks in terms of chords and harmonies rather than individual notes. Abstraction is central to computer science and, in particular, to object-oriented programming (OOP). Although the word *abstraction* can seem intimidating, its purpose is to simplify: it repackages technical details into higher-level units whose inner workings can be ignored.

Several transistors can be combined to form **logic gates** that perform higher-level processing. The simplest gates have two inputs and a single output. Each wire is either on or off, depending on whether current flows through it. The output of a gate answers a YES/NO question about the inputs; for instance, one type of gate produces current if at least one of its input wires carries current.
The states of wires and gates can be represented symbolically using 0s and 1s. This is what people mean when they refer to bits (binary digits—zeros and ones) inside a computer. 

Viewed in terms of logic gates, a program is essentially a sequence of YES/NO questions about the input, calling to mind the classic game of Twenty Questions. This is an improvement over thinking about transistors individually, but it is still hardware-oriented and distant from how we reason about real-world problems.

By combining logic gates into increasingly sophisticated circuits, engineers can build hardware that recognizes certain patterns of bits stored in memory as commands, triggering operations such as performing arithmetic, comparing values, or jumping to another instruction. At the lowest level, instructions, data, and the operations performed on them are all implemented by networks of logic gates built from transistors.

The set of instructions that a particular CPU can execute is called its **machine language**, and these **machine instructions** are extremely simple. Even such a trivial task as adding two numbers must be expressed as several machine instructions, which in English might be described roughly as follows:

1. Load the first number from a specified main memory location into a register.
2. Load the second number from a specified main memory location into another register.
3. Add the numbers in the first two registers and store the result in a third register.
4. Copy the contents of the third register to a specified location in main memory.

Registers are small storage locations inside the CPU used to hold values currently being processed. 

Beyond arithmetic, comparing values, and conditionally jumping to specified instructions, a CPU can do remarkably little. Yet billions of these simple instructions can execute each second, and it is this astonishing speed that enables the complex behavior of modern computers.

Considering programming in terms of machine instructions (or **machine code**) moves us up another layer of abstraction, away from concrete hardware details.

---

## 1.1.2 Low-Level Programming

In the early days of computing, programmers wrote instructions directly in machine language. This was severely limiting in two ways.

1. Machine instructions are bit patterns interpreted directly by the CPU, each representing one of a  small number of elementary operations, so programming in machine language is slow and tedious. It is very difficult—if not practically impossible—to write programs of moderate complexity. Finding errors and understanding code written by others is also extremely difficult.

2. Each CPU has its own machine language, so writing machine code requires knowledge of a specific CPU’s instruction set, which may differ from that of another CPU. Machine code is therefore not **portable**: a program written for one computer will not run on another.

The first step toward freeing programmers from these constraints was the introduction of **assembly language**, which allows each binary machine instruction to be expressed using a mnemonic more meaningful to a human reader. Assembly code for adding two numbers might look like this:

```text
LOAD r1 1000
LOAD r2 1008
ADD r1 r2 r3
STORE r3 1016
```

The first instruction loads the value at memory location `1000` into register `1`. The second loads the value at memory location `1008` into register `2`. The third adds the values in registers `1` and `2`, storing the result in register `3`. The final instruction copies that result to memory location `1016`, where it can be retrieved later by the program.

Assembly language allows programmers to write code in a form that is slightly more readable and easier to reason about. Programs written in assembly must still be translated into machine code before the CPU can execute them, but this translation is handled automatically by a utility program called an **assembler**. This development made programming somewhat easier, but it still requires familiarity with a specific CPU’s instruction set—portability remains a problem.

---

## 1.1.3 High-Level Programming

The problems of readability and portability motivated the invention of **high-level programming languages** in the 1950s. These languages allow programmers to write intuitive, English-like instructions without regard for the specific CPU that will execute them.

The assembly code shown earlier, for example, might be expressed in a high-level language as:

```java
sum = num1 + num2;
```

Simple conditional logic might look like this:

```java
if (score > 70)
    status = PASS;
else
    status = FAIL;
```

Instructions written in a high-level language are referred to as **source code**. Source code is meaningless to the CPU: like assembly code, it must be translated into machine language for execution. This translation is performed by a **compiler**, which checks that the source code conforms to the rules of the language and, if so, converts it into machine instructions.

Compilation solves the portability problem. The same source code can be compiled into the appropriate machine language for any supported platform, without the programmer needing to understand the details of the hardware.

Ultimately, programming is still about controlling a physical machine, just as chemistry is ultimately about the behavior of atoms, but high-level languages hide the machine from the programmer, allowing attention to shift to the logical (machine-independent) aspects of the task.

The first high-level language was FORTRAN, invented in 1954 for scientific computation. COBOL, developed soon after, was designed for business applications. Today there are hundreds of general-purpose high-level languages. Some are widely used in diverse settings; others are of mainly historical or theoretical interest. A few, including Java, have evolved to occupy a position of lasting importance.

---

## 1.1.4 A Note on Terminology

What is the difference between a *program* and an *application*? The terms are used interchangeably in this book. Strictly speaking, an application is a kind of program that performs a specific task for a user and provides a user interface—unlike, for example, a background utility such as an antivirus service.

The term *software* refers more generally to applications, suites (collections of related programs), libraries (reusable collections of code), and frameworks (structured environments for developing applications).