package model;

public class EmployeeClass {
    private int num;
    private String name;
    private String surname;
    private String type;
    private String username;
    private String password;
    private String sexe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public EmployeeClass(int num, String name, String surname, String type, String username, String password, String sexe) {
        this.num = num;
        this.name = name;
        this.type = type;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.sexe = sexe;
    }
}
