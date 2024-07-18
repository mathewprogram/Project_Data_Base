package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {
    //Variable de instancia (Atributos)
    
    private String dataBase;
    private Connection connection;
    
    public MySQLConnection(String dB) {
        this.dataBase = dB;
        String url = "jdbc:mysql://localhost:3306/" + dataBase;
        String user = "root";
        String password = "12345678";

        try{
            connection = DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            connection = null;
        }
        
    }
    
    public Connection getConnectionTo(){
        return this.connection;
    }
    
}
