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
import salud.entidades.clases.Atencion;

/**
 *
 * @author Geovanny Cudco
 */
public class FAtencion {

    public static ArrayList<Atencion> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Atencion> lst = new ArrayList<Atencion>();
        Atencion atencion = null;
        try {
            while (rs.next()) {
                atencion = new Atencion(
                        rs.getInt("pid_atencion"),
                        FPaciente.obtenerPacienteDadoCodigo(rs.getInt("pid_paciente")),
                        rs.getDate("pfecha_atencion"),
                        rs.getString("pdiagnostico"),
                        rs.getString("psindrome"),
                        rs.getString("pmorbilidad"),
                        rs.getString("pprevencion"),
                        rs.getString("pdescripcion"),
                        rs.getString("penfermedad"),
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

    public static ArrayList<Atencion> obtenerAtenciones() throws Exception {
        ArrayList<Atencion> lst = new ArrayList<Atencion>();
        try {
            String sql = "select * from salud.f_select_atencion()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean insertarAtencion(Atencion atencion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from salud.f_insert_atencion(?,?,?,?,?,?,?,?,?)";            
            lstP.add(new Parametro(1, atencion.getId_paciente().getId_paciente()));
            lstP.add(new Parametro(2, atencion.getFecha_atencion()));
            lstP.add(new Parametro(3, atencion.getDiagnostico()));
            lstP.add(new Parametro(4, atencion.getSindrome()));
            lstP.add(new Parametro(5, atencion.getMorbilidad()));
            lstP.add(new Parametro(6, atencion.getPrevencion()));
            lstP.add(new Parametro(7, atencion.getDescripcion()));
            lstP.add(new Parametro(8, atencion.getEnfermedad()));
            lstP.add(new Parametro(9, atencion.getLugar_atencion()));
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
    
    public static boolean actualizarAtencion(Atencion atencion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from salud.f_update_atencion(?,?,?,?,?,?,?,?,?,?)";            
            lstP.add(new Parametro(1, atencion.getId_atencion()));
            lstP.add(new Parametro(2, atencion.getId_paciente().getId_paciente()));
            lstP.add(new Parametro(3, atencion.getFecha_atencion()));
            lstP.add(new Parametro(4, atencion.getDiagnostico()));
            lstP.add(new Parametro(5, atencion.getSindrome()));
            lstP.add(new Parametro(6, atencion.getMorbilidad()));
            lstP.add(new Parametro(7, atencion.getPrevencion()));
            lstP.add(new Parametro(8, atencion.getDescripcion()));
            lstP.add(new Parametro(9, atencion.getEnfermedad()));
            lstP.add(new Parametro(10, atencion.getLugar_atencion()));
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
    
    public static  boolean eliminarAtencion (int codigo) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from salud.f_delete_atencion(?)";
        lstP.add(new Parametro(1,codigo));
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
    
    public static ArrayList<Atencion> obtenerAtencionDadoIdPaciente(int codigoPaciente) throws Exception {
        ArrayList<Atencion> lst = new ArrayList<Atencion>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from salud.f_select_atencion_dado_codigo_paciente(?)";
            lstP.add(new Parametro(1, codigoPaciente));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
    public static ArrayList<Atencion> obtenerAtencionDadoCedulaPaciente(String cedulaPaciente) throws Exception {
        ArrayList<Atencion> lst = new ArrayList<Atencion>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from salud.f_select_atencion_dado_cedula_paciente(?)";
            lstP.add(new Parametro(1, cedulaPaciente));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }

    

}
