/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vif.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import vif.logica.clases.Victima;

/**
 *
 * @author Virt-ICITS-2
 */
public class FVictima {

    //llenar datos
    public static ArrayList<Victima> llenarVictima(ConjuntoResultado rs) throws Exception {
        ArrayList<Victima> lst = new ArrayList<Victima>();
        Victima victima = null;

        try {
            while (rs.next()) {
                victima = new Victima(rs.getInt("pid_victima"), rs.getString("pcedula_identidad"), rs.getString("pnombres"),
                        rs.getString("papellidos"), rs.getString("psexo"), rs.getString("pdireccion"),
                        rs.getString("pdomiciliado"), rs.getInt("pedad"), rs.getString("pestado_civil"),
                        rs.getString("pnivel_educacion"), rs.getString("pocupacion")
                );

                lst.add(victima);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }

        return lst;
    }

    //obtener victimas     
    public static ArrayList<Victima> ObtenerVictimas() throws Exception {
        ArrayList<Victima> lst = new ArrayList<Victima>();

        try {
            String sql = "select * from vif.f_select_victima()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarVictima(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //insertar victimas    
    public static boolean Insertar(Victima victima) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from med_general.f_insert_paciente(?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, victima.getCedula_identidad()));
            lstP.add(new Parametro(2, victima.getPnombres()));
            lstP.add(new Parametro(3, victima.getPapellidos()));
            lstP.add(new Parametro(4, victima.getSexo()));
            lstP.add(new Parametro(5, victima.getDireccion()));
            lstP.add(new Parametro(6, victima.getPdomiciliado()));
            lstP.add(new Parametro(7, victima.getEdad()));
            lstP.add(new Parametro(8, victima.getEstado_civil()));
            lstP.add(new Parametro(9, victima.getNivel_educacion()));
            lstP.add(new Parametro(10, victima.getOcupacion()));
            
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

    public static boolean editarVictima(Victima victima) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.f_update_victima(?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, victima.getCedula_identidad()));
            lstP.add(new Parametro(2, victima.getPnombres()));
            lstP.add(new Parametro(3, victima.getPapellidos()));
            lstP.add(new Parametro(4, victima.getSexo()));
            lstP.add(new Parametro(5, victima.getDireccion()));
            lstP.add(new Parametro(6, victima.getPdomiciliado()));
            lstP.add(new Parametro(7, victima.getEdad()));
            lstP.add(new Parametro(8, victima.getEstado_civil()));
            lstP.add(new Parametro(9, victima.getNivel_educacion()));
            lstP.add(new Parametro(10, victima.getOcupacion()));
            lstP.add(new Parametro(11, victima.getId_victima()));
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
    
    
    public static  boolean eliminarVictima (int vid) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from vif.f_delete_victima(?)";
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

    public static Victima ObtenerVictimaDadoId(int id) throws Exception {
        Victima lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.f_select_victima_dado_id(?)";
            lstP.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Victima();
            lst = llenarVictima(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    
}
