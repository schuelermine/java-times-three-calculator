import java.io.*;

public abstract class Main {
	public static void main(String[] args) throws IOException {
		try {
			Calculator calculator = new Calculator();
			calculator.main();
		} catch (ConsoleNotFoundException e) {
			
		}
	}
}
