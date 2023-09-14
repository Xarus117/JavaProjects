import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Llamamos al escáner
		Scanner keyboard = new Scanner(System.in);

		//Lo que introduce el usuario por consola
		int input = 0;
		//Para errores
		boolean checkError = false;

		do {
			System.out.println("Bienvenido a ATM. ¿En qué puedo ayudarle?\n" + "Ingresar dinero: 1\nExtraer dinero: 2\nMi cuenta: 3\nSalir: 4");
			
			//Setear el boleano en falso
			checkError = false;
			
			//Revisar errores de entrada
			while (!checkError) {
				try {
					input = keyboard.nextInt();
					checkError = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor inválido, vuelva a intentarlo");
					keyboard.nextLine();
				}
			}

			//Opción uno
			if (input == 1) {
				
				//Setear el boleano en falso
				checkError = false;
				
				System.out.println("¿Cuánto quiere depositar?");
				
				//Revisar errores de entrada
				while (!checkError) {
					try {
						input = keyboard.nextInt();
						checkError = true;
					} catch (InputMismatchException e) {
						System.out.println("Valor invalido, vuelve a intentarlo");
						keyboard.nextLine();
					}
				}
				
				//Llamar al escritor de archivo
				Writer.write("ES9121000418450200051332", "Cuenta_Xariiiis", "Cezary Lukasz Gebczyk", 100.00, "BBVA");
				
			//Opción dos
			} else if (input == 2) {
				
			//Opción tres
			} else if (input == 3) {

			//Iban, nombre de cuenta, depósito de cuenta y una opción para crear nueva cuenta
			}

		//Opción cuatro
		} while (input != 4);

		System.out.println("Good bye!");
		//Cerramos teclado
		keyboard.close();
	}

}