/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StadyumDAO;
import entity.Stadyum;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class StadyumController implements Serializable {

    private List<Stadyum> slist;
    private StadyumDAO sdao;
    private String bul = "";

    private Stadyum stadyum;

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

    public void updateForm(Stadyum stadyum) {
        this.stadyum = stadyum;
    }

    public void clearForm() {
        this.stadyum = new Stadyum();
    }

    public void create() {
        this.getSdao().insert(this.stadyum);
        this.clearForm();
    }

    public void delete() {
        this.getSdao().delete(this.stadyum);
        this.clearForm();
    }

    public void update() {
        this.getSdao().update(this.stadyum);
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
        this.pageCount = (int) Math.ceil(this.getSdao().count() / (double) pageSize);
        return pageCount;
    }

    public List<Stadyum> getSlist() {
        this.slist = this.getSdao().findAll(this.bul, this.page, this.pageSize);
        return slist;
    }

    public void setSlist(List<Stadyum> slist) {
        this.slist = slist;
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

    public Stadyum getStadyum() {
        if (this.stadyum == null) {
            this.stadyum = new Stadyum();
        }
        return stadyum;
    }

    public void setStadyum(Stadyum stadyum) {
        this.stadyum = stadyum;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
