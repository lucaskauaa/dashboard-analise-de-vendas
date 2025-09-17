package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {

	public static String readString (Scanner sc, String message) {
		
		System.out.print(message);
		
		return sc.nextLine();
	}
	
	public static int readInt (Scanner sc, String message) {
		
		int number = 0;
		
		while (true) {
			try {
				
				System.out.print(message);
				number = sc.nextInt();
				sc.nextLine();
				
				break;
				
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("\nInsira um valor numérico válido!");
			}
		} 
		
		return number;
	}
	
}
