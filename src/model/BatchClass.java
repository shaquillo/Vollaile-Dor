package model;

import java.util.Date;

public class BatchClass {
    private int num;
    private String name;
    private String race;
    private int qty;
    private double buyingPrice;
    private Date startDate;
    private String building;
    private String supplier;
    private String sellingPrice;

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BatchClass(int num, String name, String race, int qty, double buyingPrice, Date startDate, String building, String supplier) {
        this.num = num;
        this.name = name;
        this.race = race;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
        this.startDate = startDate;
        this.building = building;
        this.supplier = supplier;
        this.sellingPrice = "-";
    }
}
