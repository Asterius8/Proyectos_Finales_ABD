package edu.tecjerez.proyectos_finales_abd.Modelo;

import java.util.List;
import java.util.ArrayList;

public class HistorialSucursales {

    private List<SucursalMemento> historial = new ArrayList<>();
    
    public void guardar(SucursalMemento m) {
        
        historial.add(m);
        
    }
    
    public SucursalMemento deshacer() {
        
        if (!historial.isEmpty()) {
            
            return historial.remove(historial.size() - 1);
            
        }
        
        return null;
        
    }
    
}
