package edu.tecjerez.proyectos_finales_abd.ConexionBD;

import edu.tecjerez.proyectos_finales_abd.Modelo.CopiaPelicula;
import edu.tecjerez.proyectos_finales_abd.Modelo.Pelicula;
import edu.tecjerez.proyectos_finales_abd.Modelo.Sucursal;
import edu.tecjerez.proyectos_finales_abd.Modelo.SucursalMemento;
import edu.tecjerez.proyectos_finales_abd.Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
        System.out.println("✅ Conexión establecida correctamente");
    } catch (SQLException e) {
        
        String mensajeError = e.getMessage().toLowerCase();
        
        // Mostrar mensaje amigable al usuario si se alcanza el límite de conexiones
        if (mensajeError.contains("too many connections") ||
            mensajeError.contains("connection limit") ||
            mensajeError.contains("fatal: lo siento, ya tenemos demasiados clientes")) {

            JOptionPane.showMessageDialog(null,
                    "No se pudo establecer conexión.\n" +
                    "Ya se alcanzó el número máximo de usuarios conectados.\n\n" +
                    "Por favor, cierra otra instancia del programa o intenta más tarde.",
                    "Conexión no disponible",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
            
        } else {
            
            JOptionPane.showMessageDialog(null,
                    "❌ Error al conectar con la base de datos:\n" + e.getMessage(),
                    "Error de conexión",
                    JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
            
        }

        conexion = null; // importante: dejarla en null
    }
}
     
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
    
//Agregar -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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
    
    //Agregar una Sucursar a la base de datos ----------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean agregarSucursal(Sucursal s){
    
        try {

            Connection conexion = getConexion();

            pstm = conexion.prepareStatement("INSERT INTO sucursal VALUES(?,?,?,?,?,?)");
            pstm.setString(1, s.getNum_Suc());
            pstm.setString(2, s.getCalle());
            pstm.setString(3, s.getCiudad() );
            pstm.setString(4, s.getEstado());
            pstm.setString(5, s.getCod_pos());
            pstm.setString(6, s.getTel());
            
            pstm.execute();

            return true;

        } catch (Exception e) {

            System.out.println("Error en instrucción DML");

        }

        return false;
    
    }//Fin Agregar Sucursal
    
    public static boolean restaurarSucursal(SucursalMemento sm){
    
        try {
        
            Connection conexion = getConexion();
            conexion.setAutoCommit(true); 
            
            pstm = conexion.prepareStatement("INSERT INTO sucursal VALUES(?,?,?,?,?,?)");
            pstm.setString(1, sm.getNum_Suc());
            pstm.setString(2, sm.getCalle());
            pstm.setString(3, sm.getCiudad() );
            pstm.setString(4, sm.getEstado());
            pstm.setString(5, sm.getCod_pos());
            pstm.setString(6, sm.getTel());
            
            pstm.executeUpdate();
        
            return true;
            
        }catch (Exception e) {

             e.printStackTrace();

        }

        return false;

        
    }
    
    //Agregar una Pelicula a la base de datos ----------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean agregarPelicula(Pelicula p){
    
        try {

            Connection conexion = getConexion();

            pstm = conexion.prepareStatement("INSERT INTO pelicula VALUES(?,?,?,?,?,?,?)");
            pstm.setString(1, p.getNum_cat());
            pstm.setString(2, p.getTitulo());
            pstm.setString(3, p.getCategoria());
            pstm.setFloat(4, p.getCos_alqui());
            pstm.setFloat(5, p.getCost_adqui());
            pstm.setString(6, p.getAct());
            pstm.setString(7, p.getDirector());
            
            pstm.execute();

            return true;

        } catch (Exception e) {

            System.out.println("Error en instrucción DML");
            System.out.println(e);

        }

        return false;
    
    }//Fin Agregar Pelicula
    
    //Agregar una  Copia de Pelicula a la base de datos ----------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean agregarCopiaPelicula(CopiaPelicula cp){
    
        try {
        
            Connection conexion = getConexion();

            pstm = conexion.prepareStatement("INSERT INTO copiapelicula VALUES(?,?,?,?)");
            pstm.setString(1, cp.getNum_pelicula());
            pstm.setString(2, cp.getEstado());
            pstm.setString(3, cp.getNum_sucursal());
            pstm.setString(4, cp.getNum_catalogo());
            
            pstm.execute();
            
            return true;

        }catch (Exception e) {

            System.out.println("Error en instrucción DML");
            System.out.println(e);

        }
        
        return false;
        
    }
    
