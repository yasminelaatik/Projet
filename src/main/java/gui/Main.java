package gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Scene sc = new Scene(new MainPane());
        stage.setScene(sc);
          stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}