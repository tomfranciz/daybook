/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.entities.enumeration;

/**
 *
 * @author informatica
 */
public enum Currency {
    
     EURO("EU", "EURO"), FEMININO("DL", "DOLAR");

    private String initials;
    private String extension;

    private Currency(String initials, String extension) {
        this.initials = initials;
        this.extension = extension;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

   

    public static Currency getInitials(String id) {
        for (Currency s : values()) {
            if (s.getInitials().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    
    
    
    
}
