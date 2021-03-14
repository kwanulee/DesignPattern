package com.sample.singleton_benchmark;

 
public class ChocolateBoiler_Static {
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler_Static uniqueInstance = new ChocolateBoiler_Static();
  
	private ChocolateBoiler_Static() {
		empty = true;
		boiled = false;
		System.out.println("Creating unique instance of Chocolate Boiler By Static");
	}
  
	public static ChocolateBoiler_Static getInstance() {
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
