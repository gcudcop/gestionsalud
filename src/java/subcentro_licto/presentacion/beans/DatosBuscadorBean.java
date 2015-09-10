/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.presentacion.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import recursos.Util;
import subcentro_licto.logica.clases.Datos;
import subcentro_licto.logica.funciones.FDatos;

/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class DatosBuscadorBean implements Serializable{

    /**
     * Creates a new instance of DatosBuscadorBean
     */
    
    private ArrayList<Datos> lstDatos;
    private ArrayList<Datos> lstFiltradaDatos;
    private List<Datos> lstDatos1;
    private List<Datos> lstFiltradaDatos1;
    private Datos datosSel;

    public List<Datos> getLstDatos1() {
        return lstDatos1;
    }

    public void setLstDatos1(List<Datos> lstDatos1) {
        this.lstDatos1 = lstDatos1;
    }

    public List<Datos> getLstFiltradaDatos1() {
        return lstFiltradaDatos1;
    }

    public void setLstFiltradaDatos1(List<Datos> lstFiltradaDatos1) {
        this.lstFiltradaDatos1 = lstFiltradaDatos1;
    }
    
    public ArrayList<Datos> getLstDatos() {
        return lstDatos;
    }

    public void setLstDatos(ArrayList<Datos> lstDatos) {
        this.lstDatos = lstDatos;
    }

    public ArrayList<Datos> getLstFiltradaDatos() {
        return lstFiltradaDatos;
    }

    public void setLstFiltradaDatos(ArrayList<Datos> lstFiltradaDatos) {
        this.lstFiltradaDatos = lstFiltradaDatos;
    }

    public Datos getDatosSel() {
        return datosSel;
    }

    public void setDatosSel(Datos datosSel) {
        this.datosSel = datosSel;
    }
    
    
    public DatosBuscadorBean() {
        reinit();
    }
    
//    @PostConstruct
    private void reinit() {
        this.lstDatos = new ArrayList<Datos>();
        this.datosSel = new Datos();
        this.lstFiltradaDatos = new ArrayList<Datos>();
      
        this.cargarDatos();
        
    }

    private void cargarDatos() {
        try {
            this.lstDatos = FDatos.ObtenerDatos();
            this.datosSel = lstDatos.get(0);
            System.out.println(lstDatos.get(0).getApellidos());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarDatos  dice: " + e.getMessage());
            System.out.println("public void cargarDatos dice: " + e.getMessage());
        }
    }
    
        
}
