package crud_mysql;

import java.sql.Connection;
import java.util.List;

public class PrincipalRead {

    public static void main(String[] args) {
       ConexionMySQL cm = new ConexionMySQL("TABLELIST");
       Connection conexion = cm.getConexion(); 
       MetodoCrud mc;
       if(conexion != null) {
          System.out.println("Connection succeeded.");
          mc = new MetodoCrud(conexion);
          List<Alumno> alumnos_al = mc.obtenerTodosLosRegistros();
          if(alumnos_al != null) {
             for(Alumno a: alumnos_al) {
                 System.out.println(a);
             }
          }else {
             System.out.println("Error obtaining all the registers.");
          }
       }else {
          System.out.println("Connection error."); 
       }
             
    }
    
}