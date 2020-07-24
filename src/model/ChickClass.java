package model;

import java.util.Date;

public class ChickClass {
    int num;
    int qty;
    Date date;
    int percentageAlive;
    int numIncubation;

    public ChickClass(int num, int qty, Date date, int percentageAlive, int numIncubation) {
        this.num = num;
        this.qty = qty;
        this.date = date;
        this.percentageAlive = percentageAlive;
        this.numIncubation = numIncubation;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPercentageAlive() {
        return percentageAlive;
    }

    public void setPercentageAlive(int percentageAlive) {
        this.percentageAlive = percentageAlive;
    }

    public int getNumIncubation() {
        return numIncubation;
    }

    public void setNumIncubation(int numIncubation) {
        this.numIncubation = numIncubation;
    }
}
