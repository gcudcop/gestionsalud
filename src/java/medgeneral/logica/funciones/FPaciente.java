/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medgeneral.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import medgeneral.logica.clases.Paciente;

/**
 *
 * @author gcudcop
 */
public class FPaciente {

    public static ArrayList<Paciente> llenarPaciente(ConjuntoResultado rs) throws Exception {
        ArrayList<Paciente> lst = new ArrayList<Paciente>();
        Paciente paciente = null;

        try {
            while (rs.next()) {
                paciente = new Paciente(
                        rs.getInt("pid_paciente"),
                        rs.getInt("phistoria_clinica"),
                        rs.getString("pcedula_ciudadania"),
                        rs.getString("papellido_paterno"),
                        rs.getString("papellido_materno"),
                        rs.getString("pprimer_nombre"),
                        rs.getString("psegundo_nombre"),
                        rs.getString("pdireccion"),
                        rs.getString("pbarrio"),
                        rs.getString("pparroquia"),
                        rs.getString("pcanton"),
                        rs.getString("pprovincia"),
                        rs.getString("pzona"),
                        rs.getString("ptelefono"),
                        rs.getDate("pfecha_nacimiento"),
                        rs.getString("plugar_nacimiento"),
                        rs.getString("pnacionalidad"),
                        rs.getString("petnia"),
                        rs.getInt("pedad"),
                        rs.getString("psexo"),
                        rs.getString("pestado_civil"),
                        rs.getString("pinstruccion_academica"),
                        rs.getDate("pfecha_admision"),
                        rs.getString("pocupacion"),
                        rs.getString("pempresa_trabajo"),
                        rs.getString("ptipo_seguro_salud"),
                        rs.getString("preferido_de"),
                        rs.getString("pfamiliar_emergencia"),
                        rs.getString("pparentesco_afinidad"),
                        rs.getString("pdireccion_familiar"),
                        rs.getString("ptelefono_pariente")
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
            String sql = "select * from med_general.f_select_paciente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPaciente(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //insertar Pacientes   
    public static boolean InsertarPaciente(Paciente paciente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from med_general.f_insert_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1, paciente.getHistoria_clinica()));
            lstP.add(new Parametro(2,paciente.getCedula_ciudadania()));
            lstP.add(new Parametro(3,paciente.getApellido_paterno()));
            lstP.add(new Parametro(4,paciente.getApellido_materno()));
            lstP.add(new Parametro(5,paciente.getPrimer_nombre()));
            lstP.add(new Parametro(6,paciente.getSegundo_nombre()));
            lstP.add(new Parametro(7,paciente.getDireccion()));
            lstP.add(new Parametro(8,paciente.getBarrio()));
            lstP.add(new Parametro(8,paciente.getParroquia()));
            lstP.add(new Parametro(10,paciente.getCanton()));
            lstP.add(new Parametro(11,paciente.getProvincia()));
            lstP.add(new Parametro(12,paciente.getZona()));
            lstP.add(new Parametro(13,paciente.getTelefono()));
            lstP.add(new Parametro(14,paciente.getFecha_nacimiento()));
            lstP.add(new Parametro(15,paciente.getLugar_nacimiento()));
            lstP.add(new Parametro(16,paciente.getNacionalidad()));
            lstP.add(new Parametro(17,paciente.getEtnia()));
            lstP.add(new Parametro(18,paciente.getEdad()));
            lstP.add(new Parametro(10,paciente.getSexo()));
            lstP.add(new Parametro(20,paciente.getEstado_civil()));
            lstP.add(new Parametro(21,paciente.getInstruccion_academica()));
            lstP.add(new Parametro(22,paciente.getFecha_admision()));           
            lstP.add(new Parametro(23,paciente.getOcupacion()));
            lstP.add(new Parametro(24,paciente.getEmpresa_trabajo()));
            lstP.add(new Parametro(25,paciente.getTipo_seguro_salud()));
            lstP.add(new Parametro(26,paciente.getReferido_de()));
            lstP.add(new Parametro(27,paciente.getFamiliar_emergencia()));
            lstP.add(new Parametro(28,paciente.getParentesco_afinidad()));
            lstP.add(new Parametro(29,paciente.getDireccion_familiar()));
            lstP.add(new Parametro(30,paciente.getTelefono_pariente()));
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
            String sql = "select * from med_general.f_update_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";                        
            lstP.add(new Parametro(1, paciente.getHistoria_clinica()));
            lstP.add(new Parametro(2,paciente.getCedula_ciudadania()));
            lstP.add(new Parametro(3,paciente.getApellido_paterno()));
            lstP.add(new Parametro(4,paciente.getApellido_materno()));
            lstP.add(new Parametro(5,paciente.getPrimer_nombre()));
            lstP.add(new Parametro(6,paciente.getSegundo_nombre()));
            lstP.add(new Parametro(7,paciente.getDireccion()));
            lstP.add(new Parametro(8,paciente.getBarrio()));
            lstP.add(new Parametro(9,paciente.getParroquia()));
            lstP.add(new Parametro(10,paciente.getCanton()));
            lstP.add(new Parametro(11,paciente.getProvincia()));
            lstP.add(new Parametro(12,paciente.getZona()));
            lstP.add(new Parametro(13,paciente.getTelefono()));
            lstP.add(new Parametro(14,paciente.getFecha_nacimiento()));
            lstP.add(new Parametro(15,paciente.getLugar_nacimiento()));
            lstP.add(new Parametro(16,paciente.getNacionalidad()));
            lstP.add(new Parametro(17,paciente.getEtnia()));
            lstP.add(new Parametro(18,paciente.getEdad()));
            lstP.add(new Parametro(19,paciente.getSexo()));
            lstP.add(new Parametro(20,paciente.getEstado_civil()));
            lstP.add(new Parametro(21,paciente.getInstruccion_academica()));
            lstP.add(new Parametro(22,paciente.getFecha_admision()));           
            lstP.add(new Parametro(23,paciente.getOcupacion()));
            lstP.add(new Parametro(24,paciente.getEmpresa_trabajo()));
            lstP.add(new Parametro(25,paciente.getTipo_seguro_salud()));
            lstP.add(new Parametro(26,paciente.getReferido_de()));
            lstP.add(new Parametro(27,paciente.getFamiliar_emergencia()));
            lstP.add(new Parametro(28,paciente.getParentesco_afinidad()));
            lstP.add(new Parametro(29,paciente.getDireccion_familiar()));
            lstP.add(new Parametro(30,paciente.getTelefono_pariente()));
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
        String sql = "select * from med_general.f_delete_paciente(?)";
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
