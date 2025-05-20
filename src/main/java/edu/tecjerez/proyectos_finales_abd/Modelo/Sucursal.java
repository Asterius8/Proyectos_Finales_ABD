package edu.tecjerez.proyectos_finales_abd.Modelo;

public class Sucursal {
    
    //Atributos
    private String num_Suc, calle, ciudad, estado, cod_pos, tel;
    
    //Constructor(es)
    public Sucursal() {}
    public Sucursal(String num_Suc, String calle, String ciudad, String estado, String cod_pos, String tel) {
        this.num_Suc = num_Suc;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cod_pos = cod_pos;
        this.tel = tel;
    }
    
    //Getter & Setter
    public String getNum_Suc() {
        return num_Suc;
    }

    public void setNum_Suc(String num_Suc) {
        this.num_Suc = num_Suc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCod_pos() {
        return cod_pos;
    }

    public void setCod_pos(String cod_pos) {
        this.cod_pos = cod_pos;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    //Metodos Sobreesctritos

    @Override
    public String toString() {
        return "Sucursal{" + "num_Suc=" + num_Suc + ", calle=" + calle + ", ciudad=" + ciudad + ", estado=" + estado + ", cod_pos=" + cod_pos + ", tel=" + tel + '}';
    }

    




    
    
}
