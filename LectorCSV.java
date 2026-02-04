
package utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* @author saram*/


public class LectorCSV {
   

    public static List<String[]> leerCSV(String ruta) {
        List<String[]> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Divide cada línea por comas
                String[] fila = linea.split(",");
                datos.add(fila);
            }

        } catch (Exception e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return datos;
    }

}
