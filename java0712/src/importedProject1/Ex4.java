package importedProject1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex4 {

	public static void main(String[] args) {
		Member[] list = null;
		
		try(FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (Member[]) ois.readObject();
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for(Member m : list) {
			System.out.println(m.toString());
		}
	}

}
