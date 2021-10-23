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
public class Curso {
    private String nombre;

    private Carrera carrera;

    private int creditos;

    private Profesor profesor;

    public Curso(String nombre, Carrera carrera, int creditos, Profesor profesor) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.creditos = creditos;
        this.profesor = profesor;
    }

    public Curso(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", carrera=" + imprimeCarrera() +
                ", creditos=" + creditos +
                ", profesor=" + imprimeProfesor() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return nombre.equals(curso.nombre);
    }

    private String imprimeProfesor(){
        if (profesor == null) {
            return "";
        }

        return profesor.getNombre();
    }

    private String imprimeCarrera(){
        if (carrera == null) {
            return "";
        }

        return carrera.getNombre();
    }
}
