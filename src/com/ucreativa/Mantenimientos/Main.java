/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucreativa.Mantenimientos;

import com.ucreativa.personas.*;
import com.ucreativa.universidad.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 *
 * @author silvi
 */
public class Main {
    private Curso[] cursos = new Curso[10];
    private Carrera[] carreras = new Carrera[10];
    private Persona[] profesores = new Profesor[10];
    private Persona[] estudiantes = new Estudiante[10];

    public static void main(String[] args) {
        Main inicio = new Main();
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        while (continua) {
            System.out.println("----------------Menu Principal----------------");
            System.out.println("Seleccione una opcion");
            System.out.println("1-Mantenimiento Cursos");
            System.out.println("2-Mantenimiento Carreras");
            System.out.println("3-Mantenimiento Profesores");
            System.out.println("4-Mantenimiento Estudiante");
            System.out.println("5-Asignar o quitar carreras a profesor");
            System.out.println("6-Asignar o quitar carreras a estudiante");
            System.out.println("7-Asignar o quitar director a carrera");
            System.out.println("8-Asignar o quitar cursos a estudiante");
            System.out.println("9-Generar lista de estudiantes de un curso");
            System.out.println("10-Salir");
            System.out.println("----------------------------------------------");
            String operacion = scanner.nextLine();
            int operador = -1;
            try {
                operador = Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                operador = -1;
            }
            switch (operador) {
                case 1:
                case 2:
                case 3:
                case 4:
                    inicio.subMenuMantenimientos(operador);
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    inicio.subMenuAsignaciones(operador);
                    break;
                case 9:
                    inicio.generarListaEstudiantesPorCurso();
                    break;
                case 10:
                    System.out.println("Saliendo del sistema");
                    continua = false;
                    break;
                default:
                    System.out.println("Opcion invalida, digite de nuevo la opcion\n");
                    break;
            }
        }
    }

    // Mantenimientos
    private void subMenuMantenimientos(int operador) {
        Scanner scanner01 = new Scanner(System.in);
        boolean continua = true;
        while (continua) {
            System.out.println("-------------------SubMenu--------------------");
            System.out.println("Seleccione una opcion");
            System.out.println("1-Agregar");
            System.out.println("2-Modificar");
            System.out.println("3-Eliminar");
            System.out.println("4-Consultar");
            System.out.println("5-Salir");
            System.out.println("----------------------------------------------");
            String operacion = scanner01.nextLine();
            int operadorSubMenu = 0;
            try {
                operadorSubMenu = Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                operadorSubMenu = -1;
            }
            switch (operadorSubMenu) {
                case 1:
                    agregar(operador);
                    break;
                case 2:
                    modificar(operador);
                    break;
                case 3:
                    eliminar(operador);
                    break;
                case 4:
                    consultar(operador);
                    break;
                case 5:
                    System.out.println("Saliendo del submenu");
                    continua = false;
                    break;
                default:
                    System.out.println("Opcion invalida, digite de nuevo la opcion\n");
                    break;
            }
        }
    }

    private void agregar(int operador) {
        switch (operador)
        {
            case 1:
                agregarCurso();
                break;
            case 2:
                agregarCarrera();
                break;
            case 3:
                agregarProfesor();
                break;
            case 4:
                agregarEstudiante();
                break;
            default:
                break;
        }
    }

    public void eliminar(int operador) {
        switch (operador)
        {
            case 1:
                eliminarCurso();
                break;
            case 2:
                eliminarCarrera();
                break;
            case 3:
                eliminarProfesor();
                break;
            case 4:
                eliminarEstudiante();
                break;
            default:
                break;
        }
    }

    public void modificar(int operador) {
        switch (operador)
        {
            case 1:
                modificarCurso();
                break;
            case 2:
                modificarCarrera();
                break;
            case 3:
                modificarProfesor();
                break;
            case 4:
                modificarEstudiante();
                break;
            default:
                break;
        }
    }

