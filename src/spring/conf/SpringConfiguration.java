package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample04.SungJukDTO2;

@Configuration // 컨피그레이션 파일이라 설정을 해줘야 스프링이 이걸 읽는다.
public class SpringConfiguration {
	//자바방식
	//빈 생성. <=== 2.자바에서 바로 빈설정을 한다. 얘를 빈으로 쓰겠다 설정함.
//	@Bean // 지금 생성하는 클래스가 빈 역할 을 할것이다 라고 알려준다.
//	public MessageBeanImpl messageBeanImpl(){ //함수에 리턴되는 얘를 빈으로 써먹겠다.
//		return new MessageBeanImpl("사과");
//	}
	
	@Bean(name="messageBeanImpl") // 자바 문법이랑 비슷하게 
	public MessageBeanImpl getMessageBeanImpl(){ //함수에 리턴되는 얘를 빈으로 써먹겠다.
		return new MessageBeanImpl("사과");
	}
	// 자바방식 으로 실행.
	@Bean
	public CalcAdd calcAdd(){ // 이거랑 
		return new CalcAdd(25,46); // CalcAdd(25,46) 생성자에 값이 두개 넘어가야됨. 기본생성자.
	}
	// 자바방식 으로 실행.	
	
	
	@Bean(name="calcMul") // 이거 두개 차이???
	public CalcMul getCalcMul() { //기본생성자가 caclcMul() 안에 매개변수가 없다.
		return new CalcMul();
	}
	
	//sample04 arrayList 인터페이스 의 자식클래스를 알수가없어요. 그래서 여기쓰는거임.
	 //얘함수에서 리턴하는 애를 빈으로 생성해라
	@Bean
	//public ArrayList<SungJukDTO2> arrayList(){
	public List<SungJukDTO2> arrayList(){ // 부모 - 자식 . 자식을 보내도 된다.
		return new ArrayList<SungJukDTO2>(); //받을떈 부모로 받아야된다.
	}
}
/* 
@Bean 
- 메소드에서 return 되는 값을 스프링 빈으로 생성해준다.
- 메소드의 이름은 반드시 빈의 id명으로 만들어야한다.
 
 * */
