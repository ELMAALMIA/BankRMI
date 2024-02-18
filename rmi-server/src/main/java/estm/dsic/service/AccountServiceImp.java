package estm.dsic.service;

import estm.dsic.dao.AccountDao;
import estm.dsic.model.Account;
import estm.dsic.model.Statment;

import java.util.List;

public class AccountServiceImp implements AccountService{
    private final AccountDao accountDao = new AccountDao();
    @Override
    public Account withdraw(Account account, double solde) {
        account = accountDao.findById(account.getId());
        double new_solde = account.getSolde() - solde;
        account.setSolde(new_solde);
        accountDao.updateSolde(new_solde,account.getId());
        // create statment account
        Statment statment = new Statment();
        statment.setOperation_type("withdraw");
        statment.setAccount(account);
        statment.setSolde(solde);
        accountDao.accountStatment(statment);
        return account;
    }

    @Override
    public Account deposit(Account account, double solde) {
        account = accountDao.findById(account.getId());
        double new_solde = account.getSolde() + solde;
        account.setSolde(new_solde);
        accountDao.updateSolde(new_solde,account.getId());
        // create statment account
        Statment statment = new Statment();
        statment.setOperation_type("deposit");
        statment.setAccount(account);
        statment.setSolde(solde);
        accountDao.accountStatment(statment);
        return account;
    }

    @Override
    public Account transfert(Account from, Account to, double solde) {
        from = accountDao.findById(from.getId());
        to = accountDao.findById(to.getId());
        // withdraw
        from.setSolde(from.getSolde() - solde);
        // deposite
        to.setSolde(to.getSolde() + solde);
        accountDao.updateSolde(from.getSolde(), from.getId());
        accountDao.updateSolde(to.getSolde(), to.getId());

        System.out.println(from+" : "+to);
        // create statment
        // create statment account
        Statment statment = new Statment();
        statment.setOperation_type("transfer");
        // statment from account
        statment.setAccount(from);
        statment.setSolde(solde);
        accountDao.accountStatment(statment);
        // statment to account
        statment.setAccount(to);
        accountDao.accountStatment(statment);

        return null;
    }

    @Override
    public List<Statment> accountStatement(Account account) {
        return accountDao.accountStatment(account.getId());
    }

    @Override
    public Account getAccount(int id) {
        return  accountDao.findById(id);
    }
}
