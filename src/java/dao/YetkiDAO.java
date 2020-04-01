package dao;

import entity.Kullanici;
import entity.Yetki;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YetkiDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    KullaniciDAO kdao;

    public void insert(Yetki yetki) {

        try {
            pst = this.getConnection().prepareStatement("insert into yetki (yetki_turu) values(?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, yetki.getYetki_turu());
            pst.executeUpdate();

            int y_id = 0;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                y_id = gk.getInt(1);
            }
            for (Kullanici k : yetki.getYetkiKullanicilari()) {
                pst = this.getConnection().prepareStatement("insert into kullanici_yetki (kullanici_id,yetki_id) values (?,?)");
                pst.setInt(1, k.getKullanici_id());
                pst.setInt(2, y_id);
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(" YetkiDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Yetki yetki) {  //kullanici_yetki tablosundaki foreign_key cascade !

        try {
            pst = this.getConnection().prepareStatement("delete from yetki where yetki_id=?");
            pst.setInt(1, yetki.getYetki_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("YetkiDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(yetki_id) as yetki_count from yetki ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("yetki_count");

        } catch (SQLException ex) {
            System.out.println("YetkiDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Yetki> findAll(String deger, int page, int pageSize) {
        List<Yetki> ylist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from yetki where yetki_turu ilike ? order by yetki_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();
            while (rs.next()) {
                Yetki temp = new Yetki(rs.getInt("yetki_id"), rs.getString("yetki_turu"));
                temp.setYetkiKullanicilari(this.getKdao().getYetkiKullanicilari(temp.getYetki_id()));
                ylist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("YetkiDAO HATA(FindAll):" + ex.getMessage());
        }
        return ylist;
    }

    public Yetki find(int id) {
        Yetki y = null;
        try {
            pst = this.getConnection().prepareStatement("select * from yetki where yetki_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            y = new Yetki();
            y.setYetki_id(rs.getInt("yetki_id"));
            y.setYetki_turu(rs.getString("yetki_turu"));
        } catch (SQLException ex) {
            System.out.println("YetkiDAO HATA(FİND) :" + ex.getMessage());
        }
        return y;
    }

    public void update(Yetki yetki) {

        try {
            pst = this.getConnection().prepareStatement("update yetki set yetki_turu=? where yetki_id=?");
            pst.setString(1, yetki.getYetki_turu());
            pst.setInt(2, yetki.getYetki_id());
            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from kullanici_yetki where yetki_id=?");
            pst.setInt(1, yetki.getYetki_id());
            pst.executeUpdate();

            for (Kullanici k : yetki.getYetkiKullanicilari()) {
                pst = this.getConnection().prepareStatement("insert into kullanici_yetki (kullanici_id,yetki_id) values (?,?)");
                pst.setInt(1, k.getKullanici_id());
                pst.setInt(2, yetki.getYetki_id());
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("YetkiDAO HATA(Update): " + ex.getMessage());
        }
    }

    public List<Yetki> getKullaniciYetkileri(int kullanici_id) {
        List<Yetki> list = new ArrayList<>();

        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("select * from kullanici_yetki where kullanici_id=?");
            pst1.setInt(1, kullanici_id);
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {

                list.add(this.find(rs1.getInt("yetki_id")));

            }
        } catch (SQLException ex) {
            System.out.println("YetkiDAO HATA(getKullaniciYetkileri): " + ex.getMessage());
        }
        return list;
    }

    public KullaniciDAO getKdao() {
        if (this.kdao == null) {
            this.kdao = new KullaniciDAO();
        }
        return kdao;
    }

}
