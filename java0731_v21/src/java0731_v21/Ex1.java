package java0731_v21;

import java.util.HashMap;

public class Ex1 {
	public static void main(String[] args) {
		var map = new HashMap<String, Integer>();
		map.put("신", 86);
		map.put("홍", 90);
		map.put("동", 80);
		
		var entrySet = map.entrySet();
		for(var mm : entrySet) {
			System.out.println(mm);
			var k1= mm.getKey();
			System.out.println(k1);
			var v1 = mm.getValue();
			System.out.println(v1);
		}
	}
}
