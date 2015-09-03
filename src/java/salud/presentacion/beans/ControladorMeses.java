/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.presentacion.beans;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import recursos.MesesDias;
import salud.entidades.clases.DatosSalud;
import salud.entidades.funciones.FDatosSalud;

/**
 *
 * @author gcudcop
 */
@ManagedBean
@RequestScoped
public class ControladorMeses {

    /**
     * Creates a new instance of ControladorMeses
     */
    private ArrayList<String> lstMeses;
    private ArrayList<DatosSalud> lstDatos;
    private ArrayList<DatosSalud> lstDatosDadoMes;
    private CartesianChartModel lineMeses;    
    private CartesianChartModel lineMeses2012;
    private CartesianChartModel lineMeses2013;
    private CartesianChartModel lineMeses2014;

    public CartesianChartModel getLineMeses2012() {
        return lineMeses2012;
    }

    public void setLineMeses2012(CartesianChartModel lineMeses2012) {
        this.lineMeses2012 = lineMeses2012;
    }

    public CartesianChartModel getLineMeses2013() {
        return lineMeses2013;
    }

    public void setLineMeses2013(CartesianChartModel lineMeses2013) {
        this.lineMeses2013 = lineMeses2013;
    }

    public CartesianChartModel getLineMeses2014() {
        return lineMeses2014;
    }

    public void setLineMeses2014(CartesianChartModel lineMeses2014) {
        this.lineMeses2014 = lineMeses2014;
    }
    

    public ArrayList<String> getLstMeses() {
        return lstMeses;
    }

    public void setLstMeses(ArrayList<String> lstMeses) {
        this.lstMeses = lstMeses;
    }

    public ArrayList<DatosSalud> getLstDatos() {
        return lstDatos;
    }

    public void setLstDatos(ArrayList<DatosSalud> lstDatos) {
        this.lstDatos = lstDatos;
    }

    public ArrayList<DatosSalud> getLstDatosDadoMes() {
        return lstDatosDadoMes;
    }

    public void setLstDatosDadoMes(ArrayList<DatosSalud> lstDatosDadoMes) {
        this.lstDatosDadoMes = lstDatosDadoMes;
    }

    public CartesianChartModel getLineMeses() {
        return lineMeses;
    }

    public void setLineMeses(CartesianChartModel lineMeses) {
        this.lineMeses = lineMeses;
    }

    @PostConstruct
    private void graficar() {
        this.lineMeses = graficaMeses();
        this.lineMeses2012 = graficaMeses2012();
        this.lineMeses2013 = graficaMeses2013();
        this.lineMeses2014 = graficaMeses2014();
    }

    public ControladorMeses() {
        this.graficar();
    }

    private CartesianChartModel graficaMeses() {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstDatos=FDatosSalud.obtenerDatosDadoAnio(2011);
            lstMeses=MesesDias.obtenerMeses();
            ChartSeries meses = new ChartSeries();
            meses.setLabel("Meses");
            for (int i=0;i<lstMeses.size();i++){
                for (int j=0;j<lstDatos.size();j++){
                    lstDatosDadoMes=FDatosSalud.obtenerDatosDadoMesAnio(2011,lstMeses.get(i));
                    meses.set(lstMeses.get(i),lstDatosDadoMes.size());
                }
            }
            model.addSeries(meses);
        } catch (Exception e) {
        }
        return model;
    }
    
    private CartesianChartModel graficaMeses2012() {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstDatos=FDatosSalud.obtenerDatosDadoAnio(2012);
            lstMeses=MesesDias.obtenerMeses();
            ChartSeries meses = new ChartSeries();
            meses.setLabel("Meses");
            for (int i=0;i<lstMeses.size();i++){
                for (int j=0;j<lstDatos.size();j++){
                    lstDatosDadoMes=FDatosSalud.obtenerDatosDadoMesAnio(2012,lstMeses.get(i));
                    meses.set(lstMeses.get(i),lstDatosDadoMes.size());
                }
            }
            model.addSeries(meses);
        } catch (Exception e) {
        }
        return model;
    }
    
    private CartesianChartModel graficaMeses2013() {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstDatos=FDatosSalud.obtenerDatosDadoAnio(2013);
            lstMeses=MesesDias.obtenerMeses();
            ChartSeries meses = new ChartSeries();
            meses.setLabel("Meses");
            for (int i=0;i<lstMeses.size();i++){
                for (int j=0;j<lstDatos.size();j++){
                    lstDatosDadoMes=FDatosSalud.obtenerDatosDadoMesAnio(2013,lstMeses.get(i));
                    meses.set(lstMeses.get(i),lstDatosDadoMes.size());
                }
            }
            model.addSeries(meses);
        } catch (Exception e) {
        }
        return model;
    }
    
    private CartesianChartModel graficaMeses2014() {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstDatos=FDatosSalud.obtenerDatosDadoAnio(2014);
            lstMeses=MesesDias.obtenerMeses();
            ChartSeries meses = new ChartSeries();
            meses.setLabel("Meses");
            for (int i=0;i<lstMeses.size();i++){
                for (int j=0;j<lstDatos.size();j++){
                    lstDatosDadoMes=FDatosSalud.obtenerDatosDadoMesAnio(2014,lstMeses.get(i));
                    meses.set(lstMeses.get(i),lstDatosDadoMes.size());
                }
            }
            model.addSeries(meses);
        } catch (Exception e) {
        }
        return model;
    }

}
