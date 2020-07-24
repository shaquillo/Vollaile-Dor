package model;

public class BuildingClass {
    int num;
    String name;
    double surface;

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

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public BuildingClass(int num, String name, double surface) {
        this.num = num;
        this.name = name;
        this.surface = surface;
    }
}
