package com.ucreativa.Mantenimientos;
import com.ucreativa.personas.*;

/**
 *
 * @author silvi
 */
public class Mantenimientos {

    public static Persona[] agregar(Persona[] lista, Persona dato) {
        int indice = indiceAAgregar(lista);
        if (indice == lista.length){
            // La lista esta llena, expanda el arreglo
            lista = expandirArreglo(lista);
        }
        lista[indice] = dato;
        return lista;
    }

    public static boolean eliminar(Persona[] lista, String identificacion) throws Exception {
        int indiceAEliminar = buscarDato(lista, identificacion);
        if (indiceAEliminar == -1) {
            throw new Exception("Persona con el id " + identificacion + " no encontrada para eliminar");
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

    public static Persona consultar(Persona[] lista, String identificacion) throws Exception {
        int indiceAConsultar = buscarDato(lista, identificacion);
        if (indiceAConsultar == -1) {
            throw new Exception("Persona con el id " + identificacion + " no encontrada para consultar");
        }

        return lista[indiceAConsultar];
    }

    public static boolean modificar(Persona[] lista, String identificacion, Persona nuevoDato) throws Exception {
        int indiceAModificar = buscarDato(lista, identificacion);
        if (indiceAModificar == -1) {
            throw new Exception("Persona con el id " + identificacion + " no encontrada para modificar");
        }

        lista[indiceAModificar] = nuevoDato;

        return true;
    }

    public static boolean idExiste(Persona[] lista, String id) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getIdentification().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static int buscarDato(Persona[] lista, String identificacion) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getIdentification().equals(identificacion)) {
                return i;
            }
        }
        return -1;
    }

    private static int indiceAAgregar(Persona[] lista) {
        int i = 0;
        do {
            if (lista[i] == null) {
                break;
            }
            i++;
        } while (i < lista.length);

        return i;
    }

    private static Persona[] expandirArreglo(Persona[] lista) {
        int tamannoNuevo = lista.length * 2;
        Persona[] listaVieja = lista;
        Persona[] listaNueva = new Persona[tamannoNuevo];

        for (int i = 0; i < listaVieja.length; i++) {
            listaNueva[i] = listaVieja[i];
        }

        return listaNueva;
    }
}
