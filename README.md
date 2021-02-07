# Employee app refactor
A Java tutorial showing how to implement best practices like strong encapsulation, composition over inheritance, immutability, and dependency injection, via an application printing out information for various types of employees.

The application begins with its main classes linked to each other by implementation inheritance in Java's default package with mutable fields, large methods, and all fields open to change from anywhere via getters and setters. Its end point is an application with classes in a named package linked to each other by composition using decorator patterns to illustrate multiple possible composition relationships, methods refactored so as to generally have a body no larger than three lines, public getters and setters eliminated to enforce stronger restrictions on field encapsulation, and fields and classes made final to enforce immutability.

## 1 Place all classes in a package
Using the default package opens up the possibility for class name ambiguity, which can lead to compilation errors.

## 2 Use version control 
Code should be placed under a system of version control such as git. Version control allows a programmer to keep track of the previous stages of a project, and to revert back to an earlier stage should a problem arise. This means that if there is a need to recover a wrongly deleted piece of functionality, it may be done through version control. 

### 2.1 Clean up unused code immediately
Since version control allows for prior functionality to be stored in a codebase's history, there is little reason to keep unneeded code in your current version past the point when it's needed. Most languages have one or several code cleanup tools that are able to partially or even fully automate the process of finding and removing unused chunks of code. Cleaning up unused code as soon as it becomes unused ensures other developers don't mistakenly build on code marked for deletion, preventing sprawl and helping to direct other developers to the preferred way of implementing a piece of functionality elsewhere in an application.

## 3 Encapsulation and object cohesion
Encapsulation refers to the practice of enclosing fields in classes with the methods they act on. Properly done, encapsulation prevents code sprawl and allows developers to use objects without being forced to attend to how their methods work internally. The following provide suggestions for how to best make use of this practice. 

Object cohesion is a property of objects according to which an object's fields and methods belong together, particularly in the sense that each of its methods' direct dependencies are given by all and only its fields. Cohesion allows for object functionality to be limited and clearly defined, leading code to be more reusable and objects to be more easily switched out should a substitution of a different object be desired.

Encapsulation is sometimes thought to involve little more than requiring access to an object's fields be mediated by its methods. But doing this only answers to the bare letter of the notion while ignoring its main purpose, with the ultimate effects on cohesion and maintainability being comparable to unencapsulated procedural code albeit with additional boilerplate code needed to account for class types and workaround methods. In order to write more coherent, properly encapsulated code in consider instantiating the following guidelines: 

### 3.1 Avoid public fields
A field is that which, belonging to an object in accordance with the design dictated by its implementation type, may be assigned as its value an object or primitive data type instance. A field of an object is public if that field's value may be obtained by any other object directly and without mediation. A field is private if its value is at best only directly accessible by those functions, called methods, belonging to the object itself.

By definition, an object's public fields can be obtained directly from anywhere in an application; if the values of those fields may be varied, then they can also be manipulated. This can make it difficult to keep track of all the places a field used and can lead to excessive complexity, making a program hard to understand, hard to detect errors in, and hard to build on without introducing new errors. It can also open up your application to security vulnerabilities should a third party choose to manipulate the field in an unanticipated manner.

To avoid these problems, use private fields, thus ensuring the methods able to access a field's value are limited in number and clearly defined.

### 3.2 Keep methods with the classes they act on.
For instance, prefer calling a void ```myObj.info()``` method, where the body of ```info``` is ```System.out.println(this)``` over calling ```System.out.println(myObj)``` in a ```main``` method. As the example suggests, this should be done even for very small methods as a way of managing complexity in advance before it gets out of hand.

### 3.3 Avoid empty getters
A getter is a method belonging to an object, in accordance with its type, that a distinct object may use to obtain the values of that object's private fields. Getters are called so from the common practice of naming them with a ```get``` prefix, followed by the field whose value they obtain by it, e.g. ```getName```.  to obtain the value of an object's ```name``` field, ```getAddress``` for that of an ```address``` field, etc. A getter is empty if it does nothing else besides return the value of its associated field.

The use of public fields and empty getters have certain advantages relative to each other: making a field public and obtaining its value directly has the immediate advantage of simpler syntax with less boilerplate code; using getters has the advantage of procuring a single place for changes in the manner in which a field's value may is obtained in case these become necessary at a later point in time. But both have in common that by making values accessible anywhere in an application, they make an application's code more sprawling and less maintainable, increasing the likelihood of other developers introducing accidental errors and of malicious actors introducing intentional ones. Instead, consider relegating the relevant functionality of the object type obtaining the field back to the object type to which the field belongs directly. 

### 3.4 Avoid getters, period.
Getters may be divided into two kinds: those that simply return the value of the field that they get, i.e. empty getters, and those that perform any additional functionality in the process of returning the object. The reasons for avoiding the first have been given above. The reasons for avoiding the second are semantic: namely such functions aren't properly getters, but functions that get and, in addition, do other things as well. Consequently, these functions should be named in a manner representing their full functionality to ensure their proper use by others.

