@FunctionalInterface
/**
 * With introduction of default keyword in java 8 we can have any number of default implementation of method inside an interface. This default keyword was used for introducing forEach method in the collection interface (Iterable interface to be more precise). 
 * @author gokulpandey
 *
 */
public interface TestMarkerInterface {

	public void doNothing();

	public default void ex() {
		System.out.println();
	}

	public default void ex1() {
		System.out.println();
	}

}
