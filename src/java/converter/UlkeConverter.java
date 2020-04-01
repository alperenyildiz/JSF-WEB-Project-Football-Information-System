
package converter;

import dao.UlkeDAO;
import entity.Ulke;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="ulkeConverter")
public class UlkeConverter implements Converter {

    private UlkeDAO udao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getUdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Ulke u=(Ulke) o;
        return String.valueOf(u.getUlke_id());
    }

    public UlkeDAO getUdao() {
        if(this.udao==null){
            this.udao=new UlkeDAO();
        }
        return udao;
    }
    
}
