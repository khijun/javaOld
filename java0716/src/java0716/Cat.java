package java0716;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Cat {
	String breed;	// 품종
	String color;
	int age = 10;
	
//	public Cat(String breed, String color, int age) {
//		super();	// this()
//		this.breed = breed;
//		this.color = color;
//		if(age>9) {
//			this.age = age;
//		}
//	}
//
//	public Cat(String breed, String color) {
//		this(breed,color, 10);
//	}
//
//	public Cat(String breed) {
//		this(breed,"흰색", 10);
//	}
//
//	public Cat(int age) {
//	
//	}
//	
//	public Cat() {	// 기본 생성자
//		System.out.println("Cat() 호출");
//	}

	
}
