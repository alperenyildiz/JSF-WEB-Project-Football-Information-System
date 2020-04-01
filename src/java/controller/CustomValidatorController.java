package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("validator")
@SessionScoped
public class CustomValidatorController implements Serializable {

    private Collection<FacesMessage> msgList = new ArrayList<>();

    public boolean validateAdSoyad(FacesContext fc, UIComponent uı, Object v) {

        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Ad Ve Soyad Giriniz  ! "));
            isValid = false;
        } else if (value.length() < 3 || value.length() > 50) {
            msgList.add(new FacesMessage("Ad Ve Soyad 3'den Küçük 50 den Büyük Olamaz"));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }

    public boolean validateKullaniciAdi(FacesContext fc, UIComponent uı, Object v) {

        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Kullanıcı Adı Giriniz  ! "));
            isValid = false;
        } else if (value.length() < 5 || value.length() > 30) {
            msgList.add(new FacesMessage("Kullanıcı Adı 5 karakterden Küçük 30 karakterden Büyük Olamaz"));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }

    public boolean validateTelefon(FacesContext fc, UIComponent uı, Object v) {
        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value == null || value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Telefon Giriniz ! "));
            isValid = false;
        } else if (value.length() < 11 || value.length() > 12) {
            msgList.add(new FacesMessage("Lütfen 11 haneli telefon giriniz 054xxxxxxxx"));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }

    public boolean validateEmail(FacesContext fc, UIComponent uı, Object v) {
        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        value = value.trim();

        if (value == null || value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Email Giriniz! "));
            isValid = false;
        } else if (!value.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            msgList.add(new FacesMessage("Lütfen Email Adresini Düzgün Giriniz! example@example.com "));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);

        } else {
            return true;
        }
    }

    public boolean validateBos(FacesContext fc, UIComponent uı, Object v) {
        boolean isValid = true;
        msgList.clear();

        String value = (String) v.toString();
        value = value.trim();

        if (value == null || value.equals("") || value.equalsIgnoreCase("0")) {
            msgList.add(new FacesMessage("(*) Alanları boş geçilmez! "));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);

        } else {
            return true;
        }
    }

    public boolean validateCinsiyet(FacesContext fc, UIComponent uı, Object v) {
        boolean isValid = true;
        msgList.clear();

        String value = (String) v;

        if (value == null || value.equals("") || value.equalsIgnoreCase("Seçiniz")) {
            msgList.add(new FacesMessage("Lütfen Cinsiyet Seçiniz!"));
            isValid = false;
        }
        if (!isValid) {
            throw new ValidatorException(msgList);

        } else {
            return true;
        }
    }

    public Collection<FacesMessage> getMsgList() {
        return msgList;
    }

    public void setMsgList(Collection<FacesMessage> msgList) {
        this.msgList = msgList;
    }

}
