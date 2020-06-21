package models.entities;

public class FilmRecord {
    private Integer id_film;
    private String title;
    private String director_surname;
    private String director_name;
    private String age_category;
    private String yop;
    private String genre;
    private String country;


    public FilmRecord(Integer id_film, String title,String director_name, String director_surname, String age_category, String yop, String genre, String country) {
        this.id_film = id_film;
        this.title = title;
        this.director_name=director_name;
        this.director_surname = director_surname;
        this.age_category = age_category;
        this.yop = yop;
        this.genre = genre;
        this.country = country;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getId_film() {
        return id_film;
    }

    public void setId_film(Integer id_film) {
        this.id_film = id_film;
    }

    public String getYop() {
        return yop;
    }

    public void setYop(String yop) {
        this.yop = yop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAge_category() {
        return age_category;
    }

    public void setAge_category(String age_category) {
        this.age_category = age_category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector_surname() {
        return director_surname;
    }

    public void setDirector_surname(String director_surname) {
        this.director_surname = director_surname;
    }

    @Override
    public String toString() {
        return "FilmRecord{" +
                "id_film=" + id_film +
                ", title='" + title + '\'' +
                ", director_surname='" + director_surname + '\'' +
                ", age_category='" + age_category + '\'' +
                ", yop='" + yop + '\'' +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
