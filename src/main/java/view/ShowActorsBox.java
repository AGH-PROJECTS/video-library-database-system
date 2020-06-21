package view;

import api.DataHandlerImpl;
import exception.FetchDataException;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.entities.ActorRecord;
import models.entities.OpinionRecord;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowActorsBox implements Initializable {
    private Dialog<OpinionRecord> dialog = new Dialog();
    private DialogPane dialogPane = dialog.getDialogPane();
    private TableView<ActorRecord> table = new TableView<>();
    private TableColumn<ActorRecord, Integer> id_actorCol=new TableColumn<>();
    private TableColumn<ActorRecord, String> nameCol=new TableColumn<>();
    private TableColumn<ActorRecord, String> surnameCol=new TableColumn<>();
    private DataHandlerImpl dataHandler = new DataHandlerImpl();
    private ObservableList<ActorRecord> actorRecords;

    public ShowActorsBox() {
        table.getColumns().addAll(id_actorCol, nameCol, surnameCol);
        dialog.setHeaderText("Opinions");
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        id_actorCol.setText("Actor ID");
        nameCol.setText("Name");
        surnameCol.setText("Surname");
    }

    public void show(Integer id_film) throws FetchDataException {

        actorRecords = dataHandler.getActors(id_film);
        if(actorRecords.size()!=0){
            dialogPane.setContent(new AnchorPane(table));
            dialog.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There is no information about cast");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id_actorCol.setCellValueFactory(new PropertyValueFactory("id_actor"));
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        table.setItems(actorRecords);
    }
}
