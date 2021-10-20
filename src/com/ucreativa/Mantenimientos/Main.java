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

   // private Estudiante estudiante[] = null;
   // private Profesor profesor[] = null;
   // private Carrera carrera[] = null;
    private Curso[] curso = null;
  //  private Mantenimientos estudiantes = new Mantenimientos();
  //  private Mantenimientos profesores = new Mantenimientos();
  //  private Mantenimientos carreras = new Mantenimientos();
    private Mantenimientos cursos = new Mantenimientos();

    public static void main(String[] args) {
        Main inicio = new Main();
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("Seleccione una opcion");
            System.out.println("1-Cursos");
            System.out.println("2-Carreras");
            System.out.println("3-Profesores");
            System.out.println("4-Estudiante");
            System.out.println("5-Salir");
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

    public void subMenu() {
        Main inicio = new Main();
        Scanner scanner01 = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("Seleccione una opcion");
            System.out.println("1-Agregar");
            System.out.println("2-Modificar");
            System.out.println("3-Eliminar");
            System.out.println("4-Consultar");
            System.out.println("5-Salir");
            String operacion = scanner01.nextLine();
            int operador = -1;
            try {
                operador = Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
            }
            switch (operador) {
                case 1:
                    
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
     public void agregarEstudiante() {
        Scanner scanner01 = new Scanner(System.in);
        System.out.println("Ingrese la cedula");
        try {
            int cedula = Integer.parseInt(scanner01.nextLine());
            System.out.println("Ingrese el nombre del curso");
            String nombre = scanner01.nextLine();
            System.out.println("Ingrese nombre del director");
            String director = scanner01.nextLine();         
            Curso nuevoCurso = new Curso(nombre, director);    
        } catch (NumberFormatException e) {
            System.out.println("Cedula debe ser numerica");
        }
    }

}
