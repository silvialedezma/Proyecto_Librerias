/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.Mantenimientos;

import com.ucreativa.personas.*;
import com.ucreativa.universidad.*;
import java.util.Scanner;

/**
 *
 * @author silvi
 */
public class Main {

    private Profesor[] profesor = new Profesor[10];
    private Carrera[] carrera = new Carrera[10];
    private Curso[] curso = new Curso[10];
    private Mantenimientos cursos = new Mantenimientos();
    public static final String ANSI_BLUE = "\u001B[34m";
    
    public static void main(String[] args) {
        Main inicio = new Main();
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println(ANSI_BLUE + "----------------Menu Principal----------------");
            System.out.println("Seleccione una opcion");
            System.out.println("1-Cursos");
            System.out.println("2-Carreras");
            System.out.println("3-Profesores");
            System.out.println("4-Estudiante");
            System.out.println("5-Salir");
            System.out.println(ANSI_BLUE + "----------------------------------------------");
            String operacion = scanner.nextLine();
            int operador = -1;
            try {
                operador = Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
            }
            switch (operador) {
                case 1:
                    inicio.subMenu();
                    break;
                case 2:
                    inicio.subMenu();
                    break;

                case 3:
                    inicio.subMenu();
                    break;
                case 4:
                    inicio.subMenu();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema");
                    b = false;
                    break;
                default:
                    break;
            }

        }
    }

    public void subMenu() {
        Main inicio = new Main();
        Scanner scanner01 = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("-------------------SubMenu--------------------");
            System.out.println("Seleccione una opcion");
            System.out.println("1-Agregar");
            System.out.println("2-Modificar");
            System.out.println("3-Eliminar");
            System.out.println("4-Consultar");
            System.out.println("5-Salir");
            System.out.println("----------------------------------------------");
            String operacion = scanner01.nextLine();
            int operador = -1;
            try {
                operador = Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
            }
            switch (operador) {
                case 1:
                    agregarCurso();
                    break;
                case 2:
                    modificarCurso();
                    break;
                case 3:
                    eliminarCurso();
                    break;
                case 4:
                    consultarCurso();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema");
                    b = false;
                    break;
                default:
                    break;
            }

        }
    }

    /* public void agregarEstudiante() {
        Scanner scanner01 = new Scanner(System.in);
        System.out.println("Ingrese la cedula");
        try {
            int cedula = Integer.parseInt(scanner01.nextLine());
            System.out.println("Ingrese el nombre del curso");
            String nombre = scanner01.nextLine();
            System.out.println("Ingrese nombre del director");
            String director = scanner01.nextLine();         
            //
            Curso nuevoCurso = new Curso();
            Profesor profesor=new Profesor();
            Carrera carrera=new Carrera();
            Mantenimientos.agregarCurso(curso, nuevoCurso);
            
        } catch (NumberFormatException e) {
            System.out.println("Cedula debe ser numerica");
        }
    }*/
    public void agregarCurso() {

        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso: ");
            String nombre = scanner01.nextLine();
            System.out.print("Digite la cantidad de creditos: ");
            String cred = scanner01.nextLine();
            Curso newCurso = new Curso();
            newCurso.setNombre(nombre);
            newCurso.setCreditos(Integer.parseInt(cred));
            MantenimientoCursos mantCurso = new MantenimientoCursos();
            mantCurso.agregarCurso(curso, newCurso);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
    }

    public void eliminarCurso() {
        Scanner scanner02 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso que desea eliminar ");
            String nombreCurso = scanner02.nextLine();
            Curso newCurso = new Curso();
            newCurso.setNombre(nombreCurso);
            MantenimientoCursos mantCurso = new MantenimientoCursos();
            mantCurso.eliminarCurso(curso, newCurso);
            scanner02.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
    }

    public void modificarCurso() {
        Scanner scanner03 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso a modificar:");
            String nombre = scanner03.nextLine();
            System.out.print("Digite el nuevo nombre del curso:");
            String nombreNuevo = scanner03.nextLine();
            System.out.print("Digite la cantidad de creditos a modificar:");
            String cred = scanner03.nextLine();
            Curso newCurso = new Curso();
            newCurso.setNombre(nombreNuevo);
            newCurso.setCreditos(Integer.parseInt(cred));
            MantenimientoCursos mantCurso = new MantenimientoCursos();
            mantCurso.modificarCurso(curso, nombre, newCurso);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
    }

    public void consultarCurso() {

        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso a consultar:");
            String nombreCurso = scanner01.nextLine();
            Curso newCurso = new Curso();
            newCurso.setNombre(nombreCurso);
            MantenimientoCursos mantCurso = new MantenimientoCursos();
            mantCurso.agregarCurso(curso, newCurso);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
    }

}
