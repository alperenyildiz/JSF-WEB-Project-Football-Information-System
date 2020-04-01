package converter;

import dao.YetkiDAO;
import entity.Yetki;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "yetkiConverter")
public class YetkiConverter implements Converter {

    private YetkiDAO ydao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getYdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Yetki y = (Yetki) o;
        return String.valueOf(y.getYetki_id());
    }

    public YetkiDAO getYdao() {
        if (this.ydao == null) {
            this.ydao = new YetkiDAO();
        }
        return ydao;
    }

    public void setYdao(YetkiDAO ydao) {
        this.ydao = ydao;
    }

}
