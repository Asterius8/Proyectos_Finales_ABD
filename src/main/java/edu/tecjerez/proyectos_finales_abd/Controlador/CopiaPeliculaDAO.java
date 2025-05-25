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
    
    //ELIMINAR
    public static boolean eliminarCopia(String filtro1) {

        boolean res = false;

        res = ConexionBD.eliminarCopia(filtro1);

        return res;

    }
    
    //Cambios
    public static boolean cambiosCop(CopiaPelicula c){
    
        boolean res = false;
        
        res = ConexionBD.cambiosCop(c);
        
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
    
    //------------------------------- Consultas Filtradas --------------------------------------------------------------------------------------------------------------------------------------
    public static ResultSet numCop1(String patron){
    
        String sql = "SELECT * FROM copiapelicula WHERE num_pelicula like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
    }
    
    public static ResultSet comboEstado1(String patron){
    
        String sql = "SELECT * FROM copiapelicula WHERE estado like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
    }
    
    public static ResultSet comboSucursal(String patron){
    
        String sql = "SELECT * FROM copiapelicula WHERE sucursal_num_sucursal like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
    }
    
    public static ResultSet comboPelicula(String patron){
    
        String sql = "SELECT * FROM copiapelicula WHERE pelicula_num_catalogo like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
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
