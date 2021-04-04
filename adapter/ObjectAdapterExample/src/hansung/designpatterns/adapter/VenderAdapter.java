package hansung.designpatterns.adapter;

public class VenderAdapter implements Vender {
	Vender2 vender;
	
	public VenderAdapter (Vender2 vender) {
		this.vender = vender;
	}
	
	public void request() {
		vender.specificRequest();
	}

}
