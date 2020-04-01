package dao;

import entity.Musabaka;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusabakaDAO extends SuperDAO {

    PreparedStatement pst;
    ResultSet rs;

    private LigDAO ldao;
    private HakemDAO hdao;
    private StadyumDAO sdao;
    private TakimDAO tdao;

    public void insert(Musabaka m) {

        try {
            pst = this.getConnection().prepareStatement("insert into musabaka (lig_id,hakem_id,stadyum_id,takim1_id,takim1_gol,takim2_id,takim2_gol) "
                    + "values(?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, m.getLig().getLig_id());
            pst.setInt(2, m.getHakem().getHakem_id());
            pst.setInt(3, m.getTakim1().getStadyum().getStadyum_id());
            pst.setInt(4, m.getTakim1().getTakim_id());
            pst.setInt(5, m.getTakim1_gol());
            pst.setInt(6, m.getTakim2().getTakim_id());
            pst.setInt(7, m.getTakim2_gol());

            pst.executeUpdate();

            int m_id = 0;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                m_id = gk.getInt(1);
            }
            pst = this.getConnection().prepareStatement("insert into takim_musabaka (takim_id,musabaka_id) values(?,?)");
            pst.setInt(1, m.getTakim1().getTakim_id());
            pst.setInt(2, m_id);
            pst.executeUpdate();
            //deplasman için de bir satır ekliyoruz takim_musabakaya
            pst = this.getConnection().prepareStatement("insert into takim_musabaka (takim_id,musabaka_id) values(?,?)");
            pst.setInt(1, m.getTakim2().getTakim_id());
            pst.setInt(2, m_id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(" MusabakaDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Musabaka m) {

        try {
            pst = this.getConnection().prepareStatement("delete from musabaka where musabaka_id=?");
            pst.setInt(1, m.getMusabaka_id());
            pst.executeUpdate();
            //Musabakayı silince ilişkili takim_musabaka tablosundan musabakaları silmemize gerek yok otomatik siliniyor.
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" MusabakaDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(musabaka_id) as musabaka_count from musabaka ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("musabaka_count");

        } catch (SQLException ex) {
            System.out.println("MusabakaDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Musabaka> findAll(String deger, int page, int pageSize) {
        List<Musabaka> mlist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from takim inner join musabaka on takim.takim_id=musabaka.takim1_id or takim.takim_id=musabaka.takim2_id where isim ilike ? order by musabaka_id asc limit ? offset ?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, pageSize);
            pst.setInt(3, start);
            rs = pst.executeQuery();
            while (rs.next()) {
                Musabaka temp = new Musabaka(rs.getInt("musabaka_id"), rs.getInt("takim1_gol"), rs.getInt("takim2_gol"));
                temp.setLig(this.getLdao().find(rs.getInt("lig_id")));
                temp.setHakem(this.getHdao().find(rs.getInt("hakem_id")));
                temp.setStadyum(this.getSdao().find(rs.getInt("stadyum_id")));
                temp.setTakim1(this.getTdao().find(rs.getInt("takim1_id")));
                temp.setTakim2(this.getTdao().find(rs.getInt("takim2_id")));
                mlist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("MusabakaDAO HATA(FindAll):" + ex.getMessage());
        }
        return mlist;
    }

    public Musabaka find(int id) {
        Musabaka m = null;
        try {
            pst = this.getConnection().prepareStatement("select * from musabaka where musabaka_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            m = new Musabaka();

            m.setMusabaka_id(rs.getInt("musabaka_id"));
            m.setLig(this.getLdao().find(rs.getInt("lig_id")));
            m.setHakem(this.getHdao().find(rs.getInt("hakem_id")));
            m.setStadyum(this.getSdao().find(rs.getInt("stadyum_id")));
            m.setTakim1(this.getTdao().find(rs.getInt("takim1_id")));
            m.setTakim1_gol(rs.getInt("takim1_gol"));
            m.setTakim2(this.getTdao().find(rs.getInt("takim2_id")));
            m.setTakim2_gol(rs.getInt("takim2_gol"));

        } catch (SQLException ex) {
            System.out.println("MusabakaDAO HATA(FİND) :" + ex.getMessage());
        }
        return m;
    }

    public void update(Musabaka m) {

        try {
            pst = this.getConnection().prepareStatement("update musabaka set lig_id=?,hakem_id=?,stadyum_id=?,takim1_id=?,"
                    + "takim1_gol=?,takim2_id=?,takim2_gol=? where musabaka_id=?");

            pst.setInt(1, m.getLig().getLig_id());
            pst.setInt(2, m.getHakem().getHakem_id());
            pst.setInt(3, m.getTakim1().getStadyum().getStadyum_id());
            pst.setInt(4, m.getTakim1().getTakim_id());
            pst.setInt(5, m.getTakim1_gol());
            pst.setInt(6, m.getTakim2().getTakim_id());
            pst.setInt(7, m.getTakim2_gol());
            pst.setInt(8, m.getMusabaka_id());
            pst.executeUpdate();
//update yapmak için önce update yapılacak olan musabakanın  takim_musabaka'daki verilerini siliyoruz.
            pst = this.getConnection().prepareStatement("delete from takim_musabaka where musabaka_id=?");
            pst.setInt(1, m.getMusabaka_id());
            pst.executeUpdate();

//Şimdi tekrar yeni musabakanın takımlarını ekliyoruz takim_musabaka'ya
            pst = this.getConnection().prepareStatement("insert into takim_musabaka(takim_id,musabaka_id) values(?,?)");
            pst.setInt(1, m.getTakim1().getTakim_id());
            pst.setInt(2, m.getMusabaka_id());
            pst.executeUpdate();
            //TAKIM2 için de güncelliyoruz takim_musabakayı
            pst = this.getConnection().prepareStatement("insert into takim_musabaka(takim_id,musabaka_id) values(?,?)");
            pst.setInt(1, m.getTakim2().getTakim_id());
            pst.setInt(2, m.getMusabaka_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("KullaniciDAO HATA(Update): " + ex.getMessage());
        }
    }

    public List<Musabaka> getTakiminMusabakalari(int takim_id) {
        List<Musabaka> list = new ArrayList<>();

        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("select * from takim_musabaka where takim_id=?");
            pst1.setInt(1, takim_id);
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {

                list.add(this.find(rs1.getInt("musabaka_id")));

            }
        } catch (SQLException ex) {
            System.out.println("MusabakaDAO HATA(getTakimMusabakalari): " + ex.getMessage());
        }
        return list;
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

    public HakemDAO getHdao() {
        if (this.hdao == null) {
            this.hdao = new HakemDAO();
        }
        return hdao;
    }

    public void setHdao(HakemDAO hdao) {
        this.hdao = hdao;
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
