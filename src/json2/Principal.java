package json2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import json.Persona;

public class Principal {

    public static void main(String[] args) {
        String rna = "data/alumnos.json";
        try {
            String json = new String(Files.readAllBytes(Paths.get(rna))); 
            /* ^ esta sentencia de arriba convierte en un objeto 
            esto: data/persona.json y lo almacena en json*/
            Gson gson = new Gson();
            List<Alumno> alumnos_al = gson.fromJson(json, new TypeToken<List<Alumno>>(){}.getType());
            
            for(Alumno alumno: alumnos_al){
                System.out.println("Id               : " + alumno.getIdAlumno());
                System.out.println("Nombre           : " + alumno.getNombre());
                System.out.println("Apellido         : " + alumno.getApellido());
                System.out.println("Estatura         : " + alumno.getEstatura());
                boolean casado = alumno.isCasado();
                String estadoCivil = casado ? "Casado" : "Soltero";
                System.out.println("Estado Civil     : " + estadoCivil);
                System.out.println("Direccion: Calle : " + alumno.getDireccion().getCalle() 
                                                         + ", " + alumno.getDireccion().getNumero() 
                                                         + ", " + alumno.getDireccion().getCiudad());
                List<String> hobbies_al = alumno.getHobbies();
                System.out.println("Hobbies          : " + String.join(", ", hobbies_al + "."));
                /*for(String hobbie: hobbies_al){
                    System.out.println(hobbie);
                } Este for los imprime en lista*/
                System.out.println();
            } 
            
            //System.out.println(persona); //te imprime el toString
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }
    
}
