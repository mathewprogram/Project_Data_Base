package crud_mysql;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

public class PrincipalCreate {

    public static void main(String[] args) {
        ConexionMySQL cm = new ConexionMySQL("TABLELIST");
        Connection conexion = cm.getConexion();
        MetodoCrud mc;
        
        if(conexion != null){
            System.out.println("Connection Succeeded.\n");
            
            String fechaString = "2024-06-03";
            Date fechaDate = Date.valueOf(LocalDate.parse(fechaString));
            
            Alumno alumno = new Alumno(0, "Mihai", "Matei", "dam", fechaDate);
            
            mc = new MetodoCrud(conexion);
            
            if(mc.insertarAlumno(alumno)){
                System.out.println("Alumno inserted successfuly.\n");
            }else{
                System.out.println("Alumno insert error.");
            }
        }else{
            System.out.println("Connection error.");
        }
    }
    
}
