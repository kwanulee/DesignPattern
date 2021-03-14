
public class SimpleBenchmark {
	static long elapses1=0;
	static long elapses2=0;
	static long elapses3=0;

	static public void testThreadSafe() throws InterruptedException {
    	Thread thread1 = new Thread() {
			public void run() {
				long start = System.nanoTime();
				ChocolateBoiler_TS.getInstance();
				long end = System.nanoTime();
				long elapse = end-start;
				elapses1 += elapse;
				//System.out.println("ChocolateBoiler_TS instance creation time = "+elapse + " ns");
			}
		};

		Thread thread2 = new Thread() {
			public void run() {
				long start = System.nanoTime();
				ChocolateBoiler_TS.getInstance();
				long end = System.nanoTime();
				long elapse = end-start;
				elapses1 += elapse;
				//System.out.println("ChocolateBoiler_TS instance creation time = "+elapse + " ns");
			}
		};
	
		thread1.start();
		thread2.start();
		Thread.sleep(1000);
		System.out.println("Average ChocolateBoiler_TS instance creation time = " + elapses1/2);
    }
    
	static public void testDCL() throws InterruptedException {
    	Thread thread1 = new Thread() {
			public void run() {
				long start = System.nanoTime();
				ChocolateBoiler_DCL.getInstance();
				long end = System.nanoTime();
				long elapse = end-start;
				elapses2 += elapse;
				//System.out.println("ChocolateBoiler_DCL instance creation time = "+elapse + " ns");

			}
		};

		Thread thread2 = new Thread() {
			public void run() {
				long start = System.nanoTime();
				ChocolateBoiler_DCL.getInstance();
				long end = System.nanoTime();
				long elapse = end-start;
				elapses2 += elapse;
				//System.out.println("ChocolateBoiler_DCL instance creation time = "+elapse + " ns");

			}
		};
		
		thread1.start();
		thread2.start();
		Thread.sleep(1000);
		System.out.println("Average ChocolateBoiler_DCL instance creation time = " + elapses2/2);
    }

	static public void testStatic() throws InterruptedException {
    	Thread thread1 = new Thread() {
			public void run() {
				long start = System.nanoTime();
				ChocolateBoiler_Static.getInstance();
				long end = System.nanoTime();
				long elapse = end-start;
				elapses3 += elapse;
				//System.out.println("ChocolateBoiler_Static instance creation time = "+elapse + " ns");
			}
		};

		Thread thread2 = new Thread() {
			public void run() {
				long start = System.nanoTime();
				ChocolateBoiler_Static.getInstance();
				long end = System.nanoTime();
				long elapse = end-start;
				elapses3 += elapse;
				//System.out.println("ChocolateBoiler_Static instance creation time = "+elapse + " ns");
			}
		};
		
		thread1.start();
		thread2.start();
		Thread.sleep(1000);
		System.out.println("Average ChocolateBoiler_Static instance creation time = " + elapses3/2);
		
    }
	

	public static void main(String[] args) throws InterruptedException {
		testThreadSafe();
		testStatic();
		testDCL();
	}

}
