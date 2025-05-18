package edu.tecjerez.proyectos_finales_abd.Controlador;

import edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD;
import edu.tecjerez.proyectos_finales_abd.Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    
     //------------------------------------------- Altas ------------------------------------------------
    public static boolean agregarUsuario(Usuario u){
        
        boolean res = false;

        res = ConexionBD.agregarUsuario(u);

        return res;
    
    }
    
    //-------------------------------------------- Consultas -------------------------------------------
    public static boolean buscarUsuarioIgual(String filtro1) {
        
        try {
            
            String sql = "SELECT * FROM usuarios WHERE nombre_usuario ='" + filtro1 + "'";
            
            ResultSet rs = ConexionBD.BuscarUsuarioIgual(sql);
            
            int contFilas = 0;
            
            while (rs.next()) {
                
                contFilas++;
                
            }
            
            return contFilas == 1;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return false;
        
    }
    
}
