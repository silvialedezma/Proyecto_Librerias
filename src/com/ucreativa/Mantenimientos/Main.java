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

    private Profesor[] profesores = new Profesor[20];
    private Carrera[] carrera = new Carrera[20];
    private Curso[] curso = new Curso[20];
    private Mantenimientos cursos = new Mantenimientos();
    private Estudiante[] estudiantes = new Estudiante[20];

    //MENU PRINCIPAL
    public static void main(String[] args) {
        Main inicio = new Main();
        Submenus submenu = new Submenus(inicio);
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("----------------Menu Principal----------------");         
            System.out.println("1-Cursos");
            System.out.println("2-Carreras");
            System.out.println("3-Profesores");
            System.out.println("4-Estudiante");
            System.out.println("5-Salir");
            System.out.println("----------------------------------------------");
            System.out.println("Seleccione una opcion:");
            String operacion = scanner.nextLine();
            int operador = -1;
            try {
                operador = Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
            }
            switch (operador) {
                case 1:
                    submenu.subMenuCurso();
                    break;
                case 2:
                    submenu.subMenuCarreras();
                    break;
                case 3:
                    submenu.subMenuProfesor();
                    break;
                case 4:
                    submenu.subMenuEstudiante();
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

//MANTENIMIENTO DE CURSOS
    public void agregarCurso() {

        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso:\n");
            String nombre = scanner01.nextLine();
            System.out.print("Digite la cantidad de creditos:\n");
            String cred = scanner01.nextLine();
            Curso newCurso = new Curso();
            newCurso.setNombre(nombre.toLowerCase());
            newCurso.setCreditos(Integer.parseInt(cred));
            MantenimientoCursos mantCurso = new MantenimientoCursos();
            mantCurso.agregarCurso(curso, newCurso);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

    public void consultarCurso() {

        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso a consultar:\n");
            String nombreCurso = scanner01.nextLine();           
            Curso newCurso = new Curso();
            newCurso.setNombre(nombreCurso.toLowerCase());
            MantenimientoCursos mantCurso = new MantenimientoCursos();
            mantCurso.consultarCurso(curso, nombreCurso);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

    public void modificarCurso() {
        Scanner scanner03 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso a modificar:\n");
            String nombre = scanner03.nextLine();
            System.out.print("Digite el nuevo nombre del curso:\n");
            String nombreNuevo = scanner03.nextLine();
            System.out.print("Digite la cantidad de creditos a modificar:\n");
            String cred = scanner03.nextLine();
            Curso newCurso = new Curso();
            newCurso.setNombre(nombreNuevo.toLowerCase());
            newCurso.setCreditos(Integer.parseInt(cred));
            MantenimientoCursos mantCurso = new MantenimientoCursos();
            mantCurso.modificarCurso(curso, nombre, newCurso);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

    public void eliminarCurso() {
        Scanner scanner02 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre del curso que desea eliminar:\n");
            String nombreCurso = scanner02.nextLine();
            Curso newCurso = new Curso();
            newCurso.setNombre(nombreCurso.toLowerCase());
            MantenimientoCursos mantCurso = new MantenimientoCursos();
            mantCurso.eliminarCurso(curso, newCurso);
            scanner02.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

//MANTENIMIENTO DE CARRERAS
    public void agregarCarrera() {
        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera a agregar:\n");
            String nombre = scanner01.nextLine();
            Carrera nuevaCarrera = new Carrera();
            nuevaCarrera.setNombre(nombre.toLowerCase());
            MantenimientoCarrera mantCarrera = new MantenimientoCarrera();
            Profesor director=new Profesor();
            mantCarrera.agregarCarrera(carrera, nuevaCarrera);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

    public void consultarCarrera() {
        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera a consultar:\n");
            String nombreCarrera = scanner01.nextLine();
            Carrera nuevaCarrera = new Carrera();
            nuevaCarrera.setNombre(nombreCarrera.toLowerCase());
            MantenimientoCarrera mantCarrera = new MantenimientoCarrera();
            mantCarrera.consultarCarrera(carrera, nombreCarrera.toLowerCase());
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

    public void modificarCarrera() {
        Scanner scanner03 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera a modificar:\n");
            String nombre = scanner03.nextLine();
            System.out.print("Digite el nuevo nombre:\n");
            String nuevoNombre = scanner03.nextLine();
            Carrera nuevaCarrera = new Carrera();
            nuevaCarrera.setNombre(nuevoNombre.toLowerCase());
            MantenimientoCarrera mantCarrera = new MantenimientoCarrera();
            mantCarrera.modificarCarrera(carrera, nombre, nuevaCarrera);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

    public void eliminarCarrera() {
        Scanner scanner02 = new Scanner(System.in);
        try {
            System.out.print("Digite el nombre de la carrera que desea eliminar:\n");
            String nombreCarrera = scanner02.nextLine();
            Carrera nuevaCarrera = new Carrera();
            nuevaCarrera.setNombre(nombreCarrera.toLowerCase());
            MantenimientoCarrera mantCarrera = new MantenimientoCarrera();
            mantCarrera.eliminarCarrera(carrera, nuevaCarrera);
            scanner02.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

//MANTENIMIENTO DE ESTUDIANTES
    public void agregarEstudiante() {
        String cedula = "";
        String nombre = "";
        String carnet = "";
        Scanner scanner01 = new Scanner(System.in);
        boolean verificacionCed = false;
        while (!verificacionCed) {
            System.out.println("Ingrese la cedula del estudiante a registrar:\n");
            cedula = scanner01.nextLine();
            if (cedula != "") {
                verificacionCed = true;
            } else {
                System.out.println("Cedula no puede estar vacia");
            }
        }
        boolean verificacionNom = false;
        while (!verificacionNom) {
            System.out.println("Digite el nombre del estudiante:\n");
            nombre = scanner01.nextLine();
            if (nombre != "") {
                verificacionNom = true;
            } else {
                System.out.println("Nombre no puede estar vacio");
            }
        }
        LocalDate fechaNacimiento = LocalDate.now();
        boolean verificacionFecha = false;
        while (!verificacionFecha) {
            System.out.print("Digite la fecha de nacimiento del estudiante (ej 1953-01-30):\n");
            String fecha = scanner01.nextLine();
            try {
                LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
                verificacionFecha = true;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha con mal formato, por favor digitela de nuevo\n");
            }
        }
        boolean verificacionCarnet = false;
        while (!verificacionCarnet) {
            System.out.println("Digite el numero de Carnet:\n");
            carnet = scanner01.nextLine();
            if (carnet != "") {
                verificacionCarnet = true;
            } else {
                System.out.println("Carnet puede estar vacio");
            }
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setIdentificacion(cedula.toLowerCase());
        estudiante.setNombre(nombre.toLowerCase());
        estudiante.setFechaNacimiento(fechaNacimiento);
        estudiante.setCarnet(carnet.toLowerCase());
        estudiante.setCarreras(new Carrera[20]);
        estudiante.setCursos(new Curso[20]);
        Mantenimientos.agregarPersona(estudiantes, estudiante);

    }

    public void consultarEstudiante() {

        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite la cedula del estudiante a consultar:\n");
            String cedula = scanner01.nextLine();
            Estudiante estudiante = new Estudiante();
            estudiante.setIdentificacion(cedula.toLowerCase());
            Mantenimientos.consultarPersona(estudiantes, cedula);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

    public void ModificarEstudiante() {
        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite la cedula del estudiantes a actualizar:\n");
            String cedEstudiante = scanner01.nextLine();
            Estudiante estudiante = new Estudiante();
            System.out.println("Digite el nombre:\n");
            String nombre = scanner01.nextLine();
            LocalDate fechaNacimiento = LocalDate.now();
            boolean verificacionFecha = false;
            while (!verificacionFecha) {
                System.out.print("Digite la nueva fecha de nacimiento del profesor (ej 1953-01-30):\n");
                String fecha = scanner01.nextLine();
                try {
                    LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
                    verificacionFecha = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha con mal formato, por favor digitela de nuevo\n");
                }
            }
            System.out.println("Digite el numero de Carnet:\n");
            String carnet = scanner01.nextLine();
            estudiante.setIdentificacion(cedEstudiante.toLowerCase());
            estudiante.setNombre(nombre.toLowerCase());
            estudiante.setCarnet(carnet.toLowerCase());
            estudiante.setFechaNacimiento(fechaNacimiento);
            Mantenimientos.modificarPersona(estudiantes, cedEstudiante, estudiante);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

    public void eliminarEstudiante() {
        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.println("Ingrese la cedula a eliminar:\n");
            String cedula = scanner01.nextLine();
            Estudiante estudiante = new Estudiante();
            estudiante.setIdentificacion(cedula);
            Mantenimientos.eliminarPersona(estudiantes, cedula);
        } catch (NumberFormatException e) {
            System.out.println("Cedula debe ser numerica\n");
        }
    }

//MANTENIMIENTO DE PROFESOR
    public void agregarProfesor() {
        Scanner scanner01 = new Scanner(System.in);

        try {
            System.out.println("Ingrese la cedula del profesor a registrar:\n");
            String cedula = scanner01.nextLine();
            System.out.println("Digite el nombre:\n");
            String nombre = scanner01.nextLine();
            LocalDate fechaNacimiento = LocalDate.now();
            boolean verificacionFecha = false;
            while (!verificacionFecha) {
                System.out.print("Digite la nueva fecha de nacimiento del profesor (ej 1953-01-30):\n");
                String fecha = scanner01.nextLine();
                try {
                    LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
                    verificacionFecha = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha con mal formato, por favor digitela de nuevo\n");
                }
            }
            System.out.println("Digite el ID de empleado:\n");
            String idEmpleado = scanner01.nextLine();
            Profesor profesor = new Profesor();
            profesor.setIdentificacion(cedula);
            profesor.setNombre(nombre);
            profesor.setFechaNacimiento(fechaNacimiento);
            profesor.setIdEmpleado(idEmpleado);
            profesor.setCarreras(new Carrera[20]);
            Mantenimientos.agregarPersona(profesores, profesor);
        } catch (NumberFormatException e) {
            System.out.println("Cedula debe ser numerica\n");
        }
    }

    public void consultarProfesor() {
        Scanner scanner01 = new Scanner(System.in);

        try {
            System.out.println("Ingrese la cedula del profesor a consultar:\n");
            String cedula = scanner01.nextLine();
            Profesor profesor = new Profesor();
            profesor.setIdentificacion(cedula);
            Mantenimientos.consultarPersona(profesores, cedula);
        } catch (NumberFormatException e) {
            System.out.println("Cedula debe ser numerica\n");
        }
    }

    public void ModificarProfesor() {
        Scanner scanner01 = new Scanner(System.in);
        try {
            System.out.print("Digite la cedula del Profesor a actualizar:\n");
            String cedEstudiante = scanner01.nextLine();
            Profesor profesor = new Profesor();
            System.out.println("Digite el nombre del profesor:\n");
            String nombre = scanner01.nextLine();
            LocalDate fechaNacimiento = LocalDate.now();
            boolean verificacionFecha = false;
            while (!verificacionFecha) {
                System.out.print("Digite la nueva fecha de nacimiento del profesor (ej 1953-01-30):\n");
                String fecha = scanner01.nextLine();
                try {
                    LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
                    verificacionFecha = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha con mal formato, por favor digitela de nuevo\n");
                }
            }
            System.out.println("Digite el id de empleado a actualizar:\n");
            String id = scanner01.nextLine();
            profesor.setIdentificacion(cedEstudiante);
            profesor.setNombre(nombre);
            profesor.setFechaNacimiento(fechaNacimiento);
            profesor.setIdEmpleado(id);
            Mantenimientos.modificarPersona(profesores, id, profesor);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto, intente de nuevo\n");
        }
    }

    public void eliminarProfesor() {
        Scanner scanner01 = new Scanner(System.in);

        try {
            System.out.println("Ingrese la cedula del profesor a eliminar:\n");
            String cedula = scanner01.nextLine();
            Profesor profesor = new Profesor();
            profesor.setIdentificacion(cedula);
            Mantenimientos.eliminarPersona(profesores, cedula);
        } catch (NumberFormatException e) {
            System.out.println("Cedula debe ser numerica\n");
        }
    }
//ASIGNAR O QUITAR UNA O VARIAS CARRERAS A UN ESTUDIANTE

    public void asignarQuitarCarreraEstudiante(boolean quitar) {
        try {
            Carrera datoCarrera = buscaCarrera();
            if (datoCarrera == null)
            {
                // El usuario aborto la asignacion
                return;
            }
            Estudiante estudiante = buscaEstudiante();
            if (estudiante == null) {
                // El usuario aborto la asignacion
                return;
            }
            if (quitar) {
                MantenimientoCarrera.eliminarCarrera(estudiante.getCarreras(), datoCarrera);
            } else {
                MantenimientoCarrera.agregarCarrera(estudiante.getCarreras(),datoCarrera);
            }
            System.out.println("Operacion realizada satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private Carrera buscaCarrera() {
        Carrera dato = null;
        String nombre = "";
        boolean verificacion = false;
        Scanner scanner01 = new Scanner(System.in);
        if(imprimeCarreras()){
        System.out.println("No existen carreras registradas");
        }
        while (!verificacion) {            
                System.out.println("De la lista anterior digite el nombre de la carrera (Enter para abortar)\n");
                nombre = scanner01.nextLine();
                if (nombre.equals("")) {
                    return null;
                }
                dato = MantenimientoCarrera.buscarDato(carrera, nombre);
                if (dato == null) {
                    System.out.print("El nombre no existe en la lista, por favor ingrese uno valido\n");
                } else {
                    verificacion = true;
                }
            }
        return dato;
    }

    private Estudiante buscaEstudiante() {
        String identificacion = "";
        Estudiante estudiante=null;
        Scanner scanner01 = new Scanner(System.in);
        boolean verificacion = false;
        imprimeEstudiantes();
        while (!verificacion) {
            System.out.print("De la lista anterior digite el id del estudiante (Enter para abortar)\n");
            identificacion = scanner01.nextLine();
            if (identificacion.equals("")) {
                return null;
            }
            estudiante=(Estudiante)Mantenimientos.buscarDato(estudiantes, identificacion);
            if (estudiante==null) {
                System.out.print("El id no existe en la lista, por favor ingrese uno valido\n");
            } else {
                verificacion = true;
            }
        }
                
        return estudiante;
    }    
    
//ASIGNAR O QUITAR UNA O VARIOS CURSOS A UN ESTUDIANTE

    public void asignarQuitarCursoEstudiante(boolean quitar) {
        try {
            Curso datoCurso = buscaCurso();
            if (datoCurso == null)
            {
                // El usuario aborto la asignacion
                return;
            }
            Estudiante estudiante = buscaEstudiante();
            if (estudiante == null) {
                // El usuario aborto la asignacion
                return;
            }
            if (quitar) {
                MantenimientoCursos.eliminarCurso(estudiante.getCursos(), datoCurso);
            } else {
                MantenimientoCursos.agregarCurso(estudiante.getCursos(),datoCurso);
            }
            System.out.println("Operacion realizada satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private Curso buscaCurso() {
        Curso dato = null;
        String nombre = "";
        boolean verificacion = false;
        Scanner scanner01 = new Scanner(System.in);
        if(imprimeCursos()){
        System.out.println("No existen cursos registrad0s");
        }
        while (!verificacion) {            
                System.out.println("De la lista anterior digite el nombre del curso (Enter para abortar)\n");
                nombre = scanner01.nextLine();
                if (nombre.equals("")) {
                    return null;
                }
                dato = MantenimientoCursos.buscarDato(curso, nombre);
                if (dato == null) {
                    System.out.print("El nombre no existe en la lista, por favor ingrese uno valido\n");
                } else {
                    verificacion = true;
                }
            }
        return dato;
    }
    
        //ASIGNAR O QUITAR CARRERAS A UN PROFESOR
    private Profesor buscaProfesor() {
        String identificacion = "";
        Profesor profesor=null;
        Scanner scanner01 = new Scanner(System.in);
        boolean verificacion = false;
        imprimeProfesores();
        while (!verificacion) {
            System.out.print("De la lista anterior digite el id del profesor (Enter para abortar)\n");
            identificacion = scanner01.nextLine();
            if (identificacion.equals("")) {
                return null;
            }
            profesor=(Profesor)Mantenimientos.buscarDato(profesores, identificacion);
            if (profesor==null) {
                System.out.print("El id no existe en la lista, por favor ingrese uno valido\n");
            } else {
                verificacion = true;
            }
        }
        return profesor;
    }   
       
    public void asignarQuitarCarreraProfesor(boolean quitar) {
        try {
            Carrera datoCarrera = buscaCarrera();
            if (datoCarrera == null)
            {
                // El usuario aborto la asignacion
                return;
            }
            Profesor profesor = buscaProfesor();
            if (profesor == null) {
                // El usuario aborto la asignacion
                return;
            }
            if (quitar) {
                MantenimientoCarrera.eliminarCarrera(profesor.getCarreras(), datoCarrera);
            } else {
                MantenimientoCarrera.agregarCarrera(profesor.getCarreras(),datoCarrera);
            }
            System.out.println("Operacion realizada satisfactoriamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void asignarQuitarProfesorDirectorCarrera(boolean quitar){
        try{
            Carrera datoCarrera=buscaCarrera();
            if (datoCarrera == null)
            {
                return;
            }
            Profesor director = buscaProfesor();
            if(director==null){
                    return; 
            }
            if(quitar){
                    datoCarrera.setDirector(null);
            }else {                
                datoCarrera.setDirector(director);
                datoCarrera.toString();
            }
            
            System.out.println("Operacion realizada satisfactoriamente");
            
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
    }
    
    
   //GENERAR LISTA DE ESTUDIANTES MATRICULADOS A UN CURSO
    public void generarListaEstudiantesCurso() {

        Curso cursoAImprimir = buscaCurso();
        String listaEstudiantes = "";
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                Curso[] cursoEstudiantes = estudiantes[i].getCursos();
                for (int j = 0; j < cursoEstudiantes.length; j++) {
                    if (cursoEstudiantes[j] != null) {
                        if (cursoAImprimir.equals(cursoEstudiantes[j])) {
                            listaEstudiantes += estudiantes[i] + "\n";
                            break;
                        }
                    }

                }
            }
            System.out.println(listaEstudiantes);
        }
    }

    //IMPRIMIR LISTA DE ESTUDIANTES,CURSOS,CARRERAS
    private void imprimeEstudiantes() {
        System.out.println("----- LISTA ESTUDIANTES ------");
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                System.out.println(estudiantes[i]);
            }
        }
    }

    private boolean imprimeCursos() {
        boolean vacio=true;
        System.out.println("----- LISTA CURSOS ------");
        for (int i = 0; i < curso.length; i++) {
            if (curso[i] != null) {
                vacio=false;
                System.out.println(curso[i]);
            }
        }
        return vacio;
    }

       private boolean imprimeCarreras() {
        boolean vacio=true;        
        System.out.println("----- LISTA Carreras ------");
        for (int i = 0; i < carrera.length; i++) {
            if (carrera[i] != null) {
                vacio = false;
                System.out.println(carrera[i]);
            }
        }
        return vacio;
    }
    
     //Imprimir Profesores
     private void imprimeProfesores(){
           System.out.println("----- LISTA PROFESORES ------");
           for(int i=0;i< profesores.length;i++){
               if(profesores[i] !=null){
                   System.out.println(profesores[i]);
               }
           }
     }
}
