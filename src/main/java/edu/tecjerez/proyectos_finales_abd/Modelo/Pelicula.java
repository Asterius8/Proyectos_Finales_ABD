package edu.tecjerez.proyectos_finales_abd.Modelo;

public class Pelicula {
    
    //Atributos
    private String num_cat, titulo, categoria, actores, director;
    private float cos_alqui, cost_adqui;
    
    //Constructor(es)

    public Pelicula() {
    }

    public Pelicula(String num_cat, String titulo, String categoria, float cos_alqui, float cost_adqui, String actores, String director) {
        this.num_cat = num_cat;
        this.titulo = titulo;
        this.categoria = categoria;
        this.cos_alqui = cos_alqui;
        this.cost_adqui = cost_adqui;
        this.actores = actores;
        this.director = director;
    }
    
    //Getter & Setter

    public String getNum_cat() {
        return num_cat;
    }

    public void setNum_cat(String num_cat) {
        this.num_cat = num_cat;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getCos_alqui() {
        return cos_alqui;
    }

    public void setCos_alqui(float cos_alqui) {
        this.cos_alqui = cos_alqui;
    }

    public float getCost_adqui() {
        return cost_adqui;
    }

    public void setCost_adqui(float cost_adqui) {
        this.cost_adqui = cost_adqui;
    }

    public String getAct() {
        return actores;
    }

    public void setAct(String act) {
        this.actores = act;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    //Metodos Sobreescritos

    @Override
    public String toString() {
        return "Pelicula{" + "num_cat=" + num_cat + ", titulo=" + titulo + ", categoria=" + categoria + ", cos_alqui=" + cos_alqui + ", cost_adqui=" + cost_adqui + ", actores=" + actores + ", director=" + director + '}';
    }
    
    
    
    
}
