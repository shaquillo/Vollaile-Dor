package model;

import java.util.Date;

public class EggClass {
    int num;
    String type;
    Date date;
    int qtyIncubation;
    int branchId;
    int priceTrau;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQtyIncubation() {
        return qtyIncubation;
    }

    public void setQtyIncubation(int qtyIncubation) {
        this.qtyIncubation = qtyIncubation;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getPriceTrau() {
        return priceTrau;
    }

    public void setPriceTrau(int priceTrau) {
        this.priceTrau = priceTrau;
    }

    public EggClass(int num, String type, Date date, int qtyIncubation, int branchId, int priceTrau) {
        this.num = num;
        this.type = type;
        this.date = date;
        this.qtyIncubation = qtyIncubation;
        this.branchId = branchId;
        this.priceTrau = priceTrau;
    }
}
