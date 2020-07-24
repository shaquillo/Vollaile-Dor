package model;


import java.util.Date;

public class VaccinClass {
    private int num;
    private String name;
    private Date period;
    private int duration;
    private String qtyVaccin;
    private int qtyFoul;
    private double price;
    private String description;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

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

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public String  getQtyVaccin() {
        return qtyVaccin;
    }

    public void setQtyVaccin(String qtyVaccin) {
        this.qtyVaccin = qtyVaccin;
    }

    public int getQtyFoul() {
        return qtyFoul;
    }

    public void setQtyFoul(int qtyFoul) {
        this.qtyFoul = qtyFoul;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VaccinClass(int num, String name, Date period, int duration, String qtyVaccin, int qtyFoul, double price, String description) {
        this.num = num;
        this.name = name;
        this.period = period;
        this.duration = duration;
        this.qtyVaccin = qtyVaccin;
        this.qtyFoul = qtyFoul;
        this.price = price;
        this.description = description;
    }
}
