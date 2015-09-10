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
import subcentro_licto.logica.clases.Paciente;

/**
 *
 * @author Mari
 */

public class FPaciente {

    public static ArrayList<Paciente> llenarPaciente(ConjuntoResultado rs) throws Exception {
        ArrayList<Paciente> lst = new ArrayList<Paciente>();
        Paciente paciente = null;

        try {
            while (rs.next()) {
                paciente = new Paciente(
                        rs.getInt("pid_paciente"),
                        rs.getString("papellidos"),
                        rs.getString("pnombres"),
                        rs.getString("phistoria_clinica"),
                        rs.getInt("psexo"),
                        rs.getDate("pfecha_nacimiento"),
                        rs.getString("pcedula_ciudadana"),
                        rs.getInt("pnacionalidad"),
                        rs.getInt("pautoidentificacion"),
                        rs.getInt("paporta_afiliado"),
                        rs.getString("pprovincia"),
                        rs.getString("pcanton"),
                        rs.getString("pparroquia"),
                        rs.getString("pbarrio"),
                        rs.getString("psector"),
                        rs.getString("precinto"),
                        rs.getString("pcomunidad"),
                        rs.getString("pdireccion"),
                        rs.getString("ptelefono"),
                        rs.getInt("pgrupo_prioritario")
                      );
                lst.add(paciente);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //obtener pacientes   
    public static ArrayList<Paciente> ObtenerPacientes() throws Exception {
        ArrayList<Paciente> lst = new ArrayList<Paciente>();
        try {
            String sql = "select * from subcentro_licto.f_select_paciente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPaciente(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //insertar paciente    
    public static boolean InsertarPaciente(Paciente paciente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto.f_insert_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1, paciente.getApellidos()));
            lstP.add(new Parametro(2,paciente.getNombres()));
            lstP.add(new Parametro(3,paciente.getHistoria_Clinica()));
            lstP.add(new Parametro(4,paciente.getSexo()));
            lstP.add(new Parametro(5,paciente.getFecha_Nacimiento()));
            lstP.add(new Parametro(6,paciente.getCedula_ciudadania()));
            lstP.add(new Parametro(7,paciente.getNacionalidad()));
            lstP.add(new Parametro(8,paciente.getAutoidentificacion()));
            lstP.add(new Parametro(9,paciente.getAporta_Afiliado()));
            lstP.add(new Parametro(10,paciente.getProvincia()));
            lstP.add(new Parametro(11,paciente.getCanton()));
            lstP.add(new Parametro(12,paciente.getParroquia()));
            lstP.add(new Parametro(13,paciente.getBarrio()));
            lstP.add(new Parametro(14,paciente.getSector()));
            lstP.add(new Parametro(15,paciente.getRecinto()));
            lstP.add(new Parametro(16,paciente.getComunidad()));
            lstP.add(new Parametro(17,paciente.getDireccion()));
            lstP.add(new Parametro(18,paciente.getTelefono()));
            lstP.add(new Parametro(19,paciente.getGrupo_prioritario()));
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
    
    //editar paciente    
    public static boolean EditarPaciente(Paciente paciente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from subcentro_licto..f_update_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1, paciente.getApellidos()));
            lstP.add(new Parametro(2,paciente.getNombres()));
            lstP.add(new Parametro(3,paciente.getHistoria_Clinica()));
            lstP.add(new Parametro(4,paciente.getSexo()));
            lstP.add(new Parametro(5,paciente.getFecha_Nacimiento()));
            lstP.add(new Parametro(6,paciente.getCedula_ciudadania()));
            lstP.add(new Parametro(7,paciente.getNacionalidad()));
            lstP.add(new Parametro(8,paciente.getAutoidentificacion()));
            lstP.add(new Parametro(9,paciente.getAporta_Afiliado()));
            lstP.add(new Parametro(10,paciente.getProvincia()));
            lstP.add(new Parametro(11,paciente.getCanton()));
            lstP.add(new Parametro(12,paciente.getParroquia()));
            lstP.add(new Parametro(13,paciente.getBarrio()));
            lstP.add(new Parametro(14,paciente.getSector()));
            lstP.add(new Parametro(15,paciente.getRecinto()));
            lstP.add(new Parametro(16,paciente.getComunidad()));
            lstP.add(new Parametro(17,paciente.getDireccion()));
            lstP.add(new Parametro(18,paciente.getTelefono()));
            lstP.add(new Parametro(19,paciente.getGrupo_prioritario()));
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
    
    public static  boolean eliminarPaciente (int vid) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from subcentro_licto.f_delete_paciente(?)";
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
