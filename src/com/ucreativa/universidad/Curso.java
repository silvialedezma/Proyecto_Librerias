/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.universidad;
import com.ucreativa.personas.*;
import com.ucreativa.universidad.*;
import java.util.Scanner;
import com.ucreativa.personas.Profesor;

/**
 *
 * @author verog
 */
public class Curso extends Carrera {

    private String nombre = "";
    private Carrera carrera = new Carrera();
    private int creditos = 0;
    private Profesor profesor = new Profesor();

    public Curso() {
  
    }

    public Curso(String nombre, Profesor profesor) {
        this.nombre=nombre;
        this.profesor=profesor;
    }

    public Curso(String nombre, String director) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * @return the carrera
     */
    public Carrera getCarrera() {
        return this.carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the creditos
     */
    public int getCreditos() {
        return this.creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return this.profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String toString() {//revisar
        return "Curso{"
                + "nombre='" + nombre + '\''
                + ", carrera='" + carrera + '\''
                + ", creditos='" + creditos + '\''
                + ", profesor='" + profesor + '\''
                + '}';
    }
    
}
