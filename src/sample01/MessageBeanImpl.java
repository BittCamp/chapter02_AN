package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("messageBeanImpl") <<=== 1번 얘를 빈으로 쓰겠다.
public class MessageBeanImpl implements MessageBean {
	private String fruit;
	private int cost;
	private int qty;
	
	//Constructor Injection
	public MessageBeanImpl(@Value("사과") String fruit) {
		super();
		this.fruit = fruit;
	} 
	
	//Setter Injection
	@Autowired // 세터를 자동으로 불러서 처리해라 라는 의미다.
	public void setCost(@Value("5000") int cost) { // @Value("5000") xml에 데이터를 안주고 impl에 초기 데이터를 주었다.
		this.cost = cost;
	}
	@Autowired
	public void setQty(@Value("3") int qty) {
		this.qty = qty;
	}


	@Override
	public void sayHello() {
		System.out.println(fruit+ "\t" +cost+ "\t" +qty);
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit+ "\t" +cost+ "\t" +qty);
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit+ "\t" +cost+ "\t" +qty);
	}

}
