package controller;

import dao.UlkeDAO;
import entity.Ulke;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UlkeController implements Serializable {

    private List<Ulke> ulist;
    private UlkeDAO udao;
    private String bul = "";

    private Ulke ulke;

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

    public void updateForm(Ulke ulke) {
        this.ulke = ulke;
    }

    public void clearForm() {
        this.ulke = new Ulke();
    }

    public void create() {
        this.getUdao().insert(this.ulke);
        this.clearForm();
    }

    public void deleteConfirm(Ulke ulke) { // MODAL İÇİN
        this.ulke = ulke;
    }

    public void delete() {
        this.getUdao().delete(this.ulke);
        this.clearForm();
    }

    public void update() {
        this.getUdao().update(this.ulke);
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
        this.pageCount = (int) Math.ceil(this.getUdao().count() / (double) pageSize);
        return pageCount;
    }

    public List<Ulke> getUlist() {
        this.ulist = this.getUdao().findAll(this.bul, this.page, this.pageSize);
        return ulist;
    }

    public void setUlist(List<Ulke> ulist) {
        this.ulist = ulist;
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

    public Ulke getUlke() {
        if (this.ulke == null) {
            this.ulke = new Ulke();
        }
        return ulke;
    }

    public void setUlke(Ulke ulke) {
        this.ulke = ulke;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
