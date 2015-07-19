/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medgeneral.logica.clases;

import java.sql.Date;

/**
 *
 * @author gcudcop
 */
public class Paciente {

    private int id_paciente;
    private int historia_clinica;
    private String cedula_ciudadania;
    private String apellido_paterno;
    private String apellido_materno;
    private String primer_nombre;
    private String segundo_nombre;
    private String direccion;
    private String barrio;
    private String parroquia;
    private String canton;
    private String provincia;
    private String zona;
    private String telefono;
    private Date fecha_nacimiento;
    private String lugar_nacimiento;
    private String nacionalidad;
    private String etnia;
    private int edad;
    private String sexo;
    private String estado_civil;
    private String instruccion_academica;
    private Date fecha_admision;
    private String ocupacion;
    private String empresa_trabajo;
    private String tipo_seguro_salud;
    private String referido_de;
    private String familiar_emergencia;
    private String parentesco_afinidad;
    private String direccion_familiar;
    private String telefono_pariente;

    public Paciente() {
    }

    public Paciente(int id_paciente, int historia_clinica, String cedula_ciudadania, String apellido_paterno, String apellido_materno, String primer_nombre, String segundo_nombre, String direccion, String barrio, String parroquia, String canton, String provincia, String zona, String telefono, Date fecha_nacimiento, String lugar_nacimiento, String nacionalidad, String etnia, int edad, String sexo, String estado_civil, String instruccion_academica, Date fecha_admision, String ocupacion, String empresa_trabajo, String tipo_seguro_salud, String referido_de, String familiar_emergencia, String parentesco_afinidad, String direccion_familiar, String telefono_pariente) {
        this.id_paciente = id_paciente;
        this.historia_clinica = historia_clinica;
        this.cedula_ciudadania = cedula_ciudadania;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.direccion = direccion;
        this.barrio = barrio;
        this.parroquia = parroquia;
        this.canton = canton;
        this.provincia = provincia;
        this.zona = zona;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.nacionalidad = nacionalidad;
        this.etnia = etnia;
        this.edad = edad;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
        this.instruccion_academica = instruccion_academica;
        this.fecha_admision = fecha_admision;
        this.ocupacion = ocupacion;
        this.empresa_trabajo = empresa_trabajo;
        this.tipo_seguro_salud = tipo_seguro_salud;
        this.referido_de = referido_de;
        this.familiar_emergencia = familiar_emergencia;
        this.parentesco_afinidad = parentesco_afinidad;
        this.direccion_familiar = direccion_familiar;
        this.telefono_pariente = telefono_pariente;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getHistoria_clinica() {
        return historia_clinica;
    }

    public void setHistoria_clinica(int historia_clinica) {
        this.historia_clinica = historia_clinica;
    }

    public String getCedula_ciudadania() {
        return cedula_ciudadania;
    }

    public void setCedula_ciudadania(String cedula_ciudadania) {
        this.cedula_ciudadania = cedula_ciudadania;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
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

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getInstruccion_academica() {
        return instruccion_academica;
    }

    public void setInstruccion_academica(String instruccion_academica) {
        this.instruccion_academica = instruccion_academica;
    }

    public Date getFecha_admision() {
        return fecha_admision;
    }

    public void setFecha_admision(Date fecha_admision) {
        this.fecha_admision = fecha_admision;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEmpresa_trabajo() {
        return empresa_trabajo;
    }

    public void setEmpresa_trabajo(String empresa_trabajo) {
        this.empresa_trabajo = empresa_trabajo;
    }

    public String getTipo_seguro_salud() {
        return tipo_seguro_salud;
    }

    public void setTipo_seguro_salud(String tipo_seguro_salud) {
        this.tipo_seguro_salud = tipo_seguro_salud;
    }

    public String getReferido_de() {
        return referido_de;
    }

    public void setReferido_de(String referido_de) {
        this.referido_de = referido_de;
    }

    public String getFamiliar_emergencia() {
        return familiar_emergencia;
    }

    public void setFamiliar_emergencia(String familiar_emergencia) {
        this.familiar_emergencia = familiar_emergencia;
    }

    public String getParentesco_afinidad() {
        return parentesco_afinidad;
    }

    public void setParentesco_afinidad(String parentesco_afinidad) {
        this.parentesco_afinidad = parentesco_afinidad;
    }

    public String getDireccion_familiar() {
        return direccion_familiar;
    }

    public void setDireccion_familiar(String direccion_familiar) {
        this.direccion_familiar = direccion_familiar;
    }

    public String getTelefono_pariente() {
        return telefono_pariente;
    }

    public void setTelefono_pariente(String telefono_pariente) {
        this.telefono_pariente = telefono_pariente;
    }
    
    
    
}
