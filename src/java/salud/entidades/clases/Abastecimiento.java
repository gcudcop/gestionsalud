/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.entidades.clases;

import java.util.Date;
import master.logica.clases.Usuario;

/**
 *
 * @author Geovanny Cudco
 */
public class Abastecimiento {

    private int id_abastecimiento;
    private Medicamento id_medicamento;
    private Usuario id_usuario;
    private Date fecha_abastecimiento;
    private int cantidad_global;
    private String unidad_cantidad_global;
    private int valores_unitarios;
    private String unidades;

    public Abastecimiento() {
    }

    public Abastecimiento(int id_abastecimiento, Medicamento id_medicamento, Usuario id_usuario, Date fecha_abastecimiento, int cantidad_global, String unidad_cantidad_global, int valores_unitarios, String unidades) {
        this.id_abastecimiento = id_abastecimiento;
        this.id_medicamento = id_medicamento;
        this.id_usuario = id_usuario;
        this.fecha_abastecimiento = fecha_abastecimiento;
        this.cantidad_global = cantidad_global;
        this.unidad_cantidad_global = unidad_cantidad_global;
        this.valores_unitarios = valores_unitarios;
        this.unidades = unidades;
    }

    public int getId_abastecimiento() {
        return id_abastecimiento;
    }

    public void setId_abastecimiento(int id_abastecimiento) {
        this.id_abastecimiento = id_abastecimiento;
    }

    public Medicamento getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(Medicamento id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha_abastecimiento() {
        return fecha_abastecimiento;
    }

    public void setFecha_abastecimiento(Date fecha_abastecimiento) {
        this.fecha_abastecimiento = fecha_abastecimiento;
    }

    public int getCantidad_global() {
        return cantidad_global;
    }

    public void setCantidad_global(int cantidad_global) {
        this.cantidad_global = cantidad_global;
    }

    public String getUnidad_cantidad_global() {
        return unidad_cantidad_global;
    }

    public void setUnidad_cantidad_global(String unidad_cantidad_global) {
        this.unidad_cantidad_global = unidad_cantidad_global;
    }

    public int getValores_unitarios() {
        return valores_unitarios;
    }

    public void setValores_unitarios(int valores_unitarios) {
        this.valores_unitarios = valores_unitarios;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

}
