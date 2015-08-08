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
import subcentro_licto.logica.clases.Atencion;
import subcentro_licto.logica.funciones.FAtencion;

/**
 *
 * @author Mari
 */
@ManagedBean
@RequestScoped
public class ControladorAtencion {
    
  /**
     * Creates a new instance of ATENCION
     */
    private Atencion objAtencion;
    private Atencion atencionSel;
    private ArrayList<Atencion> lstAtencion;
    private boolean mostrarActualizar;
    private ArrayList<Atencion> lst;
   
    public Atencion getObjAtencion() {
        return objAtencion;
    }

    public void setObjAtencion(Atencion objAtencion) {
        this.objAtencion = objAtencion;
    }
     public Atencion getAtencionSel() {
        return atencionSel;
    }

    public void setatencionSel(Atencion atencionSel) {
        this.atencionSel = atencionSel;
    }

    public ArrayList<Atencion> getLstAtencion() {
        return lstAtencion;
    }

    public void setLstAtencion(ArrayList<Atencion> lstAtencion) {
        this.lstAtencion = lstAtencion;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ControladorAtencion() {
    }

    public void reinit() {

    }
 public void obtnerAtencion() {
        try {
            this.lst = FAtencion.ObtenerAtencion();
            this.atencionSel = lstAtencion.get(0);
            System.out.println(lstAtencion.get(0).getId_Atencion());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerAtencion  dice: " + e.getMessage());
            System.out.println("public void obtnerAtencion dice: " + e.getMessage());
        }
    }

    public void insertarAtencion() {
        try {
            if (FAtencion.InsertarAtencion(objAtencion)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaAtencion.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarAtencion dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarAtencion dice: " + e.getMessage());
            System.out.println("private void insertarAtencion dice: " + e.getMessage());
        }
    }
public void editarAtencion() {
        try {
            atencionSel.setid_atencion(atencionSel.getId_Atencion());
            if (FAtencion.EditarAtencion(atencionSel)) {
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
 public void eliminarAtencion(){
        try{
                if(FAtencion.eliminarAtencion((int)atencionSel.getId_Atencion())){
                    Util.addErrorMessage("Error al eliminar la información.");
                    System.out.println("public void eliminarAtencion dice: Error al eliminar la información");
                }else {
                    this.reinit();
                    DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarAtencion.hide()");
                    Util.addSuccessMessage("Información eliminada.");
                    System.out.println("public void eliminarAtencion dice: Información eliminada.");
                }
        }catch(Exception e) {
            Util.addErrorMessage("private void eliminarAtencion dice: " + e.getMessage());
            System.out.println("private void eliminarAtencion dice: " + e.getMessage());
        }
    }
}