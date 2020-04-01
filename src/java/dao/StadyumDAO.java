package dao;

import entity.Stadyum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StadyumDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Stadyum stadyum) {

        try {
            pst = this.getConnection().prepareStatement("insert into stadyum (stadyum_adi,kapasite,yapilis_yili,sehir) values(?,?,?,?)");
            pst.setString(1, stadyum.getStadyum_adi());
            pst.setInt(2, stadyum.getKapasite());
            pst.setInt(3, stadyum.getYapilis_yili());
            pst.setString(4, stadyum.getSehir());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" StadyumDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Stadyum stadyum) {

        try {
            pst = this.getConnection().prepareStatement("delete from stadyum where stadyum_id=?");
            pst.setInt(1, stadyum.getStadyum_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" StadyumDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(stadyum_id) as stadyum_count from stadyum ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("stadyum_count");

        } catch (SQLException ex) {
            System.out.println("StadyumDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Stadyum> findAll(String deger, int page, int pageSize) {
        List<Stadyum> slist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from stadyum where stadyum_adi ilike ? order by stadyum_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();
            while (rs.next()) {
                Stadyum temp = new Stadyum(rs.getInt("stadyum_id"), rs.getString("stadyum_adi"), rs.getInt("kapasite"), rs.getInt("yapilis_yili"), rs.getString("sehir"));
                slist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("StadyumDAO HATA(FindAll):" + ex.getMessage());
        }
        return slist;
    }

    public Stadyum find(int id) {
        Stadyum s = null;
        try {
            pst = this.getConnection().prepareStatement("select * from stadyum where stadyum_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            s = new Stadyum();

            s.setStadyum_adi(rs.getString("stadyum_adi"));
            s.setStadyum_id(rs.getInt("stadyum_id"));
            s.setSehir(rs.getString("sehir"));
            s.setKapasite(rs.getInt("kapasite"));
            s.setYapilis_yili(rs.getInt("yapilis_yili"));

        } catch (SQLException ex) {
            System.out.println("StadyumDAO HATA(FİND) :" + ex.getMessage());
        }
        return s;
    }

    public void update(Stadyum stadyum) {

        try {
            pst = this.getConnection().prepareStatement("update stadyum set stadyum_adi=?,kapasite=?,yapilis_yili=?,sehir=? where stadyum_id=?");
            pst.setString(1, stadyum.getStadyum_adi());
            pst.setInt(2, stadyum.getKapasite());
            pst.setInt(3, stadyum.getYapilis_yili());
            pst.setString(4, stadyum.getSehir());

            pst.setInt(5, stadyum.getStadyum_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("StadyumDAO HATA(Update): " + ex.getMessage());
        }
    }

}
