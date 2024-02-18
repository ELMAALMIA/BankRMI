package estm.dsic.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static DbConnection uniqueInstance;
    public static DbConnection getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new DbConnection();
        }
        return uniqueInstance;
    }
    public Connection getConnection() {
        Connection conn = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_bank","root","123456789");
            System.out.println("Connection Successfully to Mysql");
        }
        catch (Exception e) {
            System.out.println("Erreur de drivers JDBC : "+e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
