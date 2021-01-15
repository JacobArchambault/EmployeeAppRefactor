# EmployeeAppRefactor
A git tutorial showing how to change an application printing out employee info to implement best practices like strong encapsulation, composition over inheritance, immutability, and dependency injection.

## 1 Place all classes in a package
Using the default package opens up the possibility for class name ambiguity, which can lead to compilation errors.

## 2 Keep methods with the classes they act on.
For instance, prefer calling a void ```myObj.info()``` method, where the body of ```info``` is ```System.out.println(this)``` over calling ```System.out.println(myObj)``` in a ```main``` method. As the example suggests, this should be done even for very small methods as a way of managing complexity in advance before it gets out of hand.

## 3 Avoid public fields
A field is that which, belonging to an object in accordance with the design dictated by its implementation type, may be assigned as its value an object or primitive data type instance. A field of an object is public if that field's value may be obtained by any other object directly and without mediation. A field is private if its value is at best only directly accessible by those functions, called methods, belonging to the object itself.

By definition, an object's public fields can be used anywhere in an application, and if the values of those fields may be varied, then they can also be manipulated. This can make it difficult to keep track of all the places a field used and lead to excessive complexity, making a program hard to understand, to detect errors in, and to build on without introducing new errors. It can also open up your application to security vulnerabilities should a third party choose to manipulate the field in an unanticipated manner.

To avoid these problems, use private fields, thus ensuring the methods a field's value are accessible by are limited in number and clearly defined.

## 4 Avoid empty getters and setters
A getter is a method belonging to an object, in accordance with its type, that a distinct object may use to obtain the values of that object's private fields. Getters are called so from the common practice of naming them with a ```get``` prefix, followed by the field whose value they obtain by it, e.g. ```getName```.  to obtain the value of a name field, ```getAddress``` for that of an address field, etc.

The use of public fields and empty getters have certain advantages relative to each other: making a field public and obtaining its value directly has the immediate advantage of simpler syntax with less boilerplate code; using getters has the advantage of procuring a single place for changes in case it become necessary at a later point in time. 
