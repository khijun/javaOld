package java0730;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("ken", 100));
		list.add(new Student("Shin", 60));
		list.add(new Student("kim", 80));
		
		Collections.sort(list, (s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()));
		
		list.stream().forEach(s->{
			System.out.println(s.getName() + ", " + s.getScore());
		});
	}
}
