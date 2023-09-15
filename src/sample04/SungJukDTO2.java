package sample04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Scope("prototype") // 스코프로 prototype잡아야 객체주소로 덮어쓰기 안되구 , 여러객체를 만들어 생성이 된다.
public class SungJukDTO2 {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	@Override
	public String toString() {
		return name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+ String.format("%.3f",avg) ;
	}

	public String getName() {
		return name;
	}
	@Autowired
	public void setName(@Value("홍길동") String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}
	@Autowired
	public void setKor(@Value("97") int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}
	@Autowired
	public void setEng(@Value("97") int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}
	@Autowired
	public void setMath(@Value("97") int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
}
