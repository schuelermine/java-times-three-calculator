import java.io.*;

public class Calculator {
	public Calculator() throws ConsoleNotFoundException {
		this.console = System.console();
		this.writer = this.console.writer();
		this.reader = this.console.reader();
	}
	public void main() throws IOException {
		int number = this.readNumber();
		String message = "3* that is = " + Integer.toString(3 * number);
		this.outputMessage(message);
	}
	private void outputMessage(String message) {
		this.writer.print(message);
		this.writer.println();
	}
	private int readNumber() throws IOException{
		char firstLnChar = System.lineSeparator().charAt(0);
		String input = "";
		int currentCharacter;
		String lnBuffer = "";
		while (true) {
			currentCharacter = this.reader.read();
			if (currentCharacter == -1) {
				break;
			} else if ((char) currentCharacter == firstLnChar) {
				lnBuffer = tryReadLn();
				if (lnBuffer.length() == 0) {
					break;
				} else {
					input += lnBuffer;
				}
			} else {
				input += (char) currentCharacter;
			}
		}
		int number = Integer.parseInt(input);
		return number;
	}
	private String tryReadLn() throws IOException {
		String ln = System.lineSeparator().substring(1);
		String buffer = "";
		boolean failed = false;
		int currentCharacter;
		while (ln.length() > 0) {
			currentCharacter = this.reader.read();
			if (currentCharacter == -1) {
				failed = true;
				break;
			} else if ((char) currentCharacter == ln.charAt(0)) {
				ln = ln.substring(1);
			} else {
				failed = true;
			}
			buffer += (char) currentCharacter;
		}
		String returnValue;
		if (failed) {
			returnValue = buffer;
		} else {
			returnValue = "";
		}
		return returnValue;
	}
	private Console console;
	private PrintWriter writer;
	private Reader reader;
}
