package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukImpl  implements SungJuk {
	//생성된 빈들 중에서 sungJukDTO찾아서 매핑을 해라. 
	//생성자 이건 Setter 메소드 이건 상관없이 SUngJukDTO 찾아서 매핑을 해라.
	@Autowired //https://www.notion.so/Spring-72aaf4703f7e4f099d69bc9a324e5b04 [ 김찬영  2023-09-14 오후 04:41:10 ]
	private SunJukDTO sungJukDTO = null; 
	

	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath());	
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0); 
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungJukDTO); 
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 입력 : ");
		String name = scan.next();
		System.out.println("국어 입력 : ");
		int kor = scan.nextInt();
		System.out.println("영어 입력 : ");
		int eng = scan.nextInt();
		System.out.println("수학 입력 : ");
		int math = scan.nextInt();
		
		sungJukDTO.setName(name);
		sungJukDTO.setKor(kor);
		sungJukDTO.setEng(eng);
		sungJukDTO.setMath(math);
	}


	
}
