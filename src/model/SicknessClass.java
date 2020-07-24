package model;

public class SicknessClass {
    private int num;
    private String name;
    private String sicknessDescription;
    private String treatmentDescription;
    private int treatmentDuration;

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

    public String getSicknessDescription() {
        return sicknessDescription;
    }

    public void setSicknessDescription(String sicknessDescription) {
        this.sicknessDescription = sicknessDescription;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public int getTreatmentDuration() {
        return treatmentDuration;
    }

    public void setTreatmentDuration(int treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }

    public SicknessClass(int num, String name, String sicknessDescription, String treatmentDescription, int treatmentDuration) {
        this.num = num;
        this.name = name;
        this.sicknessDescription = sicknessDescription;
        this.treatmentDescription = treatmentDescription;
        this.treatmentDuration = treatmentDuration;
    }
}
