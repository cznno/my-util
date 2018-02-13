package person.cznno.commonpoi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;

/**
 * Created by cznno
 * Date: 18-2-7
 */
public class MainUI extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("fxml/MainUI.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();
        primaryStage.setResizable(true);
        primaryStage.setTitle("Sample Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
