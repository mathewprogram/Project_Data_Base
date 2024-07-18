package json;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Prncipal {

    public static void main(String[] args) {
        String rna = "data/persona.json";
        try {
            String json = new String(Files.readAllBytes(Paths.get(rna))); 
            /* ^ esta sentencia de arriba convierte en un objeto 
            esto: data/persona.json y lo almacena en json*/
            Gson gson = new Gson();
            Persona persona = gson.fromJson(json, Persona.class);
            System.out.println("Dni:" + persona.getDni());
            System.out.println("Nombre:" + persona.getNombre());
            System.out.println("Apellido:" + persona.getApellido());
            System.out.println("Direccion:" + persona.getDireccion());
            System.out.println("Telefono:" + persona.getTelefono());
            System.out.println("Fecha Nacimiento:" + persona.getNacimiento());
            
            //System.out.println(persona); //te imprime el toString
        } catch (IOException ex) {
            System.out.println("Error.");
        }
        
        
    }
    
}
