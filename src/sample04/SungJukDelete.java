package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class SungJukDelete implements SungJuk {
	@Autowired
	@Qualifier("arrayList")
	private List<SungJukDTO2> list;

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름 입력 : ");
		String name = scan.next(); //삭제 for문 돌리면 중간에 값 빠지면 객수안맞아서 오류 남. //Iterator로 돌려야된다.
		
		Iterator<SungJukDTO2> it = list.iterator();
		int sw = 0;
		//it.hasnext() , it.remove() , it.next()
		while(it.hasNext()) { //항목이 없을때 까지 반복하겠다. 항목이 있으면 true 없으면 false
			//it가 가리키는 항목을 꺼내서 저장한 후 ,it는 다음 항목으로 이동한다.
			SungJukDTO2 sunJukDTO2 = it.next();
			
			if(sunJukDTO2.getName().equals(name)) {
				sw = 1;
				it.remove(); //아까보관한 항목을 제거
				System.out.println(name+"님의 데이터를 삭제하였습니다.");
				break;
			}
		}//while
		if(sw ==0) System.out.println("찾고자 하는 이름이 없습니다.");
	}
	
	
}
