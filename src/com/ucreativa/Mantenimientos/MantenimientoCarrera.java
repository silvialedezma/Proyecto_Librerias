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
    
        //Agregar carrera
    public static void agregarCarrera(Carrera[] carreras, Carrera registro) {
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] == null) {
                carreras[i] = registro;
                System.out.println("Se ha agregado la carrera" + registro + "satisfactoriamente");
                break;
            } else {
                System.out.println("No se puede ingresar mas carreras");
            }
        }
    }
    
        //Eliminar carrera
    public static void eliminarCarrera(Carrera[] carreras, Carrera registro) {
       boolean recordfound = true;
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] != null && carreras[i].getNombre().equals(registro.getNombre())) {
                recordfound = true;
                carreras[i] = null;
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
    
    //Modificar Carrera
        public static void modificarCarrera(Carrera[] carreras, String nombreCarrera, Carrera registroNuevo) {
        boolean recordfound = true;
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] != null && carreras[i].getNombre().equals(nombreCarrera)) {
                recordfound = true;
                carreras[i] = registroNuevo;
                System.out.println("Registro modificado satisfactoriamente:" + " "+carreras[i].getNombre());
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("El registro no existe");
        }
    }
        
     //Consultar carrera   
   /* public static Carrera consultarCarrera(Carrera[] carreras, String nombreActual) {
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] != null && carreras[i].getNombre()== nombreActual) {
                return carreras[i];
            }
        }
        return null;
    }*/
        
    public static void consultarCarrera(Carrera[] carreras, String nombreActual) {
          boolean recordfound = true;
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] != null && carreras[i].getNombre().equals(nombreActual)) {
                recordfound = true;
                //carreras[i] = registroNuevo;
                System.out.println("Registro encontrado satisfactoriamente:" + " "+carreras[i].getNombre());
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("El registro no fue encontrado");
        }
    }
    
}
