package dao;

import entity.Ulke;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UlkeDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Ulke ulke) {

        try {
            pst = this.getConnection().prepareStatement("insert into ulke (isim,nufus) values(?,?)");
            pst.setString(1, ulke.getIsim());
            pst.setLong(2, ulke.getNufus());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" UlkeDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Ulke ulke) {

        try {
            pst = this.getConnection().prepareStatement("delete from ulke where ulke_id=?");
            pst.setInt(1, ulke.getUlke_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" UlkeDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(ulke_id) as ulke_count from ulke ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("ulke_count");

        } catch (SQLException ex) {
            System.out.println("UlkeDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Ulke> findAll(String deger, int page, int pageSize) {
        List<Ulke> ulist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from ulke where isim ilike ? order by ulke_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();
            while (rs.next()) {
                Ulke temp = new Ulke(rs.getInt("ulke_id"), rs.getString("isim"), rs.getLong("nufus"));
                ulist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("UlkeDAO HATA(READ):" + ex.getMessage());
        }
        return ulist;
    }

    public Ulke find(int id) {
        Ulke u = null;
        try {
            pst = this.getConnection().prepareStatement("select * from ulke where ulke_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            u = new Ulke();
            u.setUlke_id(rs.getInt("ulke_id"));
            u.setIsim(rs.getString("isim"));
            u.setNufus(rs.getLong("nufus"));

        } catch (SQLException ex) {
            System.out.println("UlkeDAO HATA(FİND) :" + ex.getMessage());
        }
        return u;
    }

    public void update(Ulke ulke) {

        try {
            pst = this.getConnection().prepareStatement("update  ulke set isim=?,nufus=? where ulke_id=?");
            pst.setString(1, ulke.getIsim());
            pst.setLong(2, ulke.getNufus());
            pst.setInt(3, ulke.getUlke_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" UlkeDAO HATA(Delete): " + ex.getMessage());
        }
    }

}
