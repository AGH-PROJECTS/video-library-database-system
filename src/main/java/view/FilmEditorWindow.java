package view;

import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.entities.FilmRecord;

public class FilmEditorWindow {


    Dialog<FilmRecord> dialog=new Dialog();
    DialogPane dialogPane= dialog.getDialogPane();

    TextField titleField=new TextField();
    TextField d_surnameField=new TextField();
    TextField age_category=new TextField();
    TextField yop=new TextField();
    TextField genre=new TextField();
    TextField country=new TextField();

    public FilmRecord editFilmRecord(FilmRecord filmRecord){
        dialog.setTitle("Edit record");
        dialog.setHeaderText("Edit gaps");
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        titleField.setText(filmRecord.getTitle());
        d_surnameField.setText(filmRecord.getDirector_surname());
        age_category.setText(filmRecord.getAge_category());
        yop.setText(filmRecord.getYop());
        genre.setText(filmRecord.getGenre());
        country.setText(filmRecord.getCountry());


        dialogPane.setContent(new VBox(8,titleField,d_surnameField,age_category, yop,genre,country));
        Platform.runLater(titleField::requestFocus);

        dialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                filmRecord.setTitle(titleField.getText());
                filmRecord.setDirector_surname(d_surnameField.getText());
                filmRecord.setAge_category(age_category.getText());
                filmRecord.setYop(yop.getText());
                filmRecord.setGenre(genre.getText());
                filmRecord.setCountry(country.getText());
                return filmRecord;
            }
            else return null;
        });
        dialog.showAndWait();
        return filmRecord;
    }
}
