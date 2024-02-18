module estm.dsic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;
    requires com.jfoenix;


    opens estm.dsic to javafx.fxml;
    exports estm.dsic;
}