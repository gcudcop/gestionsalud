/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.logica.clases;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Datos {
    
  private int id ;
  private String provincia ;
  private String canton ;
  private String barrio ;
  private String institucion ;
  private Date fecha_de_atencion ;
  private String apellidos ;
  private String nombres ;
  private int edad ;
  private String sexo ;
  private String instruccion_formal ;
  private String estado_civil ;
  private String ocupacion ;
  private String telefono ;
  private String canton_domicilio ;
  private String parroquia_domicilio ;
  private String calles_domicilio ;
  private String direccion_trabajo ;
  private String telefono_trabajo ;
  private String tipos_de_agresiones ;
  private String frecuencia ;
  private String lugar_de_agresion ;
  private Date fecha_agresion ;
  private String asociacion ;
  private String objeto_de_agresion ;
  private String estado_de_conciencia ;
  private String tratamiento ;
  private String caso_medico ;
  private String referido ;

    public Datos() {
    }

    public Datos(int id, String provincia, String canton, String barrio, String institucion, Date fecha_de_atencion, String apellidos, String nombres, int edad, String sexo, String instruccion_formal, String estado_civil, String ocupacion, String telefono, String canton_domicilio, String parroquia_domicilio, String calles_domicilio, String direccion_trabajo, String telefono_trabajo, String tipos_de_agresiones, String frecuencia, String lugar_de_agresion, Date fecha_agresion, String asociacion, String objeto_de_agresion, String estado_de_conciencia, String tratamiento, String caso_medico, String referido) {
        this.id = id;
        this.provincia = provincia;
        this.canton = canton;
        this.barrio = barrio;
        this.institucion = institucion;
        this.fecha_de_atencion = fecha_de_atencion;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.edad = edad;
        this.sexo = sexo;
        this.instruccion_formal = instruccion_formal;
        this.estado_civil = estado_civil;
        this.ocupacion = ocupacion;
        this.telefono = telefono;
        this.canton_domicilio = canton_domicilio;
        this.parroquia_domicilio = parroquia_domicilio;
        this.calles_domicilio = calles_domicilio;
        this.direccion_trabajo = direccion_trabajo;
        this.telefono_trabajo = telefono_trabajo;
        this.tipos_de_agresiones = tipos_de_agresiones;
        this.frecuencia = frecuencia;
        this.lugar_de_agresion = lugar_de_agresion;
        this.fecha_agresion = fecha_agresion;
        this.asociacion = asociacion;
        this.objeto_de_agresion = objeto_de_agresion;
        this.estado_de_conciencia = estado_de_conciencia;
        this.tratamiento = tratamiento;
        this.caso_medico = caso_medico;
        this.referido = referido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Date getFecha_de_atencion() {
        return fecha_de_atencion;
    }

    public void setFecha_de_atencion(Date fecha_de_atencion) {
        this.fecha_de_atencion = fecha_de_atencion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getInstruccion_formal() {
        return instruccion_formal;
    }

    public void setInstruccion_formal(String instruccion_formal) {
        this.instruccion_formal = instruccion_formal;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCanton_domicilio() {
        return canton_domicilio;
    }

    public void setCanton_domicilio(String canton_domicilio) {
        this.canton_domicilio = canton_domicilio;
    }

    public String getParroquia_domicilio() {
        return parroquia_domicilio;
    }

    public void setParroquia_domicilio(String parroquia_domicilio) {
        this.parroquia_domicilio = parroquia_domicilio;
    }

    public String getCalles_domicilio() {
        return calles_domicilio;
    }

    public void setCalles_domicilio(String calles_domicilio) {
        this.calles_domicilio = calles_domicilio;
    }

    public String getDireccion_trabajo() {
        return direccion_trabajo;
    }

    public void setDireccion_trabajo(String direccion_trabajo) {
        this.direccion_trabajo = direccion_trabajo;
    }

    public String getTelefono_trabajo() {
        return telefono_trabajo;
    }

    public void setTelefono_trabajo(String telefono_trabajo) {
        this.telefono_trabajo = telefono_trabajo;
    }

    public String getTipos_de_agresiones() {
        return tipos_de_agresiones;
    }

    public void setTipos_de_agresiones(String tipos_de_agresiones) {
        this.tipos_de_agresiones = tipos_de_agresiones;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getLugar_de_agresion() {
        return lugar_de_agresion;
    }

    public void setLugar_de_agresion(String lugar_de_agresion) {
        this.lugar_de_agresion = lugar_de_agresion;
    }

    public Date getFecha_agresion() {
        return fecha_agresion;
    }

    public void setFecha_agresion(Date fecha_agresion) {
        this.fecha_agresion = fecha_agresion;
    }

    public String getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }

    public String getObjeto_de_agresion() {
        return objeto_de_agresion;
    }

    public void setObjeto_de_agresion(String objeto_de_agresion) {
        this.objeto_de_agresion = objeto_de_agresion;
    }

    public String getEstado_de_conciencia() {
        return estado_de_conciencia;
    }

    public void setEstado_de_conciencia(String estado_de_conciencia) {
        this.estado_de_conciencia = estado_de_conciencia;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getCaso_medico() {
        return caso_medico;
    }

    public void setCaso_medico(String caso_medico) {
        this.caso_medico = caso_medico;
    }

    public String getReferido() {
        return referido;
    }

    public void setReferido(String referido) {
        this.referido = referido;
    }
  
  
    
}
