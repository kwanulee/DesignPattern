package hansung.designpatterns.adapter;

public class VenderClassAdapter extends Vender2 implements Vender {
	
	public void request() {
		super.specificRequest();
	}

}
