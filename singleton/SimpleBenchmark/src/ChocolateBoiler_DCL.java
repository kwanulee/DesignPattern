
 
public class ChocolateBoiler_DCL {
	private boolean empty;
	private boolean boiled;
	private volatile static ChocolateBoiler_DCL uniqueInstance;
  
	private ChocolateBoiler_DCL() {
		empty = true;
		boiled = false;
		System.out.println("Creating unique instance of Chocolate Boiler By DCL");
	}
  
	public static  ChocolateBoiler_DCL getInstance() {
		if (uniqueInstance == null) {
			synchronized (ChocolateBoiler_DCL.class) {
				if (uniqueInstance == null) { 	
					uniqueInstance = new ChocolateBoiler_DCL();
				}
			}
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
