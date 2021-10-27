package com.ucreativa.Mantenimientos;

import com.ucreativa.personas.*;
import com.ucreativa.universidad.Carrera;
import com.ucreativa.universidad.Curso;

/**
 *
 * @author silvi
 */
public class Mantenimientos {

    public static void agregarPersona(Persona[] persona, Persona registro) {
        boolean lleno = true;
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] == null) {
                persona[i] = registro;
                lleno=false;
                System.out.println("Registro agregado exitosamente: " + registro);
                break;
            }
        }
        if (lleno) {
            System.out.println("Error: No se puede ingresar mas registros");
        }
    }

    public static void eliminarPersona(Persona[] persona, Persona registro) {
        boolean recordfound = true;
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] != null && persona[i] == registro) {
                recordfound = true;
                persona[i] = null;
                System.out.println("Registro eliminado exitosamente:" + registro);
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("Error: El registro no existe");
        }
    }

    public static void eliminarPersona(Persona[] persona, String identificacion) {
        boolean recordfound = true;
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] != null && (persona[i].getIdentificacion() == null ? identificacion == null : persona[i].getIdentificacion().equals(identificacion))) {
                recordfound = true;
                persona[i] = null;
                System.out.println("Registro eliminado exitosamente:" + identificacion);
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("Error: El registro no existe");
        }
    }

    public static void modificarPersona(Persona[] persona, String identificacion, Persona registroNuevo) {
        boolean recordfound = true;
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] != null && persona[i].getIdentificacion().equals(identificacion)) {
                recordfound = true;
                persona[i] = registroNuevo;
                System.out.println("Registro modificado exitosamente:" + persona[i]);
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("Error: El registro no existe");
        }
    }

    public static Persona consultarPersona(Persona[] persona, String identificacionActual) {
        boolean recordfound = true;
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] != null && persona[i].getIdentificacion().equals(identificacionActual)) {
                recordfound = true;
                System.out.println("Registro encontrado exitosamente:"  + persona[i]);
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("Error: El registro no fue encontrado");
        }
        return null;
    }

    public static Persona buscarDato(Persona[] lista, String id) {
        for (int i = 0; i < lista.length; i++) {

            if (lista[i] != null && lista[i].getIdentificacion().equals(id)) {
                return lista[i];
            }
        }
        return null;
    }
}
