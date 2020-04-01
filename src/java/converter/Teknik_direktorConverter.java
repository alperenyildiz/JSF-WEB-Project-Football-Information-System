
package converter;

import dao.Teknik_direktorDAO;
import entity.Teknik_direktor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="teknikDirektorConverter")
public class Teknik_direktorConverter implements Converter {

    private Teknik_direktorDAO tdao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       return this.getTdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Teknik_direktor t=(Teknik_direktor) o;
        return String.valueOf(t.getTeknik_direktor_id());
    }

    public Teknik_direktorDAO getTdao() {
        if(this.tdao==null){
            this.tdao=new Teknik_direktorDAO();
        }
            
        return tdao;
    }
    
}
