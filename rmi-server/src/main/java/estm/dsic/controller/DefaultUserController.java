package estm.dsic.controller;

import estm.dsic.service.UserService;
import estm.dsic.service.UserServiceImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DefaultUserController extends UnicastRemoteObject implements UserController {
    private UserService userService = new UserServiceImp();
    public DefaultUserController() throws RemoteException {
        super();
    }
    public boolean login(String mail,String password){
        boolean is_login = false;
        try {
            is_login = userService.login(mail,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return is_login;
    }
}
