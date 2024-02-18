package estm.dsic;

import estm.dsic.controller.IUserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submit;

    @FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
    }
    public IUserController service(){
        IUserController iUserController=null;
        try {
            iUserController= (IUserController) Naming.
                    lookup("rmi://localhost:5000/login");
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        return  iUserController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               IUserController loginService =  service();
                boolean test = false;
                try {
                    test = loginService.login(usernameField.getText(), passwordField.getText());
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
                if (test) {
                    System.out.println("Username: " + usernameField.getText());
                    System.out.println("Password: " + passwordField.getText());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Bienvenue");
                    alert.show();
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Bankpage.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) submit.getScene().getWindow();
                        stage.setScene(scene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.printf("erreur");
                }
            }
        });
    }
    }

