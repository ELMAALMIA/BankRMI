package estm.dsic;
import estm.dsic.controller.IAccountController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
public class BankController implements Initializable {
    public static IAccountController  iAccountController=null;
    @FXML
    private Label id_label_1;
    @FXML
    private TextField text;

    // debiter button using rmi
        @FXML
        void debiter_btn(ActionEvent event) {
            double solde = Double.parseDouble(text.getText());
            IAccountController iAccountController =service();
            try {
                iAccountController.withdraw(iAccountController.getAccount(1),solde);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            }

        //titker button using rmi
        @FXML
        void tiket_btn(ActionEvent event) {
            /* ticker button using rmi + print ticket in pdf */



        }
        public IAccountController service(){

            try {
                iAccountController= (IAccountController) Naming.
                        lookup("rmi://localhost:5000/account");
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            return iAccountController;
        }
        public double solde(){
            double solde = 0;
            iAccountController =service();
            try {
                solde = iAccountController.getAccount(1).getSolde();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return solde;
         }
        @FXML
        void add_btn(ActionEvent event) throws RemoteException {
           iAccountController =service();
            double solde = Double.parseDouble(text.getText());
            iAccountController.deposit(iAccountController.getAccount(1),solde);


        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                id_label_1.setText(solde()+"hhjqskqdsj");
        }
}
