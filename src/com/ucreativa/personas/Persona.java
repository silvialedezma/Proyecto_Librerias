/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.personas;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author verog
 */
public abstract class Persona{
    protected String identification;

    protected String nombre;

    protected LocalDate fechaNacimiento;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(String identification, String nombre, LocalDate fechaNacimiento) {
        this.identification = identification;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(String identification)
    {
        this.identification = identification;
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return identification.equals(persona.identification);
    }
}
