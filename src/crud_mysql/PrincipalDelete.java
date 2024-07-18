package crud_mysql;

import java.sql.Connection;

public class PrincipalDelete {

    public static void main(String[] args) {
        ConexionMySQL cm = new ConexionMySQL("TABLELIST");
        Connection conexion = cm.getConexion();
        MetodoCrud mc;
        if (conexion != null) {
            System.out.println("Connection succeeded.");
            mc = new MetodoCrud(conexion);
            Alumno alumno = new Alumno(11);
            if(mc.existeAlumno(alumno)) {
               if(mc.eliminarAlumno(alumno)) {
                  System.out.println("Alumno eliminated successfuly.");
               }else {
                  System.out.println("Error eliminating the Alumno");
               }
            }else {
                System.out.println("Alumno doesen´t exist.");
            }
        }else {
            System.out.println("Connection error.");
        }
    }
}