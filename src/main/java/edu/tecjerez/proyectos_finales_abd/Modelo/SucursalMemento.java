package edu.tecjerez.proyectos_finales_abd.Modelo;

public class SucursalMemento {
    
    private String num_Suc, calle, ciudad, estado, cod_pos, tel;

    public SucursalMemento(String num_Suc, String calle, String ciudad, String estado, String cod_pos, String tel) {
        
        this.num_Suc = num_Suc;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cod_pos = cod_pos;
        this.tel = tel;
        
    }

    public String getNum_Suc() {
        return num_Suc;
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public String getCod_pos() {
        return cod_pos;
    }

    public String getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return "SucursalMemento{" + "num_Suc=" + num_Suc + ", calle=" + calle + ", ciudad=" + ciudad + ", estado=" + estado + ", cod_pos=" + cod_pos + ", tel=" + tel + '}';
    }

    
    

    
    
    
}
