package AbstractClass;
/**Explaining Fact#6
 * Any subclass of an abstract class must either implement all of the abstract methods in the superclass, 
 * or be itself declared abstract.
 */

public abstract class ExendingAbstractClass extends DefineAbstractClass{
	int c, d;
	public ExendingAbstractClass(int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated constructor stub
		super(arg1, arg2);
		c = arg3;
		d = arg4;
	}

	public void print1() {
		System.out.println("Writing through print1() "
				+ "method from ExendingAbstractClass class");
	}
	public abstract void print4();
}

