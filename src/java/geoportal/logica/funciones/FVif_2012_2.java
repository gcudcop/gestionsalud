/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoportal.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import geoportal.logica.clases.Vif_2012_2;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oscunach
 */
public class FVif_2012_2 {
    
    public static ArrayList<Vif_2012_2> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Vif_2012_2> lst = new ArrayList<Vif_2012_2>();
        Vif_2012_2 datos = null;
        try {
            while (rs.next()) {
                datos = new Vif_2012_2(rs.getDate("pfecha_denuncia"),
                        rs.getString("pdenunciante"),
                        rs.getString("pvictima"),
                        rs.getString("psexo_victima"),
                        rs.getString("pdireccion_victima"),
                        rs.getDouble("px"),
                        rs.getDouble("py"),
                        rs.getString("pcircuito"),
                        rs.getString("pcodigo_circuito"),
                        rs.getString("psubcircuito"),
                        rs.getString("pcodigo_subcircuito"),
                        rs.getString("pdomiciliado_victima"),
                        rs.getInt("pedad_victima"),
                        rs.getString("pestado_civil_victima"),
                        rs.getString("pnivel_de_instruccion_victima"),
                        rs.getString("pocupacion"),
                        rs.getString("pagresor"),
                        rs.getString("psexo_agresor"),
                        rs.getString("pdireccion_agresor"),
                        rs.getString("pedad_agresor"),
                        rs.getString("pdomiciliado_agresor"),
                        rs.getString("pestado_civil_agresor"),
                        rs.getString("pnivel_de_instruccion_agresor"),
                        rs.getString("pocupacion_agresor"),
                        rs.getString("pparentesco_victima_agresor"),
                        rs.getString("pnumero_hijos_comun"),
                        rs.getString("plugar_agresion"),
                        rs.getString("ptipo_de_violencia"),
                        rs.getDate("pfecha_agresion"),
                        rs.getString("phora_de_agresion"),
                        rs.getString("pmedidas_de_amparo"),
                        rs.getString("psentencia"),
                        rs.getString("papelacion"),
                        rs.getString("pboletas_anteriores"),
                        rs.getString("pobservaciones"),                        
                        rs.getInt("pid")
                );
                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Vif_2012_2> ObtenerDatos() throws Exception {
        ArrayList<Vif_2012_2> lst = new ArrayList<Vif_2012_2>();
        try {
            String sql = "select * from geoportal.f_select_vif_2012_2()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }    
    
    public static ArrayList<Vif_2012_2> ObtenerDatosDadoParentesco(String parentesco) throws Exception {
        ArrayList<Vif_2012_2> lst = new ArrayList<Vif_2012_2>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_vif_2012_2_dado_parentesco(?)";
            lstP.add(new Parametro(1, parentesco));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
    public static ArrayList<Vif_2012_2> ObtenerDatosParentesco() throws Exception {
        ArrayList<Vif_2012_2> lst = new ArrayList<Vif_2012_2>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_vif_2012_2_parentesco()";            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
    public static ArrayList<Vif_2012_2> ObtenerDatosParentescoSexo(String parentesco, String sexo) throws Exception {
        ArrayList<Vif_2012_2> lst = new ArrayList<Vif_2012_2>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_vif_2012_2_dado_parentesco_sexo_victima(?,?)";  
            lstP.add(new Parametro(1, parentesco));
            lstP.add(new Parametro(2, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
}