package controller;

import dao.LigDAO;
import entity.Lig;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class LigController implements Serializable {

    private List<Lig> llist;
    private LigDAO ldao;
    private Lig lig;
    private String bul = "";

    @Inject
    private UlkeController ulkeController;

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

    public void updateForm(Lig lig) {
        this.lig = lig;
    }

    public void clearForm() {
        this.lig = new Lig();
    }

    public void create() {
        this.getLdao().insert(this.lig);
        this.clearForm();
    }

    public void delete() {
        this.getLdao().delete(this.lig);
        this.clearForm();
    }

    public void update() {
        this.getLdao().update(this.lig);
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
        this.pageCount = (int) Math.ceil(this.getLdao().count() / (double) pageSize);
        return pageCount;
    }

    public List<Lig> getLlist() {
        this.llist = this.getLdao().findAll(this.bul, this.page, this.pageSize);
        return llist;
    }

    public void setLlist(List<Lig> llist) {
        this.llist = llist;
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

    public Lig getLig() {
        if (this.lig == null) {
            this.lig = new Lig();
        }
        return lig;
    }

    public void setLig(Lig lig) {
        this.lig = lig;
    }

    public UlkeController getUlkeController() {
        return ulkeController;
    }

    public void setUlkeController(UlkeController ulkeController) {
        this.ulkeController = ulkeController;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
