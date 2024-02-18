package estm.dsic.service;

import estm.dsic.model.Account;
import estm.dsic.model.Statment;

import java.util.List;

public interface AccountService {
    Account withdraw(Account account,double solde);
    Account deposit(Account account,double solde);
    Account transfert(Account from,Account to,double solde);
    List<Statment> accountStatement(Account account);
    Account getAccount(int id);
}
