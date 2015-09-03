/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import groovyjarjarasm.asm.Opcodes;
import java.util.ArrayList;

/**
 *
 * @author gcudcop
 */
public class TestMesesDias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> lst = new ArrayList<String>();
        lst = MesesDias.obtenerMeses();
        
        for (int i=0;i<lst.size();i++){
            System.out.println(lst.get(i));
        }
            
    }
    
}
