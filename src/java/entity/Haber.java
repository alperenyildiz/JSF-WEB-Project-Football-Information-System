package entity;

import java.sql.Date;

public class Haber {

    private int haber_id;
    private String baslik;
    private String icerik;
    private Date haber_tarihi;

    private Kullanici kullanici;

    public Haber() {
    }

    public Haber(int haber_id, String baslik, String icerik, Date haber_tarihi) {
        this.haber_id = haber_id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.haber_tarihi = haber_tarihi;
    }

    public int getHaber_id() {
        return haber_id;
    }

    public void setHaber_id(int haber_id) {
        this.haber_id = haber_id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public Date getHaber_tarihi() {
        return haber_tarihi;
    }

    public void setHaber_tarihi(Date haber_tarihi) {
        this.haber_tarihi = haber_tarihi;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    @Override
    public String toString() {
        return "Haber{" + "haber_id=" + haber_id + ", baslik=" + baslik + ", icerik=" + icerik + ", haber_tarihi=" + haber_tarihi + ", kullanici=" + kullanici + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.haber_id;
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
        final Haber other = (Haber) obj;
        if (this.haber_id != other.haber_id) {
            return false;
        }
        return true;
    }

  
}
