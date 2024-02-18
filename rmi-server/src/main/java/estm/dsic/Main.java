package estm.dsic;

import estm.dsic.controller.AccountController;
import estm.dsic.controller.IAccountController;
import estm.dsic.controller.IUserController;
import estm.dsic.controller.UserController;
import estm.dsic.model.Account;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(5000);
            IUserController userController = new UserController();
            IAccountController accountController = new AccountController();
            Naming.rebind("rmi://localhost:5000/login",userController);
           Naming.rebind("rmi://localhost:5000/account",accountController);


            System.out.println("server active on port : 5000");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
