import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	public static ArrayList<String> read(String file) {
		
		ArrayList<String> lineas = new ArrayList<String>();
		
		try {
            BufferedReader lector = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineas.add(linea);
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return lineas;
	}
	//Guardar en arraylist para luego guardarlo
}
