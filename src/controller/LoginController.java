package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LoginModel;
import model.PaymentModel;
import view.LoginView;
import view.AdminView;
import view.PaymentView;

public class LoginController {
    
    private LoginView loginView;
    private LoginModel loginModel;
    private static String username;
    public LoginController(LoginView loginView,LoginModel loginModel){
        this.loginView = loginView;
        this.loginModel = loginModel;
        
        //event handling untuk login button
        loginView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                    username = loginView.getuser();
                    String password = loginView.getPass();
                    
                    if(loginModel.isAdmin(loginView.getuser(), password)){
                        username = loginView.getuser();
                        JOptionPane.showMessageDialog(loginView, "Login Success (ADMIN)");
                        loginView.dispose();
                        new AdminController(new AdminView());
                    }
                    else if(loginModel.isEmployee(loginView.getuser(), password)){
                        username = loginView.getuser();
                       JOptionPane.showMessageDialog(loginView, "Login Success (USER)");
                       loginView.dispose();
                       new PaymentController(new PaymentView(),new PaymentModel());
                    }
                    else JOptionPane.showMessageDialog(loginView, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    public static String getUsername(){
        return username;
    }
    
    
}
