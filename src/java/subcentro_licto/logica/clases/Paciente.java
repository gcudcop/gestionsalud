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
public class Paciente {

    private int id_paciente;
    private String apellidos;
    private String nombres;
    private String historia_clinica;
    private Integer sexo;
    private Date fecha_nacimiento;
    private String cedula_ciudadania;
    private Integer nacionalidad;
    private Integer autoidentificacion;
    private Integer aporta_afiliado;
    private String provincia;
    private String canton;
    private String parroquia;
    private String barrio;
    private String sector;
    private String recinto;
    private String comunidad;
    private String direccion;
    private String telefono;
    private Integer grupo_prioritario;

    public Paciente() {
    }

    public Paciente(int id_paciente, String apellidos, String nombres, String historia_clinica, Integer sexo, Date fecha_nacimiento, String cedula_ciudadania, Integer nacionalidad, Integer autoidentificacion, Integer aporta_afiliado, String provincia, String canton, String parroquia, String barrio, String sector, String recinto, String comunidad, String direccion, String telefono, Integer grupo_prioritario)
    {
    this.id_paciente = id_paciente;
    this.apellidos  = apellidos;
    this.nombres  = nombres;
    this.historia_clinica  = historia_clinica;
    this.sexo  = sexo;
    this.fecha_nacimiento  = fecha_nacimiento;
    this.cedula_ciudadania  = cedula_ciudadania;
    this.nacionalidad  = nacionalidad;
    this.autoidentificacion  = autoidentificacion;    
    this.aporta_afiliado  = aporta_afiliado;            
    this.provincia  = provincia;     
    this.canton  = canton;     
    this.parroquia  = parroquia;     
    this.barrio  = barrio;     
    this.sector  = sector;     
    this.recinto  = recinto;     
    this.comunidad  = comunidad;
    this.direccion  = direccion;    
    this.telefono  = telefono;     
    this.grupo_prioritario  = grupo_prioritario;
       
}

    public int getId_paciente() {
        return id_paciente;
    }

    public void setid_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getnombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getHistoria_clinica() {
        return historia_clinica;
    }

    public void setHistoria_clinica(String historia_clinica) {
        this.historia_clinica = historia_clinica;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_Nacimiento() {
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

    public Integer getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Integer nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getAutoidentificacion() {
        return autoidentificacion;
    }

    public void setAutoidentificacion(Integer autoidentificacion) {
        this.autoidentificacion = autoidentificacion;
    }

    public Integer getAporta_Afiliado() {
        return aporta_afiliado;
    }

    public void setAporta_Afiliado(Integer aporta_afiliado) {
        this.aporta_afiliado = aporta_afiliado;
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

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getRecinto() {
        return sector;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getGrupo_prioritario() {
        return grupo_prioritario;
    }

    public void setGrupo_prioritario(Integer grupo_prioritario) {
        this.grupo_prioritario = grupo_prioritario;
    }

    public Object getNombres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getHistoria_Clinica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getCedula_ciudadana() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getGrupo_Prioritario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
