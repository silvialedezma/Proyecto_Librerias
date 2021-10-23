/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.Mantenimientos;

import com.ucreativa.personas.Persona;
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
                System.out.println("Se ha agregado el Curso " + registro + "satisfactoriamente");
                break;
            } else {
                System.out.println("No se puede ingresar mas cursos");
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
                System.out.println("Se ha eliminado el registro " + registro + "satisfactoriamente");
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("El registro no existe");
        }
    }

    public static void modificarCurso(Curso[] cursos, String nombreCurso, Curso registroNuevo) {
        boolean recordfound = true;
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && cursos[i].getNombre().equals(nombreCurso)) {
                recordfound = true;
                cursos[i] = registroNuevo;
                System.out.println("Registro modificado" + cursos[i].getNombre() + "satisfactoriamente");
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("El registro no existe");
        }
    }

    public static Curso consultarCurso (Curso[] cursos, String nombreActual) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && (cursos[i].getNombre().equals(nombreActual))) {
                System.out.println("Registro Encontrado Satisfactoriamente: " + " Nombre Curso "+ cursos[i].getNombre()+" con " + "Creditos "+ cursos[i].getCreditos());
                return cursos[i];
            }
        }
        return null;
    }
}

