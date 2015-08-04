/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
import subcentro_licto.logica.clases.Medicamento;
import subcentro_licto.logica.funciones.FMedicamento;

/**
 *
 * @author Mari
 */
@ManagedBean
@RequestScoped
public class ControladorMedicamento {
    
  /**
     * Creates a new instance of Medicamento
     */
    private Medicamento objMedicamento;
    private Medicamento medicamentoSel;
    private ArrayList<Medicamento> lstMedicamento;
    private boolean mostrarActualizar;
    private ArrayList<Medicamento> lst;
   
    public Medicamento getObjMedicamento() {
        return objMedicamento;
    }

    public void setObjMedicamento(Medicamento objMedicamento) {
        this.objMedicamento = objMedicamento;
    }
     public Medicamento getMedicamentoSel() {
        return medicamentoSel;
    }

    public void setMedicamentoSel(Medicamento medicamentoSel) {
        this.medicamentoSel = medicamentoSel;
    }

    public ArrayList<Medicamento> getLstMedicamento() {
        return lstMedicamento;
    }

    public void setLstMedicamento(ArrayList<Medicamento> lstMedicamento) {
        this.lstMedicamento = lstMedicamento;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ControladorMedicamento() {
    }

    public void reinit() {

    }
 public void obtnerMedicamento() {
        try {
            this.lst = FMedicamento.ObtenerMedicamento();
            this.medicamentoSel = lstMedicamento.get(0);
            System.out.println(lstMedicamento.get(0).getId_Medicamento());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerMedicamento  dice: " + e.getMessage());
            System.out.println("public void obtnerMedicamento dice: " + e.getMessage());
        }
    }

    public void insertarMedicamento() {
        try {
            if (FMedicamento.InsertarMedicamento(objMedicamento)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaMedicamento.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarMedicamento dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarMedicamento dice: " + e.getMessage());
            System.out.println("private void insertarMedicamento dice: " + e.getMessage());
        }
    }
public void editarMedicamento() {
        try {
            medicamentoSel.setId_Medicamento(medicamentoSel.getId_Medicamento());
            if (FMedicamento.EditarMedicamento(medicamentoSel)) {
                medicamentoSel = new Medicamento();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarMedicamento.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void editarMedicamento dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void editarMedicamento dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void editarUnidad Operativa dice: " + e.getMessage());
            System.out.println("private void editarUnidad Operativa dice: " + e.getMessage());
        }
    }
 public void eliminarMedicamento(){
        try{
                if(FMedicamento.eliminarMedicamento((int)medicamentoSel.getId_Medicamento())){
                    Util.addErrorMessage("Error al eliminar la información.");
                    System.out.println("public void eliminarMedicamento dice: Error al eliminar la información");
                }else {
                    this.reinit();
                    DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarMedicamento.hide()");
                    Util.addSuccessMessage("Información eliminada.");
                    System.out.println("public void eliminarMedicamento dice: Información eliminada.");
                }
        }catch(Exception e) {
            Util.addErrorMessage("private void eliminarMedicamento dice: " + e.getMessage());
            System.out.println("private void eliminarMedicamento dice: " + e.getMessage());
        }
    }
}