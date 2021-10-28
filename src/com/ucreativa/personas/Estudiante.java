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
        carrera = new Carrera[20];
        curso = new Curso[20];
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
    public String toString() {
        return "Estudiante{"
                + "Identificacion='" + identificacion + '\''
                + "Nombre='" + nombre + '\''
                + "Fecha Nacimiento='" + getFechaNacimiento() + '\''
                + "carne='" + carnet + '\''
                + ", carrera='" + imprimeCarrerasAsociadas()+ '\''
                + ", curso='" + imprimeCursosAsociadas() + '\''
                + '}';
    }
    
private String imprimeCarrerasAsociadas() {
        String carrerasTexto = "";
        for (int i = 0; i < carrera.length; i++) {
            if (carrera[i] != null)
            {
                carrerasTexto += carrera[i].getNombre() + "|";
            }
        }

        return carrerasTexto;
    }
private String imprimeCursosAsociadas() {
        String cursosTexto = "";
        for (int i = 0; i < curso.length; i++) {
            if (curso[i] != null)
            {
                cursosTexto += curso[i].getNombre() + "|";
            }
        }

        return cursosTexto;
    }
}
