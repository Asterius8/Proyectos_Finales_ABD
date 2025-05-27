package edu.tecjerez.proyectos_finales_abd.Controlador;

import edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD;
import static edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD.getConexion;
import edu.tecjerez.proyectos_finales_abd.Modelo.CopiaPelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public static boolean eliminarCopia(String num_pelicula, String sucursal_num_sucursal, String pelicula_num_catalogo) {

        boolean res = false;

        res = ConexionBD.eliminarCopia(num_pelicula, sucursal_num_sucursal, pelicula_num_catalogo);

        return res;

    }
    
    //Cambios
    public static boolean cambiosCop(CopiaPelicula c) {
    
        boolean res = false;
        
        res = ConexionBD.cambiosCop(c);
        
        return res;
        
        
    }
    
    //------------------------------- Consultas --------------------------------------------------------------------------------------------------------------------------------------
    public static boolean numCopiaPeliculaIgual(String numCopia, String sucursal, String catalogo) {
        
    try {
        
        String sql = "SELECT * FROM copiapelicula WHERE num_pelicula = ? AND Sucursal_num_sucursal = ? AND Pelicula_num_catalogo = ?";
        PreparedStatement pstm = ConexionBD.getConexion().prepareStatement(sql);
        pstm.setString(1, numCopia);
        pstm.setString(2, sucursal);
        pstm.setString(3, catalogo);
        ResultSet rs = pstm.executeQuery();
        
        int countFilas = 0;
        
        while (rs.next()){
            
                countFilas++;
                
            }
            
            return countFilas == 1; 
        
    } catch (SQLException ex) {
        
        Logger.getLogger(CopiaPeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println(ex);
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
