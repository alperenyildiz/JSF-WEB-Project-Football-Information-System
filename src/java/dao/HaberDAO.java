package dao;

import entity.Haber;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HaberDAO extends SuperDAO {

    PreparedStatement pst;
    ResultSet rs;

    KullaniciDAO kdao;

    public void insert(Haber haber) {

        try {
            pst = this.getConnection().prepareStatement("insert into haber(kullanici_id,baslik,icerik) values(?,?,?)");
            pst.setInt(1, haber.getKullanici().getKullanici_id());
            pst.setString(2, haber.getBaslik());
            pst.setString(3, haber.getIcerik());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" HaberDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Haber haber) {

        try {
            pst = this.getConnection().prepareStatement("delete from haber where haber_id=?");
            pst.setInt(1, haber.getHaber_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" HaberDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(haber_id) as haber_count from haber");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("haber_count");

        } catch (SQLException ex) {
            System.out.println("HaberDAO HATA(Count): " + ex.getMessage());
        }
        return count;
    }

    public List<Haber> findAll(String deger, int page, int pageSize) {
        List<Haber> hlist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from haber where baslik ilike ? order by haber_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();

            while (rs.next()) {
                Haber temp = new Haber();
                temp.setHaber_id(rs.getInt("haber_id"));
                temp.setBaslik(rs.getString("baslik"));
                temp.setIcerik(rs.getString("icerik"));
                temp.setHaber_tarihi(rs.getDate("haber_tarihi"));
                temp.setKullanici(this.getKdao().find(rs.getInt("kullanici_id")));

                hlist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("HaberDAO HATA(FindAll):" + ex.getMessage());
        }
        return hlist;
    }

    public void update(Haber haber) {

        try {
            pst = this.getConnection().prepareStatement("update haber set kullanici_id=?,baslik=?,icerik=? where haber_id=?");
            pst.setInt(1, haber.getKullanici().getKullanici_id());
            pst.setString(2, haber.getBaslik());
            pst.setString(3, haber.getIcerik());

            pst.setInt(4, haber.getHaber_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("HaberDAO HATA(Update): " + ex.getMessage());
        }
    }

    public KullaniciDAO getKdao() {
        if (this.kdao == null) {
            this.kdao = new KullaniciDAO();
        }
        return kdao;
    }

    public void setKdao(KullaniciDAO kdao) {
        this.kdao = kdao;
    }

}
