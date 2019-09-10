package Inheritance;

//SuperClass or ParentClass
public class BaseClass {	
	//Parent Class variables
	String parentVariable = "BaseVariable";
	String parentChildVariable = "Parent";
	String valueToAssignedinChild;
	
	//Fact #1 - This variable has no access to child classes, since it is private
	private int onlyBaseVariable; 
	
	//Constructors
	BaseClass(int a){
		onlyBaseVariable = a;
	}
	BaseClass(){
		onlyBaseVariable = 1;
	}
	
	//Methods
	void parenPrint() {
		System.out.println("Printing Base Class");
	}
	void parentPrintOnlyBaseVariable() {
		System.out.println("Printing onlyBaseVariable: " + onlyBaseVariable);
	}
}	