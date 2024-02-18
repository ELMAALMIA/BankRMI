package estm.dsic;

import estm.dsic.services.LoginService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

import java.rmi.Remote;
import java.rmi.RemoteException;


public class Main extends Application implements Remote {


    public static Stage  stage;
        @Override
    public void start(Stage primaryStage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("banking system");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        launch();
    }
}