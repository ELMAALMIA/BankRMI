package estm.dsic;

import estm.dsic.controller.DefaultAccountController;
import estm.dsic.controller.AccountController;
import estm.dsic.controller.UserController;
import estm.dsic.controller.DefaultUserController;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(5000);
            UserController userController = new DefaultUserController();
            AccountController accountController = new DefaultAccountController();
            Naming.rebind("rmi://localhost:5000/login",userController);
           Naming.rebind("rmi://localhost:5000/account",accountController);


            System.out.println("server active on port : 5000");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
