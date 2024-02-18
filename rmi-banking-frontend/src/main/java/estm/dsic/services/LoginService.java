package estm.dsic.services;

import javafx.event.ActionEvent;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginService extends Remote {
    boolean login(String mail , String password) ;
}
