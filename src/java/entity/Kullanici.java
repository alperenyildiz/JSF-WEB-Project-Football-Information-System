package entity;

import java.util.List;

public class Kullanici {

    private int kullanici_id;
    private String login_name;
    private String sifre;
    private String ad_soyad;
    private String cinsiyet;
    private int yas;
    private String cep_telefonu;
    private String email;

    private List<Yetki> KullaniciYetkileri;

    public Kullanici() {
    }

    public Kullanici(int kullanici_id, String login_name, String sifre, String ad_soyad, String cinsiyet, int yas, String cep_telefonu, String email) {
        this.kullanici_id = kullanici_id;
        this.login_name = login_name;
        this.sifre = sifre;
        this.ad_soyad = ad_soyad;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
        this.cep_telefonu = cep_telefonu;
        this.email = email;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getCep_telefonu() {
        return cep_telefonu;
    }

    public void setCep_telefonu(String cep_telefonu) {
        this.cep_telefonu = cep_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Yetki> getKullaniciYetkileri() {
        return KullaniciYetkileri;
    }

    public void setKullaniciYetkileri(List<Yetki> KullaniciYetkileri) {
        this.KullaniciYetkileri = KullaniciYetkileri;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "kullanici_id=" + kullanici_id + ", login_name=" + login_name + ", sifre=" + sifre + ", ad_soyad=" + ad_soyad + ", cinsiyet=" + cinsiyet + ", yas=" + yas + ", cep_telefonu=" + cep_telefonu + ", email=" + email + ", KullaniciYetkileri=" + KullaniciYetkileri + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.kullanici_id;
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
        final Kullanici other = (Kullanici) obj;
        if (this.kullanici_id != other.kullanici_id) {
            return false;
        }
        return true;
    }

}
