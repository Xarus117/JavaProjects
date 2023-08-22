import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Room[] rooms = {new Room(1, 15, false, "SINGLE", "BASIC", true), new Room(2, 22, true, "SINGLE", "BASIC", true), new Room(3, 25, true, "DOUBLE", "VIP", true), new Room(4, 30, true, "DOUBLE", "DELUXE", true)};
		int operation = start();
		Room roomSelect;
		while (operation == 0) {
			System.out.println("Valor inválido, abortando programa");
			operation = start();
		}
		
		if (operation == 1) {
			roomSelect = reservar(rooms);
			if (roomSelect != null) {
			System.out.println("Has seleccionado la habitación: " + roomSelect.idRoom);
			}
			else {
				System.out.println("No has seleccionado ninguna habitación");
			}
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
	
	  public static Room reservar(Room[] rooms) { 
		Scanner input = new Scanner(System.in);
		int choice = 0;
		boolean checkError = false;
	 	boolean exists = false;
	 	Room roomSelect = null;
	    System.out.println("Habitaciones disponibles:");
	    System.out.println("");
	    for (int i = 0; i < rooms.length; i++) {
	    	
	    	System.out.println("OPCIÓN " + "[" + (i + 1) + "]" );
	    	System.out.println("--------------------------");
	    	System.out.println("Número: " + rooms[i].idRoom);
	      	System.out.println("Tamaño: " + rooms[i].sizeSquaredMeters + " metros cuadrados");
	      	System.out.println("Baño privado: " + rooms[i].privateBathroom);
	      	System.out.println("Tipo de cama: " + rooms[i].bedType);
	      	System.out.println("Tipo de servicio: " + rooms[i].serviceType);
	      	System.out.println("Diponible: " + rooms[i].disponible);
	     	System.out.println("");
	    }
	    
	    System.out.println("Seleccione la habitación (Número) que desea:");
	   
	    while (!checkError) {
		    try {choice = input.nextInt();
			checkError = true;
		    } 
		    catch (InputMismatchException e) 
		    {System.out.println("Valor invalido, vuelve a intentarlo:"); 
		    input.nextLine();
		    }
		    }
	    
	    for (int i = 0; i < rooms.length; i++) {
	    	if (choice == rooms[i].idRoom) {
	    		roomSelect = rooms[i];
	    	}
	    }
	    
	   return roomSelect;
	   
	  }
	  
	  public static void confirm() {
	
	  }
}
