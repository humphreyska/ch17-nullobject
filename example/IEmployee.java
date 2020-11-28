/*
 * Example using a clever implementation of 
 * the Null Object pattern
 *
 * The NullEmployee object is static, so it's always available 
 * to any client using IEmployee. And there's only ever one
 * such IEmployee object!
 *
 * And it's the designer of IEmployee that sets up this
 * infrastructure, which is why embedding it right there in the
 * interface definition itself is appropriate.
 */

// Clients will need certain Employee behaviors. 
public interface IEmployee {
    // Each IEmployee class must implement this method.
    void foo();
    

    // All IEmployee clients get access to this one object.
    public static final IEmployee NULL = new NullEmployee();
    static class NullEmployee implements IEmployee {
	public void foo() { System.out.println("NULL"); }
    }
}


// Here is a concrete realization of the IEmployee behavior
// interface. 
class Employee implements IEmployee {
    public void foo() { System.out.println("not null"); }
}



// Here is an example of some client code! Notice that clients
// have the ability to know if a specific IEmployee object is
// the IEmployee.NULL object. But generally don't need to
// worry about it!
class Client {
    public static void main(String[] args) {

	System.out.println("Making 10 random IEmployee objects:");
	for (int i=0; i < 10; i++) {
	    // Not even sure what I'm getting!
	    IEmployee a = makeEmployee();
	    a.foo(); // notice not checking for null reference here!!!!!!!!!
	    // But if really need to know:
	    if (a == IEmployee.NULL) {
		System.out.println("\tIt was NULL, wasn't it?!");
	    }
	    else {
		System.out.println("\tIt wasn't null, was it?!");
	    }
	}
    }

    static java.util.Random randomizer = new java.util.Random();
    public static IEmployee makeEmployee() {
	if (randomizer.nextBoolean()) {
	    return new Employee();
	}
	return IEmployee.NULL;
    }
}
    
