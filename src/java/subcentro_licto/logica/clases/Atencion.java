/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.logica.clases;

import java.sql.Date;

/**
 *
 * @author Mari
 */
public class Atencion {

    private int id_atencion;
    private String diagnostico;
    private String sindrome;
    private String morbilidad;
    private String prevencion;
    private String descripcion;
    private String enfermedad;
    private Date fecha_atencion;
    private String lugar_atencion;

    public Atencion() {
    }

    public Atencion(int id_atencion, String diagnostico, String sindrome, String morbilidad, String prevencion, String descripcion, String enfermedad, Date fecha_atencion, String lugar_atencion) {
        this.id_atencion = id_atencion;
        this.diagnostico = diagnostico;
        this.sindrome = sindrome;
        this.morbilidad = morbilidad;
        this.prevencion = prevencion;
        this.descripcion = descripcion;
        this.enfermedad = enfermedad;
        this.fecha_atencion = fecha_atencion;
        this.lugar_atencion = lugar_atencion;
    }

    public int getId_atencion() {
        return id_atencion;
    }

    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSindrome() {
        return sindrome;
    }

    public void setSindrome(String sindrome) {
        this.sindrome = sindrome;
    }

    public String getMorbilidad() {
        return morbilidad;
    }

    public void setMorbilidad(String morbilidad) {
        this.morbilidad = morbilidad;
    }

    public String getPrevencion() {
        return prevencion;
    }

    public void setPrevencion(String prevencion) {
        this.prevencion = prevencion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Date getFecha_atencion() {
        return fecha_atencion;
    }

    public void setFecha_atencion(Date fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }

    public String getLugar_atencion() {
        return lugar_atencion;
    }

    public void setLugar_atencion(String lugar_atencion) {
        this.lugar_atencion = lugar_atencion;
    }

   
}
