/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.entidades.clases;

import java.util.Date;

/**
 *
 * @author Geovanny Cudco
 */
public class Medicamentos {

    private int id_medicamentos;
    private String codigo_medicamento;
    private String nombre_medicamento;
    private String forma_farmaceutica;
    private String concentracion;
    private String tipo;
    private String presentacion;
    private int unidades;
    private Date fecha_ingreso;
    private String proveedor;
    private String registro_sanitario;

    /*
     ** constructores
     */
    public Medicamentos() {
    }

    public Medicamentos(int id_medicamentos, String codigo_medicamento, String nombre_medicamento, String forma_farmaceutica, String concentracion, String tipo, String presentacion, int unidades, Date fecha_ingreso, String proveedor, String registro_sanitario) {
        this.id_medicamentos = id_medicamentos;
        this.codigo_medicamento = codigo_medicamento;
        this.nombre_medicamento = nombre_medicamento;
        this.forma_farmaceutica = forma_farmaceutica;
        this.concentracion = concentracion;
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.unidades = unidades;
        this.fecha_ingreso = fecha_ingreso;
        this.proveedor = proveedor;
        this.registro_sanitario = registro_sanitario;
    }

    /*
     ** metodos get y set
     */
    public int getId_medicamentos() {
        return id_medicamentos;
    }

    public void setId_medicamentos(int id_medicamentos) {
        this.id_medicamentos = id_medicamentos;
    }

    public String getCodigo_medicamento() {
        return codigo_medicamento;
    }

    public void setCodigo_medicamento(String codigo_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
    }

    public String getNombre_medicamento() {
        return nombre_medicamento;
    }

    public void setNombre_medicamento(String nombre_medicamento) {
        this.nombre_medicamento = nombre_medicamento;
    }

    public String getForma_farmaceutica() {
        return forma_farmaceutica;
    }

    public void setForma_farmaceutica(String forma_farmaceutica) {
        this.forma_farmaceutica = forma_farmaceutica;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getRegistro_sanitario() {
        return registro_sanitario;
    }

    public void setRegistro_sanitario(String registro_sanitario) {
        this.registro_sanitario = registro_sanitario;
    }

}
