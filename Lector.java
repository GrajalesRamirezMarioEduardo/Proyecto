import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Lector {
    public static List<Usuario> cargarUsuarios(String archivo) throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
    
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            usuarios.add(new Usuario(
                datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim().charAt(0), datos[4].trim(), Integer.parseInt(datos[5].trim())
            ));
        }
        br.close();
        return usuarios;
    }
}
