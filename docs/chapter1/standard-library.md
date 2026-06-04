# 1.4 The Standard Java Library

**Key terms:** standard Java library, library class, platform class, custom class, Java Class 
Library (JCL), application programming interface (API), Java API, Java API specification, 
black-box description, argument

---

## 1.4.1 Packages

The **standard Java library** is a vast collection of useful classes provided with every 
implementation of the Java SE platform. These **library classes** (also called **platform 
classes**) form the foundation upon which programmers write programs and build their own custom 
classes representing new and useful abstractions for particular problem domains.

The library’s size can be intimidating, but only a small portion is used frequently. Some classes soon become familiar, others are encountered only with more experience, and many are so specialized that most developers never encounter them.

A **package** is a collection of related classes. The standard library contains thousands of classes organized into hundreds of packages. A few examples are:

- `java.io` provides classes for stream-based I/O and file handling.
- `java.math` provides classes for arbitrary-precision arithmetic.
- `java.net` provides classes for networking applications.
- `java.time` provides classes for dates, times, instants, and durations.

The **Java Class Library** (JCL) includes the standard library as well as additional platform 
classes used internally by the JDK or to support the implementation of standard classes. For 
internal organization, the JCL is divided into modules, each grouping related packages. You will 
rarely deal with modules directly, but if you explore Oracle’s online documentation you may see them 
listed. All core platform classes that every Java program depends on are contained in the 
`java.base` module.

---

## 1.4.2 Application Programming Interfaces

An **application programming interface (API)** specifies how programs can access and use services or code libraries. It describes what can be done or obtained and how to request it, without exposing details about the internal workings of the code or services.

APIs are used widely in software development. For example:

- The Google Maps JavaScript API allows web developers to embed interactive maps in web pages.
- The GitHub REST API allows collaborating developers to create, store, and share code.
- The Spotify Web API allows applications to search for music, retrieve playlists, and control playback.

Services and libraries described by an API do not have to be online. For example, operating systems provide a system-call API that lets programs request access to protected resources such as files and memory.

The distinction between an API and a library is subtle but important. An API defines what can be 
done and how to do it; a library contains the actual code that performs the work. In other words, 
the API is an abstract specification — a contract between provider and user — while the library is 
the concrete implementation that fulfills it.

The **Java API** defines the interface to the standard Java library — the official description of 
its classes and methods. The **Java API Specification** lists all packages and classes in the Java 
API. You can view the most recent version by visiting 
<a href="https://docs.oracle.com/javase">https://docs.oracle.com/javase</a>, then clicking API 
Documentation and selecting `java.base`. The base module, which contains all classes intended for 
general-purpose programming, includes over 50 packages and more than 6,000 classes.

For each class, the specification provides an overview of its purpose and a **black-box 
description** of each method. In science and engineering, a system is said to be treated as a black 
box when it is understood solely in terms of its inputs and outputs, without reference to its 
internal workings. A black-box description of a method tells you its name, purpose, **arguments** 
(required inputs), and the result or effect of calling it — it does not tell you how it performs 
its 
work.

The methods themselves are written in Java by the designers of the library. As programmers, we do 
not need to know how the methods were implemented — just as we do not need to understand how an 
engine works in order to drive a car.

In later chapters, you will encounter sub-APIs within the Java API, such as the date-time API for 
working with temporal data. These are focused groups of related packages within the larger Java 
API.
