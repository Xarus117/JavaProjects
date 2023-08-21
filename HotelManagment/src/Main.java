import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int operation = start();
		while (operation == 0) {
			System.out.println("Valor inválido, abortando programa");
			operation = start();
		}
	}
	
	public static int start() {
	    Scanner input = new Scanner(System.in);
	    int choice = 0;
	    boolean checkError = false;
	
	    // MENSAJES SELECCIÓN DE OPERACIÓN
	    
		System.out.println("¡Bienvenido!");
		System.out.println("¿Que operación desea realizar?");
		System.out.println("------------------------------------");
		System.out.println("[1] Reservar habitación");
		System.out.println("[2] Check-in");
		System.out.println("[3] Check-out");
		System.out.println("------------------------------------");

		
		// SELECCIÓN DE OPERACIÓN CON TRY CATCH
		
	    System.out.println("Escoge:");
	    while (!checkError) {
	    try {choice = input.nextInt();
		checkError = true;
	    } 
	    catch (InputMismatchException e) 
	    {System.out.println("Valor invalido, vuelve a intentarlo:"); 
	    input.nextLine();
	    }
	    }
	    
	    if (choice == 1 || choice == 2 || choice == 3) {return choice;}
	    else {
	    	return 0;
	    }
	}
	

}
