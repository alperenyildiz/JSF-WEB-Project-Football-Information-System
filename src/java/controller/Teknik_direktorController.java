package controller;

import dao.Teknik_direktorDAO;
import entity.Teknik_direktor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Teknik_direktorController implements Serializable {

    private Teknik_direktorDAO tdao;
    private List<Teknik_direktor> tlist;
    private String bul="";
    
    
    private Teknik_direktor td;

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

    public void updateForm(Teknik_direktor td) {
        this.td = td;
    }

    public void clearForm() {
        this.td = new Teknik_direktor();
    }

    public void create() {
        this.getTdao().insert(this.td);
        this.clearForm();
    }

    public void delete() {
        this.getTdao().delete(this.td);
        this.clearForm();
    }

    public void update() {
        this.getTdao().update(this.td);
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

    public Teknik_direktorDAO getTdao() {
        if (this.tdao == null) {
            this.tdao = new Teknik_direktorDAO();
        }
        return tdao;
    }

    public void setTdao(Teknik_direktorDAO tdao) {
        this.tdao = tdao;
    }

    public Teknik_direktor getTd() {
        if (this.td == null) {
            this.td = new Teknik_direktor();
        }
        return td;
    }

    public void setTd(Teknik_direktor td) {
        this.td = td;
    }

    public List<Teknik_direktor> getTlist() {
        this.tlist = this.getTdao().findAll(this.bul,this.page,this.pageSize);
        return tlist;
    }

    public void setTlist(List<Teknik_direktor> tlist) {
        this.tlist = tlist;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
