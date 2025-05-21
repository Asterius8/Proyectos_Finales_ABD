package edu.tecjerez.proyectos_finales_abd.Modelo;

public class CopiaPelicula {
    
    //Atributos
    String num_pelicula, estado, num_sucursal, num_catalogo;
    
    //Constructor(es)

    public CopiaPelicula() {
    }

    public CopiaPelicula(String num_pelicula, String estado, String num_sucursal, String num_catalogo) {
        this.num_pelicula = num_pelicula;
        this.estado = estado;
        this.num_sucursal = num_sucursal;
        this.num_catalogo = num_catalogo;
    }

    //getter & Setter
    public String getNum_pelicula() {
        return num_pelicula;
    }

    public void setNum_pelicula(String num_pelicula) {
        this.num_pelicula = num_pelicula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNum_sucursal() {
        return num_sucursal;
    }

    public void setNum_sucursal(String num_sucursal) {
        this.num_sucursal = num_sucursal;
    }

    public String getNum_catalogo() {
        return num_catalogo;
    }

    public void setNum_catalogo(String num_catalogo) {
        this.num_catalogo = num_catalogo;
    }

    @Override
    public String toString() {
        return "CopiaPelicula{" + "num_pelicula=" + num_pelicula + ", estado=" + estado + ", num_sucursal=" + num_sucursal + ", num_catalogo=" + num_catalogo + '}';
    }
    
    
    
}
