package controller;


import api.DataHandlerImpl;
import exception.FetchDataException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.date_validators.DateValidator;
import models.entities.FilmRecord;
import models.entities.OrderRecord;
import models.entities.UserRecord;
import view.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TextField userSearchTextField, filmSearchTextField, orderSearchTextField;
    public TextField nameField, surnameField, addressField, yojField, peselField, roleField;
    public TextField filmTitleField, yopField, acField, nameDirectorField, surnameDirectorField, genreField, countryField;
    public TextField Order_peselField, Order_filmtitleField, Order_rentalDateField, Order_empIdField;
    public ComboBox<String> genreFilter, countryFilter;
    public TableView usersTable, filmsTable, ordersTable;
    public TableColumn<UserRecord, Integer> userIdCol;
    public TableColumn<UserRecord, String> nameCol, surnameCol, peselCol, addressCol, yojCol, roleCol;
    public TableColumn<FilmRecord, Integer> filmIdCol;
    public TableColumn<FilmRecord, String> titleCol, directorCol, nameDirectorCol, age_categoryCol, yopCol, genreCol, countryCol;
    public TableColumn<OrderRecord, Integer> orderIdCol, o_EmpIdCol;
    public TableColumn<OrderRecord, String> userPeselCol, o_nameCol, o_surnameCol, o_titleCol, rentaleDateCol, returnDateCol;
    private ObservableList<UserRecord> userList = FXCollections.observableArrayList();
    private ObservableList<FilmRecord> filmList = FXCollections.observableArrayList();
    private ObservableList<OrderRecord> orderList = FXCollections.observableArrayList();
    private DataHandlerImpl dataHandler = new DataHandlerImpl();
    private InformationPopUp popUp = new InformationPopUp();
    private DateValidator dateValidator = new DateValidator();
    private ConfirmationPopUp confirmationPopUp = new ConfirmationPopUp();

    public void uploadUsers() throws FetchDataException {
        usersTable.getItems().clear();
        dataHandler.getAllUsers(userList);
    }

    public void uploadOrders() throws FetchDataException {
        ordersTable.getItems().clear();
        dataHandler.getAllOrders(orderList);
    }

    public void uploadFilms() throws FetchDataException {
        filmsTable.getItems().clear();
        dataHandler.getAllFilms(filmList);
    }

    public void searchUserById() throws FetchDataException {
        if (dateValidator.validate(userSearchTextField)) {
            userList = dataHandler.getUserById(userSearchTextField.getText());
            usersTable.setItems(userList);
        }
    }

    public void searchFilmById() throws FetchDataException {
        if (dateValidator.validate(filmSearchTextField)) {
            filmList = dataHandler.getFilmById(filmSearchTextField.getText());
            filmsTable.setItems(filmList);
        }
    }

    public void searchOrderById() throws FetchDataException {

        if (dateValidator.validate(orderSearchTextField)) {

            orderList = dataHandler.getOrderById(orderSearchTextField.getText());
        }
    }

    public void addUser() throws FetchDataException {
        if (dateValidator.validate(nameField.getText()) && dateValidator.validate(surnameField.getText()) && dateValidator.validate(addressField.getText())
                && dateValidator.validate(peselField.getText()) && dateValidator.validate(yojField.getText()) && dateValidator.validate(roleField.getText())) {
            usersTable.getItems().clear();

            System.out.println(peselField.getText());
            dataHandler.addUser(nameField.getText(), surnameField.getText(), addressField.getText(), yojField.getText(), peselField.getText(), roleField.getText());
            dataHandler.getAllUsers(userList);
            dateValidator.clearUserFields(nameField, surnameField, addressField, peselField, yojField, roleField);
            popUp.userAddedDialogShow();
            nameField.setText("");
            surnameField.setText("");
            addressField.setText("");
            peselField.setText("");
            yojField.setText("");
            roleField.setText("");

        } else popUp.emptyFieldsDialogShow();

    }

    public void addFilm() throws FetchDataException {
        if (dateValidator.validate(filmTitleField.getText()) && dateValidator.validate(yopField.getText()) && dateValidator.validate(acField.getText())
                && dateValidator.validate(nameDirectorField.getText())
                && dateValidator.validate(surnameDirectorField.getText())
                && dateValidator.validate(genreField.getText())
                && dateValidator.validate(countryField.getText())) {

            dataHandler.addFilm(filmTitleField.getText(), yopField.getText(), acField.getText(), nameDirectorField.getText(), surnameDirectorField.getText(), genreField.getText(), countryField.getText());
            dateValidator.clearFilmFields(filmTitleField, yopField, acField, nameDirectorField, surnameDirectorField, genreField, countryField);
            popUp.filmAddedDialogShow();
        } else popUp.emptyFieldsDialogShow();
    }

    public void addOrder() throws FetchDataException {
        if (dateValidator.validate(filmTitleField) && dateValidator.validate(yopField) && dateValidator.validate(acField)
                && dateValidator.validate(nameDirectorField) && dateValidator.validate(surnameDirectorField)
                && dateValidator.validate(genreField) && dateValidator.validate(countryField)) {

            dateValidator.clearOrderFields(filmTitleField, yopField, acField, nameDirectorField, surnameDirectorField, genreField, countryField);
            dataHandler.addOrder(Order_peselField.getText(), Order_filmtitleField.getText(), Order_rentalDateField.getText(), Order_empIdField.getText());
            popUp.orderAddedDialogShow();
        } else popUp.emptyFieldsDialogShow();
    }

    public void filterResults() throws FetchDataException {

        if (genreFilter.getValue() != null && countryFilter.getValue() == null) {
            filmList = dataHandler.getFilmByGenre(genreFilter.getValue().toString());
            uploadFilms();
        }
        if (genreFilter.getValue() == null && countryFilter.getValue() != null) {
            dataHandler.getFilmByCountry(countryFilter.getValue().toString());
            uploadFilms();
        }
        if (genreFilter.getValue() != null && countryFilter.getValue() != null) {
            dataHandler.getFilmByGenreAndCountry(genreFilter.getValue().toString(), countryFilter.getValue().toString());
            uploadFilms();
        }
    }

    public void handleUserUpdate() throws FetchDataException {
        UserRecord userRecord = (UserRecord) usersTable.getSelectionModel().getSelectedItem();
        if (userRecord == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("No user selected");
            alert.setContentText("Please select user to update!");
            alert.showAndWait();
        } else {
            UserEditorWindow editorWindow = new UserEditorWindow();
            userRecord = editorWindow.editUserRecord(userRecord);
            if (userRecord != null) {
                dataHandler.updateUser(userRecord);
                uploadUsers();
            }
        }
    }

    public void handleUserDelete() throws FetchDataException {
        UserRecord userRecord = (UserRecord) usersTable.getSelectionModel().getSelectedItem();
        if (userRecord == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("No user selected");
            alert.setContentText("Please select user to delete!");
            alert.showAndWait();
        } else {
            if (confirmationPopUp.confirmDelete()) {
                dataHandler.deleteUser(userRecord.getUser_id());
                uploadUsers();
            }
        }
    }

    public void handleFilmUpdate() throws FetchDataException {
        FilmRecord filmRecord = (FilmRecord) filmsTable.getSelectionModel().getSelectedItem();
        if (filmRecord == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("No film selected");
            alert.setContentText("Please select film to update!");
            alert.showAndWait();
        } else {
            FilmEditorWindow filmEditorWindow = new FilmEditorWindow();
            filmRecord = filmEditorWindow.editFilmRecord(filmRecord);
            if (filmRecord != null) {
                dataHandler.updateFilm(filmRecord);
                uploadFilms();
            }
        }
    }

    public void handleFilmDelete() throws FetchDataException {
        FilmRecord filmRecord = (FilmRecord) filmsTable.getSelectionModel().getSelectedItem();
        if (filmRecord == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("No film selected");
            alert.setContentText("Please select film to delete!");
            alert.showAndWait();
        } else {
            if (confirmationPopUp.confirmDelete()) {
                dataHandler.deleteFilm(filmRecord.getId_film());
                uploadFilms();
            }

        }
    }

    public void handleShowOpinions() throws FetchDataException {
        FilmRecord filmRecord = (FilmRecord) filmsTable.getSelectionModel().getSelectedItem();
        if (filmRecord == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("No film selected");
            alert.setContentText("Please select film to see opinions!");
            alert.showAndWait();
        } else {
            ShowOpinionBox box = new ShowOpinionBox();
            box.show(filmRecord.getId_film());
        }

    }

    public void handleShowActors() throws FetchDataException {
        FilmRecord filmRecord = (FilmRecord) filmsTable.getSelectionModel().getSelectedItem();
        if (filmRecord == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("No film selected");
            alert.setContentText("Please select film to see actors!");
            alert.showAndWait();
        } else {
            ShowActorsBox box = new ShowActorsBox();
            box.show(filmRecord.getId_film());
        }
    }

    public void handleUpdateOrder() throws FetchDataException {
        OrderRecord orderRecord = (OrderRecord) ordersTable.getSelectionModel().getSelectedItem();
        if (orderRecord == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("No order selected");
            alert.setContentText("Please select order to update!");
            alert.showAndWait();
        } else {
            OrderEditorWindow orderEditorWindow = new OrderEditorWindow();
            orderEditorWindow.editOrderRecord(orderRecord);
            if (orderRecord != null) {
                dataHandler.updateOrder(orderRecord);
                uploadUsers();
            }
        }
        uploadOrders();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genreFilter.getItems().addAll("Sci-Fi", "Sensacyjny", "Dramat", "Wojenny", "Thriller", "Akcja");
        countryFilter.getItems().addAll("Polska", "Wielka Brytania", "Francja", "Niemcy", "Hiszpania", "Włochy");

        userIdCol.setCellValueFactory(new PropertyValueFactory("user_id"));
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        peselCol.setCellValueFactory(new PropertyValueFactory("pesel"));
        addressCol.setCellValueFactory(new PropertyValueFactory("address"));
        yojCol.setCellValueFactory(new PropertyValueFactory("yoj"));
        roleCol.setCellValueFactory(new PropertyValueFactory("role"));
        usersTable.setItems(userList);


        filmIdCol.setCellValueFactory(new PropertyValueFactory("id_film"));
        titleCol.setCellValueFactory(new PropertyValueFactory("title"));
        directorCol.setCellValueFactory(new PropertyValueFactory("director_surname"));
        age_categoryCol.setCellValueFactory(new PropertyValueFactory("age_category"));
        yopCol.setCellValueFactory(new PropertyValueFactory("yop"));
        genreCol.setCellValueFactory(new PropertyValueFactory("genre"));
        countryCol.setCellValueFactory(new PropertyValueFactory("country"));
        nameDirectorCol.setCellValueFactory(new PropertyValueFactory("director_name"));
        filmsTable.setItems(filmList);

        orderIdCol.setCellValueFactory(new PropertyValueFactory("id_order"));
        userPeselCol.setCellValueFactory(new PropertyValueFactory("user_pesel"));
        o_nameCol.setCellValueFactory(new PropertyValueFactory("user_name"));
        o_surnameCol.setCellValueFactory(new PropertyValueFactory("user_surname"));
        o_titleCol.setCellValueFactory(new PropertyValueFactory("title"));
        o_EmpIdCol.setCellValueFactory(new PropertyValueFactory("id_emp"));
        rentaleDateCol.setCellValueFactory(new PropertyValueFactory("rental_date"));
        returnDateCol.setCellValueFactory(new PropertyValueFactory("country"));
        ordersTable.setItems(orderList);
    }
}
