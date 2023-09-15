package sample04;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class HelloSpring {
	public void menu(ApplicationContext applicationContext) {
		Scanner scan = new Scanner(System.in);
		SungJuk sungJuk = null;
		int num;
		//int count =0;
		while(true) {
			System.out.println("**************");
			System.out.println("   1. 입력");
			System.out.println("   2. 출력");
			System.out.println("   3. 수정");
			System.out.println("   4. 삭제");
			System.out.println("   5. 끝");
			System.out.println("**************");
			System.out.println(" 번호 입력 : ");
			num = scan.nextInt();
			if(num == 5) break;
			if(num == 1 ) {
				sungJuk = (SungJuk)applicationContext.getBean("sungJukInput"); //new SungJukInput(); new 안하고 빈으로 잡는다.
			}else if(num == 2 ){
				sungJuk = (SungJuk)applicationContext.getBean("sungJukOutput");
			}else if(num == 3  ) {
				sungJuk = (SungJuk)applicationContext.getBean("sungJukUpdate");
			}else if(num == 4  ) {
				sungJuk = (SungJuk)applicationContext.getBean("sungJukDelete");
			}
			sungJuk.execute();
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); //전역쓰면 싫어해서 . 지역으로 쓴다.
		HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");
		helloSpring.menu(applicationContext); // 매개변수로 쓰면 지역으로 쓸수있다.
		System.out.println("프로그램 종료합니다.");
		
	}
}
