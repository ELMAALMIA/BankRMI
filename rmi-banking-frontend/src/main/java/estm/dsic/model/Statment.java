package estm.dsic.model;


import java.io.Serializable;
import java.util.Date;

public class Statment implements Serializable {
    private long id;
    private Date operation_date;
    private double solde;
    private String operation_type;
    private Account account;
    public Statment(){
        this.operation_date = new Date();

    }
    public Statment(long id, double solde, String operation_type,Account account) {
        this.id = id;
        this.solde = solde;
        this.operation_type = operation_type;
        this.operation_date = new Date();
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Date operation_date) {
        this.operation_date = operation_date;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Statment{" +
                "id=" + id +
                ", operation_date=" + operation_date +
                ", solde=" + solde +
                ", operation_type='" + operation_type + '\'' +
                ", account=" + account +
                '}';
    }
}
