package edu.tecjerez.proyectos_finales_abd.Controlador;

import edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD;
import edu.tecjerez.proyectos_finales_abd.Modelo.Sucursal;
import edu.tecjerez.proyectos_finales_abd.Modelo.SucursalMemento;
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
    
        String query = "INSERT INTO sucursal (num_sucursal, calle, ciudad, estado, codigo_postal, telefono) "
                 + "VALUES (?, ?, ?, ?, ?, ?)";
    
        try (PreparedStatement stmt = ConexionBD.getConexion().prepareStatement(query)) {
        
            stmt.setString(1, sm.getNum_Suc());
            stmt.setString(2, sm.getCalle());
            stmt.setString(3, sm.getCiudad());
            stmt.setString(4, sm.getEstado());
            stmt.setString(5, sm.getCod_pos());
            stmt.setString(6, sm.getTel());

            return stmt.executeUpdate() > 0;
        
        } catch (SQLException e) {
        
            e.printStackTrace();
        
            return false;
        
        }
        
    }
    
    //------------------------------- Baja ---------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean eliminarSucursal(String filtro1) {

        boolean res = false;

        res = ConexionBD.eliminarSucursal(filtro1);

        return res;

    }
    
    //------------------------------- Cambio -------------------------------------------------------------------------------------------------------------------------------------------------
    
    
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
}
