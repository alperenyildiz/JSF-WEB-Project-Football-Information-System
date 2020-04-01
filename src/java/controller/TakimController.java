/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TakimDAO;
import entity.Takim;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class TakimController implements Serializable {

    private TakimDAO tdao;
    private List<Takim> tlist;
    private Takim takim;
    private String bul = "";

    @Inject
    private Teknik_direktorController teknikDirektorController;
    @Inject
    private StadyumController stadyumController;
    @Inject
    private UlkeController ulkeController;
    @Inject
    private LigController ligController;

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

    public void updateForm(Takim takim) {
        this.takim = takim;
    }

    public void clearForm() {
        this.takim = new Takim();
    }

    public void create() {
        this.getTdao().insert(this.takim);
        this.clearForm();
    }

    /*   public void deleteConfirm(Takim takim) { MODAL İÇİN
        this.takim = takim;
    }*/
    public void delete() {
        this.getTdao().delete(this.takim);
        this.clearForm();
    }

    public void update() {
        this.getTdao().update(this.takim);
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
        this.pageCount = (int) Math.ceil(this.getTdao().count() / (double) pageSize);
        return pageCount;
    }

    public List<Takim> getTlist() {
        this.tlist = this.getTdao().findAll(this.bul, this.page, this.pageSize);
        return tlist;
    }

    public void setTlist(List<Takim> tlist) {
        this.tlist = tlist;
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

    public Takim getTakim() {
        if (this.takim == null) {
            this.takim = new Takim();
        }
        return takim;
    }

    public void setTakim(Takim takim) {
        this.takim = takim;
    }

    public Teknik_direktorController getTeknikDirektorController() {
        return teknikDirektorController;
    }

    public void setTeknikDirektorController(Teknik_direktorController teknikDirektorController) {
        this.teknikDirektorController = teknikDirektorController;
    }

    public StadyumController getStadyumController() {
        return stadyumController;
    }

    public void setStadyumController(StadyumController stadyumController) {
        this.stadyumController = stadyumController;
    }

    public UlkeController getUlkeController() {
        return ulkeController;
    }

    public void setUlkeController(UlkeController ulkeController) {
        this.ulkeController = ulkeController;
    }

    public LigController getLigController() {
        return ligController;
    }

    public void setLigController(LigController ligController) {
        this.ligController = ligController;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
