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

    public Atencion(int id_atencion, String diagnostico, String sindrome,String morbilidad,String prevencion,String descripcion,String enfermedad,Date fecha_atencion,String lugar_atencion)

    {
    this.id_atencion = id_atencion;
    this.diagnostico  = diagnostico;
    this.sindrome  = sindrome ;
    this.morbilidad  = morbilidad;
    this.prevencion = prevencion;
    this.descripcion= descripcion;
    this.enfermedad = enfermedad;
    this.fecha_atencion= fecha_atencion;
    this.lugar_atencion=lugar_atencion;
     
    }
    public int getId_Atencion() {
        return id_atencion;
    }
    public void setid_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setdiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getSindrome() {
        return sindrome;
    }
    public void setsindrome(String sindrome) {
        this.sindrome = sindrome;
    }
    public String getMorbilidad() {
        return morbilidad;
    }
    public void setmorbilidad(String morbilidad) {
        this.morbilidad = morbilidad;
    }
    public String getPrevencion() {
        return prevencion;
    }
    public void setprevencion(String prevencion) {
        this.prevencion = prevencion;
    }
    public String getDrescripcion () {
        return descripcion;
    }
    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEnfermedad() {
        return enfermedad;
    }
    public void setenfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
     public Date getFecha_Atencion() {
        return fecha_atencion;
    }
    public void setfecha_atencion(Date fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }
     public String getLugar_Atencion() {
        return lugar_atencion;
    }
    public void setlugar_atencion(String lugar_atencion) {
        this.lugar_atencion = lugar_atencion;
    }
}   
