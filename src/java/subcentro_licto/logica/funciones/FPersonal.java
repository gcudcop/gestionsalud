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
import subcentro_licto.logica.clases.Personal;

/**
 *
 * @author Mari
 */
public class FPersonal {
public static ArrayList<Personal> llenarPersonal(ConjuntoResultado rs) throws Exception {
        ArrayList<Personal> lst = new ArrayList<Personal>();
        Personal personal = null; 
         try {
            while (rs.next()) {
                personal = new Personal(
                        rs.getInt("pid_personal"),
                        rs.getString("papellidos"),
                        rs.getString("pnombres"),
                        rs.getDate("pfecha_nacimiento"),
                        rs.getString("pcedula_ciudadania"),
                        rs.getInt("psexo"),
                        rs.getInt("pformacion"),
                        rs.getInt("pespecialida_subespecialidad"),
                        rs.getInt("pnacionalidad"),
                        rs.getString("pautoidentificacion"),
                        rs.getString("pcodigo_mps")
                          );
                lst.add(personal);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    //obtener personal  
    public static ArrayList<Personal> ObtenerPersonal() throws Exception {
        ArrayList<Personal> lst = new ArrayList<Personal>();
        try {
            String sql = "select * from subcentro_licto.f_select_personal()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPersonal(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     //insertar personal   
    public static boolean InsertarPersonal(Personal personal) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_insert_personal(?,?,?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1, personal.getApellidos()));
            lstP.add(new Parametro(2, personal.getNombres()));
            lstP.add(new Parametro(3,personal.getFecha_nacimiento()));
            lstP.add(new Parametro(4,personal.getCedula_ciudadania()));
            lstP.add(new Parametro(5,personal.getSexo()));
            lstP.add(new Parametro(6,personal.getFormacion()));
            lstP.add(new Parametro(7,personal.getEspecialidad_Subespecialidad()));
            lstP.add(new Parametro(8,personal.getAutoidentificacion()));
            lstP.add(new Parametro(9,personal.getNacionalidad()));
            lstP.add(new Parametro(10,personal.getCodigo_Mps()));
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
     //editar personal    
    public static boolean EditarPersonal(Personal personal) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from Subcentro_licto.f_update_personal(?,?,?,?,?,?,?,?,?,?)";                        
             lstP.add(new Parametro(1, personal.getApellidos()));
            lstP.add(new Parametro(2, personal.getNombres()));
            lstP.add(new Parametro(3,personal.getFecha_nacimiento()));
            lstP.add(new Parametro(4,personal.getCedula_ciudadania()));
            lstP.add(new Parametro(5,personal.getSexo()));
            lstP.add(new Parametro(6,personal.getFormacion()));
            lstP.add(new Parametro(7,personal.getEspecialidad_Subespecialidad()));
            lstP.add(new Parametro(8,personal.getAutoidentificacion()));
            lstP.add(new Parametro(9,personal.getNacionalidad()));
            lstP.add(new Parametro(10,personal.getCodigo_Mps()));
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
     public static  boolean eliminarPersonal (int vid) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from suncemtro_licto.f_delete_personal(?)";
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
