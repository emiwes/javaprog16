import java.io.*;
import java.util.Scanner;

public class addWord {
	public static void main(String[] args) {
		Scanner data = null;
		String word;
		String longWord;
		Integer n;

		data = new Scanner(System.in);

		longWord = new String();

		while (data.hasNext()) {
			if (data.hasNextInt()) {
				n = data.nextInt();
			}
			else {
			word = data.next();
			longWord += word;
			}
		}

		System.out.println(longWord);
	}
}