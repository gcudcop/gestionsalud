/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.entidades.clases;

import java.util.Date;

/**
 *
 * @author gcudcop
 */
public class Personal {

    private int id_personal;
    private String apellidos;
    private String nombres;
    private Date fecha_nacimiento;
    private String cedula_ciudadania;
    private int sexo;
    private int formacion;
    private int especialidad_subespecialidad;
    private int nacionalidad;
    private int autoidentificacion;
    private String codigo_mps;

    /*
     ** Constructores
     */
    public Personal() {
    }

    public Personal(int id_personal, String apellidos, String nombres, Date fecha_nacimiento, String cedula_ciudadania, int sexo, int formacion, int especialidad_subespecialidad, int nacionalidad, int autoidentificacion, String codigo_mps) {
        this.id_personal = id_personal;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fecha_nacimiento = fecha_nacimiento;
        this.cedula_ciudadania = cedula_ciudadania;
        this.sexo = sexo;
        this.formacion = formacion;
        this.especialidad_subespecialidad = especialidad_subespecialidad;
        this.nacionalidad = nacionalidad;
        this.autoidentificacion = autoidentificacion;
        this.codigo_mps = codigo_mps;
    }

    /*
     ** Getters y Setters
     */
    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCedula_ciudadania() {
        return cedula_ciudadania;
    }

    public void setCedula_ciudadania(String cedula_ciudadania) {
        this.cedula_ciudadania = cedula_ciudadania;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getFormacion() {
        return formacion;
    }

    public void setFormacion(int formacion) {
        this.formacion = formacion;
    }

    public int getEspecialidad_subespecialidad() {
        return especialidad_subespecialidad;
    }

    public void setEspecialidad_subespecialidad(int especialidad_subespecialidad) {
        this.especialidad_subespecialidad = especialidad_subespecialidad;
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getAutoidentificacion() {
        return autoidentificacion;
    }

    public void setAutoidentificacion(int autoidentificacion) {
        this.autoidentificacion = autoidentificacion;
    }

    public String getCodigo_mps() {
        return codigo_mps;
    }

    public void setCodigo_mps(String codigo_mps) {
        this.codigo_mps = codigo_mps;
    }

}
