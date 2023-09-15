package sample02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//@Component //어노테이션방식
public class CalcMul implements Calc {
	
	private int x,y;

	public CalcMul() {
		System.out.println("CalcMul 기본 생성자");
	}
	
	@Autowired
	public void setX(@Value("25") int x) {
		this.x = x;
	}
	
	@Autowired
	public void setY(@Value("36") int y) {
		this.y = y;
	}
	
	
	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x*y));
	}
	
	
}
