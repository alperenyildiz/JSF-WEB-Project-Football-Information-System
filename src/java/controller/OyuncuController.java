package controller;

import dao.OyuncuDAO;
import entity.Oyuncu;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class OyuncuController implements Serializable {

    private List<Oyuncu> olist;
    private OyuncuDAO odao;
    private String bul = "";
    private Oyuncu oyuncu;

    @Inject
    private UlkeController ulkeController;
    @Inject
    private TakimController takimController;

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

    public void updateForm(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;
    }

    public void clearForm() {
        this.oyuncu = new Oyuncu();
    }

    public void create() {
        this.getOdao().insert(this.oyuncu);
        this.clearForm();
    }

    /* public void deleteConfirm(Oyuncu oyuncu) {  MODAL İÇİN
        this.oyuncu = oyuncu;
    }*/
    public void delete() {
        this.getOdao().delete(this.oyuncu);
        this.clearForm();
    }

    public void update() {
        this.getOdao().update(this.oyuncu);
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
        this.pageCount = (int) Math.ceil(this.getOdao().count() / (double) pageSize);
        return pageCount;
    }

    public List<Oyuncu> getOlist() {
        this.olist = this.getOdao().findAll(this.bul, this.page, this.pageSize);
        return olist;
    }

    public void setOlist(List<Oyuncu> olist) {
        this.olist = olist;
    }

    public OyuncuDAO getOdao() {
        if (this.odao == null) {
            this.odao = new OyuncuDAO();
        }
        return odao;
    }

    public void setOdao(OyuncuDAO odao) {
        this.odao = odao;
    }

    public Oyuncu getOyuncu() {
        if (this.oyuncu == null) {
            this.oyuncu = new Oyuncu();
        }
        return oyuncu;
    }

    public void setO(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;
    }

    public UlkeController getUlkeController() {
        return ulkeController;
    }

    public void setUlkeController(UlkeController ulkeController) {
        this.ulkeController = ulkeController;
    }

    public TakimController getTakimController() {
        return takimController;
    }

    public void setTakimController(TakimController takimController) {
        this.takimController = takimController;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
