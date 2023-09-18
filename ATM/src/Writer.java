import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
	
	public static boolean write(Account userAccount) {
				
		ArrayList<String> accounts = Reader.read("src/Assets/Accounts.txt");

		Boolean checkRep = false;
		
		try {
			
	        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Assets/Accounts.txt"));
	        
	        //For each
	        for (String account : accounts) {
	        	
	        	//Comprobar que los datos se repiten, es decir, el usuario está haciendo un ingreso
	        	if (account.startsWith(userAccount.getIban() + "," + userAccount.getAccount_name() + "," + userAccount.getHeadline()) && account.endsWith(userAccount.getBanking_entity())) {
	        		
	        		//Editar línea del .txt
	        		writer.write(userAccount.getAll());
	        		//Seteamos el boleano a verdadero
	        		checkRep = true;
	        		
	        	//Añadir línea al .txt
	        	} else { writer.write(account+"\n"); }
	        	
	        }
	        
	        //Si se ha editado alguna línea, no se añadirá una nueva, ya que ha complementado otra
	        if (!checkRep) { writer.write(userAccount.getAll()+"\n"); }
	        
	        //Cerramos escritor
	        writer.close();
	        return true;
	        
	    } catch (IOException e) { e.printStackTrace(); return false; }
	
	}
	
	public static boolean register() {
				
		ArrayList<String> users = Reader.read("src/Assets/Users.txt");

		User regist = User.registerUser();	
		
		Boolean checkError = false;
		
		try {
			
	        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Assets/Users.txt"));
	        
	        //For each
	        for (String user : users) {
	        	if (user.startsWith(regist.ID) || user.endsWith(regist.email+","+regist.password)) {
	        		checkError = true;
	        	}
		        	writer.write(user+"\n");	        	
	        }

			if (!checkError) {
				writer.write(regist.ID+","+regist.firstName+","+regist.lastName+","+regist.dateOfBirth+","+regist.address+","+regist.email+","+regist.password+"\n");
			}

			//Cerramos escritor
	        writer.close();
	        return true;
	        
	    } catch (IOException e) { e.printStackTrace(); return false; }
		
	}
}