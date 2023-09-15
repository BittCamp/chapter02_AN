package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//생성자 방식
		SungJuk sungJuk = (SungJuk)applicationContext.getBean("sungJukImpl");
		sungJuk.calcTot();
		sungJuk.calcAvg();
		sungJuk.display(); //출력
		
		System.out.println();
		sungJuk.modify();
		sungJuk.calcTot();
		sungJuk.calcAvg();
		sungJuk.display(); 
	}
}
