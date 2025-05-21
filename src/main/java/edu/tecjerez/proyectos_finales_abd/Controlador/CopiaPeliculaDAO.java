package edu.tecjerez.proyectos_finales_abd.Controlador;

import edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD;
import edu.tecjerez.proyectos_finales_abd.Modelo.CopiaPelicula;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopiaPeliculaDAO {
    
    //------------------------------- Alta -------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean agregarCopiaPelicula(CopiaPelicula cp){
    
        boolean res = false;
        
        res = ConexionBD.agregarCopiaPelicula(cp);
        
        return res;
    
    }
    
    //------------------------------- Consultas --------------------------------------------------------------------------------------------------------------------------------------
    public static boolean numCopiaPeliculaIgual(String filtro){
    
        try {
            String sql = "SELECT * FROM copiapelicula WHERE num_pelicula = '" + filtro + "'";
            
            ResultSet rs = ConexionBD.BuscarUsuario(sql);
            
            int contFilas = 0;
            
            while (rs.next()){
                
                contFilas++;
                
            }
            
            return contFilas == 1; 
            
        } catch (SQLException ex) {
            
            Logger.getLogger(CopiaPeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return false;
    }
    
    public static ResultSet buscarNumSucursal() {

        return ConexionBD.buscarNumSucursal();

    }
    
    public static ResultSet buscarNumCatalogo() {

        return ConexionBD.buscarNumCatalogo();

    }
    
    public static ResultSet buscar() {

        return ConexionBD.buscarCopiasPeliculas();

    }
    
}
