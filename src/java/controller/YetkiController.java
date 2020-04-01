package controller;

import dao.YetkiDAO;
import entity.Yetki;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class YetkiController implements Serializable {

    private YetkiDAO ydao;
    private List<Yetki> ylist;
    private String bul = "";
    private Yetki yetki;

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

    public void updateForm(Yetki yetki) {
        this.yetki = yetki;
    }

    public void clearForm() {
        this.yetki = new Yetki();
    }

    public void create() {
        this.getYdao().insert(this.yetki);
        this.clearForm();
    }

    /*  public void deleteConfirm(Yetki yetki) { //MODAL İÇİN,SİLME ONAYI
        this.yetki = yetki;
    }*/
    public void delete() {
        this.getYdao().delete(this.yetki);
        this.clearForm();
    }

    public void update() {
        this.getYdao().update(this.yetki);
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
        this.pageCount = (int) Math.ceil(this.getYdao().count() / (double) pageSize);
        return pageCount;
    }

    public YetkiDAO getYdao() {
        if (this.ydao == null) {
            this.ydao = new YetkiDAO();
        }
        return ydao;
    }

    public void setYdao(YetkiDAO ydao) {
        this.ydao = ydao;
    }

    public List<Yetki> getYlist() {
        this.ylist = this.getYdao().findAll(this.bul, this.page, this.pageSize);
        return ylist;
    }

    public void setYlist(List<Yetki> ylist) {
        this.ylist = ylist;
    }

    public Yetki getYetki() {
        if (this.yetki == null) {
            this.yetki = new Yetki();
        }
        return yetki;
    }

    public void setYetki(Yetki yetki) {
        this.yetki = yetki;
    }

    public KullaniciController getKullaniciController() {
        return kullaniciController;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
