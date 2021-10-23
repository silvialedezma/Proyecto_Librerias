/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.Mantenimientos;
import com.ucreativa.universidad.Carrera;

/**
 *
 * @author verog
 */
public class MantenimientoCarrera {
    
    public static Carrera[] agregar(Carrera[] lista, Carrera dato) {
    int indice = indiceAAgregar(lista);
    if (indice == lista.length){
        // La lista esta llena, expanda el arreglo
        lista = expandirArreglo(lista);
    }
    lista[indice] = dato;
    return lista;
}

    public static boolean eliminar(Carrera[] lista, String nombre) throws Exception {
        int indiceAEliminar = buscarDato(lista, nombre);
        if (indiceAEliminar == -1) {
            throw new Exception("Carrera con el nombre " + nombre + " no encontrada para eliminar");
        }

        // Borre el elemento
        lista[indiceAEliminar] = null;
        // Mueva los elementos a la izquierda
        int j = indiceAEliminar + 1;
        while (j < lista.length && lista[j] != null) {
            lista[j-1] = lista[j];
            lista[j] = null;
            j++;
        }
        return true;
    }

    public static Carrera consultar(Carrera[] lista, String nombre) throws Exception {
        int indiceAConsultar = buscarDato(lista, nombre);
        if (indiceAConsultar == -1) {
            throw new Exception("Carrera con el nombre " + nombre + " no encontrada para consultar");
        }

        return lista[indiceAConsultar];
    }

    public static boolean modificar(Carrera[] lista, String nombre, Carrera nuevoDato) throws Exception {
        int indiceAModificar = buscarDato(lista, nombre);
        if (indiceAModificar == -1) {
            throw new Exception("Carrera con el nombre " + nombre + " no encontrada para modificar");
        }

        lista[indiceAModificar] = nuevoDato;

        return true;
    }

    public static boolean nombreExiste(Carrera[] lista, String id) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getNombre().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static int buscarDato(Carrera[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    private static int indiceAAgregar(Carrera[] lista) {
        int i = 0;
        do {
            if (lista[i] == null) {
                break;
            }
            i++;
        } while (i < lista.length);

        return i;
    }

    private static Carrera[] expandirArreglo(Carrera[] lista) {
        int tamannoNuevo = lista.length * 2;
        Carrera[] listaVieja = lista;
        Carrera[] listaNueva = new Carrera[tamannoNuevo];

        for (int i = 0; i < listaVieja.length; i++) {
            listaNueva[i] = listaVieja[i];
        }

        return listaNueva;
    }
}
