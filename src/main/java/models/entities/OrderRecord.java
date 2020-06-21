package models.entities;

public class OrderRecord {
    private Integer id_order;
    private String user_pesel;
    private String user_name;
    private String user_surname;
    private String title;
    private Integer id_emp;
    private String rental_date;
    private String return_date;

    public OrderRecord(Integer id_order, String user_pesel, String user_name, String user_surname, String title, Integer id_emp, String rental_date) {
        this.id_order = id_order;
        this.user_pesel = user_pesel;
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.title = title;
        this.id_emp = id_emp;
        this.rental_date = rental_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public String getUser_pesel() {
        return user_pesel;
    }

    public void setUser_pesel(String user_pesel) {
        this.user_pesel = user_pesel;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId_emp() {
        return id_emp;
    }

    public void setId_emp(Integer id_emp) {
        this.id_emp = id_emp;
    }

    public String getRental_date() {
        return rental_date;
    }

    public void setRental_date(String rental_date) {
        this.rental_date = rental_date;
    }

    @Override
    public String toString()
    {
        return "FilmRecord{" +
                "id_order=" + id_order +
                ", user_pesel='" + user_pesel + '\'' +
                ", name='" + user_name + '\'' +
                ", surname='" + user_surname + '\'' +
                ", title='" + title + '\'' +
                ", id_emp='" + id_emp + '\'' +
                ", rental_date='" + rental_date + '\'' +
                ", return_date='" + null + '\'' +
                '}';
    }

}
