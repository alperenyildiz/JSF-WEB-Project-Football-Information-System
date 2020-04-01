package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class KullaniciController implements Serializable {

    private KullaniciDAO kdao;
    private List<Kullanici> klist;
    private String bul = "";

    private Kullanici kullanici;
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    @Inject
    private YetkiController yetkiController;

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

    public void updateForm(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public void clearForm() {
        this.kullanici = new Kullanici();
    }

    public void create() {
        this.getKdao().insert(this.kullanici);
        this.clearForm();
    }

    public void delete() {
        this.getKdao().delete(this.kullanici);
        this.clearForm();
    }

    public void update() {
        this.getKdao().update(this.kullanici);
        this.clearForm();
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
        this.pageCount = (int) Math.ceil(this.getKdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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

    public List<Kullanici> getKlist() {
        this.klist = this.getKdao().findAll(this.bul, this.page, this.pageSize);
        return klist;
    }

    public void setKlist(List<Kullanici> klist) {
        this.klist = klist;
    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setK(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public YetkiController getYetkiController() {
        return yetkiController;
    }

    public void setYetkiController(YetkiController yetkiController) {
        this.yetkiController = yetkiController;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }
}
