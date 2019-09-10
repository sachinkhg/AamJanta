package AbstractClass;

public class TestAbstractClass {
	
	public static void main(String[] args) {
		/*Explaining Fact#3
		 * There can be no objects of an abstract class. 
		 * That is, an abstract class cannot be directly instantiated with the new operator. 
		 * Such objects would be useless, because an abstract class is not fully defined. 
		 * 
		 * Can not instantiate Abstract Class - uncomment the below line and check 
		 */
		//DefineAbstractClass dac = new DefineAbstractClass();
		
		//Defining object for ExtendingExtendedAbstractClass, which is extended by Abstract Class
		DefineAbstractClass dac = new ExtendingExtendedAbstractClass(1, 2, 3, 4); // a = 1, b = 2, c = 3, d = 4
		ExendingAbstractClass eac = new ExtendingExtendedAbstractClass(5, 6, 7, 8); // a = 5, b = 6, c = 7, d = 8
		ExtendingExtendedAbstractClass eeac = new ExtendingExtendedAbstractClass(9, 10, 11, 12); // a = 9, b = 10, c = 11, d = 12
		
		dac.print3();
		eac.print2();
		eeac.print2();
	}
	
	
}
