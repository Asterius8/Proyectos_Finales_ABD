package edu.tecjerez.proyectos_finales_abd.ConexionBD;

import edu.tecjerez.proyectos_finales_abd.Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
    
//Atributos ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    private static Connection conexion = null;
    private static PreparedStatement pstm;
    String usuario = "Oscar";
    String contraseña = "oscar";
    String db = "videoclub";
    String puerto = "5435";
    
//Constructor-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
     private ConexionBD() {
         
         String cadena = "jdbc:postgresql://localhost:" + puerto + "/" + db;
         
         try {

            conexion = DriverManager.getConnection(cadena, usuario, contraseña);
            System.out.println("Si conecto");

        } catch (SQLException e) {

            System.err.println("Error de conexion del driver " + e.getMessage());

        }
     
     }//Fin Constructor
     
//Metodos-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     
    //Obtener conexion-------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static Connection getConexion() {

        if (conexion == null) {

            new ConexionBD();

        }

        return conexion;
    }//Fin Obtener Conexion

    //Cerrar conexion -------------------------------------------------------------------------------------------------------------------------------------------------------------
    static void cerrarConexion() {
        try {
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión");
            e.printStackTrace();
        }
    }//Fin Cerrar Conexion
    
    //Agregar un Usuario la base de datos -----------------------------------------------------------------------------------------------------------------------------------------
    public static boolean agregarUsuario(Usuario u) {

        try {

            Connection conexion = getConexion();

            pstm = conexion.prepareStatement("INSERT INTO usuarios VALUES(?,?)");
            pstm.setString(1, u.getNombre_de_usuario());
            pstm.setString(2, u.getContrase_usuario());

            pstm.execute();

            return true;

        } catch (Exception e) {

            System.out.println("Error en instrucción DML");

        }

        return false;

    }//Fin Agregar Usuario
    
    //Ejecutar la consulta a tabla usuarios buscando el usuario -------------------------------------------------------------------------------------------------------------------
    public static ResultSet BuscarUsuarioIgual(String consulta) {
    
        try {

            Connection conexion = getConexion();

            if (conexion != null) {

                PreparedStatement pstm = conexion.prepareStatement(consulta);

                return pstm.executeQuery();

            } else {

                System.out.println("Error: No se pudo obtener la conexión a la base de datos.");

            }
            
        } catch (SQLException e) {

            System.out.println("Error en instrucción SQL a nivel conexion BD");

        }
        return null;
        
    }//Fin Consulta Usuarios
    
    public static ResultSet BuscarUsuario(String consulta){
    
    try {
    
        Connection conexion = getConexion();
        
        if (conexion != null) {
            
            PreparedStatement pstm = conexion.prepareStatement(consulta);
            
            return pstm.executeQuery();
            
        }else {

                System.out.println("Error: No se pudo obtener la conexión a la base de datos.");

            }
    
    }catch (SQLException e) {

            System.out.println("Error en instrucción SQL a nivel conexion BD");

        }
        return null;
        
    }
}
