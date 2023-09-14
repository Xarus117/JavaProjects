import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		int input = 0;
		boolean checkError = false;

		do {
			User.registerUser();
			System.out.println("Welcome to ATM. How can we serve you?\n" + "Deposit: 1\nWithDraw: 2\nCount: 3\nExit: 4");
			while (!checkError) {
				try {
					input = keyboard.nextInt();
					checkError = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor invalido, vuelve a intentarlo:");
					keyboard.nextLine();
				}
			}
			
			checkError = false;

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