### 3.5 Method names should be a noun or a verb, nothing more
If your methods have longer names than this, it is usually a sign that your class is too large and coarse-grained, and should be broken down into smaller classes. Void methods should name actions, e.g. ```print```, ```save```. Return methods should name what they return , e.g. ```fullName()```.

## 4 Immutability, multithreading and thread safety
### 4.1 Immutability
An field is immutable if its value may not change at any point after its creation throughout the course of an application, and mutable otherwise. We can call an object immutable if, in addition, all of its methods reliably return the same output whenever they are invoked with like inputs, and mutable otherwise. An application or library is immutable if all of its object types are immutable. 

### 4.2 Synchronous applications
The most basic applications run synchronously. On a synchronously running app, an app begins at a particular entry point, usually a main method, then runs through the application line-by-line until it reaches a point, e.g. a method or function, that has its own internal set of instructions to carry out. At this point, it will 'step into' that function, carry out that function's internal code step by step, repeating this process for each function it encounters, then continuing on back at the point where the function was encountered when complete. By analogy with sewing, the path this code runs through as it is executed, entering into and leaving functions as they are encountered, is called a thread. Synchronous code is that which is executed along only a single thread. 

### 4.3 Asynchronous applications and multithreaded applications
In more advanced applications, the initial application execution process may be split up at various points, so that different paths of code are able to be run through simultaneously. Such an application's code is said to be asynchronous, and an application where code execution splits up into these multiple simultaneously running paths is called a multithreaded application. Because they execute multiple code paths simultaneously, multithreaded applications are usually faster and more performant than single-threaded ones.

### 4.4 Thread safety
However, since threads in a multithreaded application may nevertheless depend on changes made in other concurrently running threads, and since the order in which different threads are completed is indeterminate, programs with mutable objects require careful handling to ensure that threads work as desired and do not behave or break in unpredictable ways. Applications which do not take these precautions are said not to be thread safe. 

### 4.5 Immutability guarantees thread safety
The greatest practical benefit associated with immutability is that immutable applications are ipso facto thread safe. Because of this, they eliminate unpredictable functionality that might otherwise stem from the design of a multithreaded application, making them more reliable and secure. 

### 4.6 Avoid setters
One practical consequence of preferring immutable to mutable objects is that setter methods should be avoided. A setter is a method that changes the value of a (usually private) field it is associated with in an object according to the type it implements. Setters get their name in a manner analogous to getters, and engender many of the same problems as getters do. In addition, because setters change the values of their associated fields, methods making use of setters inherently suffer from a phenomenon called temporal coupling, which occurs when an object's functionality is strongly dependent on its surrounding code. In particular, temporal coupling means that there is no guarantee that calling the same method with the exact same inputs will always return the same result. To avoid this, avoid setters and prefer immutable to mutable fields. 

## 5 Composition over inheritance
In object oriented programming, inheritance is a many-to-one relation between classes according to which the code of one class, called the base, parent, or superclass, is made available to one or more other classes, called its derived, child, or subclasses. When instantiated, a subclass then retains all of the functionality of both its immediate type and of any of that type's direct or indirect superclasses. 

The primary practical justification for inheritance is that it allows for code to be made usable by select classes that may need it without thereby making it accessible everywhere. The primary theoretical justification for inheritance is that it supports the idea of object-oriented programming objects as modeling real life ones: just as e.g. living things are classified according to species which may themselves be grouped together under a common genus, so too OOP objects making use of inheritance belong to types which are themselves subtypes of other types. 

The primary disadvantages of inheritance are that it leads to classes being tightly coupled together, to larger, less cohesive objects, and to a child class' full functionality being partly hidden in its parent class instead of being immediately viewable to other developers in the class itself.

The main problem with inheritance arises is that the assimilation of object-oriented programming objects to real-world ones is largely misleading. In practice, very little code in object oriented programming languages actually adhere to the ideal of having objects reflect real-world entities: such an endeavor is even antithetical to theoretical virtues like object cohesion and loose coupling, and even classes that fail to exhibit these virtues are far more likely to name roles (e.g. builder) than types (e.g. dog). Most strikingly, where real-world objects act primarily on other objects, object-oriented programming objects primarily act on themselves. 

From a computational standpoint, the main import of inheritance is that it makes code in one object accessible to other objects via a many-to-one relationship. But such a relationship can be obtained in a cleaner way and more flexible way by dependency injection, i.e. by passing the would-be parent object as an argument into the would-be child object's constructor and assigning it therein to one of its internal fields. In this way, the would-be parent object's functionality remains accessible to its would-be child class without negatively affecting that class' cohesion. In addition, if the constructor is written to require an interface instead of a particular concrete class, it becomes possible to pass in alternate implementations, achieving greater versatility by decoupling the would-be child from a particular implementation. 

## Inject dependencies
## Prefer pure dependency injection over dependency injection containers.
## Named variables are a code smell.
## Prefer accurate data types over validation logic. 

## Remove validation logic from constructors
