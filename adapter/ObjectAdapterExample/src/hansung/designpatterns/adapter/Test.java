package hansung.designpatterns.adapter;

public class Test {

	public static void main(String[] args) {
		Vender vender = new VenderAdapter(new Vender2());
		//Vender vender = VenderFactory.getInstance().createVender();
		MyApp app = new MyApp(vender);
        app.run();
	}

}
