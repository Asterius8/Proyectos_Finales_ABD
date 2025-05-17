package edu.tecjerez.proyectos_finales_abd.vista;

import edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD;
import java.sql.Connection;

public class test {
    
    public static void main(String[] args) {
        
        Connection conn = ConexionBD.getConexion();
        
    }
    
}
