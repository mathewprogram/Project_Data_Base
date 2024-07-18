package crud_mysql;

import java.sql.Connection;

public class PrincipalUpdate {

    public static void main(String[] args) {
        ConexionMySQL cm = new ConexionMySQL("TABLELIST");
        Connection conexion = cm.getConexion();
        MetodoCrud mc;
        if (conexion != null) {
            System.out.println("Connection succeeded.");
            mc = new MetodoCrud(conexion);
            Alumno alumno = new Alumno(10, "Jorge", "Andujar", "dam", null);
            if (mc.existeAlumno(alumno)) {
                if (mc.actualizarAlumno(alumno)) {
                    System.out.println("Alumno updated.");
                } else {
                    System.out.println("Error updating alumno.");
                }
            } else {
                System.out.println("Alumno doesen´t exist.");
            }
        } else {
            System.out.println("Connection error.");
        }
    }
    
}
