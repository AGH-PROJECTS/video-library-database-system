package view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ConfirmationPopUp {
    private Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

    public boolean confirmDelete() {
        alert.setTitle("Delete user");
        alert.setContentText("Are you sure you want to delete this record?");
        Optional<ButtonType> answer=alert.showAndWait();
        if(answer.get()==ButtonType.OK) return true;
        else return false;
    }
}