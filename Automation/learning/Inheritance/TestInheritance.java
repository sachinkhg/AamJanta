package Inheritance;

public class TestInheritance {

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		ChildClassOfBase child = new ChildClassOfBase();
		
		
		//child object will have access of Parent class method
		base.parenPrint();	
		
		child.parenPrint();
		child.childPrint();
		
		// child object will have access of Parent class variable
		child.parentVariable = "BaseVariableOverrideenFromChild"; 
		
		child.childVariable = "ChildVariable";
		
		//Printing value for the variables available in the base and child class
		System.out.println("parentVariable" + child.parentVariable);
		System.out.println("parentVariable" + base.parentVariable);
		System.out.println("childVariable" + child.childVariable);
		
		//child.parentPrintOnlyBaseVariable();
		//child.childPrintOnlyChildVariable();
	}
}
