package estm.dsic.controller;

import estm.dsic.dao.AccountDao;
import estm.dsic.model.Account;
import estm.dsic.model.Statment;
import estm.dsic.service.AccountService;
import estm.dsic.service.AccountServiceImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class AccountController extends UnicastRemoteObject implements IAccountController {
    private final AccountService accountService = new AccountServiceImp();
    public AccountController() throws RemoteException {
        super();
    }
    @Override
    public Account withdraw(Account account, double solde) {return accountService.withdraw(account,solde);}
    @Override
    public Account deposit(Account account, double solde) {
        return accountService.deposit(account,solde);
    }
    @Override
    public Account transfert(Account from, Account to, double solde) {
        return accountService.transfert(from,to,solde);
    }
    @Override
    public List<Statment> accountStatement(Account account) {
        return accountService.accountStatement(account);
    }

    @Override
    public Account getAccount(int id) throws RemoteException {
        AccountDao accountDao = new AccountDao();
        return  accountDao.findById(id);
    }


}
