import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	public static ArrayList<String> read(String file) {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            
            //Añadir todas las líneas del .txt en una arraylist
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            
            //Cerrar lector
            reader.close();
        } catch (IOException e) { e.printStackTrace(); }
		
		//Devolver arraylist
		return lines;
	}
}
