/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.Mantenimientos;

import com.ucreativa.personas.Persona;
import com.ucreativa.universidad.Carrera;
import com.ucreativa.universidad.Curso;

/**
 *
 * @author silvi
 */
public class MantenimientoCursos {

    //Agregar un curso
    public static void agregarCurso(Curso[] cursos, Curso registro) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null) {
                cursos[i] = registro;
                System.out.println("Registro agregado exitosamente:" + registro);
                break;
            } else {
                System.out.println("Error:No se puede ingresar mas cursos");
            }
        }
    }

    //Eliminar un curso
    public static void eliminarCurso(Curso[] cursos, Curso registro) {
        boolean recordfound = true;
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && cursos[i].getNombre().equals(registro.getNombre())) {
                recordfound = true;
                cursos[i] = null;
                System.out.println("Registro eliminado exitosamente:" + registro );
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("Error: El registro no existe");
        }
    }

    public static void modificarCurso(Curso[] cursos, String nombreCurso, Curso registroNuevo) {
        boolean recordfound = true;
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && cursos[i].getNombre().equals(nombreCurso)) {
                recordfound = true;
                cursos[i] = registroNuevo;
                System.out.println("Registro modificado exitosamente:" + cursos[i]);
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("El registro no existe");
        }
    }

    public static Curso consultarCurso(Curso[] cursos, String nombreActual) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && (cursos[i].getNombre().equals(nombreActual))) {
                System.out.println("Registro encontrado exitosamente: " + cursos[i]);
                return cursos[i];
            }
        }
        return null;
    }

    public static Curso buscarDato(Curso[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {

            if (lista[i] != null && lista[i].getNombre().equals(nombre)) {
                return lista[i];
            }
        }
        return null;
    }
}
