package view;

import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.entities.OrderRecord;
import models.entities.UserRecord;

public class OrderEditorWindow {
    Dialog<OrderRecord> dialog=new Dialog();
    DialogPane dialogPane= dialog.getDialogPane();

    TextField returnDate=new TextField();


    public OrderRecord editOrderRecord(OrderRecord orderRecord){
        dialog.setTitle("Fill record");
        returnDate.setText("return date");
        dialog.setHeaderText("Fill return date field ");
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        dialogPane.setContent(new VBox(8,returnDate));
        Platform.runLater(returnDate::requestFocus);
        dialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                orderRecord.setReturn_date(returnDate.getText());
                return orderRecord;
            }
            else return null;
        });
        dialog.showAndWait();
        return orderRecord;
    }

}
