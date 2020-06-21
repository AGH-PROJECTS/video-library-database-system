package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VideoLibrary extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src\\main\\java\\view\\filmBaseGUI.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Video Library");
        primaryStage.setScene(new Scene(root, 1127, 823));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
