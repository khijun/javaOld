package java0715;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ArrayListEx1 {

	public static void main(String[] args) {
		List<String> list;
		list = new Vector<String>();
		
		list.add("홍길동");
		list.add("자바");
		list.add("Hello");
			
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
//		for(String str : list) {
//			System.out.println(str);
//		}
	}

}
