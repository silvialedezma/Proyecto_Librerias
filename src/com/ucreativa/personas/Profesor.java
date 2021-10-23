/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.personas;

import com.ucreativa.universidad.Carrera;
import java.time.LocalDate;

/**
 *
 * @author verog
 */
public class Profesor extends Persona {
    private String idEmpleado;

    private Carrera[] carreras;

    public Carrera[] getCarreras() {
        return carreras;
    }

    public void setCarreras(Carrera[] carreras) {
        this.carreras = carreras;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Profesor(String identificacion, String nombre, LocalDate fechaNacimiento, String idEmpleado, Carrera[] carreras) {
        super(identificacion, nombre, fechaNacimiento);
        this.idEmpleado = idEmpleado;
        this.carreras = carreras;
    }

    public Profesor(String identificacion, String nombre, LocalDate fechaNacimiento, String idEmpleado) {
        super(identificacion, nombre, fechaNacimiento);
        this.idEmpleado = idEmpleado;
        this.carreras = new Carrera[10];
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "identification='" + identification + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", idEmpleado='" + idEmpleado + '\'' +
                ", carreras=" + imprimeCarrerasAsociadas() +
                '}';
    }

    private String imprimeCarrerasAsociadas() {
        String carrerasTexto = "";
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] == null)
                break;
            else {
                carrerasTexto += carreras[i] + "|";
            }
        }

        return carrerasTexto;
    }
}
