/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.presentacion.beans;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.StringToDate;
import recursos.Util;
import salud.entidades.clases.Paciente;
import salud.entidades.funciones.FPaciente;

/**
 *
 * @author gcudcop
 */
@ManagedBean
@RequestScoped
public class PacienteCtrl {

    private Paciente objPaciente;
    private Paciente pacienteSel;
    private ArrayList<Paciente> lstPaciente;
    private boolean mostrarActualizar;
    private int sexoPaciente;
    private Date fechaNacimiento;
    private int nacionalidad;
    private int autoidentificacion;
    private int aporte;
    private int grupoPrioritario;

    /*
     ** Getters y Setters    
     */
    public int getGrupoPrioritario() {
        return grupoPrioritario;
    }

    public void setGrupoPrioritario(int grupoPrioritario) {
        this.grupoPrioritario = grupoPrioritario;
    }

    public int getAporte() {
        return aporte;
    }

    public void setAporte(int aporte) {
        this.aporte = aporte;
    }

    public int getAutoidentificacion() {
        return autoidentificacion;
    }

    public void setAutoidentificacion(int autoidentificacion) {
        this.autoidentificacion = autoidentificacion;
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(int sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    public Paciente getObjPaciente() {
        return objPaciente;
    }

    public void setObjPaciente(Paciente objPaciente) {
        this.objPaciente = objPaciente;
    }

    public Paciente getPacienteSel() {
        return pacienteSel;
    }

    public void setPacienteSel(Paciente pacienteSel) {
        this.pacienteSel = pacienteSel;
    }

    public ArrayList<Paciente> getLstPaciente() {
        return lstPaciente;
    }

    public void setLstPaciente(ArrayList<Paciente> lstPaciente) {
        this.lstPaciente = lstPaciente;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    private void reinit() {
        this.lstPaciente = new ArrayList<Paciente>();
        this.objPaciente = new Paciente();
        this.pacienteSel = new Paciente();
        this.obtnerPacientes();
    }

    public PacienteCtrl() {
        this.reinit();
    }

    private void obtnerPacientes() {
        try {
            this.lstPaciente = FPaciente.ObtenerPacientes();
            this.pacienteSel = lstPaciente.get(0);
            System.out.println(lstPaciente.get(0).getId_paciente());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerPacientes  dice: " + e.getMessage());
            System.out.println("public void obtnerPacientes dice: " + e.getMessage());
        }
    }

    public void insertarPaciente() {
        try {
            objPaciente.setSexo(sexoPaciente);
            objPaciente.setNacionalidad(nacionalidad); 
            objPaciente.setFecha_nacimiento(StringToDate.devolverFecha(fechaNacimiento));
            objPaciente.setAutoidentificacion(autoidentificacion);
            objPaciente.setAporta_afiliado(aporte);
            objPaciente.setGrupo_prioritario(grupoPrioritario);
            
            if (FPaciente.insertarPaciente(objPaciente)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoPaciente.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarPaciente dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarPaciente dice: " + e.getMessage());
            System.out.println("private void insertarPaciente dice: " + e.getMessage());
        }
    }
    
    public void editarPaciente() {
        try {
            //pacienteSel.setid_paciente(pacienteSel.getId_paciente());
            
            if (FPaciente.actualizarPaciente(pacienteSel)){
                pacienteSel = new Paciente();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarPaciente.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void editarPaciente dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void editarPaciente dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void editarPaciente dice: " + e.getMessage());
            System.out.println("private void editarPaciente dice: " + e.getMessage());
        }
    }
    
    public void eliminarPaciente() {
        try {
            if (FPaciente.eliminarPaciente((int) pacienteSel.getId_paciente())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarPaciente.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarPaciente dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarPaciente dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarPaciente dice: " + e.getMessage());
            System.out.println("private void eliminarPaciente dice: " + e.getMessage());
        }
    }

}
