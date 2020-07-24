package model;

public class CustomerClass {
    int num;
    String name;
    String adresse;
    String tel;

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

    public CustomerClass(int num,String name, String adresse, String tel){
        this.num = num;
        this.name = name;
        this.adresse = adresse;
        this.tel = tel;
    }
}
