import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
	
	public static void write(String data) {
		
		//Llamar al lector y que pase arraylist, modificar arraylist y escribirla
		
		ArrayList<String> cuentas = new ArrayList<String>();

		cuentas = Reader.read("src/Assets/Accounts.txt");
		
		try {
			
	        BufferedWriter escritor = new BufferedWriter(new FileWriter("src/Assets/Accounts.txt"));
	        //For each
	        for (String cuenta : cuentas) {
	        	escritor.write(cuenta+"\n");
	        }
	        escritor.write(data);
	        escritor.close();
	        System.out.println("El archivo se ha escrito correctamente.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	}
	
}