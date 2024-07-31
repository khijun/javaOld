package java0730;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("ken", 100));
		list.add(new Student("Shin", 60));
		list.add(new Student("kim", 80));
		
		list.stream()	// 스트림
		.filter(s->s.getScore() >= 70)	// 중간 작업
		.forEach(s->System.out.println(s.getName()));	// 최종 작업
	
		int count = (int)list.stream()
		.filter(s->s.getScore() >= 70)
		.count();
		System.out.println(count);
		
		list.stream().forEach(s -> {
			System.out.println(String.format("%s, %d", s.getName(), s.getScore()));
		});
		
		for(Student std : list) {
			if(std.getScore() < 70) {
				list.remove(std);
			}
		}
	}
}
