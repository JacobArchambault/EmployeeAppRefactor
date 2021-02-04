# EmployeeAppRefactor
A git tutorial showing how to change an application printing out employee info to implement best practices like strong encapsulation, composition over inheritance, immutability, and dependency injection. 

The application begins with its main classes linked to each other by implementation inheritance in Java's default package with mutable fields, large methods, and all fields open to change from anywhere via getters and setters. Its end point is an application with classes in a named package linked to each other by composition using decorator patterns to illustrate multiple possible composition relationships, methods refactored so as to generally have a body no larger than three lines, public getters and setters eliminated to enforce stronger restrictions on field encapsulation, and fields and classes made final to enforce immutability.

## 1 Place all classes in a package
Using the default package opens up the possibility for class name ambiguity, which can lead to compilation errors.

## 2 Use version control, and clean up unused code immediately
Code should be placed under a system of version control such as git. Version control allows a programmer to keep track of the previous stages of a project, and to revert back to an earlier stage should a problem arise. This means that if there is a need to recover a wrongly deleted piece of functionality, it may be done through version control. Most languages have one or several code cleanup tools that are able to partially or even fully automate the process of finding and removing unused chunks of code. Cleaning up unused code as soon as it becomes unused ensures other developers don't mistakenly build on code marked for deletion, preventing sprawl and helping to direct other developers to the preferred way of implementing a piece of functionality elsewhere in an application.

## 2 Encapsulation
Encapsulation refers to the practice of enclosing fields in classes with the methods they act on. Properly done, encapsulation prevents code sprawl and allows developers to use objects without being forced to attend to how their methods work internally. The following provide suggestions for how to best make use of this practice.

### 2.1 Keep methods with the classes they act on.
For instance, prefer calling a void ```myObj.info()``` method, where the body of ```info``` is ```System.out.println(this)``` over calling ```System.out.println(myObj)``` in a ```main``` method. As the example suggests, this should be done even for very small methods as a way of managing complexity in advance before it gets out of hand.

### 2.2 Avoid public fields
A field is that which, belonging to an object in accordance with the design dictated by its implementation type, may be assigned as its value an object or primitive data type instance. A field of an object is public if that field's value may be obtained by any other object directly and without mediation. A field is private if its value is at best only directly accessible by those functions, called methods, belonging to the object itself.

By definition, an object's public fields can be obtained directly from anywhere in an application; if the values of those fields may be varied, then they can also be manipulated. This can make it difficult to keep track of all the places a field used and can lead to excessive complexity, making a program hard to understand, hard to detect errors in, and hard to build on without introducing new errors. It can also open up your application to security vulnerabilities should a third party choose to manipulate the field in an unanticipated manner.

To avoid these problems, use private fields, thus ensuring the methods able to access a field's value are limited in number and clearly defined.

### 2.3 Avoid empty getters
A getter is a method belonging to an object, in accordance with its type, that a distinct object may use to obtain the values of that object's private fields. Getters are called so from the common practice of naming them with a ```get``` prefix, followed by the field whose value they obtain by it, e.g. ```getName```.  to obtain the value of an object's ```name``` field, ```getAddress``` for that of an ```address``` field, etc. A getter is empty if it does nothing else besides return the value of its associated field.

The use of public fields and empty getters have certain advantages relative to each other: making a field public and obtaining its value directly has the immediate advantage of simpler syntax with less boilerplate code; using getters has the advantage of procuring a single place for changes in the manner in which a field's value may is obtained in case these become necessary at a later point in time. But both have in common that by making values accessible anywhere in an application, they make an application's code more sprawling and less maintainable, increasing the likelihood of other developers introducing accidental errors and of malicious actors introducing intentional ones. Instead, consider relegating the relevant functionality of the object type obtaining the field back to the object type to which the field belongs directly. 

### 2.4 Avoid getters, period.
Getters may be divided into two kinds: those that simply return the value of the field that they get, i.e. empty getters, and those that perform any additional functionality in the process of returning the object. The reasons for avoiding the first have been given above. The reasons for avoiding the second are semantic: namely such functions aren't properly getters, but functions that get and, in addition, do other things as well. Consequently, these functions should be named in a manner representing their full functionality to ensure their proper use by others.

### 2.5 Avoid setters
A setter is a method that changes the value of a (usually private) field it is associated with in an object according to the type it implements. Setters get their name in a manner analogous to getters, and engender the same problems as getters do. In addition, because setters change the values of their associated fields, methods making use of setters inherently suffer from a phenomenon called temporal coupling, which occurs when an object's functionality is strongly dependent on its surrounding code. In particular, temporal coupling means that there is no guarantee that calling the same method with the exact same inputs will always return the same result. To avoid this, avoid setters and prefer immutable to mutable fields. 

## Fields should be immutable
An immutable field is one whose value does not change at any point after its creation throughout the course of an application. Consequently, objects whose fields are immutable reliably produce the same output or perform the same action whenever they are invoked with like inputs. This is not the case for mutable objects, i.e. those whose fields may change their value. 
### 2.6 Method names should be a noun or a verb, nothing more
If your methods have longer names than this, it is usually a sign that your class is too large and coarse-grained, and should be broken down into smaller classes. Void methods should name actions, e.g. ```print```, ```save```. Return methods should name what they return , e.g. ```fullName()```.
## Composition over inheritance
## Use only one primary constructor.
## Named variables are a code smell.
## Prefer accurate data types over validation logic. 

## Remove validation logic from constructors
