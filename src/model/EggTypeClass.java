package model;

public class EggTypeClass {
    int num;
    String name;
    double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EggTypeClass(int num, String name, double price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }
}
