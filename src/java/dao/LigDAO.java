package dao;

import entity.Lig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LigDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;
    UlkeDAO udao;

    public void insert(Lig lig) {

        try {
            pst = this.getConnection().prepareStatement("insert into lig (lig_adi,ulke_id,takim_sayisi,sezon) values(?,?,?,?)");
            pst.setString(1, lig.getLig_adi());
            pst.setInt(2, lig.getUlke().getUlke_id());
            pst.setInt(3, lig.getTakim_sayisi());
            pst.setInt(4, lig.getSezon());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" LigDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Lig lig) {

        try {
            pst = this.getConnection().prepareStatement("delete from lig where lig_id=?");
            pst.setInt(1, lig.getLig_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" LigDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(lig_id) as lig_count from lig ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("lig_count");

        } catch (SQLException ex) {
            System.out.println("LigDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Lig> findAll(String deger, int page, int pageSize) {
        List<Lig> llist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from lig where lig_adi ilike ? order by lig_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();
            while (rs.next()) {
                Lig temp = new Lig();
                temp.setLig_id(rs.getInt("lig_id"));
                temp.setLig_adi(rs.getString("lig_adi"));
                temp.setTakim_sayisi(rs.getInt("takim_sayisi"));
                temp.setSezon(rs.getInt("sezon"));
                temp.setUlke(this.getUdao().find(rs.getInt("ulke_id")));
                System.out.println(temp.getLig_adi());
                llist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("LigDAO HATA(FindAll):" + ex.getMessage());
        }
        return llist;
    }

    public Lig find(int id) {
        Lig l = null;
        try {
            pst = this.getConnection().prepareStatement("select * from lig where lig_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            l = new Lig();
            l.setLig_id(rs.getInt("lig_id"));
            l.setLig_adi(rs.getString("lig_adi"));
            l.setSezon(rs.getInt("sezon"));
            l.setTakim_sayisi(rs.getInt("takim_sayisi"));
            l.setUlke(this.getUdao().find(rs.getInt("ulke_id")));

        } catch (SQLException ex) {
            System.out.println("LigDAO HATA(FİND) :" + ex.getMessage());
        }
        return l;
    }

    public void update(Lig lig) {

        try {
            pst = this.getConnection().prepareStatement("update lig set lig_adi=?,takim_sayisi=?,sezon=?,ulke_id=? where lig_id=?");
            pst.setString(1, lig.getLig_adi());
            pst.setInt(2, lig.getTakim_sayisi());
            pst.setInt(3, lig.getSezon());
            pst.setInt(4, lig.getUlke().getUlke_id());

            pst.setInt(5, lig.getLig_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("LigDAO HATA(Update): " + ex.getMessage());
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

}
