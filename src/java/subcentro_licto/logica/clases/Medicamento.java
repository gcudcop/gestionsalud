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
public class Medicamento {
 
    private int id_medicamento;
    private String codigo_medicamento;
    private String nombre_medicamento;
    private String forma_farmaceutica;
    private String concentracion;
    
   

    public Medicamento() {
    }

    public Medicamento(int id_medicamento, String codigo_medicamento, String nombres_medicamento,String froma_famaceuitaca,String concentracion)
    {
    this.id_medicamento = id_medicamento;
    this.codigo_medicamento  = codigo_medicamento;
    this.nombre_medicamento  = nombre_medicamento;
    this.forma_farmaceutica = forma_farmaceutica;
    this.concentracion  = concentracion;
   
       
    }

    public int getId_Medicamento() {
        return id_medicamento;
    }
    public void setid_mediamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }
      public String getCodigo_Medicamento() {
        return codigo_medicamento;
    }
    public void setcodigo_medicamento(String codigo_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
    }
    public String getNombre_Medicamento() {
        return nombre_medicamento;
    }
    public void setnombre_medicamento(String nombre_medicamento) {
        this.nombre_medicamento = nombre_medicamento;
    }
    public String getForma_Farmaceutica() {
        return forma_farmaceutica;
     }
    public void setforma_farmaceutica(String forma_farmaceutica) {
        this.forma_farmaceutica = forma_farmaceutica;
    }
    public String getConcentracion() {
        return concentracion;
    }
    public void setconcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public void getInt(String pid_medicamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_Medicamento(int id_Medicamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