    public void consultar(int operador) {
        switch (operador)
        {
            case 1:
                consultarCurso();
                break;
            case 2:
                consultarCarrera();
                break;
            case 3:
                consultarProfesor();
                break;
            case 4:
                consultarEstudiante();
                break;
            default:
                break;
        }
    }

    // Cursos
    private void agregarCurso() {
        Scanner scanner = new Scanner(System.in);
        try {
            String nombre = "";
            boolean verificacionNombre = false;
            while (!verificacionNombre)
            {
                System.out.print("Digite el nombre del curso: ");
                nombre = scanner.nextLine();
                if (MantenimientoCursos.nombreExiste(cursos, nombre)) {
                    System.out.print("El nombre ya existe en la lista, por favor ingrese otro\n");
                }
                else {
                    verificacionNombre = true;
                }
            }
            System.out.print("Digite la cantidad de creditos:");
            String cantidadCreditos = scanner.nextLine();
            Curso curso = new Curso(nombre, Integer.parseInt(cantidadCreditos));
            cursos = MantenimientoCursos.agregar(cursos, curso);
            System.out.println("Curso agregado satisfactoriamente");
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarCurso() {
        Scanner scanner = new Scanner(System.in);
        try {
            boolean verificacionNombre = false;
            String nombre = "";
            while (!verificacionNombre)
            {
                System.out.print("Digite el nombre del curso a modificar: ");
                nombre = scanner.nextLine();
                if (!MantenimientoCursos.nombreExiste(cursos, nombre)) {
                    System.out.print("El nombre no existe en la lista, por favor ingrese uno valido\n");
                }
                else {
                    verificacionNombre = true;
                }
            }

            System.out.print("Digite el nuevo nombre del curso:");
            String nombreNuevo = scanner.nextLine();
            System.out.print("Digite la cantidad de creditos a modificar:");
            String cantidadCreditos = scanner.nextLine();
            Curso nuevoCurso = new Curso(nombreNuevo,Integer.parseInt(cantidadCreditos));
            MantenimientoCursos.modificar(cursos, nombre, nuevoCurso);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eliminarCurso() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso que desea eliminar:");
            String nombre = scanner.nextLine();
            if (MantenimientoCursos.eliminar(cursos, nombre))
            {
                System.out.println("Curso eliminado satisfactoriamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarCurso() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso a consultar (para todos presione Enter):");
            String nombre = scanner.nextLine();
            if (nombre.equals("")) {
                System.out.println("Cursos:\n");
                imprimeCursos();
            }
            else{
                Curso curso = MantenimientoCursos.consultar(cursos, nombre);
                System.out.println("Datos del curso:");
                System.out.println(curso);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void imprimeCursos() {
        System.out.println("----- LISTA CURSOS ------");
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null)
            {
                System.out.println(cursos[i]);
            }
            else {
                break;
            }
        }
    }

    // Carreras
    private void agregarCarrera() {
        Scanner scanner = new Scanner(System.in);
        try {
            String nombre = "";
            boolean verificacionNombre = false;
            while (!verificacionNombre)
            {
                System.out.print("Digite el nombre de la carrera: ");
                nombre = scanner.nextLine();
                if (MantenimientoCarrera.nombreExiste(carreras, nombre)) {
                    System.out.print("El nombre ya existe en la lista, por favor ingrese otro\n");
                }
                else {
                    verificacionNombre = true;
                }
            }

            Carrera carrera = new Carrera(nombre);
            carreras = MantenimientoCarrera.agregar(carreras, carrera);
            System.out.println("Carrera agregada satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarCarrera() {
        Scanner scanner = new Scanner(System.in);
        try {
            String nombre = "";
            boolean verificacionNombre = false;
            while (!verificacionNombre)
            {
                System.out.print("Digite el nombre de la carrera a modificar: ");
                nombre = scanner.nextLine();
                if (!MantenimientoCarrera.nombreExiste(carreras, nombre)) {
                    System.out.print("El nombre no existe en la lista, por favor ingrese uno valido\n");
                }
                else {
                    verificacionNombre = true;
                }
            }
            System.out.print("Digite el nuevo nombre de la carrera:");
            String nombreNuevo = scanner.nextLine();

            Carrera nuevaCarrera = new Carrera(nombreNuevo);

            MantenimientoCarrera.modificar(carreras, nombre, nuevaCarrera);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eliminarCarrera() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera que desea eliminar:");
            String nombre = scanner.nextLine();
            if (MantenimientoCarrera.eliminar(carreras, nombre))
            {
                System.out.println("Carrera eliminada satisfactoriamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarCarrera() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera consultar (para todos presione Enter):");
            String nombre = scanner.nextLine();
            if (nombre.equals("")) {
                System.out.println("Carreras:\n");
                imprimeCarreras();
            }
            else {
                Carrera carrera = MantenimientoCarrera.consultar(carreras, nombre);
                System.out.println("Datos de la carrera:");
                System.out.println(carrera);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void imprimeCarreras() {
        System.out.println("----- LISTA CARRERAS ------");
        for (int i = 0; i < carreras.length; i++) {
            if (carreras[i] != null) {
                System.out.println(carreras[i]);
            }
            else
            {
                break;
            }
        }
    }

    // Profesores
    private void agregarProfesor() {
        Scanner scanner = new Scanner(System.in);
        try {
            String identificacion = "";
            boolean verificacionId = false;
            while (!verificacionId)
            {
                System.out.print("Digite la identificacion del profesor: ");
                identificacion = scanner.nextLine();
                if (Mantenimientos.idExiste(profesores, identificacion)) {
                    System.out.print("El id ya existe en la lista, por favor ingrese otro\n");
                }
                else {
                    verificacionId = true;
                }
            }
            System.out.print("Digite el nombre del profesor:");
            String nombre = scanner.nextLine();
            boolean verificacionFecha = false;
            LocalDate fechaNacimiento = LocalDate.now();

            while (!verificacionFecha) {
                System.out.print("Digite la fecha de nacimiento del profesor (ej 1953-01-30):");
                String fecha = scanner.nextLine();
                try{
                    fechaNacimiento = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
                    verificacionFecha = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha con mal formato, por favor digitela de nuevo\n");
                }
            }

            System.out.print("Digite el id de empleado del profesor:");
            String idEmpleado = scanner.nextLine();

            Profesor profesor = new Profesor(identificacion, nombre, fechaNacimiento, idEmpleado);
            profesores = Mantenimientos.agregar(profesores, profesor);
            System.out.println("Curso agregado satisfactoriamente");
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarProfesor() {
        Scanner scanner = new Scanner(System.in);
        try {
            String identificacion = "";
            boolean verificacionId = false;
            while (!verificacionId)
            {
                System.out.print("Digite la identificacion del profesor a modificar: ");
                identificacion = scanner.nextLine();
                if (!Mantenimientos.idExiste(profesores, identificacion)) {
                    System.out.print("El id no existe en la lista, por favor ingrese uno valido\n");
                }
                else {
                    verificacionId = true;
                }
            }
            System.out.print("Digite el nuevo nombre del profesor:");
            String nombreNuevo = scanner.nextLine();
            boolean verificacionFecha = false;
            LocalDate fechaNacimiento = LocalDate.now();

            while (!verificacionFecha) {
                System.out.print("Digite la nueva fecha de nacimiento del profesor (ej 1953-01-30):");
                String fecha = scanner.nextLine();
                try{
                    LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
                    verificacionFecha = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha con mal formato, por favor digitela de nuevo\n");
                }
            }

            System.out.print("Digite el nuevo id de empleado del profesor:");
            String idEmpleado = scanner.nextLine();
            Profesor profesor = new Profesor(identificacion, nombreNuevo, fechaNacimiento, idEmpleado);
            Mantenimientos.modificar(profesores, identificacion, profesor);
            System.out.println("Profesor agregado satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eliminarProfesor() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite la identificacion del profesor que desea eliminar:");
            String identificacion = scanner.nextLine();
            if (Mantenimientos.eliminar(profesores, identificacion))
            {
                System.out.println("Profesor eliminado satisfactoriamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarProfesor() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite la identificacion del profesor a consultar (para todos presione Enter):");
            String identificacion = scanner.nextLine();
            if (identificacion.equals("")) {
                System.out.println("Profesores:\n");
                imprimeProfesores();
            }
            else{
                Profesor profesor = (Profesor) Mantenimientos.consultar(profesores, identificacion);
                System.out.println("Datos del profesor:");
                System.out.println(profesor);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void imprimeProfesores() {
        System.out.println("----- LISTA PROFESORES ------");
        for (int i = 0; i < profesores.length; i++) {
            if (profesores[i] != null)
            {
                System.out.println(profesores[i]);
            }
            else {
                break;
            }
        }
    }

    // Estudiantes
    private void agregarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        try {
            String identificacion = "";
            boolean verificacionId = false;
            while (!verificacionId)
            {
                System.out.print("Digite la identificacion del estudiante: ");
                identificacion = scanner.nextLine();
                if (Mantenimientos.idExiste(estudiantes, identificacion)) {
                    System.out.print("El id ya existe en la lista, por favor ingrese otro\n");
                }
                else {
                    verificacionId = true;
                }
            }
            System.out.print("Digite el nombre del estudiante:");
            String nombre = scanner.nextLine();
            boolean verificacionFecha = false;
            LocalDate fechaNacimiento = LocalDate.now();

            while (!verificacionFecha) {
                System.out.print("Digite la fecha de nacimiento del estudiante (ej 1953-01-30):");
                String fecha = scanner.nextLine();
                try{
                    fechaNacimiento = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
                    verificacionFecha = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha con mal formato, por favor digitela de nuevo\n");
                }
            }

            System.out.print("Digite el carnet del estudiante:");
            String carnet = scanner.nextLine();

            Estudiante estudiante = new Estudiante(identificacion, nombre, fechaNacimiento, carnet);
            estudiantes = Mantenimientos.agregar(estudiantes, estudiante);
            System.out.println("Estudiante agregado satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        try {
            String identificacion = "";
            boolean verificacionId = false;
            while (!verificacionId)
            {
                System.out.print("Digite la identificacion del estudiante a modificar: ");
                identificacion = scanner.nextLine();
                if (!Mantenimientos.idExiste(estudiantes, identificacion)) {
                    System.out.print("El id no existe en la lista, por favor ingrese uno valido\n");
                }
                else {
                    verificacionId = true;
                }
            }
            System.out.print("Digite el nuevo nombre del estudiante:");
            String nombreNuevo = scanner.nextLine();
            boolean verificacionFecha = false;
            LocalDate fechaNacimiento = LocalDate.now();

            while (!verificacionFecha) {
                System.out.print("Digite la nueva fecha de nacimiento del estudiante (ej 1953-01-30):");
                String fecha = scanner.nextLine();
                try{
                    LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
                    verificacionFecha = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha con mal formato, por favor digitela de nuevo\n");
                }
            }

            System.out.print("Digite el nuevo carnet del estudiante:");
            String carnet = scanner.nextLine();
            Estudiante estudiante = new Estudiante(identificacion, nombreNuevo, fechaNacimiento, carnet);
            Mantenimientos.modificar(estudiantes, identificacion, estudiante);
            System.out.println("Estudiante agregado satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eliminarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite la identificacion del estudiante que desea eliminar:");
            String identificacion = scanner.nextLine();
            if (Mantenimientos.eliminar(estudiantes, identificacion))
            {
                System.out.println("Estudiante eliminado satisfactoriamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite la identificacion del estudiante a consultar (para todos presione Enter):");
            String identificacion = scanner.nextLine();
            if (identificacion.equals("")) {
                System.out.println("Estudiantes:\n");
                imprimeEstudiantes();
            }
            else{
                Estudiante estudiante = (Estudiante) Mantenimientos.consultar(estudiantes, identificacion);
                System.out.println("Datos del estudiante:");
                System.out.println(estudiante);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void imprimeEstudiantes() {
        System.out.println("----- LISTA ESTUDIANTES ------");
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                System.out.println(estudiantes[i]);
            }
            else {
                break;
            }
        }
    }

    // Asignaciones
    private void subMenuAsignaciones(int operador) {
        Scanner scanner01 = new Scanner(System.in);
        boolean continua = true;
        while (continua) {
            System.out.println("-------------------SubMenu--------------------");
            System.out.println("Seleccione una opcion");
            System.out.println("1-Asignar");
            System.out.println("2-Quitar");
            System.out.println("3-Salir");
            System.out.println("----------------------------------------------");
            String operacion = scanner01.nextLine();
            int operadorSubMenu = 0;
            try {
                operadorSubMenu = Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                operadorSubMenu = -1;
            }
            switch (operadorSubMenu) {
                case 1:
                    asignar(operador);
                    break;
                case 2:
                    quitar(operador);
                    break;
                case 3:
                    System.out.println("Saliendo del submenu");
                    continua = false;
                    break;
                default:
                    System.out.println("Opcion invalida, digite de nuevo la opcion\n");
                    break;
            }
        }
    }

    private void asignar(int operador) {
        switch (operador)
        {
            case 5:
                asignarQuitarCarreraProfesor(false);
                break;
            case 6:
                asignarQuitarCarreraEstudiante(false);
                break;
            case 7:
                asignarQuitarDirectorCarrera(false);
                break;
            case 8:
                asignarQuitarCursoEstudiante(false);
                break;
            default:
                break;
        }
    }

    private void quitar(int operador) {
        switch (operador)
        {
            case 5:
                asignarQuitarCarreraProfesor(true);
                break;
            case 6:
                asignarQuitarCarreraEstudiante(true);
                break;
            case 7:
                asignarQuitarDirectorCarrera(true);
                break;
            case 8:
                asignarQuitarCursoEstudiante(true);
                break;
            default:
                break;
        }
    }

    private void asignarQuitarCarreraProfesor(boolean quitar) {
        try {
            Carrera carrera = buscaCarrera();
            Profesor profesor = buscaProfesor();
            if (carrera == null || profesor == null){
                // El usuario aborto la asignacion
                return;
            }
            if (quitar) {
                MantenimientoCarrera.eliminar(profesor.getCarreras(), carrera.getNombre());
            }
            else {
                MantenimientoCarrera.agregar(profesor.getCarreras(), carrera);
            }
            System.out.println("Operacion realizada satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void asignarQuitarCarreraEstudiante(boolean quitar) {
        try {
            Carrera carrera = buscaCarrera();
            Estudiante estudiante = buscaEstudiante();
            if (carrera == null || estudiante == null){
                // El usuario aborto la asignacion
                return;
            }
            if (quitar) {
                MantenimientoCarrera.eliminar(estudiante.getCarreras(), carrera.getNombre());
            }
            else {
                MantenimientoCarrera.agregar(estudiante.getCarreras(), carrera);
            }
            System.out.println("Operacion realizada satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void asignarQuitarDirectorCarrera(boolean quitar) {
        Profesor director = buscaProfesor();
        Carrera carrera = buscaCarrera();

        if (director == null || carrera == null) {
            // El usuario aborto la accion
            return;
        }

        if (quitar) {
            carrera.setDirector(null);
        }
        else {
            carrera.setDirector(director);
        }
        System.out.println("Operacion realizada satisfactoriamente");
    }

    private void asignarQuitarCursoEstudiante(boolean quitar) {
        try {
            Curso curso = buscaCurso();
            Estudiante estudiante = buscaEstudiante();
            if (curso == null || estudiante == null){
                // El usuario aborto la asignacion
                return;
            }
            if (quitar)
            {
                MantenimientoCursos.eliminar(estudiante.getCursos(), curso.getNombre());
            }
            else {
                MantenimientoCursos.agregar(estudiante.getCursos(), curso);
            }
            System.out.println("Operacion realizada satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Carrera buscaCarrera() {
        String nombre = "";
        boolean verificacion = false;
        Scanner scanner01 = new Scanner(System.in);
        imprimeCarreras();
        while (!verificacion)
        {
            System.out.println("De la lista anterior digite el nombre de la carrera (Enter para abortar)\n");
            nombre = scanner01.nextLine();
            if (nombre.equals(""))
            {
                return null;
            }
            if (!MantenimientoCarrera.nombreExiste(carreras, nombre)) {
                System.out.print("El nombre no existe en la lista, por favor ingrese uno valido\n");
            }
            else {
                verificacion = true;
            }
        }
        return carreras[MantenimientoCarrera.buscarDato(carreras, nombre)];
    }

    private Profesor buscaProfesor() {
        String identificacion = "";
        Scanner scanner01 = new Scanner(System.in);
        boolean verificacion = false;

        imprimeProfesores();
        while (!verificacion)
        {
            System.out.print("De la lista anterior digite el id del profesor (Enter para abortar)\n");
            identificacion = scanner01.nextLine();
            if (identificacion.equals("")) {
                return null;
            }
            if (!Mantenimientos.idExiste(profesores, identificacion)) {
                System.out.print("El id no existe en la lista, por favor ingrese uno valido\n");
            }
            else {
                verificacion = true;
            }
        }
        return (Profesor) profesores[Mantenimientos.buscarDato(profesores, identificacion)];
    }

    private Estudiante buscaEstudiante() {
        String identificacion = "";
        Scanner scanner01 = new Scanner(System.in);
        boolean verificacion = false;

        imprimeEstudiantes();
        while (!verificacion)
        {
            System.out.print("De la lista anterior digite el id del estudiante (Enter para abortar)\n");
            identificacion = scanner01.nextLine();
            if (identificacion.equals(""))
            {
                return null;
            }
            if (!Mantenimientos.idExiste(estudiantes, identificacion)) {
                System.out.print("El id no existe en la lista, por favor ingrese uno valido\n");
            }
            else {
                verificacion = true;
            }
        }
        return (Estudiante) estudiantes[Mantenimientos.buscarDato(estudiantes, identificacion)];
    }

    private Curso buscaCurso() {
        String nombre = "";
        Scanner scanner01 = new Scanner(System.in);
        boolean verificacion = false;

        imprimeCursos();
        while (!verificacion)
        {
            System.out.println("De la lista anterior digite el nombre del curso (Enter para abortar)\n");
            nombre = scanner01.nextLine();
            if (nombre.equals(""))
            {
                return null;
            }
            if (!MantenimientoCursos.nombreExiste(cursos, nombre)) {
                System.out.print("El nombre no existe en la lista, por favor ingrese uno valido\n");
            }
            else {
                verificacion = true;
            }
        }
        return cursos[MantenimientoCursos.buscarDato(cursos, nombre)];
    }

    // Lista estudiantes por curso
    private void generarListaEstudiantesPorCurso() {
        // pseudo codigo
        // cursoAImprimir = buscarCurso();
        // resultado = "";
        // por cada estudiante en estudiantes mientras estudiante no sea nulo
        // {
        //      por cada curso en estudiante.cursos mientras curso no sea nulo
        //      {
        //          si cursoAImprimir es igual a curso
        //          {
        //              resultado += estudiante
        //              break;
        //          }
        //      }
        // }
        //
        // imprime en consola resultado
    }
}
