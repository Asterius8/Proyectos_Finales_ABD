package edu.tecjerez.proyectos_finales_abd.Controlador;

import edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD;
import edu.tecjerez.proyectos_finales_abd.Modelo.Pelicula;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeliculaDAO {
    
    //------------------------------- Alta -------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean agregarPelicula(Pelicula p){
    
        boolean res = false;
        
        res = ConexionBD.agregarPelicula(p);
        
        return res;
    
    }
    
    
    
    //------------------------------- Consultas --------------------------------------------------------------------------------------------------------------------------------------
    public static boolean numPeliculaIgual(String filtro){
    
        try {
    
            String sql = "SELECT * FROM pelicula WHERE num_catalogo = '" + filtro + "'";
        
            ResultSet rs = ConexionBD.BuscarUsuario(sql);
    
            int contFilas = 0;
            
            while (rs.next()){
            
                contFilas++;
                
            }
            
            return contFilas == 1; 
    }catch (SQLException ex) {
            
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
    }
        
    return false;
    
    }
    
    public static ResultSet buscar() {

        return ConexionBD.buscarPeliculas();

    }
    
    
    
    
}
