import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int input;
		
		do {
			
			System.out.println("Welcome to ATM, how we can serve you?\n"
					+ "Deposit: 1\nWithDraw: 2\nCount: 3\nExit: 4");
			
			input = keyboard.nextInt();
			
			if (input == 1) {
				System.out.println(1);
			
			} else if (input == 2) {
				System.out.println(2);
				
			} else if (input == 3) {
				System.out.println(3);
				
			}
			
		} while (input != 4);
		
		System.out.println("Good bye!");
	}

}