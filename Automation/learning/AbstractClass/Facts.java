package AbstractClass;

public class Facts {

	/**
	1.	Any class that contains one or more abstract methods must also be declared abstract. 
	2.	To declare a class abstract, you simply use the abstract keyword in front of the class 
		keyword
		at the beginning of the class declaration. 
	3.	There can be no objects of an abstract class. That is, an abstract class cannot be directly 
		instantiated with the new operator. Such objects would be useless, because an abstract class 
		is not fully defined. 
	4.	you cannot declare abstract constructors, 
	5. 	you cannot declare abstract static methods. 
	6.	Any subclass of an abstract class must either implement all of the abstract methods in the 
		superclass, or be itself declared abstract.
	7. 	You can require that certain methods be overridden by subclasses by specifying the
		abstract type modifier. These methods are sometimes referred to as subclasser responsibility
		because they have no implementation specified in the superclass. Thus, a subclass must
		override them—it cannot simply use the version defined in the superclass. 
	8.	To declare an abstract method, use this general form:
		abstract type name(parameter-list);
	 **/
}
