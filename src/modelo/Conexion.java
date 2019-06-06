
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conexion {
    
    public static final String URL = "jdbc:mysql://localhost:3306/escuela?auroReconnect=true&useSSL=false";
    public static final String usuario = "alexander";
    public static final String contraseña = "Alexrrlalh25!";
    
    public Connection getConnection(){
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL,usuario,contraseña);
            //JOptionPane.showMessageDialog(this, "Conexion exitosa");
            
        }catch(Exception ex) {
            System.out.println("Error, " + ex);
        }
        
        return conexion;
    }
    
}
