package entity;

public class Hakem {

    private int hakem_id;
    private String isim;
    private int yas;
    private String fifa_kokarti;
    private double ortalama_puan;

    public Hakem() {
    }

    public Hakem(int hakem_id, String isim, int yas, String fifa_kokarti, double ortalama_puan) {
        this.hakem_id = hakem_id;
        this.isim = isim;
        this.yas = yas;
        this.fifa_kokarti = fifa_kokarti;
        this.ortalama_puan = ortalama_puan;
    }

    public int getHakem_id() {
        return hakem_id;
    }

    public void setHakem_id(int hakem_id) {
        this.hakem_id = hakem_id;
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

    public String getFifa_kokarti() {
        return fifa_kokarti;
    }

    public void setFifa_kokarti(String fifa_kokarti) {
        this.fifa_kokarti = fifa_kokarti;
    }

    public double getOrtalama_puan() {
        return ortalama_puan;
    }

    public void setOrtalama_puan(double ortalama_puan) {
        this.ortalama_puan = ortalama_puan;
    }

    @Override
    public String toString() {
        return "Hakem{" + "hakem_id=" + hakem_id + ", isim=" + isim + ", yas=" + yas + ", fifa_kokarti=" + fifa_kokarti + ", ortalama_puan=" + ortalama_puan + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.hakem_id;
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
        final Hakem other = (Hakem) obj;
        if (this.hakem_id != other.hakem_id) {
            return false;
        }
        return true;
    }

}
