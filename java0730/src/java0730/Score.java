package java0730;

public class Score {
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	public Score(int num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	int getNum() {
		return num;
	}
	void setNum(int num) {
		this.num = num;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getKor() {
		return kor;
	}
	void setKor(int kor) {
		this.kor = kor;
	}
	int getEng() {
		return eng;
	}
	void setEng(int eng) {
		this.eng = eng;
	}
	int getMath() {
		return math;
	}
	void setMath(int math) {
		this.math = math;
	}
	
	int getTotal() {
		return kor + eng + math;
	}
	
	double getAvg() {
		return getTotal()/3;
	}
}
