/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.logica.clases;

/**
 *
 * @author Mari
 */
public class Unidad_Operativa {

 
    private int id_uo;
    private String nombre_uo;
    private String provincia;
    private String canton;
    private String parroquia;
    private String zona;
    private String distrito;
    private String circuito;
    private String tipo_uo;
    private Integer institucion_sistema;
   
   

    public Unidad_Operativa() {
    }

    public Unidad_Operativa(int id_uo, String nombre_uo, String provincia,String canton,String parroquia,String zona,String distrito,String circuito,String tipo_uo, Integer institucion_sistema)
    {
    this.id_uo = id_uo;
    this.nombre_uo  = nombre_uo;
    this.provincia  = provincia;
    this.canton  = canton;
    this.parroquia  = parroquia;
    this.zona = zona;
    this.distrito = distrito;
    this.circuito = circuito;
    this.tipo_uo=tipo_uo;
    this.institucion_sistema = institucion_sistema;
    
       
}

    public int getId_UO() {
        return id_uo;
    }

    public void setid_uo(int id_uo) {
        this.id_uo = id_uo;
    }

    public String getNombre_UO() {
        return nombre_uo;
    }

    public void setnombre_uo(String nombre_uo) {
        this.nombre_uo = nombre_uo;
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

    public void setparroquia(String parroquia) {
        this.parroquia = parroquia;

    }

    public String getZona () {
        return zona;
    }

    public void setzona(String zona) {
        this.zona = zona;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setdistrito(String distrito) {
        this.distrito = distrito;
    }
     public String getTipo_UO() {
        return tipo_uo;
    }

    public void settipo_uo(String tipo_uo) {
        this.tipo_uo = tipo_uo;
    }
     public Integer getInstitucion_Sistema() {
        return institucion_sistema;
    }

    public void setinstitucion_sistema(String instirucion_sistema) {
        this.institucion_sistema = institucion_sistema;
    }

    public Object getCircuito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_UO(int id_UO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
   
