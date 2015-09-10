/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import java.sql.SQLException;
import java.util.ArrayList;
import subcentro_licto.logica.clases.Datos;

/**
 *
 * @author Usuario
 */
public class FDatos {

    public static ArrayList<Datos> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Datos> lst = new ArrayList<Datos>();
        Datos datos = null;

        try {
            while (rs.next()) {
                datos = new Datos(
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
                
                
                                                       
                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //obtener datoss   
    public static ArrayList<Datos> ObtenerDatos() throws Exception {
        ArrayList<Datos> lst = new ArrayList<Datos>();
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
    
//    public static ArrayList<Producto> ObtenerProductos() throws Exception {
//        ArrayList<Producto> lst = new ArrayList<Producto>();
//        try {
//            String sql = "select * from sgflc.f_select_producto()";
//            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
//            lst = llenarProductos(rs);
//            rs = null;
//        } catch (SQLException exConec) {
//            throw new Exception(exConec.getMessage());
//        }
//        return lst;
//    }

}
