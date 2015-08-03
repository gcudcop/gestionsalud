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
import subcentro_licto.logica.clases.Unidad_Operativa;

/**
 *
 * @author Mari
 */
public class FUnidad_Operativa {
    private static Object unidad_operativa;
  public static ArrayList<Unidad_Operativa> llenarUnidad_Operativa(ConjuntoResultado rs) throws Exception {
        ArrayList<Unidad_Operativa> lst = new ArrayList<Unidad_Operativa>();
        Unidad_Operativa unidad_operativa = null;

        try {
            while (rs.next()) {
                
                unidad_operativa = new Unidad_Operativa(
                        rs.getInt("pid_uo"),
                        rs.getString("pnombre_uo"),
                        rs.getString("pprovincia"),
                        rs.getString("pcanton"),
                        rs.getString("pparroquia"),
                        rs.getString("pzona"),
                        rs.getString("pdistrito"),
                        rs.getString("pcircuito"),
                        rs.getString("ptipo_uo"),
                        rs.getInt("pinstitucion_sistema")
                                          );
                lst.add(unidad_operativa);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //obtener unidad operativa
    public static ArrayList<Unidad_Operativa> ObtenerUnidad_Operativa() throws Exception {
        ArrayList<Unidad_Operativa> lst = new ArrayList<Unidad_Operativa>();
        try {
            String sql = "select * from subcentro_licto .f_select_unidad_operativa()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarUnidad_Operativa(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //insertar unidad operativa   
    public static boolean InsertarUnidad_Operativa(Unidad_Operativa unidad_operativa) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_insert_unidad_operativa(?,?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1, unidad_operativa.getNombre_UO()));
            lstP.add(new Parametro(2,unidad_operativa.getProvincia()));
            lstP.add(new Parametro(3,unidad_operativa.getCanton()));
            lstP.add(new Parametro(4,unidad_operativa.getParroquia()));
            lstP.add(new Parametro(5,unidad_operativa.getZona()));
            lstP.add(new Parametro(6,unidad_operativa.getDistrito()));
            lstP.add(new Parametro(7,unidad_operativa.getCircuito()));
            lstP.add(new Parametro(8,unidad_operativa.getTipo_UO()));
            lstP.add(new Parametro(9,unidad_operativa.getInstitucion_Sistema()));
            
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
    
    //editar unidad operativa
    public static boolean EditarUnidad_Operativa(Unidad_Operativa unidad_operativa) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto..f_update_unidad_operativa(?,?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1, unidad_operativa.getNombre_UO()));
            lstP.add(new Parametro(2,unidad_operativa.getProvincia()));
            lstP.add(new Parametro(3,unidad_operativa.getCanton()));
            lstP.add(new Parametro(4,unidad_operativa.getParroquia()));
            lstP.add(new Parametro(5,unidad_operativa.getZona()));
            lstP.add(new Parametro(6,unidad_operativa.getDistrito()));
            lstP.add(new Parametro(7,unidad_operativa.getCircuito()));
            lstP.add(new Parametro(8,unidad_operativa.getTipo_UO()));
            lstP.add(new Parametro(9,unidad_operativa.getInstitucion_Sistema()));
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
    
    public static  boolean eliminarUnidad_Operativa(int vid) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from subcentro_licto.f_delete_unidad_operativa(?)";
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
  
