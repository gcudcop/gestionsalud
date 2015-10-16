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
import salud.entidades.clases.Medicamentos;
import salud.entidades.funciones.FMedicamentos;

/**
 *
 * @author Xp
 */
@ManagedBean
@RequestScoped
public class MedicamentosCtrl {

    /**
     * Creates a new instance of MedicamentosCtrl
     */
    private Medicamentos objMedicamentos;
    private Medicamentos medicamentoSel;
    private ArrayList<Medicamentos> lstMedicamentos;
    private Date fechaEntrega;
    private boolean mostrarActualizar;
    private String medicamentoBuscado;

    public String getMedicamentoBuscado() {
        return medicamentoBuscado;
    }

    public void setMedicamentoBuscado(String medicamentoBuscado) {
        this.medicamentoBuscado = medicamentoBuscado;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Medicamentos getObjMedicamentos() {
        return objMedicamentos;
    }

    public void setObjMedicamentos(Medicamentos objMedicamentos) {
        this.objMedicamentos = objMedicamentos;
    }

    public Medicamentos getMedicamentoSel() {
        return medicamentoSel;
    }

    public void setMedicamentoSel(Medicamentos medicamentoSel) {
        this.medicamentoSel = medicamentoSel;
    }

    public ArrayList<Medicamentos> getLstMedicamentos() {
        return lstMedicamentos;
    }

    public void setLstMedicamentos(ArrayList<Medicamentos> lstMedicamentos) {
        this.lstMedicamentos = lstMedicamentos;
    }

    private void reinit() {
        this.objMedicamentos = new Medicamentos();
        this.medicamentoSel = new Medicamentos();
        this.lstMedicamentos = new ArrayList<Medicamentos>();
        this.obtnerMedicamentos();
    }

    public MedicamentosCtrl() {
        this.reinit();
    }

    public void obtnerMedicamentos() {
        try {
            this.lstMedicamentos = FMedicamentos.obtenerMedicamentos();
            this.medicamentoSel = lstMedicamentos.get(0);
            System.out.println(lstMedicamentos.get(0).getNombre_medicamento());
        } catch (Exception e) {
            Util.addErrorMessage("private void obtnerMedicamentos() dice: " + e.getMessage());
            System.out.println("private void obtnerMedicamentos() dice: " + e.getMessage());
        }
    }

    public void obtnerMedicamentosDadoNombre() {
        try {
            this.lstMedicamentos = FMedicamentos.obtenerMedicamentosDadoNombre(medicamentoBuscado);
            this.medicamentoSel = lstMedicamentos.get(0);
            System.out.println(lstMedicamentos.get(0).getNombre_medicamento());
        } catch (Exception e) {
            //Util.addErrorMessage("private void obtnerMedicamentos() dice: " + e.getMessage());
            System.out.println("private void obtnerMedicamentos() dice: " + e.getMessage());
            Util.addErrorMessage("El medicamento buscado no existe!!!");
        }
    }

    public void insertarMedicamentos() {
        try {
            objMedicamentos.setFecha_ingreso(StringToDate.devolverFecha(fechaEntrega));
            if (FMedicamentos.insertarMedicamentos(objMedicamentos)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoMedicamento.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarMedicamentos() dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("public void insertarMedicamentos() dice: " + e.getMessage());
            System.out.println("public void insertarMedicamentos() dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void editarMedicamento() {
        try {
            medicamentoSel.setFecha_ingreso(StringToDate.devolverFecha(fechaEntrega));

            if (FMedicamentos.actualizarMedicamentos(medicamentoSel)) {
                medicamentoSel = new Medicamentos();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarMedicamentos.hide()");
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
            if (FMedicamentos.eliminarMedicamentos((int) medicamentoSel.getId_medicamentos())) {
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
