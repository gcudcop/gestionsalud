/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salud.presentacion.beans;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Xp
 */
@ManagedBean
@RequestScoped
public class GaleriaLicto {

    /**
     * Creates a new instance of GaleriaLicto
     */
    private ArrayList<String> imagesLicto;

    public ArrayList<String> getImagesLicto() {
        return imagesLicto;
    }

    public void setImagesLicto(ArrayList<String> imagesLicto) {
        this.imagesLicto = imagesLicto;
    }

    
    
    public GaleriaLicto() {
        this.init();
    
    }
    
     @PostConstruct
    public void init() {
        imagesLicto = new ArrayList<String>();
        for (int i = 1; i <= 13; i++) {
            imagesLicto.add("licto" + i + ".jpg");
        }
    }

}
