
package entity;


public class Stadyum {
    
    private int stadyum_id;
    private String stadyum_adi;
    private int kapasite;
    private int yapilis_yili;
    private String sehir;

    public Stadyum() {
    }

    public Stadyum(int stadyum_id, String stadyum_adi, int kapasite, int yapilis_yili, String sehir) {
        this.stadyum_id = stadyum_id;
        this.stadyum_adi = stadyum_adi;
        this.kapasite = kapasite;
        this.yapilis_yili = yapilis_yili;
        this.sehir = sehir;
    }

    public int getStadyum_id() {
        return stadyum_id;
    }

    public void setStadyum_id(int stadyum_id) {
        this.stadyum_id = stadyum_id;
    }

    public String getStadyum_adi() {
        return stadyum_adi;
    }

    public void setStadyum_adi(String stadyum_adi) {
        this.stadyum_adi = stadyum_adi;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public int getYapilis_yili() {
        return yapilis_yili;
    }

    public void setYapilis_yili(int yapilis_yili) {
        this.yapilis_yili = yapilis_yili;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    @Override
    public String toString() {
        return "Stadyum{" + "stadyum_id=" + stadyum_id + ", stadyum_adi=" + stadyum_adi + ", kapasite=" + kapasite + ", yapilis_yili=" + yapilis_yili + ", sehir=" + sehir + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.stadyum_id;
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
        final Stadyum other = (Stadyum) obj;
        if (this.stadyum_id != other.stadyum_id) {
            return false;
        }
        return true;
    }
    
    
}
