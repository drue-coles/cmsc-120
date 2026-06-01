# 1.2 The Story of Java

**Key terms:** object-oriented programming, architecture neutrality, object, attribute, method call or invocation, object identity, object state, class, instance, instantiate, type, robustness, extensibility

---

## 1.2.1 Origins

Java was created in 1991 by a team at Sun Microsystems led by James Gosling. The goal was to develop an operating environment for networked devices and embedded systems—special-purpose computing units built into mechanical or electronic devices. The project in its original form failed to gain traction because the market for this technology did not yet exist.

But in 1994, just as the popularity of the World Wide Web was about to skyrocket, the team realized that the technology it had developed could be repurposed to create a web browser capable of downloading and executing code to generate interactive content, at a time when other browsers displayed only static text and images. The browser was primarily a proof of concept and not commercially viable, but it demonstrated Java’s potential and established its reputation as a versatile, platform-neutral programming environment.

Today, millions of developers around the world use Java to program mobile devices, embedded systems, desktop computers, enterprise servers, distributed systems, and supercomputers. Since its inception, it has consistently ranked among the most influential and widely used programming languages.

In 2010, Oracle Corporation acquired Sun Microsystems and now serves as the principal steward of Java, working with a global community to guide the evolution of the language and advance its use worldwide.

---

## 1.2.2 Design Goals of Java

The C programming language is one of the most important and successful high-level languages ever created. C++ was developed as an extension of C to support object-oriented programming (OOP), a proven software design methodology. Gosling’s team initially used C++ for their work, but many of its notorious complexities, including non-object-oriented features inherited from C, impeded their progress.

Java was designed as a remedy. It intentionally resembles C++ but avoids much of its complexity. It is more than a language: it is a computing platform—a collection of tools, libraries, and runtime components for writing, testing, debugging, and executing software.

Anticipating the impact of the World Wide Web, Gosling’s team emphasized **architecture neutrality**: applications execute consistently regardless of the underlying hardware. More broadly, Java was intended to be completely portable: source code can be written once, compiled, and run on any machine with the Java platform installed, independent of the computer or host operating system.

A full account of Java’s design goals is provided in the influential white paper <a href="https://www.stroustrup.com/1995_Java_whitepaper.pdf"><em>The Java Language Environment</em></a> by James Gosling and Henry McGilton (1995).

---

## 1.2.3 A First Look at Objects and Classes

An **object** is an integrated collection of data and behaviors representing a meaningful entity in a problem-solving context. For example, a student object might include data such as name, major, grades, course schedule, and fees owed, along with behaviors for calculating a grade point average, declaring a second major, and modifying the course schedule. The formal object-oriented terms for data and behaviors are **attributes** and **methods**.

To **call** (or **invoke**) a method on an object is to tell the object to execute that method. An object-oriented program consists of statements that create objects and call their methods to calculate values, update states, and coordinate as needed with other objects. Problem-solving is distributed across objects, each providing a precisely defined set of methods with narrowly focused responsibilities. These methods form a clear interface through which objects interact, while the internal details of each object remain hidden.

Objects have **identity** and **state**. Identity means that an object exists as a distinct entity in memory, while state refers to the current values of the object’s attributes. Two objects can share the same state, meaning their attributes currently have identical values—but they remain distinct, each occupying its own location in memory.

Before objects can be created, a programmer must define a **class** to specify its attributes and methods. A class is therefore a blueprint for creating objects. An object is an **instance** of a particular class—to create an object is to **instantiate** the class. The class of an object is also referred to as its **type**.

To further illustrate these ideas, suppose we are designing a graphics application to display the path of an imaginary ant meandering on a flat surface. Taking the object-oriented approach, we would first specify a class to model ants. Perhaps an ant has only one relevant attribute here, its location. Our class might provide methods for calculating an ant’s distance from the origin and for updating its current location to reflect movement in a random direction.

---

## 1.2.4 What is a Philosophy of Programming?

Since this book is about the practice and philosophy of OOP, you might wonder what philosophy actually means in this context. Philosophy as a traditional discipline in the liberal arts generally concerns itself with two distinct (but not mutually exclusive) goals:

- To understand and describe features of reality and their interconnections.
- To determine and practice what is beneficial or desirable.

It is philosophy in the second sense—as a guide to action—that applies to programming. The philosophy of OOP is a set of organizing principles for constructing **robust** and **extensible** software systems. Robustness is the ability to continue performing correctly in the presence of errors or other unforeseen circumstances, such as invalid user input or a disk failure. Extensibility enables new features to be added without creating ripple effects that require widespread code modification.

To better appreciate OOP, it may help to consider an alternative design philosophy: *procedural* or *top-down* programming. In this approach, a problem is decomposed into simpler tasks (procedures), each of which may be further subdivided until arriving at steps simple enough to be implemented directly as a series of elementary instructions not far removed from machine instructions. Procedural programming emphasizes the steps needed to reach a certain computational state, whereas OOP focuses on modeling meaningful entities in the problem domain.

Java is not the only object-oriented language. Other prominent examples include C++, C# (pronounced *C-sharp*), Objective-C, Eiffel, Python, Ruby, Scala, and Smalltalk. Some are pure object-oriented languages, treating everything—including numbers and characters—as objects; others, like Java, were designed to support OOP but retain procedural elements. In all cases, the philosophy of OOP provides a systematic, language-independent approach to managing the complexity of building, maintaining, and extending software.