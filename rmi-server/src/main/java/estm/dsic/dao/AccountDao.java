package estm.dsic.dao;

import estm.dsic.model.Account;
import estm.dsic.model.Statment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private final Connection connection = DbConnection.getInstance().getConnection();
    public List<Account> findAll(){
        List<Account> accounts = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM accounts");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setCin(resultSet.getString("cin"));
                account.setF_name(resultSet.getString("f_name"));
                account.setL_name(resultSet.getString("l_name"));
                account.setSolde(resultSet.getDouble("solde"));
                accounts.add(account);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  accounts;
    }
    public Account findById(long id){
        Account account = new Account();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM accounts WHERE id=?");
            stmt.setLong(1,id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()){
                account.setId(resultSet.getLong("id"));
                account.setCin(resultSet.getString("cin"));
                account.setF_name(resultSet.getString("f_name"));
                account.setL_name(resultSet.getString("l_name"));
                account.setSolde(resultSet.getDouble("solde"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }
    public void updateSolde(double solde,long accoundId){
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE  accounts SET solde=? WHERE id=?");
            stmt.setDouble(1,solde);
            stmt.setLong(2,accoundId);

            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void accountStatment(Statment statment){
        try {
            System.out.println(statment.getAccount());
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO statments(operation_date,solde,operation_type,account_id) VALUES (?,?,?,?)");
            stmt.setDate(1, new Date(statment.getOperation_date().getTime()));
            stmt.setDouble(2,statment.getSolde());
            stmt.setString(3,statment.getOperation_type());
            stmt.setLong(4,statment.getAccount().getId());
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Statment> accountStatment(long id){
        List<Statment> statments = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM statments WHERE account_id=?");
            stmt.setLong(1,id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
               Statment statment = new Statment();
               statment.setId(resultSet.getLong("id"));
               statment.setSolde(resultSet.getDouble("solde"));
               statment.setOperation_date(resultSet.getDate("operation_date"));
               statment.setOperation_type(resultSet.getString("operation_type"));
               statments.add(statment);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return statments;
    }
}
