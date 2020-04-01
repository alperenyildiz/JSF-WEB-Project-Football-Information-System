/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.HakemDAO;
import entity.Hakem;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="hakemConverter")
public class HakemConverter implements Converter {

    private HakemDAO hdao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getHdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Hakem h=(Hakem) o;
        return String.valueOf(h.getHakem_id());
    }

    public HakemDAO getHdao() {
        if(this.hdao==null){
            this.hdao=new HakemDAO();
        }
        return hdao;
    }
    
}
