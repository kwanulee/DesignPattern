
 
public class ChocolateBoiler_TS {
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler_TS uniqueInstance;
  
	private ChocolateBoiler_TS() {
		empty = true;
		boiled = false;
		System.out.println("Creating unique instance of Chocolate Boiler By TS");
	}
  
	public static synchronized ChocolateBoiler_TS getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ChocolateBoiler_TS();
		} 
		return uniqueInstance;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			// fill the boiler with a milk/chocolate mixture
		}
	}
 
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			// drain the boiled milk and chocolate
			empty = true;
		}
	}
 
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			// bring the contents to a boil
			boiled = true;
		}
	}
  
	public boolean isEmpty() {
		return empty;
	}
 
	public boolean isBoiled() {
		return boiled;
	}
}
