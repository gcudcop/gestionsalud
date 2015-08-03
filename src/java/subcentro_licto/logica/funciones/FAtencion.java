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
import subcentro_licto.logica.clases.Atencion;


/**
 *
 * @author Mari
 */
public class FAtencion {
    private static Object atencion;
   public static ArrayList<Atencion> llenarAtencion(ConjuntoResultado rs) throws Exception {
        ArrayList<Atencion> lst = new ArrayList<Atencion>();
        Atencion atencion = null;

        try {
            while (rs.next()) {
                
                atencion = new Atencion(
                        rs.getInt("pid_atencion"),
                        rs.getString("pdiagnostico"),
                        rs.getString("psindrome"),
                        rs.getString("pmorbilidad"),
                        rs.getString("pprevencion"),
                        rs.getString("pdescripcion"),
                        rs.getString("penfermedad"),
                        rs.getDate("pfecha_atencion"),
                        rs.getString("plugar_atencion")
                                          );
                lst.add(atencion);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //obtener atencion 
    public static ArrayList<Atencion> ObtenerAtencion() throws Exception {
        ArrayList<Atencion> lst = new ArrayList<Atencion>();
        try {
            String sql = "select * from subcentro_licto .f_select_atencion()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAtencion(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //insertar medicamento    
    public static boolean InsertarAtencion(Atencion atencion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_insert_atencion(?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1,atencion.getDiagnostico()));
            lstP.add(new Parametro(2,atencion.getSindrome()));
            lstP.add(new Parametro(3,atencion.getMorbilidad()));
            lstP.add(new Parametro(4,atencion.getPrevencion()));
            lstP.add(new Parametro(5,atencion.getDescripcion()));
            lstP.add(new Parametro(6,atencion.getEnfermedad()));
            lstP.add(new Parametro(7,atencion.getFecha_Atencion()));
            lstP.add(new Parametro(8,atencion.getLugar_Atencion()));
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
    
    //editar atencion
    public static boolean EditarAtencion(Atencion atencion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto..f_update_atencion(?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1,atencion.getDiagnostico()));
            lstP.add(new Parametro(2,atencion.getSindrome()));
            lstP.add(new Parametro(3,atencion.getMorbilidad()));
            lstP.add(new Parametro(4,atencion.getPrevencion()));
            lstP.add(new Parametro(5,atencion.getDescripcion()));
            lstP.add(new Parametro(6,atencion.getEnfermedad()));
            lstP.add(new Parametro(7,atencion.getFecha_Atencion()));
            lstP.add(new Parametro(8,atencion.getLugar_Atencion()));
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
    
    public static  boolean eliminarAtencion(int vid) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from subcentro_licto.f_delete_atencion(?)";
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
   
