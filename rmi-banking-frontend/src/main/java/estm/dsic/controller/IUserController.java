package estm.dsic.controller;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUserController extends Remote {
    boolean login(String mail,String password) throws RemoteException;
}