//Eliminar -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    //Eliminar una Sucursal de la base de datos ----------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean eliminarSucursal(String filtro) {

        try {

            Connection conexion = getConexion();
            
            conexion.setAutoCommit(false);

            String queryCopiaPeliculas = "DELETE FROM copiapelicula WHERE sucursal_num_sucursal = ?";
            
            PreparedStatement pstmCopiaPeliculas = conexion.prepareStatement(queryCopiaPeliculas);
            
            pstmCopiaPeliculas.setString(1, filtro);

            pstmCopiaPeliculas.execute();

            String querySucursal = "DELETE FROM sucursal WHERE num_sucursal = ?";
            
            PreparedStatement pstmSucursal = conexion.prepareStatement(querySucursal);
            
            pstmSucursal.setString(1, filtro);

            pstmSucursal.execute();

            conexion.commit();

            return true;

        } catch (Exception e) {

            System.err.println("Error en la ejecución de la instrucción SQL: " + e.getMessage());
            e.printStackTrace();
            return false;

        }

    }
    
      public static boolean eliminarPelicula(String filtro) {

        try {

            Connection conexion = getConexion();
            
            conexion.setAutoCommit(false);

            String queryCopiaPeliculas = "DELETE FROM copiapelicula WHERE pelicula_num_catalogo = ?";
            
            PreparedStatement pstmCopiaPeliculas = conexion.prepareStatement(queryCopiaPeliculas);
            
            pstmCopiaPeliculas.setString(1, filtro);

            pstmCopiaPeliculas.execute();

            String querySucursal = "DELETE FROM pelicula WHERE num_catalogo = ?";
            
            PreparedStatement pstmSucursal = conexion.prepareStatement(querySucursal);
            
            pstmSucursal.setString(1, filtro);

            pstmSucursal.execute();

            conexion.commit();

            return true;

        } catch (Exception e) {

            System.err.println("Error en la ejecución de la instrucción SQL: " + e.getMessage());
            e.printStackTrace();
            return false;

        }

    }
    
//Cambiar -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public static boolean cambioSucursal(Sucursal s){
    
        try {
        
            Connection conexion = getConexion();
            
            pstm = conexion.prepareStatement("UPDATE sucursal SET num_sucursal = ?, calle = ?, ciudad = ?, estado = ?, codigo_postal = ?, telefono = ? WHERE num_sucursal = ?");

            
            pstm.setString(1, s.getNum_Suc());
            pstm.setString(2, s.getCalle());
            pstm.setString(3, s.getCiudad());
            pstm.setString(4, s.getEstado());
            pstm.setString(5, s.getCod_pos());
            pstm.setString(6, s.getTel());
            pstm.setString(7, s.getNum_Suc());
            
            System.out.println(s.toString());
            
            pstm.execute();

            return true;
            
        }catch (Exception e) {

            System.out.println("Error en instrucción DML \n" + e);

        }
    
        return false;
        
    }
    
//Consultar ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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
    
    //Consulta General -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
    //Consulta de Sucursales de la base de datos ---------------------------------------------------------------------------------------------------------------------------------------------
    public static ResultSet buscarSucursales(){
    
        try {
        
            Connection conexion = getConexion();

            String sentencia = "SELECT * FROM sucursal;";

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            
            return rs;
        
        } catch (Exception e) {

        }

        return null;
    
    }
    
    //Consulta de numero de Sucursales de la base de datos ---------------------------------------------------------------------------------------------------------------------------------------------
    public static ResultSet buscarNumSucursal(){
    
        try {
        
            Connection conexion = getConexion();
            
            String sentencia = "SELECT num_sucursal FROM sucursal";
            
            PreparedStatement stmt = conexion.prepareStatement(sentencia);
        
            ResultSet rs = stmt.executeQuery();
            
            return  rs;
            
        }catch (SQLException e) {
        
        }
        return null;
    }
    
    //Consulta de numero de catalogo de Peliculas de la base de datos ---------------------------------------------------------------------------------------------------------------------------------------------
    public static ResultSet buscarNumCatalogo(){
    
        try {
        
            Connection conexion = getConexion();
            
            String sentencia = "SELECT num_catalogo FROM pelicula";
            
            PreparedStatement stmt = conexion.prepareStatement(sentencia);
        
            ResultSet rs = stmt.executeQuery();
            
            return  rs;
            
        }catch (SQLException e) {
        
        }
        return null;
        
    }
    
    //Consulta de Peliculas de la base de datos ---------------------------------------------------------------------------------------------------------------------------------------------
    public static ResultSet buscarPeliculas(){
    
        try {
        
            Connection conexion = getConexion();

            String sentencia = "SELECT * FROM pelicula;";

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            
            return rs;
        
        } catch (Exception e) {

        }

        return null;
    
    }

    //Consulta de Copias de Peliculas de la base de datos ---------------------------------------------------------------------------------------------------------------------------------------------
    public static ResultSet buscarCopiasPeliculas(){
    
        try {
        
            Connection conexion = getConexion();

            String sentencia = "SELECT * FROM copiapelicula;";

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            
            return rs;
        
        } catch (Exception e) {

        }

        return null;
    
    }
}
