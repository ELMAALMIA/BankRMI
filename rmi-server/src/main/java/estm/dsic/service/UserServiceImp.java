package estm.dsic.service;

import estm.dsic.dao.UserDao;
import estm.dsic.model.User;

public class UserServiceImp implements UserService{
    private final UserDao userDao = new UserDao();
    @Override
    public boolean login(String mail, String password) {
        boolean is_login = false;
        try {
            User user = userDao.findByEmail(mail);
            if(user.getPassword().equals(password)){
                is_login=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return is_login;
    }
}
