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
public class Personal {
 
    private int id_personal;
    private String apellidos;
    private String nombres;
    private Date fecha_nacimiento;
    private String cedula_ciudadania;
    private Integer sexo;
    private Integer formacion;
    private Integer especialidad_subespecialidad;
    private Integer nacionalidad;
    private String autoidentificacion;
    private String codigo_mps;
   

    public Personal() {
    }

    public Personal(int id_personal, String apellidos, String nombres,Date fecha_nacimiento, String cedula_ciudadania,Integer sexo,Integer formacion,Integer especialidad_subespecialidad, Integer nacionalidad, String autoidentificacion, String codigo_mps)
    {
    this.id_personal = id_personal;
    this.apellidos  = apellidos;
    this.nombres  = nombres;
    this.fecha_nacimiento  = fecha_nacimiento;
    this.cedula_ciudadania  = cedula_ciudadania;
    this.sexo  = sexo;
    this.formacion=formacion;
    this.especialidad_subespecialidad=especialidad_subespecialidad;
    this.nacionalidad=nacionalidad;
    this.autoidentificacion=autoidentificacion;
    this.codigo_mps=codigo_mps;
       
}

    public int getId_personal() {
        return id_personal;
    }

    public void setid_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getNombres() {
        return nombres;
    }

    public void setnombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setfecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String getCedula_ciudadania() {
        return cedula_ciudadania;
    }

    public void setcedula_ciudadania(String cedula_ciudadania) {
        this.cedula_ciudadania = cedula_ciudadania;
    }
    public Integer getSexo() {
        return sexo;
    }

    public void setsexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Integer getFormacion() {
        return formacion;
    }

    public void setformacion(Integer formacion) {
        this.formacion = formacion;
    }

    public Integer getEspecialidad_Subespecialidad() {
        return especialidad_subespecialidad;
    }

    public void setespecialidad_subespecialidad(Integer especialidad_subespecialidad) {
        this.especialidad_subespecialidad = especialidad_subespecialidad;
    }

    public Integer getNacionalidad() {
        return nacionalidad;
    }

    public void setnacionalidad(Integer nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getAutoidentificacion() {
        return autoidentificacion;
    }

    public void setautoidentificacion(String autoidentificacion) {
        this.autoidentificacion = autoidentificacion;
    }

    public String getCodigo_Mps() {
        return codigo_mps;
    }

    public void setcodigo_mps(String codigo_mps) {
        this.codigo_mps = codigo_mps;
    }
}