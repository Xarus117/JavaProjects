import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Room[] rooms = {new Room(1, 15, false, "SINGLE", "BASIC", true), new Room(2, 22, true, "SINGLE", "BASIC", true), new Room(3, 25, true, "DOUBLE", "VIP", true), new Room(4, 30, true, "DOUBLE", "DELUXE", true)};
	User User = null;	
	int operation = start();
		Room roomSelect;
		while (operation == 0) {
			System.out.println("Valor inválido, abortando programa");
			operation = start();
		}
		
		if (operation == 1) {
			roomSelect = reservar(rooms, User);
			if (roomSelect != null) {
			System.out.println("Has seleccionado la habitación: " + roomSelect.idRoom);
			if(confirm(roomSelect)) {
				System.out.println("Felicidades, has seleccionado la habitación " + roomSelect.idRoom);
			}
			}
			else {
				System.out.println("Error");
			}
		}
		else if (operation == 4) {
			User = registerUser();
			System.out.println("¡Te has registrado como usuario con los siguientes datos!");
			System.out.println("------------------------------------");
			System.out.print("ID (IMPORTANTE: Es necesario guardar su ID para realizar reservas): ");
			System.out.println(User.idUser);
			System.out.print("Nombre: ");
			System.out.println(User.firstName);
			System.out.print("Apellido: ");
			System.out.println(User.lastName);
			System.out.print("Edad: ");
			System.out.println(User.age);
			System.out.print("Email: ");
			System.out.println(User.email);
			System.out.print("Teléfono: ");
			System.out.println(User.phoneNumber);
			System.out.println("------------------------------------");
			start();
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
		System.out.println("[4] Registrar usuario");
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
	    
	    if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {return choice;}
	    else {
	    	return 0;
	    }
	    
	 
	  
	}
	
	  public static Room reservar(Room[] rooms, User User) { 
		Scanner input = new Scanner(System.in);
		int userId = 0;
		int choice = 0;
		boolean checkError = false;
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
	    
	    System.out.println("Introduzca su código de usuario:");
	    while (!checkError) {
		    try {userId = input.nextInt();
			checkError = true;
		    } 
		    catch (InputMismatchException e) 
		    {System.out.println("Valor invalido, vuelve a intentarlo:"); 
		    input.nextLine();
		    }
		 }
	    
	    if (User != null && userId == User.idUser) {
	    
	    System.out.println("Seleccione la habitación (Número) que desea:");
	    checkError = false;
	    
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
	    else {
	    	return null;
	    }
	    
	  }
	  
	  public static boolean confirm(Room roomSelect) {
	  Scanner input = new Scanner(System.in);
	  int choice = 0;
	  boolean checkError = false;
	  System.out.println("Estás reservando la habitación " + roomSelect.idRoom);
	  System.out.println("[1] Confirmar reserva");
	  System.out.println("[0] Cancelar operación");
	  
	    while (!checkError) {
		    try {choice = input.nextInt();
			checkError = true;
		    } 
		    catch (InputMismatchException e) 
		    {System.out.println("Valor invalido, vuelve a intentarlo:"); 
		    input.nextLine();
		    }
		    }
	    
	    if (choice == 1) { 	
	 	   return true;
	    }
	    else {
	    	return false;
	    }
	  }
	  
	  public static User registerUser() {
		  Scanner input = new Scanner(System.in);
		  boolean checkError = false;
		  String firstName = "";
		  String lastName = "";
		  int age = 0;
		  String email = "";
		  int phoneNumber = 0;
		  // VALIDACIONES
		  boolean validationFirstName = false;
		  boolean validationLastName = false;
		  boolean validationAge = false;
		  boolean validationEmail = false;
		  boolean validationPhoneNumber = false;
		  System.out.println("");
		  System.out.println("REGISTRO");
		  System.out.println("--------------------------");
		  System.out.println("[1] NOMBRE:");
		  while (!checkError) {
		    try {
		      firstName = input.nextLine();
		      if (firstName.length() < 1) {
		        System.out.println(
		            "La longitud del nombre es incorrecta, vuelva a intentarlo:");
		      } else {
		        checkError = true;
		        validationFirstName = true;
		      }

		    } catch (InputMismatchException e) {
		      System.out.println("Valor invalido, vuelve a intentarlo:");
		      input.nextLine();
		    }
		  }
		  checkError = false;
		  if (validationFirstName) {
		    System.out.println("[2] APELLIDO:");
		    while (!checkError) {
		      try {
		        lastName = input.nextLine();
		        if (lastName.length() < 1) {
		          System.out.println(
		              "La longitud del apellido es incorrecta, vuelva a intentarlo:");
		        } else {
		          checkError = true;
		          validationLastName = true;
		        }

		      } catch (InputMismatchException e) {
		        System.out.println("Valor invalido, vuelve a intentarlo:");
		        input.nextLine();
		      }
		    }
		  }
		  checkError = false;
		  if (validationLastName) {
		    System.out.println("[3] EDAD:");
		    while (!checkError) {
		      try {
		        age = input.nextInt();
		        if (age < 18) {
		          System.out.println(
		              "Tienes que ser mayor de edad para poder registrarte, cancele la operación o vuelva a intentarlo:");
		        } else {
		          checkError = true;
		          validationAge = true;
		        }

		      } catch (InputMismatchException e) {
		        System.out.println("Valor invalido, vuelve a intentarlo:");
		        input.nextLine();
		      }
		    }
		  }
		  checkError = false;
		  input.nextLine();
		  if (validationAge) {
		    System.out.println("[4] EMAIL:");
		    while (!checkError) {
		      try {
		        email = input.nextLine();

		        if (email.indexOf('@') == -1) {
		          System.out.println(
		              "Tienes que introducir un correo electrónico válido, vuelva a intentarlo::");
		        } else {
		          checkError = true;
		          validationEmail = true;
		        }

		      } catch (InputMismatchException e) {
		        System.out.println("Valor invalido, vuelve a intentarlo:");
		        input.nextLine();
		      }
		    }
		  }
		  checkError = false;
		  if (validationEmail) {
		    System.out.println("[5] NÚMERO DE TELÉFONO:");
		    while (!checkError) {
		      try {
		        phoneNumber = input.nextInt();
		        checkError = true;
		      } catch (InputMismatchException e) {
		        System.out.println("Valor invalido, vuelve a intentarlo:");
		        input.nextLine();
		      }
		    }
		  }

		  User User = new User(firstName, lastName, age, email, phoneNumber);
		  return User;
		}
}
