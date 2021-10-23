/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.personas;

import com.ucreativa.universidad.Carrera;
import com.ucreativa.universidad.Curso;
import java.util.Arrays;

/**
 *
 * @author verog
 */
public class Estudiante extends Persona {

    private String carnet = "";
    private Carrera[] carrera = null;
    private Curso[] curso = null;
    

    public Estudiante() {
    }

    /**
     * @return the carnet
     */
    public String getCarnet() {
        return this.carnet;
    }

    /**
     * @param carne the carnet to set
     */
    public void setCarnet(String carne) {
        this.carnet = carne;
    }

    /**
     * @return the carreras
     */
    public Carrera[] getCarreras() {
        return this.carrera;
    }

    /**
     * @param carreras the carreras to set
     */
    public void setCarreras(Carrera[] carreras) {
        this.carrera = carreras;
    }

    /**
     * @return the cursos
     */
    public Curso[] getCursos() {
        return this.curso;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(Curso[] cursos) {
        this.curso = cursos;
    }

    @Override
    public String toString() {//revisar
        return "Estudiante{"
                + "Identificacion='" + identificacion + '\''
                + "Nombre='" + nombre + '\''
                + "Fecha Nacimiento='" + fechaNacimiento + '\''
                + "carne='" + carnet + '\''
                + ", carrera='" + Arrays.toString(carrera) + '\''
                + ", curso='" + Arrays.toString(curso) + '\''
                + '}';
    }

    public void setFechaNacimiento(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
