/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
import salud.entidades.clases.Medicamento;
import salud.entidades.funciones.FMedicamento;

/**
 *
 * @author gcudcop
 */
@ManagedBean
@RequestScoped
public class MedicamentoCtrl {

    /**
     * Creates a new instance of MedicamentoCtrl
     */
    private ArrayList<Medicamento> lstMedicamento;
    private Medicamento medicamentoSel;
    private Medicamento objMedicamento;
    private boolean mostrarActualizar;

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ArrayList<Medicamento> getLstMedicamento() {
        return lstMedicamento;
    }

    public void setLstMedicamento(ArrayList<Medicamento> lstMedicamento) {
        this.lstMedicamento = lstMedicamento;
    }

    public Medicamento getMedicamentoSel() {
        return medicamentoSel;
    }

    public void setMedicamentoSel(Medicamento medicamentoSel) {
        this.medicamentoSel = medicamentoSel;
    }

    public Medicamento getObjMedicamento() {
        return objMedicamento;
    }

    public void setObjMedicamento(Medicamento objMedicamento) {
        this.objMedicamento = objMedicamento;
    }

    private void reinit() {

        this.objMedicamento = new Medicamento();
        this.medicamentoSel = new Medicamento();
        this.lstMedicamento = new ArrayList<Medicamento>();
        this.obtnerMedicamentos();
    }

    public MedicamentoCtrl() {
        this.reinit();
    }

    public void obtnerMedicamentos() {
        try {
            this.lstMedicamento = FMedicamento.obtenerMedicamentos();
            this.medicamentoSel = lstMedicamento.get(0);
            System.out.println(lstMedicamento.get(0));
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerMedicamentos()  dice: " + e.getMessage());
            System.out.println("public void obtnerMedicamentos() dice: " + e.getMessage());
        }
    }

    public void insertarMedicamento() {
        try {

            if (FMedicamento.insertarMedicamento(objMedicamento)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoMedicamento.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarMedicamento() dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("public void insertarMedicamento() dice: " + e.getMessage());
            System.out.println("public void insertarMedicamento() dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar=false;
    }

    public void editarMedicamento() {
        try {
            //pacienteSel.setid_paciente(pacienteSel.getId_paciente());

            if (FMedicamento.actualizarMedicamento(medicamentoSel)) {

                medicamentoSel = new Medicamento();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarMedicamento.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void editarMedicamento() dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void editarMedicamento() dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("public void editarMedicamento() dice: " + e.getMessage());
            System.out.println("public void editarMedicamento() dice: " + e.getMessage());
        }
    }
    
    
    public void eliminarMedicamento() {
        try {
            if (FMedicamento.eliminarMedicamento((int) medicamentoSel.getId_medicamento())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarMedicamento.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarMedicamento() dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarMedicamento() dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("public void eliminarMedicamento() dice: " + e.getMessage());
            System.out.println("public void eliminarMedicamento() dice: " + e.getMessage());
        }
    }

}
