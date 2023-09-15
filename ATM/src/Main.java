import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Llamamos al escáner
		Scanner keyboard = new Scanner(System.in);
		
		//Lo que introduce el usuario por consola
		int intInput = 0;
		String[] loginInput = {"", ""};
		//Para errores
		boolean checkError = false;
		
		do {
			
			System.out.println("Bienvenido/a a ATM. \n" + "Iniciar sesión: 1\nRegistrarse: 2\n");
			
			//Setear el boleano en falso
			checkError = false;
			
			//Revisar errores de entrada
			while (!checkError) {
				try {
					intInput = keyboard.nextInt();
					checkError = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor inválido, vuelva a intentarlo\n");
					keyboard.nextLine();
				}
			}
						
			checkError = false;
			
			do {
			
				if (intInput == 1) {
					System.out.println("Número de identificación:");
					loginInput[0] = keyboard.next();
					
					System.out.println("Contraseña:");
					loginInput[1] = keyboard.next();
				
					if (Reader.login(loginInput)) { checkError = true; }
					else { System.out.println("Datos incorrectos\n"); }
					
				} else if (intInput == 2) {
					
					Writer.register();
					
				}
			
			} while (!checkError);
			
		} while (!checkError);
		
		do {
			System.out.println("\nIngresar dinero: 1\nExtraer dinero: 2\nMi cuenta: 3\nSalir: 4");
			
			//Setear el boleano en falso
			checkError = false;
			
			//Revisar errores de entrada
			while (!checkError) {
				try {
					intInput = keyboard.nextInt();
					checkError = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor inválido, vuelva a intentarlo\n");
					keyboard.nextLine();
				}
			}

			//Opción uno
			if (intInput == 1) {
				
				//Setear el boleano en falso
				checkError = false;
				
				System.out.println("¿Cuánto quiere depositar?");
				
				//Revisar errores de entrada
				while (!checkError) {
					try {
						intInput = keyboard.nextInt();
						checkError = true;
					} catch (InputMismatchException e) {
						System.out.println("Valor invalido, vuelve a intentarlo\n");
						keyboard.nextLine();
					}
				}
				
				//Llamar al escritor de archivo
				Writer.write("ES9121000418450200051332", "Cuenta_Xariiiis", "Cezary Lukasz Gebczyk", 100.00, "BBVA");
				
			//Opción dos
			} else if (intInput == 2) {
				
			//Opción tres
			} else if (intInput == 3) {

			//Iban, nombre de cuenta, depósito de cuenta y una opción para crear nueva cuenta
			}

		//Opción cuatro
		} while (intInput != 4);

		System.out.println("¡Que tenga un buen día!");
		//Cerramos teclado
		keyboard.close();
	}

}