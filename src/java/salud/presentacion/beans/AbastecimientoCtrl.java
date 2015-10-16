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
import master.logica.clases.Usuario;
import master.logica.funciones.FUsuario;
import org.primefaces.context.DefaultRequestContext;
import recursos.StringToDate;
import recursos.Util;
import salud.entidades.clases.Abastecimiento;
import salud.entidades.clases.Medicamento;
import salud.entidades.funciones.FAbastecimiento;
import salud.entidades.funciones.FMedicamento;

/**
 *
 * @author Geovanny Cudco
 */
@ManagedBean
@RequestScoped
public class AbastecimientoCtrl {

    /**
     * Creates a new instance of AbastecimientoCtrl
     */
    private ArrayList<Abastecimiento> lstAbastecimiento;
    private ArrayList<Usuario> lstUsuarios;
    private ArrayList<Medicamento> lstMedicamentos;
    private Abastecimiento abastecimientoSel;
    private Abastecimiento objAbastecimiento;
    private int valorMSeleccionado;
    private Date fechaAbastecimiento;
    private int cajasAIngresar;
    private int valorUSeleccionado;
    private int unidadesAIngresar;

    public int getValorUSeleccionado() {
        return valorUSeleccionado;
    }

    public void setValorUSeleccionado(int valorUSeleccionado) {
        this.valorUSeleccionado = valorUSeleccionado;
    }

    public int getUnidadesAIngresar() {
        return unidadesAIngresar;
    }

    public void setUnidadesAIngresar(int unidadesAIngresar) {
        this.unidadesAIngresar = unidadesAIngresar;
    }

    public int getCajasAIngresar() {
        return cajasAIngresar;
    }

    public void setCajasAIngresar(int cajasAIngresar) {
        this.cajasAIngresar = cajasAIngresar;
    }

    public Date getFechaAbastecimiento() {
        return fechaAbastecimiento;
    }

    public void setFechaAbastecimiento(Date fechaAbastecimiento) {
        this.fechaAbastecimiento = fechaAbastecimiento;
    }

    public int getValorMSeleccionado() {
        return valorMSeleccionado;
    }

    public void setValorMSeleccionado(int valorMSeleccionado) {
        this.valorMSeleccionado = valorMSeleccionado;
    }

    public Abastecimiento getAbastecimientoSel() {
        return abastecimientoSel;
    }

    public void setAbastecimientoSel(Abastecimiento abastecimientoSel) {
        this.abastecimientoSel = abastecimientoSel;
    }

    public Abastecimiento getObjAbastecimiento() {
        return objAbastecimiento;
    }

    public void setObjAbastecimiento(Abastecimiento objAbastecimiento) {
        this.objAbastecimiento = objAbastecimiento;
    }

    public ArrayList<Abastecimiento> getLstAbastecimiento() {
        return lstAbastecimiento;
    }

    public void setLstAbastecimiento(ArrayList<Abastecimiento> lstAbastecimiento) {
        this.lstAbastecimiento = lstAbastecimiento;
    }

    public ArrayList<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(ArrayList<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public ArrayList<Medicamento> getLstMedicamentos() {
        return lstMedicamentos;
    }

    public void setLstMedicamentos(ArrayList<Medicamento> lstMedicamentos) {
        this.lstMedicamentos = lstMedicamentos;
    }

    private void reinit() {
        this.lstAbastecimiento = new ArrayList<Abastecimiento>();
        this.lstMedicamentos = new ArrayList<Medicamento>();
        this.lstUsuarios = new ArrayList<Usuario>();
        this.objAbastecimiento=new Abastecimiento();
        this.abastecimientoSel=new Abastecimiento();
        this.obtnerAbastecimientos();
        this.obtnerMedicamentos();
        this.obtnerUsuarios();

    }

    public AbastecimientoCtrl() {
        this.reinit();
    }

    private void obtnerMedicamentos() {
        try {
            this.lstMedicamentos = FMedicamento.obtenerMedicamentos();
            System.out.println(lstMedicamentos.get(0).getNombre_medicamento());
        } catch (Exception e) {
            Util.addErrorMessage("private void obtnerMedicamentos() dice: " + e.getMessage());
            System.out.println("private void obtnerMedicamentos() dice: " + e.getMessage());
        }
    }

    private void obtnerUsuarios() {
        try {
            this.lstUsuarios = FUsuario.ObtenerUsuarios();
            System.out.println(lstUsuarios.get(0).getNombres());
        } catch (Exception e) {
            Util.addErrorMessage("private void obtnerMedicamentos() dice: " + e.getMessage());
            System.out.println("private void obtnerMedicamentos() dice: " + e.getMessage());
        }
    }

    private void obtnerAbastecimientos() {
        try {
            this.lstAbastecimiento = FAbastecimiento.obtenerAbastecimientos();
            this.abastecimientoSel = lstAbastecimiento.get(0);
            System.out.println(lstAbastecimiento.get(0).getId_abastecimiento());
        } catch (Exception e) {
            Util.addErrorMessage("private void obtnerAbastecimientos() dice: " + e.getMessage());
            System.out.println("private void obtnerAbastecimientos() dice: " + e.getMessage());
        }
    }

    public void insertarAbastecimiento() {
        try {
            objAbastecimiento.setFecha_abastecimiento(StringToDate.devolverFecha(fechaAbastecimiento));
            Medicamento medicamento = new Medicamento();
            medicamento.setId_medicamento(valorMSeleccionado);
            objAbastecimiento.setId_medicamento(medicamento);
            Usuario usuario = new Usuario();
            usuario.setCodigo(valorUSeleccionado);
            objAbastecimiento.setId_usuario(usuario);
            

            objAbastecimiento.setCantidad_global(cajasAIngresar);
            int unidadTotal = cajasAIngresar*unidadesAIngresar;
            objAbastecimiento.setValores_unitarios(unidadTotal);
           
            if (FAbastecimiento.insertarAbastecimiento(objAbastecimiento)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoAbastecimiento.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarAbastecimiento dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarAbastecimiento dice: " + e.getMessage());
            System.out.println("private void insertarAbastecimiento dice: " + e.getMessage());
        }
    }

}
