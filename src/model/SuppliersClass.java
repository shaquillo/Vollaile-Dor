package model;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SuppliersClass {
    private int num;
    private String name;
    private String adresse;
    private String tel;
    private String email;
    private String website;
    private String pdtType;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPdtType() {
        return pdtType;
    }

    public void setPdtType(String pdtType) {
        this.pdtType = pdtType;
    }

    public SuppliersClass(int num, String name, String adresse, String tel, String email, String website, String pdtType) {
        this.num = num;
        this.name = name;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.website = website;
        this.pdtType = pdtType;
    }

}
