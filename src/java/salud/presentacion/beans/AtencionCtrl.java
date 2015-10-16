/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.presentacion.beans;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.StringToDate;
import recursos.Util;
import salud.entidades.clases.Atencion;
import salud.entidades.clases.Paciente;
import salud.entidades.funciones.FAtencion;
import salud.entidades.funciones.FPaciente;

/**
 *
 * @author Geovanny Cudco
 */
@ManagedBean
@RequestScoped
public class AtencionCtrl {

    /**
     * Creates a new instance of AtencionCtrl
     */
    private Atencion objAtencion;
    private Atencion atencionSel;
    private ArrayList<Atencion> lstAtencion;
    private ArrayList<Paciente> lstPaciente;
    private boolean mostrarActualizar;
    private int valorPSeleccionado;
    private Date fechaNacimiento;
    private String pacienteBuscar;
    private int idPaciente;
    private String cedulaPaciente;

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getPacienteBuscar() {
        return pacienteBuscar;
    }

    public void setPacienteBuscar(String pacienteBuscar) {
        this.pacienteBuscar = pacienteBuscar;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getValorPSeleccionado() {
        return valorPSeleccionado;
    }

    public void setValorPSeleccionado(int valorPSeleccionado) {
        this.valorPSeleccionado = valorPSeleccionado;
    }

    public Atencion getObjAtencion() {
        return objAtencion;
    }

    public void setObjAtencion(Atencion objAtencion) {
        this.objAtencion = objAtencion;
    }

    public Atencion getAtencionSel() {
        return atencionSel;
    }

    public void setAtencionSel(Atencion atencionSel) {
        this.atencionSel = atencionSel;
    }

    public ArrayList<Atencion> getLstAtencion() {
        return lstAtencion;
    }

    public void setLstAtencion(ArrayList<Atencion> lstAtencion) {
        this.lstAtencion = lstAtencion;
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

//    @PostConstruct
//    public void postObtenerAtencionDadoPaciente() {
//        this.obtnerAtencionesDadoCedulaPaciente();
//
//    }

    private void reinit() {
        this.objAtencion = new Atencion();
        this.atencionSel = new Atencion();
        this.lstAtencion = new ArrayList<Atencion>();
        this.lstPaciente = new ArrayList<Paciente>();
        this.obtnerAtenciones();
        this.obtnerPacientes();
    }

    public AtencionCtrl() {
        this.reinit();
    }

    public void obtnerPacientes() {
        try {
            this.lstPaciente = FPaciente.ObtenerPacientes();
            System.out.println(lstPaciente.get(0).getId_paciente());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerPacientes  dice: " + e.getMessage());
            System.out.println("public void obtnerPacientes dice: " + e.getMessage());
        }
    }

    public void obtnerAtenciones() {
        try {
            this.lstAtencion = FAtencion.obtenerAtenciones();
            this.atencionSel = lstAtencion.get(0);
            System.out.println(lstAtencion.get(0).getId_atencion());
        } catch (Exception e) {
            Util.addErrorMessage("private void obtnerAtenciones() dice: " + e.getMessage());
            System.out.println("private void obtnerAtenciones() dice: " + e.getMessage());
        }
    }

    public void obtnerAtencionesDadoCedulaPaciente() {
        try {
            this.lstAtencion = FAtencion.obtenerAtencionDadoCedulaPaciente(cedulaPaciente);
            this.atencionSel = lstAtencion.get(0);
            System.out.println(lstAtencion.get(0).getId_atencion());
        } catch (Exception e) {
//            Util.addErrorMessage("public void obtnerAtencionesDadoCedulaPaciente() dice: " + e.getMessage());
//            System.out.println("public void obtnerAtencionesDadoCedulaPaciente() dice: " + e.getMessage());
            Util.addErrorMessage("El paciente buscado no presenta atenciones");
        }
    }

    public void insertarAtencion() {
        try {
            Paciente paciente = new Paciente();
            paciente.setId_paciente(valorPSeleccionado);
            objAtencion.setId_paciente(paciente);
            objAtencion.setFecha_atencion(StringToDate.devolverFecha(fechaNacimiento));

            if (FAtencion.insertarAtencion(objAtencion)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaAtencion.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarAtencion dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarAtencion dice: " + e.getMessage());
            System.out.println("private void insertarPAtencion dice: " + e.getMessage());
        }
    }

    public void editarAtencion() {
        try {
            Paciente paciente = new Paciente();
            paciente.setId_paciente(valorPSeleccionado);
            atencionSel.setId_paciente(paciente);
            atencionSel.setFecha_atencion(StringToDate.devolverFecha(fechaNacimiento));

            if (FAtencion.actualizarAtencion(atencionSel)) {
                atencionSel = new Atencion();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarAtencion.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void editarAtencion dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void editarAtencion dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void editarAtencion dice: " + e.getMessage());
            System.out.println("private void editarAtencion dice: " + e.getMessage());
        }
    }

    public void eliminarAtencion() {
        try {
            if (FAtencion.eliminarAtencion((int) atencionSel.getId_atencion())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarAtencion.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarAtencion dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarAtencion dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarAtencion dice: " + e.getMessage());
            System.out.println("private void eliminarAtencion dice: " + e.getMessage());
        }
    }

}
