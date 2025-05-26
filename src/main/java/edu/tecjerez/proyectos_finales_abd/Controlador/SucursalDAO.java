package edu.tecjerez.proyectos_finales_abd.Controlador;

import edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD;
import static edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD.getConexion;
import edu.tecjerez.proyectos_finales_abd.Modelo.Sucursal;
import edu.tecjerez.proyectos_finales_abd.Modelo.SucursalMemento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SucursalDAO {
    
    //------------------------------- Alta ---------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean agregarSucursal(Sucursal s){
        
        boolean res = false;

        res = ConexionBD.agregarSucursal(s);

        return res;
    
    }
    
    public static boolean restaurarSucursal(SucursalMemento sm){
        
        boolean res = false;
        
        res = ConexionBD.restaurarSucursal(sm);
        
        return res;
        
    }
    
    //------------------------------- Baja ---------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean eliminarSucursal(String filtro1) {

        boolean res = false;

        res = ConexionBD.eliminarSucursal(filtro1);

        return res;

    }
    
    //------------------------------- Cambio -------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean cambiosSucursal(Sucursal s){
    
        boolean res = false;
        
        res = ConexionBD.cambioSucursal(s);
        
        return res;
        
    }
    
    //------------------------------- Consultas ----------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean nunSucursalIgual(String filtro){
    
        try {
        
            String sql = "SELECT * FROM sucursal WHERE num_sucursal = '" + filtro + "'";
        
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

        return ConexionBD.buscarSucursales();

    }
    
    //------------------------------ Consultas con patron -----------------------------------------------------------------------------------------------------------------------------
    public static ResultSet numSucursal(String patron){
    
        String sql = "SELECT * FROM sucursal WHERE num_sucursal like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
    }
    
    public static ResultSet calSucursal(String patron){
    
        String sql = "SELECT * FROM sucursal WHERE calle like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
    }
    
    public static ResultSet ciuSucursal(String patron){
    
        String sql = "SELECT * FROM sucursal WHERE ciudad like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
    }
    
    public static ResultSet estSucursal(String patron){
    
        String sql = "SELECT * FROM sucursal WHERE estado like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
    }
    
    public static ResultSet codSucursal(String patron){
    
        String sql = "SELECT * FROM sucursal WHERE codigo_postal like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
    }
    
    public static ResultSet telSucursal(String patron){
    
        String sql = "SELECT * FROM sucursal WHERE telefono like '%" + patron + "%'";
        ResultSet rs = ConexionBD.BuscarUsuario(sql);
        return rs;
        
    }
    
    public static ResultSet contarCopiasPorSucursal() {
    ResultSet rs = null;

    try {
        String sql = """
            SELECT s.ciudad, COUNT(c.num_pelicula) AS total_copias
            FROM CopiaPelicula c
            JOIN Sucursal s ON c.sucursal_num_sucursal = s.num_sucursal
            GROUP BY s.ciudad
            ORDER BY total_copias DESC
        """;

        PreparedStatement ps = ConexionBD.getConexion().prepareStatement(sql);
        rs = ps.executeQuery();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return rs;
}

}
