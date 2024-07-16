package dp;

public class Main2 {

	public static void main(String[] args) {
		Student minsu = new Student("민수");
		Course java = new Course("cs100", "자바");
		Course cplus= new Course("cs101", "C/C++");
		minsu.registerCourse(java);
		minsu.registerCourse(cplus);
		
		Student gildong = new Student("길동");
		gildong.registerCourse(java);
		
		System.out.println(minsu);
		System.out.println(gildong);
			
		System.out.println(java.getInfo());
		
		String str1 = "123";
		String str2 = "123";
		System.out.println(str1.concat(str2));
		
		
//		for(Student std : java.getStudent()) {
//			System.out.println(std);
//		}
	}

}
