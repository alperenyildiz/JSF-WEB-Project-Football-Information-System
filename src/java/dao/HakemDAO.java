package dao;

import entity.Hakem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HakemDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Hakem hakem) {

        try {
            pst = this.getConnection().prepareStatement("insert into hakem(isim,yas,fifa_kokarti,ortalama_puan) values(?,?,?,?)");
            pst.setString(1, hakem.getIsim());
            pst.setInt(2, hakem.getYas());
            pst.setString(3, hakem.getFifa_kokarti());
            pst.setDouble(4, hakem.getOrtalama_puan());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" HakemDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Hakem hakem) {

        try {
            pst = this.getConnection().prepareStatement("delete from hakem where hakem_id=?");
            pst.setInt(1, hakem.getHakem_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" HakemDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;

        try {
            pst = this.getConnection().prepareStatement("select count(hakem_id) as hakem_count from hakem");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("hakem_count");
        } catch (SQLException ex) {
            System.out.println("HakemDAO HATA(Count): " + ex.getMessage());
        }
        return count;
    }

    public List<Hakem> findAll(String deger, int page, int pageSize) {
        List<Hakem> hlist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from hakem where isim ilike ? order by hakem_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();

            while (rs.next()) {
                Hakem temp = new Hakem(rs.getInt("hakem_id"), rs.getString("isim"), rs.getInt("yas"), rs.getString("fifa_kokarti"), rs.getDouble("ortalama_puan"));
                hlist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("HakemDAO HATA(FindAll):" + ex.getMessage());
        }
        return hlist;
    }

    public Hakem find(int id) {
        Hakem h = null;
        try {
            pst = this.getConnection().prepareStatement("select * from hakem where hakem_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            h = new Hakem();

            h.setHakem_id(rs.getInt("hakem_id"));
            h.setIsim(rs.getString("isim"));
            h.setYas(rs.getInt("yas"));
            h.setFifa_kokarti(rs.getString("fifa_kokarti"));
            h.setOrtalama_puan(rs.getDouble("ortalama_puan"));

        } catch (SQLException ex) {
            System.out.println("HakemDAO HATA(FİND) :" + ex.getMessage());
        }
        return h;
    }

    public void update(Hakem hakem) {

        try {
            pst = this.getConnection().prepareStatement("update hakem set isim=?,yas=?,fifa_kokarti=?,ortalama_puan=? where hakem_id=?");
            pst.setString(1, hakem.getIsim());
            pst.setInt(2, hakem.getYas());
            pst.setString(3, hakem.getFifa_kokarti());
            pst.setDouble(4, hakem.getOrtalama_puan());

            pst.setInt(5, hakem.getHakem_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("HakemDAO HATA(Update): " + ex.getMessage());
        }
    }

}
