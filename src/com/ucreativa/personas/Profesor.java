/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.personas;

import com.ucreativa.universidad.Carrera;
import java.util.Arrays;

/**
 *
 * @author verog
 */
public class Profesor extends Persona {

    private String idEmpleado = "";
    private Carrera[] carreras = null;  //crear clase carrera

    public Profesor() {
        carreras=new Carrera[20];
    }

    /**
     * @return the idEmpleado
     */
    public String getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * @return the carreras
     */
    public Carrera[] getCarreras() {
        return carreras;
    }

    /**
     * @param carreras the carreras to set
     */
    public void setCarreras(Carrera[] carreras) {
        this.carreras = carreras;
    }

       @Override
    public String toString() {//revisar
        return "Profesor{"
                + "Identificacion='" + identificacion + '\''
                + "Nombre='" + nombre + '\''
                + "Fecha Nacimiento='" + getFechaNacimiento() + '\''
                + "idEmpleado='" + idEmpleado + '\''
                + ", carreras='" + imprimeCarrerasAsociadas() + '\''
                + '}';
    }
    
    private String imprimeCarrerasAsociadas() {
        String carrerasTexto = "";
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] != null)
            {
                carrerasTexto += carreras[i].getNombre() + "|";
            }
        }
        return carrerasTexto;
    }
}
