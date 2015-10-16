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
import master.logica.funciones.FUsuario;
import salud.entidades.clases.Abastecimiento;

/**
 *
 * @author Xp
 */
public class FAbastecimiento {

    public static ArrayList<Abastecimiento> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Abastecimiento> lst = new ArrayList<Abastecimiento>();
        Abastecimiento abastecimiento = null;
        try {
            while (rs.next()) {
                abastecimiento = new Abastecimiento(
                        rs.getInt("pid_abastecimiento"),
                        FMedicamento.obtenerMedicamentoDadoCodigo(rs.getInt("pid_medicamento")),
                        FUsuario.ObtenerUsuarioDadoCodigo(rs.getInt("pid_usuario")),
                        rs.getDate("pfecha_abastecimiento"),
                        rs.getInt("pcantidad_global"),
                        rs.getString("punidad_cantidad_global"),
                        rs.getInt("pvalores_unitarios"),
                        rs.getString("punidades")
                );
                lst.add(abastecimiento);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    
    public static ArrayList<Abastecimiento> obtenerAbastecimientos() throws Exception {
        ArrayList<Abastecimiento> lst = new ArrayList<Abastecimiento>();
        try {
            String sql = "select * from subcentro_licto.f_select_abastecimiento()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static boolean insertarAbastecimiento(Abastecimiento abastecimiento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_insert_abastecimiento(?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1, abastecimiento.getId_medicamento().getId_medicamento()));
            lstP.add(new Parametro(2,abastecimiento.getId_usuario().getCodigo()));
            lstP.add(new Parametro(3,abastecimiento.getFecha_abastecimiento()));
            lstP.add(new Parametro(4,abastecimiento.getCantidad_global())); 
            lstP.add(new Parametro(5, abastecimiento.getUnidad_cantidad_global()));
            lstP.add(new Parametro(6,abastecimiento.getValores_unitarios()));
            lstP.add(new Parametro(7,abastecimiento.getUnidades()));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    public static boolean actualizarAbastecimiento(Abastecimiento abastecimiento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_update_abastecimiento(?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1, abastecimiento.getId_medicamento().getId_medicamento()));
            lstP.add(new Parametro(2,abastecimiento.getId_usuario().getCodigo()));
            lstP.add(new Parametro(3,abastecimiento.getFecha_abastecimiento()));
            lstP.add(new Parametro(4,abastecimiento.getCantidad_global())); 
            lstP.add(new Parametro(5, abastecimiento.getUnidad_cantidad_global()));
            lstP.add(new Parametro(6,abastecimiento.getValores_unitarios()));
            lstP.add(new Parametro(7,abastecimiento.getUnidades()));            
            lstP.add(new Parametro(8,abastecimiento.getId_abastecimiento()));   
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

}
