import java.io.*;

public class Helloworld{
	public static void main (String[] args) {
		System.out.println("Helloworld");
		String str = "test";
		File tempFile = new File("/Users/khumphries/Gradle_Example/mytest2/consumer",str+".txt");
		try {
			tempFile.createNewFile();
		}
		catch(IOException ex){
			System.out.println(ex.toString());
		}
	}
}