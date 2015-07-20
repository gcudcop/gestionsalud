/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medgeneral.logica.clases;

import java.sql.Date;

/**
 *
 * @author Mari
 */
public class Personal {
     
     private int id_personal;
     private String apellidos;
     private String nombres;
     private String cedula_ciudadania;
     private String direccion;
     private String cedula_profecional;
     private String cargo;
     private Date fecha_nacimiento;
     private String telefono;
     private String correo_electronico;
       
 public Personal(){
}
     public Personal (int id_personal ,String apellidos, String nombres, String cedula_ciudadania, String direccion, String cedula_profecional,String cargo,Date fecha_nacimiento, String telefono, String correo_electronico)
     {

        this.id_personal = id_personal;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.cedula_ciudadania = cedula_ciudadania;
        this.direccion = direccion;
        this.cedula_profecional = cedula_profecional;
        this.cargo = cargo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
     }
     
     public int getId_Personal() {
        return id_personal;
    }

    public void setId_Personal(int id_personal) {
        this.id_personal = id_personal;
    }  
     public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos= apellidos;
    }
         
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
     public String getCedula_ciudadania() {
        return cedula_ciudadania;
    }

    public void setCedula_ciudadania(String cedula_ciudadania) {
        this.cedula_ciudadania = cedula_ciudadania;
    }
     public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
     public String getCedula_profecional() {
        return cedula_profecional;
    }

    public void setCedula_profecional(String cedula_profecional) {
        this.cedula_profecional = cedula_profecional;
    }
      public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
     public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
     public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
}

    