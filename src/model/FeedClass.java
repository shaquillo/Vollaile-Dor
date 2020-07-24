package model;

import java.util.Date;

public class FeedClass {
    private int no;
    private String aliment;
    private Date date;
    private String batch;
    private int qtyAliment;
    private int qtyWater;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAliment() {
        return aliment;
    }

    public void setAliment(String aliment) {
        this.aliment = aliment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getQtyAliment() {
        return qtyAliment;
    }

    public void setQtyAliment(int qtyAliment) {
        this.qtyAliment = qtyAliment;
    }

    public int getQtyWater() {
        return qtyWater;
    }

    public void setQtyWater(int qtyWater) {
        this.qtyWater = qtyWater;
    }

    public FeedClass(int no, String aliment, Date date, String batch, int qtyAliment, int qtyWater) {
        this.no = no;
        this.aliment = aliment;
        this.date = date;
        this.batch = batch;
        this.qtyAliment = qtyAliment;
        this.qtyWater = qtyWater;
    }
}
