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
import salud.entidades.clases.Personal;
import salud.entidades.funciones.FPersonal;

/**
 *
 * @author gcudcop
 */
@ManagedBean
@RequestScoped
public class PersonalCtrl {

    private Personal objPersonal;
    private Personal personalSel;
    private ArrayList<Personal> lstPersonal;
    private boolean mostrarActualizar;
    private Date fechaNacimiento;
    private int sexoPersonal;
    private int formacionPersonal;
    private int especialidadPersonal;
    private int nacionalidadPersonal;
    private int autoidentificacion;

    public int getAutoidentificacion() {
        return autoidentificacion;
    }

    public void setAutoidentificacion(int autoidentificacion) {
        this.autoidentificacion = autoidentificacion;
    }

    public int getNacionalidadPersonal() {
        return nacionalidadPersonal;
    }

    public void setNacionalidadPersonal(int nacionalidadPersonal) {
        this.nacionalidadPersonal = nacionalidadPersonal;
    }

    public int getEspecialidadPersonal() {
        return especialidadPersonal;
    }

    public void setEspecialidadPersonal(int especialidadPersonal) {
        this.especialidadPersonal = especialidadPersonal;
    }

    public int getFormacionPersonal() {
        return formacionPersonal;
    }

    public void setFormacionPersonal(int formacionPersonal) {
        this.formacionPersonal = formacionPersonal;
    }

    public int getSexoPersonal() {
        return sexoPersonal;
    }

    public void setSexoPersonal(int sexoPersonal) {
        this.sexoPersonal = sexoPersonal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

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

    public PersonalCtrl() {
        this.reinit();
    }

    private void reinit() {
        this.lstPersonal = new ArrayList<Personal>();
        this.objPersonal = new Personal();
        this.personalSel = new Personal();
        this.obtenerPersonal();

    }

    public void obtenerPersonal() {
        try {
            this.lstPersonal = FPersonal.obtenerPersonal();
            this.personalSel = lstPersonal.get(0);
            System.out.println(lstPersonal.get(0).getId_personal());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerPersonal  dice: " + e.getMessage());
            System.out.println("public void obtnerPersonal dice: " + e.getMessage());
        }
    }

    public void insertarPersonal() {
        try {
            objPersonal.setSexo(sexoPersonal);
            objPersonal.setFormacion(formacionPersonal);
            objPersonal.setEspecialidad_subespecialidad(especialidadPersonal);
            objPersonal.setNacionalidad(nacionalidadPersonal);
            objPersonal.setAutoidentificacion(autoidentificacion);
            objPersonal.setFecha_nacimiento(StringToDate.devolverFecha(fechaNacimiento));

            if (FPersonal.insertarPersonal(objPersonal)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoPersonal.hide()");
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

            personalSel.setSexo(sexoPersonal);
            personalSel.setFormacion(formacionPersonal);
            personalSel.setEspecialidad_subespecialidad(especialidadPersonal);
            personalSel.setNacionalidad(nacionalidadPersonal);
            personalSel.setAutoidentificacion(autoidentificacion);
            personalSel.setFecha_nacimiento(StringToDate.devolverFecha(fechaNacimiento));

            if (FPersonal.actualizarPersonal(personalSel)) {
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
    
    public void eliminarPersonal() {
        try {            
            if (FPersonal.eliminarPersonal((int) personalSel.getId_personal())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarPersonal.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarPersonal dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarPersonal dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarPersonal dice: " + e.getMessage());
            System.out.println("private void eliminarPersonal dice: " + e.getMessage());
        }
    }


}
