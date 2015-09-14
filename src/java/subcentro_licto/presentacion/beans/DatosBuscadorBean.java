/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcentro_licto.presentacion.beans;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import recursos.Util;
import subcentro_licto.logica.clases.Datos;
import subcentro_licto.logica.funciones.FDatos;

/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class DatosBuscadorBean implements Serializable {

    /**
     * Creates a new instance of DatosBuscadorBean
     */
    private ArrayList<Datos> lstDatos;
    private ArrayList<Datos> lstFiltradaDatos;
    private List<Datos> lstDatos1;
    private List<Datos> lstFiltradaDatos1;
    private Datos datosSel;
    private String palabraBusqueda;
    private int numero;
    private int tamano;

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalabraBusqueda() {
        return palabraBusqueda;
    }

    public void setPalabraBusqueda(String palabraBusqueda) {
        this.palabraBusqueda = palabraBusqueda;
    }

    public List<Datos> getLstDatos1() {
        return lstDatos1;
    }

    public void setLstDatos1(List<Datos> lstDatos1) {
        this.lstDatos1 = lstDatos1;
    }

    public List<Datos> getLstFiltradaDatos1() {
        return lstFiltradaDatos1;
    }

    public void setLstFiltradaDatos1(List<Datos> lstFiltradaDatos1) {
        this.lstFiltradaDatos1 = lstFiltradaDatos1;
    }

    public ArrayList<Datos> getLstDatos() {
        return lstDatos;
    }

    public void setLstDatos(ArrayList<Datos> lstDatos) {
        this.lstDatos = lstDatos;
    }

    public ArrayList<Datos> getLstFiltradaDatos() {
        return lstFiltradaDatos;
    }

    public void setLstFiltradaDatos(ArrayList<Datos> lstFiltradaDatos) {
        this.lstFiltradaDatos = lstFiltradaDatos;
    }

    public Datos getDatosSel() {
        return datosSel;
    }

    public void setDatosSel(Datos datosSel) {
        this.datosSel = datosSel;
    }

    public DatosBuscadorBean() {
        reinit();
    }

//    @PostConstruct
    private void reinit() {
        this.lstDatos = new ArrayList<Datos>();
        this.datosSel = new Datos();
        this.lstFiltradaDatos = new ArrayList<Datos>();
        palabraBusqueda = "Mostrar Todos";
        this.cargarDatosBusqueda();

    }

    public void cargarDatos() {
        try {
            this.lstDatos = FDatos.ObtenerDatos();
            this.datosSel = lstDatos.get(0);
            System.out.println(lstDatos.get(0).getApellidos());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarDatos  dice: " + e.getMessage());
            System.out.println("public void cargarDatos dice: " + e.getMessage());
        }
    }

    public void cargarDatosBusqueda() {
        try {
            if (palabraBusqueda.equals("Mostrar Todos")) {
                this.lstDatos = FDatos.ObtenerDatos();
                if (lstDatos.isEmpty()) {
                    Util.addSuccessMessage("No se han encontrado Datos");
                    System.out.println("No se han encontrado Datos");
                    palabraBusqueda = "";
                } else {
                    this.datosSel = lstDatos.get(0);
                    //this.lstClientes.get(0).getCodigoCli();
                    System.out.println(lstDatos.get(0).getApellidos());
                    palabraBusqueda = "";
                }

            } else {

                if (isNumeric(palabraBusqueda)) {
                    numero = Integer.parseInt(palabraBusqueda);
                    this.lstDatos = FDatos.ObtenerDatosGlobalesEdad(numero);
                    if (lstDatos.isEmpty()) {
                        Util.addSuccessMessage("No se han encontrado Datos ");
                        System.out.println("No se han encontrado Datos");
                        palabraBusqueda = "";
                    } else {
                        Util.addSuccessMessage("Se han encontrado " + lstDatos.size() + " Registros");
                        tamano = lstDatos.size();
                        this.datosSel = lstDatos.get(0);
                        //this.lstClientes.get(0).getCodigoCli();
                        System.out.println(lstDatos.get(0).getApellidos());
                        palabraBusqueda = "";
                    }
                } else {
                    this.lstDatos = FDatos.ObtenerDatosGlobales(palabraBusqueda);
                    if (lstDatos.isEmpty()) {
                        Util.addSuccessMessage("No se han encontrado Datos ");
                        System.out.println("No se han encontrado Datos");
                        palabraBusqueda = "";
                    } else {
                        Util.addSuccessMessage("Se han encontrado " + lstDatos.size() + " Registros");
                        tamano = lstDatos.size();
                        this.datosSel = lstDatos.get(0);
                        //this.lstClientes.get(0).getCodigoCli();
                        System.out.println(lstDatos.get(0).getApellidos());
                        palabraBusqueda = "";
                    }
                }

            }

        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDatos dice: " + e.getMessage());
            System.out.println("private void cargarDatos dice: " + e.getMessage());
        }
    }

    public void resetear() {
        palabraBusqueda = "Mostrar Todos";
        reinit();
    }
//COMPARA SI ES INTEGER O STRING 

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public void imprimirDatos() {
        //DateFormat dfDateFull = DateFormat.getDateInstance(DateFormat.FULL);
        try {

            //Generamos el archivo PDF
            String directorioArchivos;
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            directorioArchivos = ctx.getRealPath("/") + "reports";
            String name = directorioArchivos + "/documento-datos.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(name));

            //PdfWriter writer = PdfWriter.getInstance(document,
            //new FileOutputStream("C:"));
            Paragraph paragraph = new Paragraph();

            PdfPTable table = new PdfPTable(2);
            PdfPTable table1 = new PdfPTable(2);
            PdfPTable table2 = new PdfPTable(2);
            PdfPTable table3 = new PdfPTable(2);
            PdfPTable table4 = new PdfPTable(2);
            PdfPTable table5 = new PdfPTable(2);
            PdfPTable table6 = new PdfPTable(2);
            PdfPTable table7 = new PdfPTable(2);
            PdfPTable table8 = new PdfPTable(2);
            PdfPTable table9 = new PdfPTable(2);
            PdfPTable table10 = new PdfPTable(2);
            PdfPTable table11 = new PdfPTable(2);
            PdfPTable table12 = new PdfPTable(2);
            PdfPTable table13 = new PdfPTable(1);

            paragraph.add("\n\n\n\n\n\n");
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);

            document.open();
            Image image1 = Image.getInstance("C:/Users/Usuario/Documents/NetBeansProjects/gestionsalud/web/resources/images/logoMSP.jpg");

            image1.setAlignment(Element.ALIGN_CENTER);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Fecha Agresión: " + datosSel.getFecha_agresion()));
            PdfPCell cell7 = new PdfPCell(new Paragraph("Fecha Atención: " + datosSel.getFecha_de_atencion()));
            PdfPCell cell8 = new PdfPCell(new Paragraph("Nombres: " + datosSel.getNombres()));
            PdfPCell cell11 = new PdfPCell(new Paragraph("Apellidos: " + datosSel.getApellidos()));
            PdfPCell cell12 = new PdfPCell(new Paragraph("Edad: " + datosSel.getEdad()));
            PdfPCell cell9 = new PdfPCell(new Paragraph("Sexo: " + datosSel.getSexo()));
            PdfPCell cell10 = new PdfPCell(new Paragraph("Estado Civil:" + datosSel.getEstado_civil()));
            PdfPCell cell13 = new PdfPCell(new Paragraph("Instrucción:" + datosSel.getInstruccion_formal()));
            PdfPCell cell1 = new PdfPCell(new Paragraph("Ocupación: " + datosSel.getOcupacion()));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Institución: " + datosSel.getInstitucion()));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Asociación: " + datosSel.getAsociacion()));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Provincia: " + datosSel.getProvincia()));
            PdfPCell cell6 = new PdfPCell(new Paragraph("Cantón: " + datosSel.getCanton_domicilio()));
            PdfPCell cell14 = new PdfPCell(new Paragraph("Parroquia: " + datosSel.getParroquia_domicilio()));
            PdfPCell cell15 = new PdfPCell(new Paragraph("Barrio: " + datosSel.getBarrio()));
            PdfPCell cell16 = new PdfPCell(new Paragraph("Calles: " + datosSel.getCalles_domicilio()));
            PdfPCell cell17 = new PdfPCell(new Paragraph("Dirección Trabajo: " + datosSel.getDireccion_trabajo()));
            PdfPCell cell18 = new PdfPCell(new Paragraph("Teléfono Domicilio: " + datosSel.getTelefono()));
            PdfPCell cell19 = new PdfPCell(new Paragraph("Teléfono Trabajo: " + datosSel.getTelefono_trabajo()));
            PdfPCell cell20 = new PdfPCell(new Paragraph("Objeto de Agresión: " + datosSel.getObjeto_de_agresion()));
            PdfPCell cell21 = new PdfPCell(new Paragraph("Tipo de Agresión: " + datosSel.getTipos_de_agresiones()));
            PdfPCell cell22 = new PdfPCell(new Paragraph("Estado de Conciencia: " + datosSel.getEstado_de_conciencia()));
            PdfPCell cell23 = new PdfPCell(new Paragraph("Lugar de Agresión: " + datosSel.getLugar_de_agresion()));
            PdfPCell cell24 = new PdfPCell(new Paragraph("Frecuencia: " + datosSel.getFrecuencia()));
            PdfPCell cell25 = new PdfPCell(new Paragraph("Caso Medico: " + datosSel.getCaso_medico()));
            PdfPCell cell26 = new PdfPCell(new Paragraph("Tratamiento: " + datosSel.getTratamiento()));
            PdfPCell cell27 = new PdfPCell(new Paragraph("Referido: " + datosSel.getReferido()));

            cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell10.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell13.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell15.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell16.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell17.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell18.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell19.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell22.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell24.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell25.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell27.setHorizontalAlignment(Element.ALIGN_LEFT);

            cell1.setBorder(Rectangle.NO_BORDER);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell3.setBorder(Rectangle.NO_BORDER);
            cell4.setBorder(Rectangle.NO_BORDER);
            cell5.setBorder(Rectangle.NO_BORDER);
            cell6.setBorder(Rectangle.NO_BORDER);
            cell7.setBorder(Rectangle.NO_BORDER);
            cell8.setBorder(Rectangle.NO_BORDER);
            cell9.setBorder(Rectangle.NO_BORDER);
            cell10.setBorder(Rectangle.NO_BORDER);
            cell11.setBorder(Rectangle.NO_BORDER);
            cell12.setBorder(Rectangle.NO_BORDER);
            cell13.setBorder(Rectangle.NO_BORDER);
            cell14.setBorder(Rectangle.NO_BORDER);
            cell15.setBorder(Rectangle.NO_BORDER);
            cell16.setBorder(Rectangle.NO_BORDER);
            cell17.setBorder(Rectangle.NO_BORDER);
            cell18.setBorder(Rectangle.NO_BORDER);
            cell19.setBorder(Rectangle.NO_BORDER);
            cell20.setBorder(Rectangle.NO_BORDER);
            cell21.setBorder(Rectangle.NO_BORDER);
            cell22.setBorder(Rectangle.NO_BORDER);
            cell23.setBorder(Rectangle.NO_BORDER);
            cell24.setBorder(Rectangle.NO_BORDER);
            cell25.setBorder(Rectangle.NO_BORDER);
            cell26.setBorder(Rectangle.NO_BORDER);
            cell27.setBorder(Rectangle.NO_BORDER);

            table1.addCell(cell5);
            table1.addCell(cell7);
            table2.addCell(cell8);
            table2.addCell(cell11);
            table3.addCell(cell12);
            table3.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell13);
            table4.addCell(cell1);
            table4.addCell(cell2);
            table5.addCell(cell3);
            table5.addCell(cell4);
            table6.addCell(cell6);
            table6.addCell(cell14);
            table7.addCell(cell15);
            table7.addCell(cell16);
            table8.addCell(cell17);
            table8.addCell(cell18);
            table9.addCell(cell19);
            table9.addCell(cell20);
            table10.addCell(cell21);
            table10.addCell(cell22);
            table11.addCell(cell23);
            table11.addCell(cell24);
            table12.addCell(cell25);
            table12.addCell(cell26);
            table13.addCell(cell27);

            document.add(image1);
            document.add(paragraph);
            document.add(table1);
            document.add(table2);
            document.add(table3);
            document.add(table);
            document.add(table4);
            document.add(table5);
            document.add(table6);
            document.add(table7);
            document.add(table8);
            document.add(table9);
            document.add(table10);
            document.add(table11);
            document.add(table12);
            document.add(table13);
            //document.add(table);
            //document.setFooter(event);

            document.close();
            //----------------------------
            //Abrimos el archivo PDF
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition",
                    "inline=filename=" + name);
            try {
                response.getOutputStream().write(Util.getBytesFromFile(new File(name)));
                response.getOutputStream().flush();
                response.getOutputStream().close();
                context.responseComplete();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
