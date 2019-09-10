package AbstractClass;

public class ExtendingExtendedAbstractClass extends ExendingAbstractClass{
	public ExtendingExtendedAbstractClass(int arg1, int arg2, int arg3, int arg4) {
		super(arg1, arg2, arg3, arg4);
	}
	/** Explaining Fact#7
	 * You can require that certain methods be overridden by subclasses by specifying the abstract type modifier.
	 * These methods are sometimes referred to as subclasser responsibility 
	 * because they have no implementation specified in the superclass. 
	 * Thus, a subclass must override them—it cannot simply use the version defined in the superclass. 
	 */
	@Override
	public void print2() {
		System.out.println("Writing through print2() "
				+ "method from ExtendingExtendedAbstractClass class");
	}
	@Override
	public void print4() {
		System.out.println("Writing through print4() "
				+ "method from ExtendingExtendedAbstractClass class");
		
	}
}
