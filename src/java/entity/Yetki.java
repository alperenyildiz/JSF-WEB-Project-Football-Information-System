
package entity;

import java.util.List;


public class Yetki {
    
    private int yetki_id;
    private String yetki_turu;
    
    private List<Kullanici> yetkiKullanicilari;
    
    public Yetki() {
    }

    public Yetki(int yetki_id, String yetki_turu) {
        this.yetki_id = yetki_id;
        this.yetki_turu = yetki_turu;
    }

    public int getYetki_id() {
        return yetki_id;
    }

    public void setYetki_id(int yetki_id) {
        this.yetki_id = yetki_id;
    }

    public String getYetki_turu() {
        return yetki_turu;
    }

    public void setYetki_turu(String yetki_turu) {
        this.yetki_turu = yetki_turu;
    }

    @Override
    public String toString() {
        return "Yetki{" + "yetki_id=" + yetki_id + ", yetki_turu=" + yetki_turu + '}';
    }

    public List<Kullanici> getYetkiKullanicilari() {
        return yetkiKullanicilari;
    }

    public void setYetkiKullanicilari(List<Kullanici> yetkiKullanicilari) {
        this.yetkiKullanicilari = yetkiKullanicilari;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.yetki_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Yetki other = (Yetki) obj;
        if (this.yetki_id != other.yetki_id) {
            return false;
        }
        return true;
    }
    
}
