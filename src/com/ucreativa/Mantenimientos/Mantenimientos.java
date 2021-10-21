package com.ucreativa.Mantenimientos;
import com.ucreativa.personas.*;
import com.ucreativa.universidad.*;

/**
 *
 * @author silvi
 */
public class Mantenimientos {

    public static void agregar(Persona[] persona, Persona registro) {
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] == null) {
                persona[i] = registro;
                System.out.println("Se ha agregado el registro " + registro + "satisfactoriamente");
                break;
            } else {
                System.out.println("No se puede ingresar mas registros");
            }
        }
    }

    public static void eliminar(Persona[] persona, Persona registro) {
        boolean recordfound = true;
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] != null && persona[i] == registro) {
                recordfound = true;
                persona[i] = null;
                System.out.println("Se ha eliminado el registro " + registro + "satisfactoriamente");
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("El registro no existe");
        }
    }

    public static void eliminar(Persona[] persona, String identificacion) {
        boolean recordfound = true;
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] != null && persona[i].getIdentificacion() == identificacion) {
                recordfound = true;
                persona[i] = null;
                System.out.println("Registro eliminado " + identificacion + "satisfactoriamente");
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("El registro no existe");
        }
    }

    public static void modificar(Persona[] persona, Persona registroActual, Persona registroNuevo) {
        boolean recordfound = true;
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] != null && persona[i] == registroActual) {
                recordfound = true;
                persona[i] = registroNuevo;
                System.out.println("Registro modificado" + registroActual + "satisfactoriamente");
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("El registro no existe");
        }
    }

    public static void modificar(Persona[] persona, String identificacionActual, Persona identificacionNueva) {
        boolean recordfound = true;
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] != null && persona[i].getIdentificacion() == identificacionActual) {
                recordfound = true;
                persona[i] = identificacionNueva;
                System.out.println("Registro modificado" + identificacionActual + "satisfactoriamente");
                break;
            } else {
                recordfound = false;
            }
        }
        if (recordfound == false) {
            System.out.println("El registro no existe");
        }
    }

    public static Persona consultar(Persona[] persona, String identificacionActual) {
        for (int i = 0; i < persona.length; i++) {
            if (persona[i] != null && persona[i].getIdentificacion() == identificacionActual) {
                return persona[i];
            }
        }
        return null;
    }
}
