
package converter;

import dao.LigDAO;
import entity.Lig;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="ligConverter")
public class LigConverter implements Converter {

    private LigDAO ldao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       
        return this.getLdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Lig l=(Lig) o;
        return String.valueOf(l.getLig_id());
    }

    public LigDAO getLdao() {
        if(this.ldao==null){
            this.ldao=new LigDAO();
        }
        return ldao;
    }
    
}
