/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.Mantenimientos;

import com.ucreativa.personas.Profesor;
import com.ucreativa.universidad.Carrera;


/**
 *
 * @author verog
 */
public class MantenimientoCarrera {

    //Agregar carrera
    public static void agregarCarrera(Carrera[] carreras, Carrera registro) {
        boolean lleno=true;
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i]==null) {
                carreras[i] = registro;
                lleno=false;
                System.out.println("Registro agregado correctamente: " + registro);
                break;
            }    
        }
        if (lleno){
            System.out.println("No se pueden agregar mas carreras");
        }
    }

    //Eliminar carrera
    public static void eliminarCarrera(Carrera[] carreras, Carrera registro) {
        boolean recordfound = true;
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] != null && carreras[i].getNombre().equals(registro.getNombre())) {
                recordfound = true;
                carreras[i] = null;
                System.out.println("Se ha eliminado el registro exitosamente:" + registro);
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("Error:El registro no existe");
        }
    }

    //Modificar Carrera
    public static void modificarCarrera(Carrera[] carreras, String nombreCarrera, Carrera registroNuevo) {
        boolean recordfound = true;
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] != null && carreras[i].getNombre().equals(nombreCarrera)) {
                recordfound = true;
                carreras[i] = registroNuevo;
                System.out.println("Registro modificado satisfactoriamente:" + carreras[i]);
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("Error:El registro no existe");
        }
    }

    public static void consultarCarrera(Carrera[] carreras, String nombreActual) {
        boolean recordfound = true;
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] != null && carreras[i].getNombre().equals(nombreActual)) {
                recordfound = true;
                //carreras[i] = registroNuevo;
                System.out.println("Registro encontrado satisfactoriamente:"  + carreras[i]);
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("Error:El registro no existe");
        }
    }

    public static Carrera buscarDato(Carrera[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {

            if (lista[i] != null && lista[i].getNombre().equals(nombre)) {
                return lista[i];
            }
        }
        return null;
    }
}
