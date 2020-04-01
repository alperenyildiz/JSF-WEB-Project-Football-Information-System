package dao;

import entity.Teknik_direktor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teknik_direktorDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Teknik_direktor td) {

        try {
            pst = this.getConnection().prepareStatement("insert into teknik_direktor(isim,yas,deger,basari_yuzdesi) values(?,?,?,?)");
            pst.setString(1, td.getIsim());
            pst.setInt(2, td.getYas());
            pst.setDouble(3, td.getDeger());
            pst.setDouble(4, td.getBasari_yuzdesi());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" TeknikDirektorDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Teknik_direktor td) {

        try {
            pst = this.getConnection().prepareStatement("delete from teknik_direktor where teknik_direktor_id=?");
            pst.setInt(1, td.getTeknik_direktor_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" TeknikDirektorDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(teknik_direktor_id) as teknik_direktor_count from teknik_direktor ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("teknik_direktor_count");

        } catch (SQLException ex) {
            System.out.println("Teknik_direktorDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Teknik_direktor> findAll(String deger, int page, int pageSize) {
        List<Teknik_direktor> tlist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from teknik_direktor where isim ilike ? order by teknik_direktor_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();
            while (rs.next()) {
                Teknik_direktor temp = new Teknik_direktor(rs.getInt("teknik_direktor_id"), rs.getString("isim"), rs.getInt("yas"), rs.getDouble("deger"), rs.getDouble("basari_yuzdesi"));
                tlist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("TeknikDirektorDAO HATA(FindAll):" + ex.getMessage());
        }
        return tlist;
    }

    public Teknik_direktor find(int id) {
        Teknik_direktor t = null;
        try {
            pst = this.getConnection().prepareStatement("select * from teknik_direktor where teknik_direktor_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            t = new Teknik_direktor();
            t.setIsim(rs.getString("isim"));
            t.setDeger(rs.getDouble("deger"));
            t.setTeknik_direktor_id(rs.getInt("teknik_direktor_id"));
            t.setYas(rs.getInt("yas"));
            t.setBasari_yuzdesi(rs.getDouble("basari_yuzdesi"));
        } catch (SQLException ex) {
            System.out.println("TeknikDirektorDAO HATA(FİND) :" + ex.getMessage());
        }
        return t;
    }

    public void update(Teknik_direktor td) {

        try {
            pst = this.getConnection().prepareStatement("update teknik_direktor set isim=?,yas=?,deger=?,basari_yuzdesi=? where teknik_direktor_id=?");
            pst.setString(1, td.getIsim());
            pst.setInt(2, td.getYas());
            pst.setDouble(3, td.getDeger());
            pst.setDouble(4, td.getBasari_yuzdesi());

            pst.setInt(5, td.getTeknik_direktor_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("TeknikDirektorDAO HATA(Update): " + ex.getMessage());
        }
    }
}
