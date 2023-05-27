package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import model.LoginModel;
import model.MenuModel;
import model.PeepsModel;
import model.ReportModel;
import view.AdminView;
import view.LoginView;
import view.MenuView;
import view.PeepsView;
import view.ReportView;

public class AdminController {
    
    private AdminView adminView;

    public AdminController(AdminView adminView) {
        this.adminView = adminView;
        
        //event handling untuk pilihan menu peeps
        adminView.getJpanelPeeps().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); 
                mouseEnter(adminView.getJpanelPeeps());
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mouseExit(adminView.getJpanelPeeps());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                adminView.dispose();
                System.out.println(LoginController.getUsername());
                new PeepsController(new PeepsView(),new PeepsModel(LoginController.getUsername()));
            }
            
            
            
        });
        
        //event handling untuk pilihan menu menu
        adminView.getJpanelMenu().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); 
                mouseEnter(adminView.getJpanelMenu());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mouseExit(adminView.getJpanelMenu());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                adminView.dispose();
                new MenuController(new MenuView(), new MenuModel());
                
            }
        });
        
         //event handling untuk pilihan menu laporan
         adminView.getJpanelReport().addMouseListener(new MouseAdapter() {
             @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); 
                mouseEnter(adminView.getJpanelReport());
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mouseExit(adminView.getJpanelReport());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                adminView.dispose();
//                if(ReportModel.ge)
//                new ReportController(new ReportView(), new ReportModel("",null,0));
                new ReportController(new ReportView(), new ReportModel());
            }
           
            
            
         });
         
         
         
         //event handling untuk logout
         adminView.getJmenuItemLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.dispose();
                new LoginController(new LoginView(),new LoginModel());
            }
         });
    }
  
    
    
    
    
    
    
    private void mouseEnter(JPanel panel){
        panel.setBackground(new Color(6, 70, 99));
    }
    
    private void mouseExit(JPanel panel){
        panel.setBackground(new Color(148, 243, 228));
    }
    
}
