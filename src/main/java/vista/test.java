package vista;

import ConexionBD.ConexionBD;
import java.sql.Connection;

public class test {
    
    public static void main(String[] args) {
        
        Connection conn = ConexionBD.getConexion();
        
    }
    
}
