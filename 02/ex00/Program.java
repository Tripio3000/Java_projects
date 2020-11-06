package ex00;

import java.io.File;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws Exception {

		FileTypeTest t = new FileTypeTest();
		Scanner scan = new Scanner(System.in);
		String toCheck = scan.nextLine();
		boolean mode = true;

		while (!toCheck.equals("42")) {
			System.out.println(t.getFileType(new File(toCheck), mode));
			toCheck = scan.nextLine();
			mode = false;
		}
	}
}
