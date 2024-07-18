package agenda_basedatos;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

   //Variable de instancia    (atributo)
    String nombreBaseDatos; //(entrada)
    Connection conexion;   //(salida)
    
    //Datos de la conexion
    String protocolo = "jdbc:mysql";
    String nombreServidor = "localhost"; //the same as = 127.0.0.1
    String puerto = "3306";
    
    String usuario = "root";
    String clave = "12345678";
    
    //Constructores
    public ConexionMySQL(String nombreBaseDatos){
        this.nombreBaseDatos = nombreBaseDatos;
        setConexion();
    }
    
    //Metodos Set and Get
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(){
        String url = protocolo + "://" + nombreServidor + ":" + puerto + "/" + nombreBaseDatos;
        
        try{
            conexion = DriverManager.getConnection(url, usuario, clave);
        }   catch(SQLException e){
                System.out.println(e.getMessage());
                conexion = null;
            }
    }
    
}
