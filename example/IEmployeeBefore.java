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
public interface IEmployeeBefore {
    // Each IEmployee class must implement this method.
    void foo();
    
}


// Here is a concrete realization of the IEmployee behavior
// interface. 
class EmployeeBefore implements IEmployeeBefore {
    public void foo() { System.out.println("not null"); }
}



class ClientBefore {
    public static void main(String[] args) {

	System.out.println("Making 10 random IEmployee objects:");
	for (int i=0; i < 10; i++) {
	    // Not even sure what I'm getting!
	    IEmployeeBefore a = makeEmployee();
	    // have to check for null reference
	    if (a != null) {
		a.foo(); 
		System.out.println("\tIt wasn't null, was it?!");
	    }
	    else {
		System.out.println("NULL");
		System.out.println("\tIt was NULL, wasn't it?!");
	    }
	}
    }

    static java.util.Random randomizer = new java.util.Random();
    public static IEmployeeBefore makeEmployee() {
	if (randomizer.nextBoolean()) {
	    return new EmployeeBefore();
	}
	return null;
    }
}
    
