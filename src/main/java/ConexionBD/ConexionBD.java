package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionBD {
    
//Atributo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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
     
    //Obtener conexion
    public static Connection getConexion() {

        if (conexion == null) {

            new ConexionBD();

        }

        return conexion;
    }//Fin Obtener Conexion

    //Cerrar conexion
    static void cerrarConexion() {
        try {
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión");
            e.printStackTrace();
        }
    }//Fin Cerrar Conexion
    
    //
    
}
