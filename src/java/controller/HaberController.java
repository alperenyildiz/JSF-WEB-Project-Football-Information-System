package controller;

import dao.HaberDAO;
import entity.Haber;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class HaberController implements Serializable {

    private HaberDAO hdao;
    private List<Haber> hlist;
    private String bul = "";

    private Haber haber;

    @Inject
    private KullaniciController kullaniciController;

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void geri() {
        if (this.page == 1) {
            if (this.getPageCount() != 0) {
                this.page = this.getPageCount();
            }
        } else {
            this.page--;
        }
    }

    public void ileri() {
        if (this.page == this.getPageCount() || this.getPageCount() == 0) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void ilk() {
        this.page = 1;
    }

    public void son() {
        if (this.getPageCount() != 0) {

            this.page = this.getPageCount();
        }
    }

    public void updateForm(Haber haber) {
        this.haber = haber;
    }

    public void clearForm() {
        this.haber = new Haber();
    }

    public void create() {
        this.getHdao().insert(this.haber);
        this.clearForm();
    }

    public void delete() {
        this.getHdao().delete(this.haber);
        this.clearForm();
    }

    public void update() {
        this.getHdao().update(this.haber);
        this.clearForm();
    }

    public HaberDAO getHdao() {
        if (this.hdao == null) {
            this.hdao = new HaberDAO();
        }
        return hdao;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getHdao().count() / (double) pageSize);
        return pageCount;
    }

    public List<Haber> getHlist() {
        this.hlist = this.getHdao().findAll(this.bul, this.page, this.pageSize);
        return hlist;
    }

    public Haber getHaber() {
        if (this.haber == null) {
            this.haber = new Haber();
        }
        return haber;
    }

    public KullaniciController getKullaniciController() {
        return kullaniciController;
    }

    public void setHdao(HaberDAO hdao) {
        this.hdao = hdao;
    }

    public void setHlist(List<Haber> hlist) {
        this.hlist = hlist;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public void setHaber(Haber haber) {
        this.haber = haber;
    }

    public void setKullaniciController(KullaniciController kullaniciController) {
        this.kullaniciController = kullaniciController;
    }

}
