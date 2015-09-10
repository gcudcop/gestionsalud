/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import recursos.Util;
import subcentro_licto.logica.clases.Paciente;
import subcentro_licto.logica.funciones.FPaciente;

/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class ControladorBuscador {

    /**
     * Creates a new instance of ControladorBuscador
     */
    private ArrayList<Paciente> lstPaciente;
    private ArrayList<Paciente> lstFiltradaPaciente;
    private Paciente pacienteSel;

    public ArrayList<Paciente> getLstPaciente() {
        return lstPaciente;
    }

    public void setLstPaciente(ArrayList<Paciente> lstPaciente) {
        this.lstPaciente = lstPaciente;
    }

    public ArrayList<Paciente> getLstFiltradaPaciente() {
        return lstFiltradaPaciente;
    }

    public void setLstFiltradaPaciente(ArrayList<Paciente> lstFiltradaPaciente) {
        this.lstFiltradaPaciente = lstFiltradaPaciente;
    }

    public Paciente getPacienteSel() {
        return pacienteSel;
    }

    public void setPacienteSel(Paciente pacienteSel) {
        this.pacienteSel = pacienteSel;
    }

    public ControladorBuscador() {
        reinit();

    }

    private void reinit() {
        this.lstPaciente = new ArrayList<Paciente>();
        this.pacienteSel = new Paciente();
        this.lstFiltradaPaciente = new ArrayList<Paciente>();
        
        cargarPacientes();

    }

    public void cargarPacientes() {
        try {
            this.lstPaciente = FPaciente.ObtenerPacientes();
            this.pacienteSel = lstPaciente.get(0);
            System.out.println(lstPaciente.get(0).getId_paciente());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarPacientes  dice: " + e.getMessage());
            System.out.println("public void cargarPacientes dice: " + e.getMessage());
        }
    }

}
