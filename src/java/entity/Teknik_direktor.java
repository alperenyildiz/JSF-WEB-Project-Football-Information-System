
package entity;


public class Teknik_direktor {
    
    private int teknik_direktor_id;
    private String isim;
    private int yas;
    private double deger;
    private double basari_yuzdesi;

    public Teknik_direktor() {
    }

    public Teknik_direktor(int teknik_direktor_id, String isim, int yas, double deger, double basari_yuzdesi) {
        this.teknik_direktor_id = teknik_direktor_id;
        this.isim = isim;
        this.yas = yas;
        this.deger = deger;
        this.basari_yuzdesi = basari_yuzdesi;
    }

    public int getTeknik_direktor_id() {
        return teknik_direktor_id;
    }

    public void setTeknik_direktor_id(int teknik_direktor_id) {
        this.teknik_direktor_id = teknik_direktor_id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public double getDeger() {
        return deger;
    }

    public void setDeger(double deger) {
        this.deger = deger;
    }

    public double getBasari_yuzdesi() {
        return basari_yuzdesi;
    }

    public void setBasari_yuzdesi(double basari_yuzdesi) {
        this.basari_yuzdesi = basari_yuzdesi;
    }

    @Override
    public String toString() {
        return "Teknik_direktor{" + "teknik_direktor_id=" + teknik_direktor_id + ", isim=" + isim + ", yas=" + yas + ", deger=" + deger + ", basari_yuzdesi=" + basari_yuzdesi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.teknik_direktor_id;
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
        final Teknik_direktor other = (Teknik_direktor) obj;
        if (this.teknik_direktor_id != other.teknik_direktor_id) {
            return false;
        }
        return true;
    }
    
}
