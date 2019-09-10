package Inheritance;

public class SuperChild extends BaseClass{
	private int onlyChildVariable;
	String parentChildVariable = "Child";
	SuperChild(){
		super(2);
		onlyChildVariable = 1;
	}
	void childPrintOnlyChildVariable() {
		System.out.println("Printing onlyChildVariable: " + onlyChildVariable);
	}
}
