package estm.dsic.dao;

import estm.dsic.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private final Connection connection = DbConnection.getInstance().getConnection();

    public User findByEmail(String email) throws Exception{
        User u = new User();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE email=?");
        stmt.setString(1,email);
        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()){
            u.setEmail(email);
            u.setPassword(resultSet.getString("password"));
        }
        return u;
    }
}
