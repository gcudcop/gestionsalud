/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.entidades.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import salud.entidades.clases.DatosSalud;

/**
 *
 * @author gcudcop
 */
public class FDatosSalud {

    public static ArrayList<DatosSalud> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<DatosSalud> lst = new ArrayList<DatosSalud>();
        DatosSalud datosSalud = null;
        try {
            while (rs.next()) {
                datosSalud = new DatosSalud(
                        rs.getInt("pid"),
                        rs.getString("pprovincia"),
                        rs.getString("pcanton"),
                        rs.getString("pbarrio"),
                        rs.getString("pinstitucion"),
                        rs.getDate("pfecha_de_atencion"),
                        rs.getString("papellidos"),
                        rs.getString("pnombres"),
                        rs.getInt("pedad"),
                        rs.getString("psexo"),
                        rs.getString("pinstruccion_formal"),
                        rs.getString("pestado_civil"),
                        rs.getString("pocupacion"),
                        rs.getString("ptelefono"),
                        rs.getString("pcanton_domicilio"),
                        rs.getString("pparroquia_domicilio"),
                        rs.getString("pcalles_domicilio"),
                        rs.getString("pdireccion_trabajo"),
                        rs.getString("ptelefono_trabajo"),
                        rs.getString("ptipos_de_agresiones"),
                        rs.getString("pfrecuencia"),
                        rs.getString("plugar_de_agresion"),
                        rs.getDate("pfecha_agresion"),
                        rs.getString("pasociacion"),
                        rs.getString("pobjeto_de_agresion"),
                        rs.getString("pestado_de_conciencia"),
                        rs.getString("ptratamiento"),
                        rs.getString("pcaso_medico"),
                        rs.getString("preferido")
                );
                lst.add(datosSalud);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<DatosSalud> obtenerDatos() throws Exception {
        ArrayList<DatosSalud> lst = new ArrayList<DatosSalud>();
        try {
            String sql = "select * from subcentro_licto.f_select_datos()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<DatosSalud> obtenerDatosDadoAnio(int anio) throws Exception {
        ArrayList<DatosSalud> lst = new ArrayList<DatosSalud>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_select_datos_dado_anio(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
     public static ArrayList<DatosSalud> obtenerDatosDadoMesAnio(int anio,String mes) throws Exception {
        ArrayList<DatosSalud> lst = new ArrayList<DatosSalud>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_select_datos_dado_anio_mes(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, mes));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
    
}
