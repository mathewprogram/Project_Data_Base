package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;

public class PrincipalMySQLConnection {

    public static void main(String[] args) {
        exampleListUsers();
    }
    
    //------------------------------------------------------------------------------
    //Show the Tables from MySQL (in this case its the table Alumno)
    public static void exampleConnection1(){
        MySQLConnection mc = new MySQLConnection("CAMPUSFP1");
        Connection connection = mc.getConnectionTo();
        String sql = "SHOW TABLES";
        
        
        if(connection != null){
            System.out.println("Connection to database succeeded.");
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String tabla = rs.getString(1);
                    System.out.println(tabla);
                }   
            }catch(SQLException e){
            System.out.println("Error SQL " + e.getMessage());
            }
        }else{
            System.out.println("Connection failed.");
        }
    }
    
    //------------------------------------------------------------------------------
    //Select from the Table Alumno the idAlumno 5 or all of them
    public static void exampleConnection2(){
        MySQLConnection mc = new MySQLConnection("CAMPUSFP1");
        Connection connection = mc.getConnectionTo();
        
        //String sql = "Select * FROM Alumno WHERE idALumno = 3";
        String sql = "SELECT * FROM Alumno";
        
        if(connection != null){
            System.out.println("Connection succeeded.\n");
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                System.out.printf("%-2s  %-10s  %-18s  %-3s  %-10s\n", "Id", "  Nombre  ", "     Apellidos    ", "Grupo", "Fecha-Nacimiento");
                System.out.printf("%-2s  %-10s  %-18s  %-3s  %-10s\n", "--", "----------", "------------------", "-----", "----------------");
                while(rs.next()){
                    int idAlumno = rs.getInt("idAlumno");
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    String grupo = rs.getString("grupo");
                    Date fechaNacimiento = rs.getDate("fechaNacimiento");
                    
                    System.out.printf("%-3s  %-9s  %-18s  %-5s  %-10s",idAlumno,
                            nombre,
                            apellidos,
                            grupo,
                            fechaNacimiento);
                    System.out.println();
                    /*we can print the info like a .csv type document for easier importation using these lines:
                    System.out.println(idAlumno + ";"+ 
                                       nombre + ";" + 
                                       apellidos + ";" + 
                                       grupo + ";" + 
                                       fechaNacimiento);
                    This gives back the data separated by semicolon = ";" this. 
                    
                    But i printed them in a friendly user style.
                    */
                }
            }catch(SQLException e){
                System.out.println("Error connection " + e.getMessage());
            }
        }else{
            System.out.println("Connection failed.");
        }
        
    }
    
    //------------------------------------------------------------------------------
    //Select from the Table Alumno the GROUPO and CANTIDAD
    public static void exampleConnection3(){
        MySQLConnection mc = new MySQLConnection("CAMPUSFP1");
        Connection connection = mc.getConnectionTo();
        
        String sql = "SELECT GRUPO, COUNT(*) AS CANTIDAD FROM Alumno GROUP BY grupo";
        
        if(connection != null){
            System.out.println("Connection succeeded.\n");
            
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                System.out.printf("%-5s %8s \n", "GRUPO", "CANTIDAD");
                System.out.printf("%-5s %8s \n", "-----", "--------");
                
                while(rs.next()){
                    String grupo = rs.getString("GRUPO");
                    int cantidad = rs.getInt("CANTIDAD");
                    
                    System.out.printf("%-5s %4s\n",grupo, cantidad);
                }
                
            }catch(SQLException e){
                System.out.println("Error connection " + e.getMessage());
            }
        }else{
            System.out.println("Connection failed.");
        }
        
    }
    
    //------------------------------------------------------------------------------
    //List the MySQL users
    public static void exampleListUsers(){
        MySQLConnection mc = new MySQLConnection("CAMPUSFP1");
        Connection connection = mc.getConnectionTo();
        
        String sql = "SELECT USER, HOST FROM MYSQL.USER";
        
        if(connection != null){
            System.out.println("Connection succeeded.");
            
            try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            System.out.printf("%-20s %-10s\n", "MySQL USERS", "HOST");
            System.out.printf("%-20s %-10s\n", "--------------------", "----------");
            
            while(rs.next()){
                String user = rs.getString("USER");
                String host = rs.getString("HOST");
                
                System.out.printf("%-20s %-10s\n", user, host);
            }
            }catch(SQLException e){
                System.out.println("Error connection " + e.getMessage());
            }
        }else{
            System.out.println("Connection failed.");
        }
    }
    
    //------------------------------------------------------------------------------
    //Create user in MySQL and grant privileges on the Data Base
    public static void exampleCreateUser(){
        MySQLConnection mc = new MySQLConnection("CAMPUSFP1");
        Connection connection = mc.getConnectionTo();
        
        String sqlCU = "CREATE USER 'mihai'@'localhost' IDENTIFIED BY '12345678Mihai!'";
        String sqlP = "GRANT ALL PRIVILEGES ON CAMPUSFP1.* TO 'mihai'@'localhost'";
        String sqlFP = "FLUSH PRIVILEGES";
        
        if(connection != null){
            System.out.println("Connection succeeded.");
            
            try{
            PreparedStatement psCreateUser = connection.prepareStatement(sqlCU);
            psCreateUser.execute();
            System.out.println("User created successfully.");
            
            PreparedStatement psGrantPrivileges = connection.prepareStatement(sqlP);
            psGrantPrivileges.execute();
            System.out.println("Privileges granted successfully");
            
            PreparedStatement psFlushPrivileges = connection.prepareStatement(sqlFP);
            psFlushPrivileges.execute();
            System.out.println("Privileges flushed successfully");
            
            }catch(SQLException e){
                System.out.println("Error connection " + e.getMessage());
            }
        }else{
            System.out.println("Connection failed.");
        }
    }
    
    //------------------------------------------------------------------------------
    //Delete user in MySQL
    public static void exampleDeleteUser(){
        MySQLConnection mc = new MySQLConnection("CAMPUSFP1");
        Connection connection = mc.getConnectionTo();
        
        String sqlDU = "DROP USER 'mihai'@'localhost'";
        String sqlFP = "FLUSH PRIVILEGES";
        
        if(connection != null){
            System.out.println("Connection succeeded.");
            
            try{
            PreparedStatement psDropUser = connection.prepareStatement(sqlDU);
            psDropUser.execute();
            System.out.println("User droped successfully.");
            
            PreparedStatement psFlushPrivileges = connection.prepareStatement(sqlFP);
            psFlushPrivileges.execute();
            System.out.println("Privileges flushed successfully");
            
            }catch(SQLException e){
                System.out.println("Error connection " + e.getMessage());
            }
        }else{
            System.out.println("Connection failed.");
        }
    }
    
    
    
}
