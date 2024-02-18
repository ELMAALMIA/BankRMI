package estm.dsic;


import com.jfoenix.controls.JFXButton;
import estm.dsic.controller.IAccountController;
import estm.dsic.model.Account;
import estm.dsic.model.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;

public class DashbordController implements Initializable {

    public Label totalAmount;
    public Label usernameLabel;
    public Label nameLabel;
    public TextField debMontantField;
    public JFXButton debButton;
    public TextField credMontantField;
    public JFXButton credButton;
    public JFXButton releveButton;
    public Label soldeField;


    // debiter button (withdraw)
    public void debiter() {
        try {
            IAccountController iAccountController= (IAccountController) Naming.
                    lookup("rmi://localhost:5000/account");
            Account account = iAccountController.getAccount(1);
            double solde = Double.parseDouble(debMontantField.getText());
            account = iAccountController.withdraw(account,solde);
            soldeField.setText(String.valueOf(account.getSolde()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Operation effectuee avec succes");
            alert.showAndWait();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    public double solde(){
        //solde a partir backend rmi
        double solde = 0;
        try {
            IAccountController iAccountController= (IAccountController) Naming.
                    lookup("rmi://localhost:5000/account");
            Account account = iAccountController.getAccount(1);
            solde = account.getSolde();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        return solde;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        debButton.setOnAction(event -> debiter());
//        usernameLabel.setText("admin");
        soldeField.setText(solde()+"DH");

    }
}

