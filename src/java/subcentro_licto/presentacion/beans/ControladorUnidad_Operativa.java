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
import subcentro_licto.logica.clases.Unidad_Operativa;
import subcentro_licto.logica.funciones.FUnidad_Operativa;
import org.primefaces.context.DefaultRequestContext;
/**
 *
 * @author Mari
 */
@ManagedBean
@RequestScoped
public class ControladorUnidad_Operativa {
  /**
     * Creates a new instance of Unidad Operativa
     */
    private Unidad_Operativa objUnidad_Operativa;
    private Unidad_Operativa unidad_operativaSel;
    private ArrayList<Unidad_Operativa> lstUnidad_Operativa;
    private boolean mostrarActualizar;
    private ArrayList<Unidad_Operativa> lst;
   
    public Unidad_Operativa getObjUnidad_Operativa() {
        return objUnidad_Operativa;
    }

    public void setObjUnidad_Operativa(Unidad_Operativa objUnidad_Operativa) {
        this.objUnidad_Operativa = objUnidad_Operativa;
    }
     public Unidad_Operativa getUnidad_OperativaSel() {
        return unidad_operativaSel;
    }

    public void setUnidad_OperativaSel(Unidad_Operativa unidad_operativaSel) {
        this.unidad_operativaSel = unidad_operativaSel;
    }

    public ArrayList<Unidad_Operativa> getLstUnidad_Operativa() {
        return lstUnidad_Operativa;
    }

    public void setLstUnidad_Operativa(ArrayList<Unidad_Operativa> lstUnidad_Operativa) {
        this.lstUnidad_Operativa = lstUnidad_Operativa;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ControladorUnidad_Operativa() {
    }

    public void reinit() {

    }
 public void obtnerUnidad_Operativa() {
        try {
            this.lst = FUnidad_Operativa.ObtenerUnidad_Operativa();
            this.unidad_operativaSel = lstUnidad_Operativa.get(0);
            System.out.println(lstUnidad_Operativa.get(0).getId_UO());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerUnidad Operativa  dice: " + e.getMessage());
            System.out.println("public void obtnerUnidad Operativa dice: " + e.getMessage());
        }
    }

    public void insertarUnidad_Operativa() {
        try {
            if (FUnidad_Operativa.InsertarUnidad_Operativa(objUnidad_Operativa)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaUnidad Operativa.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarUnidad Operativa dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarUnidad Operativa dice: " + e.getMessage());
            System.out.println("private void insertarUnidad Operativa dice: " + e.getMessage());
        }
    }
public void editarUnidad_Operativa() {
        try {
            unidad_operativaSel.setid_uo(unidad_operativaSel.getId_UO());
            if (FUnidad_Operativa.EditarUnidad_Operativa(unidad_operativaSel)) {
                unidad_operativaSel = new Unidad_Operativa();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarUnidad Operativa.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void editarUnidad Operativa dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void editarUnidad Operativa dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void editarUnidad Operativa dice: " + e.getMessage());
            System.out.println("private void editarUnidad Operativa dice: " + e.getMessage());
        }
    }
 public void eliminarUnidad_Operativa(){
        try{
                if(FUnidad_Operativa.eliminarUnidad_Operativa((int)unidad_operativaSel.getId_UO())){
                    Util.addErrorMessage("Error al eliminar la información.");
                    System.out.println("public void eliminarUnidad Operativa dice: Error al eliminar la información");
                }else {
                    this.reinit();
                    DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarUnidad Operativa.hide()");
                    Util.addSuccessMessage("Información eliminada.");
                    System.out.println("public void eliminarUnidad Operativa dice: Información eliminada.");
                }
        }catch(Exception e) {
            Util.addErrorMessage("private void eliminarUnidad Operativa dice: " + e.getMessage());
            System.out.println("private void eliminarUnidad Operativa dice: " + e.getMessage());
        }
    }
}