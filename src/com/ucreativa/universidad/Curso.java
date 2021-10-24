/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.universidad;
import com.ucreativa.personas.Profesor;


/**
 *
 * @author verog
 */
public class Curso{

    private String nombreCurso = "";
    private Carrera carrera;
    private int creditos = 0;
    private Profesor profesor;

    public Curso() {
    }
    
    //constructor todos los parametros nombrecurso,carrera carrera, creditos, profesor profesor
    public Curso(String nombreCurso, Carrera carrera, int creditos, Profesor profesor) {
        this.nombreCurso = nombreCurso;
        this.carrera = carrera;
        this.creditos = creditos;
        this.profesor = profesor;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return this.nombreCurso;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombreCurso = nombre;
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

    @Override
    public String toString() {
        return "Curso{"
                + "nombre='" + nombreCurso + '\''
                + ", creditos='" + creditos + '\''
                + '}';
    }

}
