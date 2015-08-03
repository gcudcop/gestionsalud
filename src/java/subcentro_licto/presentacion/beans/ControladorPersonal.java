/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import subcentro_licto.logica.clases.Personal;
import subcentro_licto.logica.funciones.FPersonal;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
/**
 *
 * @author Mari
 */
@ManagedBean
@RequestScoped
public class ControladorPersonal {
  /**
     * Creates a new instance of ControladorPersonal
     */
    private Personal objPersonal;
    private Personal personalSel;
    private ArrayList<Personal> lstPersonal;
    private boolean mostrarActualizar;
    private ArrayList<Personal> lst;
   
    public Personal getObjPersonal() {
        return objPersonal;
    }

    public void setObjPersonal(Personal objPersonal) {
        this.objPersonal = objPersonal;
    }
     public Personal getPersonalSel() {
        return personalSel;
    }

    public void setPersonalSel(Personal personalSel) {
        this.personalSel = personalSel;
    }

    public ArrayList<Personal> getLstPersonal() {
        return lstPersonal;
    }

    public void setLstPersonal(ArrayList<Personal> lstPersonal) {
        this.lstPersonal = lstPersonal;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ControladorPersonal() {
    }

    public void reinit() {

    }
 public void obtnerPersonal() {
        try {
            this.lst = FPersonal.ObtenerPersonal();
            this.personalSel = lstPersonal.get(0);
            System.out.println(lstPersonal.get(0).getId_personal());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerPersonal  dice: " + e.getMessage());
            System.out.println("public void obtnerPersonal dice: " + e.getMessage());
        }
    }

    public void insertarPersonal() {
        try {
            if (FPersonal.InsertarPersonal(objPersonal)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaPersonal.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarPersonal dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarPersonal dice: " + e.getMessage());
            System.out.println("private void insertarPersonal dice: " + e.getMessage());
        }
    }
public void editarPersonal() {
        try {
            personalSel.setid_personal(personalSel.getId_personal());
            if (FPersonal.EditarPersonal(personalSel)) {
                personalSel = new Personal();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarPersonal.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void editarPersonal dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void editarPersonal dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void editarPersonal dice: " + e.getMessage());
            System.out.println("private void editarPersonal dice: " + e.getMessage());
        }
    }
 public void eliminarPersonal(){
        try{
                if(FPersonal.eliminarPersonal((int)personalSel.getId_personal())){
                    Util.addErrorMessage("Error al eliminar la información.");
                    System.out.println("public void eliminarPersonal dice: Error al eliminar la información");
                }else {
                    this.reinit();
                    DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarPersonal.hide()");
                    Util.addSuccessMessage("Información eliminada.");
                    System.out.println("public void eliminarPersonal dice: Información eliminada.");
                }
        }catch(Exception e) {
            Util.addErrorMessage("private void eliminarPersonal dice: " + e.getMessage());
            System.out.println("private void eliminarPersonal dice: " + e.getMessage());
        }
    }
}

