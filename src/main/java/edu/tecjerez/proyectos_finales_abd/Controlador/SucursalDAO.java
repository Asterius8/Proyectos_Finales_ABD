package edu.tecjerez.proyectos_finales_abd.Controlador;

import edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD;
import edu.tecjerez.proyectos_finales_abd.Modelo.Sucursal;
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
    
    //------------------------------- Baja ---------------------------------------------------------------------------------------------------------------------------------------------------
    
    
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
    
}
