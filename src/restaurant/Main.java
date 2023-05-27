package restaurant;

import controller.LoginController;
import controller.PaymentController;
import model.LoginModel;
import view.LoginView;
import view.PaymentView;

public class Main {
    public static void main(String[] args) {
        new LoginController(new LoginView(),new LoginModel());
//        new PaymentController(new PaymentView());
        
    }
}
