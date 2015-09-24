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
import salud.entidades.clases.Medicamento;

/**
 *
 * @author gcudcop
 */
public class FMedicamento {
    
    public static ArrayList<Medicamento> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Medicamento> lst = new ArrayList<Medicamento>();
        Medicamento datos = null;

        try {
            while (rs.next()) {
                datos = new Medicamento(
                        rs.getInt("pid_medicamento"),
                        rs.getString("pcodigo_medicamento"),
                        rs.getString("pnombre_medicamento"),
                        rs.getString("pforma_farmaceutica"),
                        rs.getString("pconcentracion")
                      );
                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    
    
    public static ArrayList<Medicamento> obtenerMedicamentos() throws Exception {
        ArrayList<Medicamento> lst = new ArrayList<Medicamento>();
        try {
            String sql = "select * from subcentro_licto.f_select_medicamento()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static boolean insertarMedicamento(Medicamento medicamento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_insert_medicamento(?,?,?,?)";                        
            lstP.add(new Parametro(1, medicamento.getCodigo_medicamento()));
            lstP.add(new Parametro(2,medicamento.getNombre_medicamento()));
            lstP.add(new Parametro(3,medicamento.getForma_farmaceutica()));
            lstP.add(new Parametro(4,medicamento.getConcentracion()));            
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
    
    public static boolean actualizarMedicamento(Medicamento medicamento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_update_medicamento(?,?,?,?,?)";                        
            lstP.add(new Parametro(1,medicamento.getCodigo_medicamento()));
            lstP.add(new Parametro(2,medicamento.getNombre_medicamento()));
            lstP.add(new Parametro(3,medicamento.getForma_farmaceutica()));
            lstP.add(new Parametro(4,medicamento.getConcentracion()));            
            lstP.add(new Parametro(5,medicamento.getId_medicamento()));  
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
    
    
    public static  boolean eliminarMedicamento (int vid) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from subcentro_licto.f_delete_medicamento(?)";
        lstP.add(new Parametro(1,vid));
        ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
        while(rs.next() )
            {
              if(rs.getString(0).equals("true"));
                   eje=true;
            }
            } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return eje;
    }
    
    
}
