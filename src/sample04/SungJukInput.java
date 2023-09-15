package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	//생성된 빈들 중에서 sungJukDTO2찾아서 자동으로 매핑을 해라. 
	//생성자 이건 Setter 메소드 이건 상관없이 SungJukDTO2 찾아서 매핑을 해라. @Autowired
	
	@Autowired
	private SungJukDTO2 sungJukDTO2; //필드 초기화
	//@Setter
	 //SpringConfiguration 인터페이스에서 제공하면 정확히 뭔지 모른다. 오토와이어는 하는데 생성된 빈들중에서
	// 이 클래스를 찾아서 매핑해라.생성된 빈들은 xml의component뿐만 아니라 자바파일의 컨피규레이션에 @Bean
	// List<SungJukDTO2> arrayList(){ 도 있다.
	@Autowired
	@Qualifier("arrayList")
	private List<SungJukDTO2> list;// 어떤클래스의 타입이 들어와야되는지 모른다. 부모가 인터페이스면 어떤 자식클래스로 생성될지 모른다.클래스가 아니라 인터페이스로 주면 정확한 자식클래스의 값이 뭔지 알아야한다.
										
	
	//public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {//세터로 가져옴. 롬복쓰면 세터빠짐.
	//	this.sungJukDTO2 = sungJukDTO2;
	//}

	//public void setList(List<SungJukDTO2> list) {
	//	this.list = list;
	//}
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이    름 입력 : ");
		String name = scan.next();
		System.out.println("국어점수 입력 : ");
		int kor = scan.nextInt();
		System.out.println("영어점수 입력 : ");
		int eng = scan.nextInt();
		System.out.println("수학점수 입력 : ");
		int math = scan.nextInt();
		System.out.println();
		
		int tot = kor + eng + math;
		double avg = tot/3.0;
		
		//SungJukDTO2 sungJukDTO2 = new SungJukDTO2(); new 로 쓰지 않겠다. 세터를 가져왔기 때문에. 호출 안써도 됨.
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(tot);
		sungJukDTO2.setAvg(avg);
		
		//ArrayList<SungJukDTO2> list = new ArrayList<SungJukDTO2>(); 이거안쓰고 빈으로 한다. 의존관계로.
		list.add(sungJukDTO2);
		//System.out.println(list); 확인용
		
		System.out.println(sungJukDTO2.getName()+ "님의 데이터를 입력 하였습니다");
		
	}


}
