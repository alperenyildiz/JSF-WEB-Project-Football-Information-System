package entity;

public class Musabaka {

    private int musabaka_id;
    private int takim1_gol;
    private int takim2_gol;

    private Lig lig;
    private Hakem hakem;
    private Stadyum stadyum;
    private Takim takim1;
    private Takim takim2;

    public Musabaka() {
    }

    public Musabaka(int musabaka_id, int takim1_gol, int takim2_gol) {
        this.musabaka_id = musabaka_id;
        this.takim1_gol = takim1_gol;
        this.takim2_gol = takim2_gol;
    }

    public int getMusabaka_id() {
        return musabaka_id;
    }

    public void setMusabaka_id(int musabaka_id) {
        this.musabaka_id = musabaka_id;
    }

    public int getTakim1_gol() {
        return takim1_gol;
    }

    public void setTakim1_gol(int takim1_gol) {
        this.takim1_gol = takim1_gol;
    }

    public int getTakim2_gol() {
        return takim2_gol;
    }

    public void setTakim2_gol(int takim2_gol) {
        this.takim2_gol = takim2_gol;
    }

    public Lig getLig() {
        return lig;
    }

    public void setLig(Lig lig) {
        this.lig = lig;
    }

    public Hakem getHakem() {
        return hakem;
    }

    public void setHakem(Hakem hakem) {
        this.hakem = hakem;
    }

    public Stadyum getStadyum() {
        return stadyum;
    }

    public void setStadyum(Stadyum stadyum) {
        this.stadyum = stadyum;
    }

    public Takim getTakim1() {
        return takim1;
    }

    public void setTakim1(Takim takim1) {
        this.takim1 = takim1;
    }

    public Takim getTakim2() {
        return takim2;
    }

    public void setTakim2(Takim takim2) {
        this.takim2 = takim2;
    }

    @Override
    public String toString() {
        return "Musabaka{" + "musabaka_id=" + musabaka_id + ", takim1_gol=" + takim1_gol + ", takim2_gol=" + takim2_gol + ", lig=" + lig + ", hakem=" + hakem + ", stadyum=" + stadyum + ", takim1=" + takim1 + ", takim2=" + takim2 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.musabaka_id;
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
        final Musabaka other = (Musabaka) obj;
        if (this.musabaka_id != other.musabaka_id) {
            return false;
        }
        return true;
    }

}
