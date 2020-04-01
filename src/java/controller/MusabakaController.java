package controller;

import dao.MusabakaDAO;
import entity.Musabaka;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class MusabakaController implements Serializable {

    private MusabakaDAO mdao;
    private List<Musabaka> mlist;
    private String bul = "";

    private Musabaka musabaka;

    @Inject
    private TakimController takimController;
    @Inject
    private LigController ligController;
    @Inject
    private HakemController hakemController;
    @Inject
    private StadyumController stadyumController;

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

    public void updateForm(Musabaka musabaka) {
        this.musabaka = musabaka;
    }

    public void clearForm() {
        this.musabaka = new Musabaka();
    }

    public void create() {
        this.getMdao().insert(this.musabaka);
        this.clearForm();
    }

    /* public void deleteConfirm(Musabaka musabaka) {  MODAL İÇİN
        this.musabaka = musabaka;
    }*/
    public void delete() {
        this.getMdao().delete(this.musabaka);
        this.clearForm();
    }

    public void update() {
        this.getMdao().update(this.musabaka);
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
        this.pageCount = (int) Math.ceil(this.getMdao().count() / (double) pageSize);
        return pageCount;
    }

    public MusabakaDAO getMdao() {
        if (this.mdao == null) {
            this.mdao = new MusabakaDAO();
        }
        return mdao;
    }

    public void setMdao(MusabakaDAO mdao) {
        this.mdao = mdao;
    }

    public List<Musabaka> getMlist() {
        this.mlist = this.getMdao().findAll(this.bul, this.page, this.pageSize);
        return mlist;
    }

    public void setMlist(List<Musabaka> mlist) {
        this.mlist = mlist;
    }

    public Musabaka getMusabaka() {
        if (this.musabaka == null) {
            this.musabaka = new Musabaka();
        }
        return musabaka;
    }

    public void setMusabaka(Musabaka musabaka) {
        this.musabaka = musabaka;
    }

    public TakimController getTakimController() {
        return takimController;
    }

    public void setTakimController(TakimController takimController) {
        this.takimController = takimController;
    }

    public LigController getLigController() {
        return ligController;
    }

    public void setLigController(LigController ligController) {
        this.ligController = ligController;
    }

    public HakemController getHakemController() {
        return hakemController;
    }

    public void setHakemController(HakemController hakemController) {
        this.hakemController = hakemController;
    }

    public StadyumController getStadyumController() {
        return stadyumController;
    }

    public void setStadyumController(StadyumController stadyumController) {
        this.stadyumController = stadyumController;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
