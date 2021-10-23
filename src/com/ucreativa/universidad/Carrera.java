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
public class Carrera {
    private String nombre;

    private Profesor director;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getDirector() {
        return director;
    }

    public void setDirector(Profesor director) {
        this.director = director;
    }

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public Carrera(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.director = profesor;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "nombre='" + nombre + '\'' +
                ", director=" + imprimeDirector() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return nombre.equals(carrera.nombre);
    }

    private String imprimeDirector() {
        if (director == null) {
            return "";
        }

        return director.getNombre();
    }
}
