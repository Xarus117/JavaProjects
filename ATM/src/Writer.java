import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	
	public static void write() {
		
		//Llamar al lector y que pase arraylist, modificar arraylist y escribirla
		
		try {
	        BufferedWriter escritor = new BufferedWriter(new FileWriter("src/Assets/Accounts.txt"));
	        escritor.write("hola");
	        escritor.close();
	        System.out.println("El archivo se ha escrito correctamente.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	}
	
}