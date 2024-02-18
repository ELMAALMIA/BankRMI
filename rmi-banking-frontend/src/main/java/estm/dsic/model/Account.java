package estm.dsic.model;

import java.io.Serializable;

public class Account implements Serializable {
    private long id;
    private double solde;
    private String cin;
    private String l_name;
    private String f_name;

    public Account(){}
    public Account(long id, double solde, String cin, String l_name, String f_name) {
        this.id = id;
        this.solde = solde;
        this.cin = cin;
        this.l_name = l_name;
        this.f_name = f_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", solde=" + solde +
                ", cin='" + cin + '\'' +
                ", l_name='" + l_name + '\'' +
                ", f_name='" + f_name + '\'' +
                '}';
    }
}
