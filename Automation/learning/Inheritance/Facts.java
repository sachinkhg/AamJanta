package Inheritance;

public class Facts {
	/**
	1. A class member that has been declared as private will remain private to its class. It is not accessible by any code outside its class, including subclasses.
	2. A reference variable of a superclass can be assigned a reference to any subclass derived from that superclass.
	3. super() in inheritance has two general forms. 
		3(a) The first calls the superclass’ constructor. 
		 	3(a)(i) A subclass can call a constructor defined by its superclass by use of the following form of super:
					super(arg-list); Here, arg-list specifies any arguments needed by the constructor in the superclass. 
			3(a)(ii) super( ) must always be the first statement executed inside a subclass’ constructor.
			3(a)(iii) When a subclass calls super( ), it is calling the constructor of its immediate superclass. 
					Thus, super( ) always refers to the superclass immediately above the calling class. 
					This is true even in a multileveled hierarchy.
					Also, super( ) must always be the first statement executed inside a subclass constructor.
		3(b) The second is used to access a member of the superclass that has been hidden by a member of a subclass.
			3(b)(i) The second form of super acts somewhat like "this", except that it always refers to the superclass of the subclass in which it is used.
			This usage has the following general form: 
			super.member - Here, member can be either a method or an instance variable.
			3(b)(ii) This second form of super is most applicable to situations in which member names of a subclass hide members by the same name in the superclass. 
	 */
}
