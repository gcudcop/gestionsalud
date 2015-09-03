/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.util.ArrayList;

/**
 *
 * @author gcudcop
 */
public class MesesDias {

    public static ArrayList<String> obtenerMeses() {
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("ENERO");
        lst.add("FEBRERO");
        lst.add("MARZO");
        lst.add("ABRIL");
        lst.add("MAYO");
        lst.add("JUNIO");
        lst.add("JULIO");
        lst.add("AGOSTO");
        lst.add("SEPTIEMBRE");
        lst.add("OCTUBRE");
        lst.add("NOVIEMBRE");
        lst.add("DICIEMBRE");
        return lst;
    }

    public static ArrayList<String> obtenerDias() {
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("LUNES");
        lst.add("MARTES");
        lst.add("MIERCOLES");
        lst.add("JUEVES");
        lst.add("VIERNES");
        lst.add("SABADO");
        lst.add("DOMINGO");        
        return lst;
    }
    
    
}
