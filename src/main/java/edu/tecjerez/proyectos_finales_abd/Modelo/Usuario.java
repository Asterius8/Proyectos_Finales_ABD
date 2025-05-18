package edu.tecjerez.proyectos_finales_abd.Modelo;

public class Usuario {

 //Atributos
    private String nombre_de_usuario;
    private String contraseña;
    
    //Constructor(es)
    public Usuario() {
    }

    public Usuario(String nombre_de_usuario, String contrase_usuario) {
        
        this.nombre_de_usuario = nombre_de_usuario;
        this.contraseña = contrase_usuario;
        
    }
    
    //Getter & Setter
    public String getNombre_de_usuario() {
        return nombre_de_usuario;
    }

    public void setNombre_de_usuario(String nombre_de_usuario) {
        this.nombre_de_usuario = nombre_de_usuario;
    }

    public String getContrase_usuario() {
        return contraseña;
    }

    public void setContrase_usuario(String contrase_usuario) {
        this.contraseña = contrase_usuario;
    }
   
    //metodos sobreescritos

    @Override
    public String toString() {
        return "Usuario{" + "nombre_de_usuario=" + nombre_de_usuario + ", contrase_usuario=" + contraseña + '}';
    }
    
}
