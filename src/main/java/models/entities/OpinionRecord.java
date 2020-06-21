package models.entities;

public class OpinionRecord {
    private Integer id_user;
    private String description;
    private  String opinion;

    public OpinionRecord(Integer id_user, String description, String opinion) {
        this.id_user = id_user;
        this.description = description;
        this.opinion = opinion;
    }

    public OpinionRecord() {
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Override
    public String toString() {
        return "OpinionRecord{" +
                "id_user=" + id_user +
                ", description='" + description + '\'' +
                ", opinion='" + opinion + '\'' +
                '}';
    }
}
