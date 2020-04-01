
package entity;


public class Lig {
   
    private int lig_id;
    private String lig_adi;
    private int takim_sayisi;
    private int sezon;
    
    private Ulke ulke;

    public Lig() {
    }

    public Lig(int lig_id, String lig_adi,int takim_sayisi, int sezon) {
        this.lig_id = lig_id;
        this.lig_adi = lig_adi;
        this.takim_sayisi = takim_sayisi;
        this.sezon = sezon;
    }

    public int getLig_id() {
        return lig_id;
    }

    public void setLig_id(int lig_id) {
        this.lig_id = lig_id;
    }

    public String getLig_adi() {
        return lig_adi;
    }

    public void setLig_adi(String lig_adi) {
        this.lig_adi = lig_adi;
    }
    public int getTakim_sayisi() {
        return takim_sayisi;
    }

    public void setTakim_sayisi(int takim_sayisi) {
        this.takim_sayisi = takim_sayisi;
    }

    public int getSezon() {
        return sezon;
    }

    public void setSezon(int sezon) {
        this.sezon = sezon;
    }

    public Ulke getUlke() {
        return ulke;
    }

    public void setUlke(Ulke ulke) {
        this.ulke = ulke;
    }

    @Override
    public String toString() {
        return "Lig{" + "lig_id=" + lig_id + ", lig_adi=" + lig_adi + ", takim_sayisi=" + takim_sayisi + ", sezon=" + sezon + ", ulke=" + ulke + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.lig_id;
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
        final Lig other = (Lig) obj;
        if (this.lig_id != other.lig_id) {
            return false;
        }
        return true;
    }

    
 
}
