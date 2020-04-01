package dao;

import entity.Oyuncu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OyuncuDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;
    UlkeDAO udao;
    TakimDAO tdao;

    public void insert(Oyuncu oyuncu) {

        try {
            pst = this.getConnection().prepareStatement("insert into oyuncu (isim,yas,boy,kilo,deger,pozisyon,kullandigi_ayak,toplam_gol_sayisi,"
                    + "ulke_id,takim_id) values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, oyuncu.getIsim());
            pst.setInt(2, oyuncu.getYas());
            pst.setInt(3, oyuncu.getBoy());
            pst.setDouble(4, oyuncu.getKilo());
            pst.setDouble(5, oyuncu.getDeger());
            pst.setString(6, oyuncu.getPozisyon());
            pst.setString(7, oyuncu.getKullandigi_ayak());
            pst.setInt(8, oyuncu.getToplam_gol_sayisi());
            pst.setInt(9, oyuncu.getUlke().getUlke_id());
            pst.setInt(10, oyuncu.getTakim().getTakim_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" OyuncuDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Oyuncu oyuncu) {

        try {
            pst = this.getConnection().prepareStatement("delete from oyuncu where oyuncu_id=?");
            pst.setInt(1, oyuncu.getOyuncu_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" OyuncuDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(oyuncu_id) as oyuncu_count from oyuncu ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("oyuncu_count");

        } catch (SQLException ex) {
            System.out.println("OyuncuDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Oyuncu> findAll(String deger, int page, int pageSize) {
        List<Oyuncu> olist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from oyuncu where isim ilike ? order by oyuncu_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();
            while (rs.next()) {
                Oyuncu temp = new Oyuncu();
                temp.setOyuncu_id(rs.getInt("oyuncu_id"));
                temp.setIsim(rs.getString("isim"));
                temp.setYas(rs.getInt("yas"));
                temp.setBoy(rs.getInt("boy"));
                temp.setKilo(rs.getDouble("kilo"));
                temp.setDeger(rs.getDouble("deger"));
                temp.setPozisyon(rs.getString("pozisyon"));
                temp.setKullandigi_ayak(rs.getString("kullandigi_ayak"));
                temp.setToplam_gol_sayisi(rs.getInt("toplam_gol_sayisi"));
                temp.setUlke(this.getUdao().find(rs.getInt("ulke_id")));
                temp.setTakim(this.getTdao().find(rs.getInt("takim_id")));
                olist.add(temp);

            }
        } catch (SQLException ex) {
            System.out.println("OyuncuDAO HATA(FindAll):" + ex.getMessage());
        }
        return olist;
    }

    public void update(Oyuncu oyuncu) {

        try {
            pst = this.getConnection().prepareStatement("update oyuncu set isim=?,yas=?,boy=?,kilo=?,deger=?,pozisyon=?,"
                    + "kullandigi_ayak=?,toplam_gol_sayisi=?,ulke_id=?,takim_id=? where oyuncu_id=?");
            pst.setString(1, oyuncu.getIsim());
            pst.setInt(2, oyuncu.getYas());
            pst.setInt(3, oyuncu.getBoy());
            pst.setDouble(4, oyuncu.getKilo());
            pst.setDouble(5, oyuncu.getDeger());
            pst.setString(6, oyuncu.getPozisyon());
            pst.setString(7, oyuncu.getKullandigi_ayak());
            pst.setInt(8, oyuncu.getToplam_gol_sayisi());
            pst.setInt(9, oyuncu.getUlke().getUlke_id());
            pst.setInt(10, oyuncu.getTakim().getTakim_id());

            pst.setInt(11, oyuncu.getOyuncu_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("OyuncuDAO HATA(Update): " + ex.getMessage());
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

    public TakimDAO getTdao() {
        if (this.tdao == null) {
            this.tdao = new TakimDAO();
        }
        return tdao;
    }

    public void setTdao(TakimDAO tdao) {
        this.tdao = tdao;
    }

}
