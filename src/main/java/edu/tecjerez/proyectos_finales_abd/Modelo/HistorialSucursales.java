package edu.tecjerez.proyectos_finales_abd.Modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class HistorialSucursales {

    private final Stack<SucursalMemento> history = new Stack<>();
    
    public void guardar(SucursalMemento m) {
        
        history.push(m);
        
    }
    
    public SucursalMemento deshacer() {
        
        return history.isEmpty() ? null : history.pop();
        
    }

    @Override
    public String toString() {
        return "HistorialSucursales{" + "history=" + history + '}';
    }
    
    
    
}
