package mysql;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

public class Principal {

    public static void main(String[] args) {
        example2();
    }
    
    
    //------------------------------------------------------------------------------
    //Probar la conexion a MySQL
    //protocolo(jdbc:mysql), 
    //nombreservidor(localhost) localhost = 127.0.0.1 es lo mismo
    //puerto(3306)
    public static void example1(){
        String url = "jdbc:mysql://localhost:3306/"; 
        String usuario = "root";
        String clave = "12345678";
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(url,usuario,clave);
            if(connection != null){
                System.out.println("Connection succeeded.");
            }else{
                System.out.println("Connection failed.");
            }
        }catch(SQLException e){
            System.out.println("Error connection " + e.getMessage());
        }
    }
    
    
    //------------------------------------------------------------------------------
    public static void example2(){
        String url = "jdbc:mysql://localhost:3306/CAMPUSFP1"; 
        String usuario = "root";
        String clave = "12345678";
        
        Connection connection = null;
        
        //String sql = "SELECT * FROM Alumno";
        String sql = "Select * FROM Alumno WHERE idAlumno = 6";
        
        try {
            connection = DriverManager.getConnection(url,usuario,clave);
            if(connection != null){
                System.out.println("Connection succeeded.");
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int idAlumno = rs.getInt("idAlumno");
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    String grupo = rs.getString("grupo");
                    Date fechaNacimiento = rs.getDate("fechaNacimiento");
                    
                    System.out.println(idAlumno + ";"+ 
                                       nombre + ";" + 
                                       apellidos + ";" + 
                                       grupo + ";" + 
                                       fechaNacimiento);
                }
            }else{
                System.out.println("Connection failed.");
            }
        }catch(SQLException e){
            System.out.println("Error connection " + e.getMessage());
        }
    }
    
    //------------------------------------------------------------------------------
    //Ejecutar el querry de agrupamiento
    public static void example3(){
        String url = "jdbc:mysql://localhost:3306/CAMPUSFP1"; 
        String usuario = "root";
        String clave = "12345678";
        
        Connection connection = null;
        
        String sql = "SELECT GRUPO, COUNT(*) AS CANTIDAD FROM Alumno GROUP BY grupo";
        
        try {
            connection = DriverManager.getConnection(url,usuario,clave);
            if(connection != null){
                System.out.println("Connection succeeded.\n");
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                System.out.printf("%5s %8s \n", "GRUPO", "CANTIDAD");
                System.out.printf("%5s %8s \n", "-----", "--------");
                
                while(rs.next()){
                    String grupo = rs.getString("GRUPO");
                    int cantidad = rs.getInt("CANTIDAD");
                    
                    System.out.printf("%5s %8s \n", grupo, cantidad);
                }
            }else{
                System.out.println("Connection failed.");
            }
        }catch(SQLException e){
            System.out.println("Error connection " + e.getMessage());
        }
    }
    
    //------------------------------------------------------------------------------
    //Listar usuarios de MySQL
    public static void example4(){
        String url = "jdbc:mysql://localhost:3306/CAMPUSFP1"; 
        String usuario = "root";
        String clave = "12345678";
        
        Connection connection = null;
        
        String sql = "SELECT USER, HOST FROM MYSQL.USER";
        
        try {
            connection = DriverManager.getConnection(url,usuario,clave);
            if(connection != null){
                System.out.println("Connection succeeded. \n");
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                System.out.printf("%-20s %-10s \n", "USER", "HOST");
                System.out.printf("%-20s %-10s \n", "--------------------", "----------");
                
                while(rs.next()){
                    String user = rs.getString("USER");
                    String host = rs.getString("HOST");
                    
                    System.out.printf("%-20s %-10s \n", user, host);
                }
            }else{
                System.out.println("Connection failed.");
            }
        }catch(SQLException e){
            System.out.println("Error connection " + e.getMessage());
        }
    }
    
    
    //------------------------------------------------------------------------------
    //Crear usuario en MySQL
    public static void example5(){
        String url = "jdbc:mysql://localhost:3306/CAMPUSFP1"; 
        String usuario = "root";
        String clave = "12345678";
        
        Connection connection = null;
        
        String sql = "CREATE USER 'Ioni'@'localhost' IDENTIFIED BY '12345678Mihai!'";
        
        try {
            connection = DriverManager.getConnection(url,usuario,clave);
            if(connection != null){
                System.out.println("Connection succeeded. \n");
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.execute();
                System.out.println("User created successfully.");
                
            }else{
                System.out.println("Connection failed.");
            }
        }catch(SQLException e){
            System.out.println("Error connection " + e.getMessage());
        }
    }
    
}
