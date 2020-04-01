
package entity;


public class Ulke {
    
    private int ulke_id;
    private String isim;
    private long nufus;

    public Ulke() {
    }

    public Ulke(int ulke_id, String isim, long nufus) {
        this.ulke_id = ulke_id;
        this.isim = isim;
        this.nufus = nufus;
    }

    public int getUlke_id() {
        return ulke_id;
    }

    public void setUlke_id(int ulke_id) {
        this.ulke_id = ulke_id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public long getNufus() {
        return nufus;
    }

    public void setNufus(long nufus) {
        this.nufus = nufus;
    }

    @Override
    public String toString() {
        return "Ulke{" + "ulke_id=" + ulke_id + ", isim=" + isim + ", nufus=" + nufus + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.ulke_id;
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
        final Ulke other = (Ulke) obj;
        if (this.ulke_id != other.ulke_id) {
            return false;
        }
        return true;
    }
    
    
}
