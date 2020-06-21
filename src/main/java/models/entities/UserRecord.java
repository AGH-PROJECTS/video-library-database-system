package models.entities;

public class UserRecord {
    private Integer user_id;
    private String name;
    private String surname;
    private String address;
    private String yoj;
    private String pesel;
    private String role;

    public UserRecord(Integer user_id, String name, String surname, String address,String yoj,String pesel, String role) {
        this.user_id = user_id;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;
        this.yoj = yoj;
        this.role=role;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYoj() {
        return yoj;
    }

    public void setYoj(String yoj) {
        this.yoj = yoj;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRecord{" +
                "id_user=" + user_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", yoj='" + yoj + '\'' +
                ", pesel='" + pesel + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
