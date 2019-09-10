package AbstractClass;

/**Explaining Fact#2
 * To declare a class abstract, 
 * you simply use the abstract keyword in front of the class keyword 
 * at the beginning of the class declaration.
**/
public abstract class DefineAbstractClass {
	//variable can not be defined as abstract - uncomment the below line and check 
	//abstract int a;
	int a;
	int b = 10;
	
	/** Explaining Fact#1
	 * Any class, having one or more abstract methods must be declare as abstract class
	 * However, a class defined as abstract is not necessarily required to have abstract method.
	 * Also, There is no point of defining a class abstract if it does not have abstract method.
	**/
	/** Explaining Fact#8
	 * To declare an abstract method, use this general form:
	 * abstract type name(parameter-list);
	 */
	public abstract void print1();
	public abstract void print2();
	public void print3() {
		System.out.println("Writing through print3() method "
				+ "from AbstractClassDemo class");
	}
	//User defined Constructor for DefineAbstractClass
	public DefineAbstractClass(int arg1, int arg2) {
		a = arg1;
		b = arg2;
	}
}
