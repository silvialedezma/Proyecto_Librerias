/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.Mantenimientos;

import com.ucreativa.universidad.Curso;

/**
 *
 * @author silvi
 */
public class MantenimientoCursos {

    public static Curso[] agregar(Curso[] lista, Curso dato) {
        int indice = indiceAAgregar(lista);
        if (indice == lista.length){
            // La lista esta llena, expanda el arreglo
            lista = expandirArreglo(lista);
        }
        lista[indice] = dato;
        return lista;
    }

    public static boolean eliminar(Curso[] lista, String nombre) throws Exception {
        int indiceAEliminar = buscarDato(lista, nombre);
        if (indiceAEliminar == -1) {
            throw new Exception("Curso con el nombre " + nombre + " no encontrado para eliminar");
        }

        // Borre el elemento
        lista[indiceAEliminar] = null;
        // Mueva los elementos a la izquierda
        int j = indiceAEliminar+1;
        while (j < lista.length && lista[j] != null) {
            lista[j-1] = lista[j];
            lista[j] = null;
            j++;
        }
        return true;
    }

    public static Curso consultar(Curso[] lista, String nombre) throws Exception {
        int indiceAConsultar = buscarDato(lista, nombre);
        if (indiceAConsultar == -1) {
            throw new Exception("Curso con el nombre" + nombre + " no encontrado para consultar");
        }

        return lista[indiceAConsultar];
    }

    public static boolean modificar(Curso[] lista, String nombre, Curso nuevoDato) throws Exception {
        int indiceAModificar = buscarDato(lista, nombre);
        if (indiceAModificar == -1) {
            throw new Exception("Curso con el nombre " + nombre + " no encontrado para modificar");
        }

        lista[indiceAModificar] = nuevoDato;

        return true;
    }

    public static boolean nombreExiste(Curso[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public static int buscarDato(Curso[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    private static int indiceAAgregar(Curso[] lista) {
        int i = 0;
        do {
            if (lista[i] == null) {
                break;
            }
            i++;
        } while (i < lista.length);

        return i;
    }

    private static Curso[] expandirArreglo(Curso[] lista) {
        int tamannoNuevo = lista.length * 2;
        Curso[] listaVieja = lista;
        Curso[] listaNueva = new Curso[tamannoNuevo];

        for (int i = 0; i < listaVieja.length; i++) {
            listaNueva[i] = listaVieja[i];
        }

        return listaNueva;
    }
}

