package sample03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SunJukDTO {

	private String name; //private String name = "홍길동"; 밑에처럼 안주고 위에 이렇게 벨류값 줘도 된다.
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	@Override
	public String toString() { // 이거 주석걸면.SungJukImpl에서 System.out.println(sunJukDTO);  할때 16진수 주소값나옴.
		return name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+ String.format("%.2f",avg) ;
	}
	@Autowired
	public void setName(@Value("홍길동") String name) {
		this.name = name;
	}
	@Autowired
	public void setKor(@Value("97") int kor) {
		this.kor = kor;
	}
	@Autowired
	public void setEng(@Value("100") int eng) {
		this.eng = eng;
	}
	@Autowired
	public void setMath(@Value("95") int math) {
		this.math = math;
	}
	//외부에서 들어오는 것을 매핑 하는걸 Autowired 라고 한다. 외부에서 입력되는게 아닌 Tot Avg get값들은 Autowired못쓴다.
	public void setTot(int tot) {
		this.tot = tot;
	}
	
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public String getName() {
		return name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public int getTot() {
		return tot;
	}
	
	public double getAvg() {
		return avg;
	}
	
	
	
}
