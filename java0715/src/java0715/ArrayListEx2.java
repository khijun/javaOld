package java0715;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.List;

public class ArrayListEx2 {

	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<>();
//		ArrayList<String> list2 = new ArrayList<String>();
//		List<String> list3 = new ArrayList<String>();
//		List<String> list4 = new ArrayList<>();
		
		list.add("홍길동");
		list.add("자바");
		list.add("Hello");
		
		Iterator<Object> it = list.iterator();
		while(it.hasNext()) {
			Object str = it.next();
			System.out.println(str);
		}
		
//		for(String str : list) {
//			System.out.println(str);
//		}
	}

}
