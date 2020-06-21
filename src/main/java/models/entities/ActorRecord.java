package models.entities;

public class ActorRecord {

    private Integer id_actor;
    private String name;
    private String surname;

    public ActorRecord(Integer id_actor, String name, String surname) {
        this.id_actor = id_actor;
        this.name = name;
        this.surname = surname;
    }

    public ActorRecord() {
    }

    public Integer getId_actor() {
        return id_actor;
    }

    public void setId_actor(Integer id_actor) {
        this.id_actor = id_actor;
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
}
