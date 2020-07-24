package model;

public class RaceClass {
    private int num;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RaceClass (int num, String name, String description) {
        this.num = num;
        this.name = name;
        this.description = description;
    }
}
