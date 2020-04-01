package entity;

public class Oyuncu {

    private int oyuncu_id;
    private String isim;
    private int yas;
    private int boy;  //cm cinsinden
    private double kilo; //kg cinsinden
    private double deger; //dolar cinsinden
    private String pozisyon;
    private String kullandigi_ayak;
    private int toplam_gol_sayisi;

    private Ulke ulke;
    private Takim takim;

    public Oyuncu() {
    }

    public Oyuncu(int oyuncu_id, String isim, int yas, int boy, double kilo, double deger, String pozisyon, String kullandigi_ayak, int toplam_gol_sayisi) {
        this.oyuncu_id = oyuncu_id;
        this.isim = isim;
        this.yas = yas;
        this.boy = boy;
        this.kilo = kilo;
        this.deger = deger;
        this.pozisyon = pozisyon;
        this.kullandigi_ayak = kullandigi_ayak;
        this.toplam_gol_sayisi = toplam_gol_sayisi;
    }

    public int getOyuncu_id() {
        return oyuncu_id;
    }

    public void setOyuncu_id(int oyuncu_id) {
        this.oyuncu_id = oyuncu_id;
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

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public double getKilo() {
        return kilo;
    }

    public void setKilo(double kilo) {
        this.kilo = kilo;
    }

    public double getDeger() {
        return deger;
    }

    public void setDeger(double deger) {
        this.deger = deger;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public String getKullandigi_ayak() {
        return kullandigi_ayak;
    }

    public void setKullandigi_ayak(String kullandigi_ayak) {
        this.kullandigi_ayak = kullandigi_ayak;
    }

    public int getToplam_gol_sayisi() {
        return toplam_gol_sayisi;
    }

    public void setToplam_gol_sayisi(int toplam_gol_sayisi) {
        this.toplam_gol_sayisi = toplam_gol_sayisi;
    }

    public Ulke getUlke() {
        return ulke;
    }

    public void setUlke(Ulke ulke) {
        this.ulke = ulke;
    }

    public Takim getTakim() {
        return takim;
    }

    public void setTakim(Takim takim) {
        this.takim = takim;
    }

    @Override
    public String toString() {
        return "Oyuncu{" + "oyuncu_id=" + oyuncu_id + ", isim=" + isim + ", yas=" + yas + ", boy=" + boy + ", kilo=" + kilo + ", deger=" + deger + ", pozisyon=" + pozisyon + ", kullandigi_ayak=" + kullandigi_ayak + ", toplam_gol_sayisi=" + toplam_gol_sayisi + ", ulke=" + ulke + ", takim=" + takim + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.oyuncu_id;
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
        final Oyuncu other = (Oyuncu) obj;
        if (this.oyuncu_id != other.oyuncu_id) {
            return false;
        }
        return true;
    }

}
