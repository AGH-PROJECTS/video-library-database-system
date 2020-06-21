package view;

import api.DataHandlerImpl;
import exception.FetchDataException;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.entities.OpinionRecord;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ShowOpinionBox implements Initializable {
    private Dialog<OpinionRecord> dialog = new Dialog();
    private DialogPane dialogPane = dialog.getDialogPane();
    private TableView<OpinionRecord> table = new TableView<>();
    private TableColumn<OpinionRecord, Integer> id_userCol=new TableColumn<>();
    private TableColumn<OpinionRecord, String> descriptionCol=new TableColumn<>();
    private TableColumn<OpinionRecord, String> opinionCol=new TableColumn<>();
    private DataHandlerImpl dataHandler = new DataHandlerImpl();
    private ObservableList<OpinionRecord> opinions;
    public ShowOpinionBox() {

        table.getColumns().addAll(id_userCol, descriptionCol, opinionCol);
        dialog.setHeaderText("Opinions");
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        id_userCol.setText("User ID");
        descriptionCol.setText("Description");
        opinionCol.setText("Opinion");

    }

    public void show(Integer id_film) throws FetchDataException {

        opinions = dataHandler.getOpinions(id_film);
        if(opinions.size()!=0){
            dialogPane.setContent(new AnchorPane(table));
            dialog.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("No one has issued an opinion yet");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id_userCol.setCellValueFactory(new PropertyValueFactory("id_user"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory("description"));
        opinionCol.setCellValueFactory(new PropertyValueFactory("opinion"));
        table.setItems(opinions);
    }
}

