package view;

import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.entities.UserRecord;


public class UserEditorWindow {
    Dialog<UserRecord> dialog=new Dialog();
    DialogPane dialogPane= dialog.getDialogPane();

    TextField nameField=new TextField();
    TextField surnameField=new TextField();
    TextField address=new TextField();
    TextField yoj=new TextField();
    TextField pesel=new TextField();
    TextField role=new TextField();

    public UserRecord editUserRecord(UserRecord userRecord){
        dialog.setTitle("Edit record");
        dialog.setHeaderText("Edit gaps");
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        nameField.setText(userRecord.getName());
        surnameField.setText(userRecord.getSurname());
        address.setText(userRecord.getAddress());
        yoj.setText(userRecord.getYoj());
        pesel.setText(userRecord.getPesel());
        role.setText(userRecord.getRole());
        dialogPane.setContent(new VBox(8,nameField,surnameField,address, yoj,pesel,role));
        Platform.runLater(nameField::requestFocus);
        dialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                userRecord.setName(nameField.getText());
                userRecord.setSurname(surnameField.getText());
                userRecord.setAddress(address.getText());
                userRecord.setYoj(yoj.getText());
                userRecord.setPesel(pesel.getText());
                userRecord.setRole(role.getText());
                return userRecord;
            }
            else return null;
        });
        dialog.showAndWait();
        return userRecord;
    }


}
