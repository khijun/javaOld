package p431;

public class ButtonExample {
	public static void main(String[] args) {
		Button b = new Button();
		b.setOnClickListener(new MsgListener());
		b.touch();
		b.setOnClickListener(new CallListener());
		b.touch();
	}
}
