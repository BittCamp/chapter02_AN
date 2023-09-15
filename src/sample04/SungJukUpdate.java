package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class SungJukUpdate implements SungJuk {
	@Autowired
	@Qualifier("arrayList")
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정할 이름 입력 : ");
		String name = scan.next();
		//SungJukDTO2 선언안해줘도 쓸수있는 이유
		int sw=0; //스위치 변수
		for(SungJukDTO2 sungJukDTO2: list) {
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTO2);
				
				System.out.println("국어점수 입력 : ");
				int kor = scan.nextInt();
				System.out.println("영어점수 입력 : ");
				int eng = scan.nextInt();
				System.out.println("수학점수 입력 : ");
				int math = scan.nextInt();
				System.out.println();
				
				int tot = kor + eng + math;
				double avg = tot/3.0;
				
				sungJukDTO2.setName(name);
				sungJukDTO2.setKor(kor);
				sungJukDTO2.setEng(eng);
				sungJukDTO2.setMath(math);
				sungJukDTO2.setTot(tot);
				sungJukDTO2.setAvg(avg);
				
				System.out.println(name+"님의 데이터를 수정하였습니다.");
				
				break;	
			}
		}//for
		//if( sw==0) {System.out.println("찾고자 하는 이름이 없습니다.");}
		//이렇게 끝나버린다.
		if( sw==0) {
			System.out.println("찾고자 하는 이름이 없습니다.");	
			return;//메소드를 벗어나라. 써도되고.
		}
	}
}
