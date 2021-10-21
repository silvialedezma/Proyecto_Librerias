/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.personas;
import java.util.Date;

/**
 *
 * @author verog
 */
public abstract class Persona {

    protected String identificacion = "";
    protected String nombre = "";
    protected Date fechaNacimiento = null;

    
    public Persona() {
    }

    /**
     * @return the identification
     */
    public String getIdentificacion() {
        return this.identificacion;
    }

    /**
     * @param identification the identification to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

   @Override
    public abstract String toString();

}
