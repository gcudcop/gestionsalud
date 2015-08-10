/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import subcentro_licto.logica.clases.Medicamento;

/**
 *
 * @author Mari
 */
public class FMedicamento {

    public static ArrayList<Medicamento> llenarMedicamento(ConjuntoResultado rs) throws Exception {
        ArrayList<Medicamento> lst = new ArrayList<Medicamento>();
        Medicamento medicamento = null;

        try {
            while (rs.next()) {

                medicamento = new Medicamento(
                        rs.getInt("pid_medicamento"),
                        rs.getString("pcodigo_medicamento"),
                        rs.getString("pnombre_medicamento"),
                        rs.getString("pforma_farmaceutica"),
                        rs.getString("pconcentracion")
                );
                lst.add(medicamento);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //obtener medicamento 
    public static ArrayList<Medicamento> ObtenerMedicamento() throws Exception {
        ArrayList<Medicamento> lst = new ArrayList<Medicamento>();
        try {
            String sql = "select * from subcentro_licto.f_select_medicamento()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarMedicamento(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //insertar medicamento    
    public static boolean InsertarMedicamento(Medicamento medicamento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_insert_medicamento(?,?,?,?)";
            lstP.add(new Parametro(1, medicamento.getCodigo_Medicamento()));
            lstP.add(new Parametro(2, medicamento.getNombre_Medicamento()));
            lstP.add(new Parametro(3, medicamento.getForma_Farmaceutica()));
            lstP.add(new Parametro(4, medicamento.getConcentracion()));
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

    //editar medicamento
    public static boolean EditarMedicamento(Medicamento medicamento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto..f_update_medicamento(?,?,?,?)";
            lstP.add(new Parametro(1, medicamento.getCodigo_Medicamento()));
            lstP.add(new Parametro(2, medicamento.getNombre_Medicamento()));
            lstP.add(new Parametro(3, medicamento.getForma_Farmaceutica()));
            lstP.add(new Parametro(4, medicamento.getConcentracion()));
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

    public static boolean eliminarMedicamento(int vid) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_delete_medicamento(?)";
            lstP.add(new Parametro(1, vid));
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
