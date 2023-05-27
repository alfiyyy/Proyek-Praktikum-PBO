package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.CartModel;
import model.LoginModel;
import model.MenuModel;
import model.PeepsModel;
import view.ReportView;
import model.ReportModel;
import view.AdminView;
import view.LoginView;
import view.MenuView;
import view.PeepsView;

public class ReportController {

private ReportView reportView;
private ReportModel reportModel;
private String datar[][];

    public ReportController(ReportView reportView, ReportModel reportModel) {
        this.reportView = reportView;
        this.reportModel = reportModel;
        
        datar= reportModel.readReport();
        
//        datac = reportModel.
//System.out.println(ReportModel.getReportList());
        
        
        reportView.getjTableReport().setModel(new DefaultTableModel(datar,new String[]{"Date","User","Menu","Total Harga"}){
            boolean[] canEdit = new boolean [] {
                false, false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        } );
        
        
        reportView.getjMenuItemHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  reportView.dispose();
                new AdminController(new AdminView());
            }
        });
        
        reportView.getjMenuItemLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  reportView.dispose();
                new LoginController(new LoginView(),new LoginModel());
            }
        });
        
        reportView.getjMenuItemPeeps().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  reportView.dispose();
                new PeepsController(new PeepsView(),new PeepsModel());
            }
        });
        
        reportView.getjMenuItemMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  reportView.dispose();
                new MenuController(new MenuView(),new MenuModel());
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
    }






    
}
