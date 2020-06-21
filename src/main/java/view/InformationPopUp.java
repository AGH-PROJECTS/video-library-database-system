package view;

import javafx.scene.control.Alert;

public class InformationPopUp {
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void emptyFieldsDialogShow() {
        alert.setTitle("Information Dialog");
        alert.setContentText("You have to fill all fields in order to add Entity!");
        alert.showAndWait();
    }

    public void userAddedDialogShow(){
        alert.setTitle("Information Dialog");
        alert.setContentText("User has been added!");
        alert.showAndWait();
    }
    public void filmAddedDialogShow(){
        alert.setTitle("Information Dialog");
        alert.setContentText("Film has been added!");
        alert.showAndWait();
    }
    public void orderAddedDialogShow(){
        alert.setTitle("Information Dialog");
        alert.setContentText("Order has been added!");
        alert.showAndWait();
    }
}
