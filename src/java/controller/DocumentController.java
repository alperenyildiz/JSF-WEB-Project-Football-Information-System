package controller;

import dao.DocumentDAO;
import entity.Document;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@SessionScoped
public class DocumentController implements Serializable {

    private Document document;
    private List<Document> documentList;
    private DocumentDAO documentDao;
    private String bul = "";

    private Part doc;  //dosyamızı xhtml tarafına direk yollayamadığımız için part türünde bir referans ürettik
    private final String uploadTo = "D:\\FutbolBilgiSistemi\\";

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

    public void upload() {

        try {
            InputStream input = doc.getInputStream();
            File f = new File(this.getUploadTo() + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());
            /*
            Veritabanına kayıt işlemi
             */
            document = this.getDocoument();
            document.setFileName(f.getName());
            document.setFilePath(f.getParent());
            document.setFileType(doc.getContentType());

            this.getDocumentDao().insert(document);

        } catch (Exception e) {
            System.out.println("DosyaController HATA(UPLOAD):" + e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public Document getDocoument() {
        if (this.document == null) {
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        this.documentList = this.getDocumentDao().findAll(this.bul, this.page, this.pageSize);
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentDAO getDocumentDao() {
        if (this.documentDao == null) {
            this.documentDao = new DocumentDAO();
        }
        return documentDao;
    }

    public void setDocumentDao(DocumentDAO documentDao) {
        this.documentDao = documentDao;
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
        this.pageCount = (int) Math.ceil(this.getDocumentDao().count() / (double) pageSize);
        return pageCount;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
