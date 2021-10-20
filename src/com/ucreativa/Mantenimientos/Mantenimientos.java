/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.Mantenimientos;
import com.ucreativa.personas.Persona;
import java.util.ArrayList;

/**
 *
 * @author silvi
 */
public class Mantenimientos {
    private ArrayList<Persona> lista;
    
     public Mantenimientos() {
        lista = new ArrayList<>();
    }
public void agregar(Persona dato) {
        lista.add(dato);
    }

    public boolean eliminar(Persona dato) {
        return eliminar(dato.getIdentificacion());
    }

    public boolean eliminar(String id) {
        int indice = buscarIndice(id);
        if (indice != -1) {
            lista.remove(indice);
            return true;
        }
        return false;
    }

    public boolean modificar(String id, Persona dato) {
        int indice = buscarIndice(id);

        if (indice != -1) {
            lista.set(indice, dato);
            return true;
        }
        return false;
    }

    public Persona consultar(String id){
        int indice = buscarIndice(id);
        if (indice != -1) {
            return lista.get(indice);
        }

        return null;
    }

    public int buscarIndice(String id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdentificacion() == id)
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String resultado = "";
        for(Persona dato : lista) {
            resultado += dato.toString() + "\n";
        }
        return resultado;
    }
}
