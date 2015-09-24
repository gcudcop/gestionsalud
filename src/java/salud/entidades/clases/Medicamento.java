/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.entidades.clases;

/**
 *
 * @author Mari
 */
public class Medicamento {

    private int id_medicamento;
    private String codigo_medicamento;
    private String nombre_medicamento;
    private String forma_farmaceutica;
    private String concentracion;

    public Medicamento() {
    }

    public Medicamento(int id_medicamento, String codigo_medicamento, String nombre_medicamento, String forma_farmaceutica, String concentracion) {
        this.id_medicamento = id_medicamento;
        this.codigo_medicamento = codigo_medicamento;
        this.nombre_medicamento = nombre_medicamento;
        this.forma_farmaceutica = forma_farmaceutica;
        this.concentracion = concentracion;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
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

    
}
