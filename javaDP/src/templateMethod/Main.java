package templateMethod;

public class Main {
	public static void main(String[] args) {
		char ch = 'A';
		AbstractDisplay a = new CharDisplay(ch);
		a.display();
		a = new StringDisplay("str");
		a.display();
	}
}
