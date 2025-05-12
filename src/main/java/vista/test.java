package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Oscar
 */
public class test {
    
    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:postgresql://localhost/prueba";
         Connection connection = DriverManager.getConnection(url, "postgres", "oscar");
        
         String query = "SELECT nombre, clave FROM usuarios";
        
        try(Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while (rs.next()){
            
                String nombre = rs.getString("nombre");
                String clave = rs.getString("clave");
                System.out.println("Nombre: " + nombre + "\nClave: " +clave);
                  
                
            }
        
        
        }
        
    }
    
}
