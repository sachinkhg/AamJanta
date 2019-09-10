package Inheritance;
//Extending Child Class from Parent Class
public class ChildClassOfBase extends BaseClass{
	String childVariable = "ChildVariable";
		
	void childPrint() {
		System.out.println("Printing Child Class");
	}
	void assingParentVariables(String value) {
		valueToAssignedinChild = value;
		System.out.println("valueToAssignedinChild: " +valueToAssignedinChild);
	}
}
