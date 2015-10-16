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
import salud.entidades.clases.Medicamentos;

/**
 *
 * @author Geovanny Cudco
 */
public class FMedicamentos {

    public static ArrayList<Medicamentos> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Medicamentos> lst = new ArrayList<Medicamentos>();
        Medicamentos datos = null;

        try {
            while (rs.next()) {
                datos = new Medicamentos(
                        rs.getInt("pid_medicamentos"),
                        rs.getString("pcodigo_medicamento"),
                        rs.getString("pnombre_medicamento"),
                        rs.getString("pforma_farmaceutica"),
                        rs.getString("pconcentracion"),
                        rs.getString("ptipo"),
                        rs.getString("ppresentacion"),
                        rs.getInt("punidades"),
                        rs.getDate("pfecha_ingreso"),
                        rs.getString("pproveedor"),
                        rs.getString("pregistro_sanitario")
                );
                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Medicamentos> obtenerMedicamentos() throws Exception {
        ArrayList<Medicamentos> lst = new ArrayList<Medicamentos>();
        try {
            String sql = "select * from salud.f_select_medicamentos()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean insertarMedicamentos(Medicamentos medicamentos) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from salud.f_insert_medicamentos(?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, medicamentos.getCodigo_medicamento()));
            lstP.add(new Parametro(2, medicamentos.getNombre_medicamento()));
            lstP.add(new Parametro(3, medicamentos.getForma_farmaceutica()));
            lstP.add(new Parametro(4, medicamentos.getConcentracion()));
            lstP.add(new Parametro(5, medicamentos.getTipo()));
            lstP.add(new Parametro(6, medicamentos.getPresentacion()));
            lstP.add(new Parametro(7, medicamentos.getUnidades()));
            lstP.add(new Parametro(8, medicamentos.getFecha_ingreso()));
            lstP.add(new Parametro(9, medicamentos.getProveedor()));
            lstP.add(new Parametro(10, medicamentos.getRegistro_sanitario()));

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

    public static boolean actualizarMedicamentos(Medicamentos medicamentos) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from salud.f_update_medicamentos(?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, medicamentos.getCodigo_medicamento()));
            lstP.add(new Parametro(2, medicamentos.getNombre_medicamento()));
            lstP.add(new Parametro(3, medicamentos.getForma_farmaceutica()));
            lstP.add(new Parametro(4, medicamentos.getConcentracion()));
            lstP.add(new Parametro(5, medicamentos.getTipo()));
            lstP.add(new Parametro(6, medicamentos.getPresentacion()));
            lstP.add(new Parametro(7, medicamentos.getUnidades()));
            lstP.add(new Parametro(8, medicamentos.getFecha_ingreso()));
            lstP.add(new Parametro(9, medicamentos.getProveedor()));
            lstP.add(new Parametro(10, medicamentos.getRegistro_sanitario()));
            lstP.add(new Parametro(11, medicamentos.getId_medicamentos()));
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
    
    
    public static  boolean eliminarMedicamentos (int vid) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from salud.f_delete_medicamentos(?)";
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
    
    public static ArrayList<Medicamentos> obtenerMedicamentosDadoNombre(String nombreMedicamento) throws Exception {
        ArrayList<Medicamentos> lst = new ArrayList<Medicamentos>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from salud.f_select_medicamentos_dado_nombre(?)";
            lstP.add(new Parametro(1, nombreMedicamento));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
    
    
    public static Medicamentos obtenerMedicamentosDadoCodigo(int codigo) throws Exception {
        Medicamentos lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from salud.f_select_medicamentos_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Medicamentos();
            lst = llenarDatos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
