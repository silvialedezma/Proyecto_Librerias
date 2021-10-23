/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.Mantenimientos;

import com.ucreativa.personas.*;
import com.ucreativa.universidad.*;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 *
 * @author silvi
 */
public class Main {

    private Profesor[] profesor = new Profesor[10];
    private Carrera[] carrera = new Carrera[10];
    private Curso[] curso = new Curso[10];
    private Mantenimientos cursos = new Mantenimientos();
    private Estudiante[] estudiantes= new Estudiante[10];

    public static void main(String[] args) {
        Main inicio = new Main();
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("----------------Menu Principal----------------");
            System.out.println("Seleccione una opcion");
            System.out.println("1-Cursos");
            System.out.println("2-Carreras");
            System.out.println("3-Profesores");
            System.out.println("4-Estudiante");
            System.out.println("5-Salir");
            System.out.println("----------------------------------------------");
            String operacion = scanner.nextLine();
            int operador = -1;
            try {
                operador = Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
            }
            switch (operador) {
                case 1:
                    inicio.subMenuCurso();
                    break;
                case 2:
                    inicio.subMenuCarreras();
                    break;

                case 3:

                    break;
                case 4:
                    inicio.agregarEstudiante();
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

    public void subMenuCurso() {
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

    public void subMenuCarreras() {
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
                    agregarCarrera();
                    break;
                case 2:
                    modificarCarrera();
                    break;
                case 3:
                    eliminarCarrera();
                    break;
                case 4:
                    consultarCarrera();
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
            mantCurso.consultarCurso(curso, nombreCurso);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
    }
    /////Carreras////

    public void agregarCarrera() {
        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera: ");
            String nombre = scanner01.nextLine();
            Carrera nuevaCarrera = new Carrera();
            nuevaCarrera.setNombre(nombre);
            MantenimientoCarrera mantCarrera = new MantenimientoCarrera();
            mantCarrera.agregarCarrera(carrera, nuevaCarrera);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
    }

    public void eliminarCarrera() {
        Scanner scanner02 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera que desea eliminar ");
            String nombreCarrera = scanner02.nextLine();
            Carrera nuevaCarrera = new Carrera();
            nuevaCarrera.setNombre(nombreCarrera);
            MantenimientoCarrera mantCarrera = new MantenimientoCarrera();
            mantCarrera.eliminarCarrera(carrera, nuevaCarrera);
            scanner02.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
    }

    public void modificarCarrera() {
        Scanner scanner03 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera a modificar:");
            String nombre = scanner03.nextLine();
            System.out.print("Digite el nuevo nombre:");
            String nuevoNombre = scanner03.nextLine();
            Carrera nuevaCarrera = new Carrera();
            nuevaCarrera.setNombre(nuevoNombre);
            MantenimientoCarrera mantCarrera = new MantenimientoCarrera();
            mantCarrera.modificarCarrera(carrera, nombre, nuevaCarrera);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
    }

    public void consultarCarrera() {
        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera a consultar:");
            String nombreCarrera = scanner01.nextLine();
            Carrera nuevaCarrera = new Carrera();
            nuevaCarrera.setNombre(nombreCarrera);
            MantenimientoCarrera mantCarrera = new MantenimientoCarrera();
            mantCarrera.consultarCarrera(carrera, nombreCarrera);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
    }

// Estudiante ////////
    public void subMenuEstudiante() {
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
                    agregarEstudiante();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

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

     public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public void agregarEstudiante() {
        Scanner scanner01 = new Scanner(System.in);
        
        try {
            System.out.println("Ingrese la cedula");
            String cedula = scanner01.nextLine();
            System.out.println("Digite el nombre:");
            String nombre = scanner01.nextLine();            
            System.out.println("Digite la fecha nacimiento (Formato: dd/MM/yyyy:");
            String fecha = scanner01.nextLine();          
            System.out.println("Digite el Carnet:");
            String carnet = scanner01.nextLine();
            Estudiante estudiante = new Estudiante();
            estudiante.setIdentificacion(cedula);
            estudiante.setNombre(nombre);
            estudiante.setFechaNacimiento(ParseFecha(fecha));
            estudiante.setCarnet(carnet);            
            Mantenimientos.agregarPersona(estudiantes, estudiante);
        } catch (NumberFormatException e) {
            System.out.println("Cedula debe ser numerica");
        }
    }
}
