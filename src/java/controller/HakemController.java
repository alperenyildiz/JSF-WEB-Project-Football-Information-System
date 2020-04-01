package controller;

import dao.HakemDAO;
import entity.Hakem;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HakemController implements Serializable {

    private HakemDAO hdao;
    private List<Hakem> hlist;
    private String bul = "";

    private Hakem hakem;
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

    public void updateForm(Hakem hakem) {
        this.hakem = hakem;
    }

    public void clearForm() {
        this.hakem = new Hakem();
    }

    public void create() {
        this.getHdao().insert(this.hakem);
        this.clearForm();
    }

    /* public void deleteConfirm(Hakem hakem) {  MODAL EKLEMEK İÇİN OLUŞTURDUK
        this.hakem = hakem;
    }*/
    public void delete() {
        this.getHdao().delete(this.hakem);
        this.clearForm();
    }

    public void update() {
        this.getHdao().update(this.hakem);
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
        this.pageCount = (int) Math.ceil(this.getHdao().count() / (double) pageSize);
        return pageCount;
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

    public List<Hakem> getHlist() {
        this.hlist = this.getHdao().findAll(this.bul, this.page, this.pageSize);
        return hlist;
    }

    public void setHlist(List<Hakem> hlist) {
        this.hlist = hlist;
    }

    public Hakem getHakem() {
        if (this.hakem == null) {
            this.hakem = new Hakem();
        }
        return hakem;
    }

    public void setHakem(Hakem hakem) {
        this.hakem = hakem;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
