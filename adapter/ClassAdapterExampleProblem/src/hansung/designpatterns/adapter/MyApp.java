package hansung.designpatterns.adapter;

public class MyApp {
	Vender vender;				// Vender 객체 인스턴스

	public MyApp(Vender vender) {
		this.vender = vender;	// vender 멤버변수 초기화
	}
	public void run() { 
		vender.request();		// vender의 request() 호출
	}
}
