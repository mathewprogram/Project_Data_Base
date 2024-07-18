package json1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import json.Persona;

public class Principal {

    public static void main(String[] args) {
        String rna = "data/personas.json";
        try {
            String json = new String(Files.readAllBytes(Paths.get(rna))); 
            /* ^ esta sentencia de arriba convierte en un objeto 
            esto: data/persona.json y lo almacena en json*/
            Gson gson = new Gson();
            List<Persona> personas_al = gson.fromJson(json, new TypeToken<List<Persona>>(){}.getType());
            for(Persona persona: personas_al){
                System.out.println("Dni             : " + persona.getDni());
                System.out.println("Nombre          : " + persona.getNombre());
                System.out.println("Apellido        : " + persona.getApellido());
                System.out.println("Direccion       : " + persona.getDireccion());
                System.out.println("Telefono        : " + persona.getTelefono());
                System.out.println("Fecha Nacimiento: " + persona.getNacimiento());
                System.out.println();
                
            }
            
            //System.out.println(persona); //te imprime el toString
        } catch (IOException ex) {
            System.out.println("Error.");
        }
        
    }
    
}
