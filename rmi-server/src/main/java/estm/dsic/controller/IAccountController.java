package estm.dsic.controller;

import estm.dsic.model.Account;
import estm.dsic.model.Statment;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface IAccountController extends Remote {
    Account withdraw(Account account, double solde)  throws RemoteException;
    Account deposit(Account accout,double solde)  throws RemoteException;
    Account transfert(Account from,Account to,double solde)  throws RemoteException;
    List<Statment> accountStatement(Account account)  throws RemoteException;
    Account getAccount(int id) throws RemoteException;
}
