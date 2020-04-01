package dao;

import entity.Lig;
import entity.Takim;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TakimDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;
    private UlkeDAO udao;
    private LigDAO ldao;
    private StadyumDAO sdao;
    private Teknik_direktorDAO tdao;
    private MusabakaDAO mdao;

    public void insert(Takim takim) {

        try {
            pst = this.getConnection().prepareStatement("insert into takim (isim,kurulus_yili,kulup_degeri,sampiyonluk_sayisi,teknik_direktor_id,stadyum_id,ulke_id,"
                    + "lig_id,oynanan_mac,galibiyet,beraberlik,maglubiyet,atilan_gol,yenilen_gol,puan) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, takim.getIsim());
            pst.setInt(2, takim.getKurulus_yili());
            pst.setLong(3, takim.getKulup_degeri());
            pst.setInt(4, takim.getSampiyonluk_sayisi());
            pst.setInt(5, takim.getTeknik_direktor().getTeknik_direktor_id());
            pst.setInt(6, takim.getStadyum().getStadyum_id());
            pst.setInt(7, takim.getUlke().getUlke_id());
            pst.setInt(8, takim.getLig().getLig_id());
            pst.setInt(9, takim.getOynanan_mac());
            pst.setInt(10, takim.getGalibiyet());
            pst.setInt(11, takim.getBeraberlik());
            pst.setInt(12, takim.getMaglubiyet());
            pst.setInt(13, takim.getAtilan_gol());
            pst.setInt(14, takim.getYenilen_gol());
            pst.setInt(15, takim.getPuan());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" TakimDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Takim takim) {

        try {
            pst = this.getConnection().prepareStatement("delete from takim where takim_id=?");
            pst.setInt(1, takim.getTakim_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" TakimDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(takim_id) as takim_count from takim ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("takim_count");

        } catch (SQLException ex) {
            System.out.println("TakimDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Takim> findAll(String deger, int page, int pageSize) {
        List<Takim> tlist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from takim where isim ilike ? order by takim_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();
            while (rs.next()) {
                Takim temp = new Takim();
                temp.setTakim_id(rs.getInt("takim_id"));
                temp.setIsim(rs.getString("isim"));
                temp.setKurulus_yili(rs.getInt("kurulus_yili"));
                temp.setKulup_degeri(rs.getLong("kulup_degeri"));
                temp.setSampiyonluk_sayisi(rs.getInt("sampiyonluk_sayisi"));
                temp.setTeknik_direktor(this.getTdao().find(rs.getInt("teknik_direktor_id")));
                temp.setStadyum(this.getSdao().find(rs.getInt("stadyum_id")));
                temp.setUlke(this.getUdao().find(rs.getInt("ulke_id")));
                temp.setLig(this.getLdao().find(rs.getInt("lig_id")));
                temp.setOynanan_mac(rs.getInt("oynanan_mac"));
                temp.setGalibiyet(rs.getInt("galibiyet"));
                temp.setBeraberlik(rs.getInt("beraberlik"));
                temp.setMaglubiyet(rs.getInt("maglubiyet"));
                temp.setAtilan_gol(rs.getInt("atilan_gol"));
                temp.setYenilen_gol(rs.getInt("yenilen_gol"));
                temp.setPuan(rs.getInt("puan"));
                temp.setTakimMusabakalari(this.getMdao().getTakiminMusabakalari(temp.getTakim_id()));

                tlist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("TakimDAO HATA(FindAll):" + ex.getMessage());
        }
        return tlist;
    }

    public Takim find(int id) {
        Takim t = null;
        try {
            pst = this.getConnection().prepareStatement("select * from takim where takim_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            t = new Takim();
            t.setTakim_id(rs.getInt("takim_id"));
            t.setIsim(rs.getString("isim"));
            t.setKurulus_yili(rs.getInt("kurulus_yili"));
            t.setKulup_degeri(rs.getLong("kulup_degeri"));
            t.setSampiyonluk_sayisi(rs.getInt("sampiyonluk_sayisi"));
            t.setTeknik_direktor(this.getTdao().find(rs.getInt("teknik_direktor_id")));
            t.setStadyum(this.getSdao().find(rs.getInt("stadyum_id")));
            t.setUlke(this.getUdao().find(rs.getInt("ulke_id")));
            t.setLig(this.getLdao().find(rs.getInt("lig_id")));
            t.setOynanan_mac(rs.getInt("oynanan_mac"));
            t.setGalibiyet(rs.getInt("galibiyet"));
            t.setBeraberlik(rs.getInt("beraberlik"));
            t.setMaglubiyet(rs.getInt("maglubiyet"));
            t.setAtilan_gol(rs.getInt("atilan_gol"));
            t.setYenilen_gol(rs.getInt("yenilen_gol"));
            t.setPuan(rs.getInt("puan"));

        } catch (SQLException ex) {
            System.out.println("TakımDAO HATA(FİND) :" + ex.getMessage());
        }
        return t;
    }

    public void update(Takim takim) {

        try {
            pst = this.getConnection().prepareStatement("update takim set isim=?,kurulus_yili=?,kulup_degeri=?,sampiyonluk_sayisi=?"
                    + ",teknik_direktor_id=?,stadyum_id=?,ulke_id=?,lig_id=?,oynanan_mac=?,galibiyet=?,beraberlik=?,maglubiyet=?,"
                    + "atilan_gol=?,yenilen_gol=?,puan=? where takim_id=?");
            pst.setString(1, takim.getIsim());
            pst.setInt(2, takim.getKurulus_yili());
            pst.setLong(3, takim.getKulup_degeri());
            pst.setInt(4, takim.getSampiyonluk_sayisi());
            pst.setInt(5, takim.getTeknik_direktor().getTeknik_direktor_id());
            pst.setInt(6, takim.getStadyum().getStadyum_id());
            pst.setInt(7, takim.getUlke().getUlke_id());
            pst.setInt(8, takim.getLig().getLig_id());
            pst.setInt(9, takim.getOynanan_mac());
            pst.setInt(10, takim.getGalibiyet());
            pst.setInt(11, takim.getBeraberlik());
            pst.setInt(12, takim.getMaglubiyet());
            pst.setInt(13, takim.getAtilan_gol());
            pst.setInt(14, takim.getYenilen_gol());
            pst.setInt(15, takim.getPuan());

            pst.setInt(16, takim.getTakim_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("TakimDAO HATA(Update): " + ex.getMessage());
        }
    }

    public UlkeDAO getUdao() {
        if (this.udao == null) {
            this.udao = new UlkeDAO();
        }
        return udao;
    }

    public void setUdao(UlkeDAO udao) {
        this.udao = udao;
    }

    public LigDAO getLdao() {
        if (this.ldao == null) {
            this.ldao = new LigDAO();
        }
        return ldao;
    }

    public void setLdao(LigDAO ldao) {
        this.ldao = ldao;
    }

    public StadyumDAO getSdao() {
        if (this.sdao == null) {
            this.sdao = new StadyumDAO();
        }
        return sdao;
    }

    public void setSdao(StadyumDAO sdao) {
        this.sdao = sdao;
    }

    public Teknik_direktorDAO getTdao() {
        if (this.tdao == null) {
            this.tdao = new Teknik_direktorDAO();
        }
        return tdao;
    }

    public void setTdao(Teknik_direktorDAO tdao) {
        this.tdao = tdao;
    }

    public MusabakaDAO getMdao() {
        if (this.mdao == null) {
            this.mdao = new MusabakaDAO();
        }
        return mdao;
    }

    public void setMdao(MusabakaDAO mdao) {
        this.mdao = mdao;
    }

}
