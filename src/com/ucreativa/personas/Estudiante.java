/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.personas;

import com.ucreativa.universidad.Carrera;
import com.ucreativa.universidad.Curso;
import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author verog
 */
public class Estudiante extends Persona {
    private String carnet;

    private Carrera[] carreras;

    private Curso[] cursos;

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public Carrera[] getCarreras() {
        return carreras;
    }

    public void setCarreras(Carrera[] carreras) {
        this.carreras = carreras;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public Estudiante(String identificacion, String nombre, LocalDate fechaNacimiento, String carnet, Carrera[] carreras, Curso[] cursos) {
        super(identificacion, nombre, fechaNacimiento);
        this.carnet = carnet;
        this.carreras = carreras;
        this.cursos = cursos;
    }

    public Estudiante(String identificacion, String nombre, LocalDate fechaNacimiento, String carnet) {
        super(identificacion, nombre, fechaNacimiento);
        this.carnet = carnet;
        carreras = new Carrera[10];
        cursos = new Curso[10];
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "identificacion='" + identification + '\'' +
                ", carnet='" + carnet + '\'' +
                ", carreras=" + imprimeCarreras() +
                ", cursos=" + imprimeCursos() +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    private String imprimeCarreras() {
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

    private String imprimeCursos() {
        String cursosTexto = "";
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null)
                break;
            else {
                cursosTexto += cursos[i] + "|";
            }
        }

        return cursosTexto;
    }
}
