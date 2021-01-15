# EmployeeAppRefactor
A git tutorial showing how to change an application printing out employee info to implement best practices like strong encapsulation, composition over inheritance, immutability, and dependency injection.

## 1 Place all classes in a package
Using the default package opens up the possibility for class name ambiguity, which can lead to compilation errors.

## 2 Keep methods with the classes they act on.
For instance, prefer calling a void ```myObj.info()``` method, where the body of info is ```System.out.println(this)``` over calling ```System.out.println(myObj)``` in a ```main``` method. As the example suggests, this should be done even for very small methods as a way of managing complexity in advance before it gets out of hand.
