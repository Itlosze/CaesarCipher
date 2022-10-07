import java.util.InputMismatchException;
import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {
		int jump = 1;
		String code = "";
		System.out.println("--- Caesar Cipher ---");
		try (Scanner scanner = new Scanner(System.in)) {
			try {
				System.out.println("How many jumps? ");
				jump = scanner.nextInt();
				System.out.println("Enter the code: ");
				code = scanner.next();
			} catch (InputMismatchException e) {
				System.out.println("Type error!");
			}
		}
		System.out.println(decode(code, jump));
	}

	public static String decode(String code, int jump) {
		String decoded = "";
		int lastCharValue = 'z';
		int alphabetLength = 'z' - 'a' + 1;
		for (char character : code.toCharArray()) {
			int charNoRotation = character + jump;
			int charValue = charNoRotation < lastCharValue ? charNoRotation : charNoRotation - alphabetLength;
			decoded += (char) charValue;
		}
		return decoded;
	}
}
