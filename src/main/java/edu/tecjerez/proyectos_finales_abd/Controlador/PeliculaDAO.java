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
    
    //------------------------------ Consultas con patron -----------------------------------------------------------------------------------------------------------------------------
    public static ResultSet numCatPelicula(String patron){
    
        String sql = "SELECT * FROM pelicula WHERE num_catalogo like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return  rs;
        
    }
    
    public static ResultSet titPelicula(String patron){
    
        String sql = "SELECT * FROM pelicula WHERE titulo like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return  rs;
        
    }
        
    public static ResultSet catPelicula(String patron){
    
        String sql = "SELECT * FROM pelicula WHERE categoria like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return  rs;
        
    }
    
    public static ResultSet cosPelicula(String patron){
         
        String sql = "SELECT * FROM pelicula WHERE CAST(coste_alquiler AS TEXT) LIKE '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return  rs;
        
    }
        
    public static ResultSet cosAdPelicula(String patron){
    
        String sql = "SELECT * FROM pelicula WHERE CAST(costo_adquisicion AS TEXT) LIKE '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return  rs;
        
    }
        
    public static ResultSet actPelicula(String patron){
    
        String sql = "SELECT * FROM pelicula WHERE actores like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return  rs;
        
    }
        
    public static ResultSet dirPelicula(String patron){
    
        String sql = "SELECT * FROM pelicula WHERE director like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return  rs;
        
    }
    
}
