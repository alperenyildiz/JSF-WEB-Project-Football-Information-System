package entity;

import java.util.List;

public class Takim {

    private int takim_id;
    private String isim;
    private int kurulus_yili;
    private long kulup_degeri;
    private int sampiyonluk_sayisi;
    private int oynanan_mac;
    private int galibiyet;
    private int beraberlik;
    private int maglubiyet;
    private int atilan_gol;
    private int yenilen_gol;
    private int puan;

    private Stadyum stadyum;
    private Ulke ulke;
    private Lig lig;
    private Teknik_direktor teknik_direktor;
    
    private List<Musabaka> takimMusabakalari;

    public Takim() {
    }

    public Takim(int takim_id, String isim, int kurulus_yili, int sampiyonluk_sayisi, int oynanan_mac, int galibiyet, int beraberlik, int maglubiyet, int atilan_gol, int yenilen_gol, int puan) {
        this.takim_id = takim_id;
        this.isim = isim;
        this.kurulus_yili = kurulus_yili;
        this.sampiyonluk_sayisi = sampiyonluk_sayisi;
        this.oynanan_mac = oynanan_mac;
        this.galibiyet = galibiyet;
        this.beraberlik = beraberlik;
        this.maglubiyet = maglubiyet;
        this.atilan_gol = atilan_gol;
        this.yenilen_gol = yenilen_gol;
        this.puan = puan;
    }



    public int getTakim_id() {
        return takim_id;
    }

    public void setTakim_id(int takim_id) {
        this.takim_id = takim_id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getKurulus_yili() {
        return kurulus_yili;
    }

    public void setKurulus_yili(int kurulus_yili) {
        this.kurulus_yili = kurulus_yili;
    }

    public long getKulup_degeri() {
        return kulup_degeri;
    }

    public void setKulup_degeri(long kulup_degeri) {
        this.kulup_degeri = kulup_degeri;
    }

    public int getSampiyonluk_sayisi() {
        return sampiyonluk_sayisi;
    }

    public void setSampiyonluk_sayisi(int sampiyonluk_sayisi) {
        this.sampiyonluk_sayisi = sampiyonluk_sayisi;
    }

    public int getOynanan_mac() {
        return oynanan_mac;
    }

    public void setOynanan_mac(int oynanan_mac) {
        this.oynanan_mac = oynanan_mac;
    }

    public int getGalibiyet() {
        return galibiyet;
    }

    public void setGalibiyet(int galibiyet) {
        this.galibiyet = galibiyet;
    }

    public int getBeraberlik() {
        return beraberlik;
    }

    public void setBeraberlik(int beraberlik) {
        this.beraberlik = beraberlik;
    }

    public int getMaglubiyet() {
        return maglubiyet;
    }

    public void setMaglubiyet(int maglubiyet) {
        this.maglubiyet = maglubiyet;
    }

    public int getAtilan_gol() {
        return atilan_gol;
    }

    public void setAtilan_gol(int atilan_gol) {
        this.atilan_gol = atilan_gol;
    }

    public int getYenilen_gol() {
        return yenilen_gol;
    }

    public void setYenilen_gol(int yenilen_gol) {
        this.yenilen_gol = yenilen_gol;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public Stadyum getStadyum() {
        return stadyum;
    }

    public void setStadyum(Stadyum stadyum) {
        this.stadyum = stadyum;
    }

    public Ulke getUlke() {
        return ulke;
    }

    public void setUlke(Ulke ulke) {
        this.ulke = ulke;
    }

    public Lig getLig() {
        return lig;
    }

    public void setLig(Lig lig) {
        this.lig = lig;
    }

    public Teknik_direktor getTeknik_direktor() {
        return teknik_direktor;
    }

    public void setTeknik_direktor(Teknik_direktor teknik_direktor) {
        this.teknik_direktor = teknik_direktor;
    }

    public List<Musabaka> getTakimMusabakalari() {
        return takimMusabakalari;
    }

    public void setTakimMusabakalari(List<Musabaka> takimMusabakalari) {
        this.takimMusabakalari = takimMusabakalari;
    }

    
    @Override
    public String toString() {
        return "Takim{" + "takim_id=" + takim_id + ", isim=" + isim + ", kurulus_yili=" + kurulus_yili + ", kulup_degeri=" + kulup_degeri + ", sampiyonluk_sayisi=" + sampiyonluk_sayisi + ", oynanan_mac=" + oynanan_mac + ", galibiyet=" + galibiyet + ", beraberlik=" + beraberlik + ", maglubiyet=" + maglubiyet + ", atilan_gol=" + atilan_gol + ", yenilen_gol=" + yenilen_gol + ", puan=" + puan + ", stadyum=" + stadyum + ", ulke=" + ulke + ", lig=" + lig + ", teknik_direktor=" + teknik_direktor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.takim_id;
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
        final Takim other = (Takim) obj;
        if (this.takim_id != other.takim_id) {
            return false;
        }
        return true;
    }



}
