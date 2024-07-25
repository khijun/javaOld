package java0725;

import java.util.HashMap;

public class KeyEx {
	public static void main(String[] args) {
		Key key1 = new Key(100);
		Key key2 = new Key(100);
		System.out.println(key1.hashCode());
		System.out.println(key2.hashCode());
		System.out.println(key1.equals(key2)?"같다":"다르다");
		
		
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		hashMap.put(new Key(1), "홍길동");
		System.out.println(hashMap.get(new Key(1)));
		
//		HashMap<Integer, String> hashMap = new HashMap<>();
//		hashMap.put(1, "홍길동");
//		System.out.println(hashMap.get(1));
	}
}
