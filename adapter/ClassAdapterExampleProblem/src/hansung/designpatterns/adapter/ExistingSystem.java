package hansung.designpatterns.adapter;

public class ExistingSystem {

	public static void main(String[] args) {
		VenderClass vender = VenderClassFactory.getInstance().createVenderClass();
		vender.request();
	}

}
