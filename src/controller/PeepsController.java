package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LoginModel;
import model.MenuModel;
import model.PeepsModel;
import model.ReportModel;
import view.AdminView;
import view.LoginView;
import view.MenuView;
import view.PeepsView;
import view.ReportView;

public class PeepsController {

//    static String[][] readAllFood() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    static String[][] readAllDrink() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    PeepsView peepsView;
    PeepsModel peepsModel;
    private String data[][];
    private String marker;

    public PeepsController(PeepsView peepsView, PeepsModel peepsModel) {
        this.peepsView = peepsView;
        this.peepsModel = peepsModel;
        data = peepsModel.readAllUsers();

        peepsView.getTabel().setModel(new DefaultTableModel(data, new String[]{
            "Fullname", "Username", "Password", "Roles"
        }) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        peepsView.getTabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = peepsView.getTabel().getSelectedRow();
                String username = peepsView.getTabel().getValueAt(row, 1).toString();
                String fullname = peepsView.getTabel().getValueAt(row, 0).toString();
                String password = peepsView.getTabel().getValueAt(row, 2).toString();
                String roles = peepsView.getTabel().getValueAt(row, 3).toString();
                marker = username;

                peepsView.setUsernameTxt(username);
                peepsView.setFullnameTxt(fullname);
                peepsView.setPasswordTxt(password);
//                peepsView.setUsernameTxt(username);

                if (roles.equals("Admin") || roles.equals("admin")) {
                    peepsView.getCmb().setSelectedIndex(0);
                } else {
                    peepsView.getCmb().setSelectedIndex(1);
                }
            }

        });
        peepsView.getAddBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullname = peepsView.getFullnameTxt();
                String username = peepsView.getUsernameTxt();
                String password = peepsView.getPasswordTxt();
                String roles = peepsView.getRolesCmb();
                
                if(!fullname.equals("") && !username.equals("") && !password.equals("")){
                    peepsModel.insertUser(fullname, username, password, roles);
                    String dataUser[][] = peepsModel.readAllUsers();
                    peepsView.getTabel().setModel(new DefaultTableModel(dataUser, new String[]{
                        "Fullname", "Username", "Password", "Roles"
                    }) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });
                    
                } else JOptionPane.showMessageDialog(peepsView, "Mohon isi form terlebih dahulu","Eror",JOptionPane.ERROR_MESSAGE);

            }
        });

        peepsView.getDeleteBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = peepsView.getUsernameTxt();

                if (peepsView.getUsernameTxt().equals("")) {
                    JOptionPane.showMessageDialog(null, "Cannot be empty");
                } else {
                    System.out.println(LoginController.getUsername());
                    peepsModel.deleteUser(username);
                    String dataUser[][] = peepsModel.readAllUsers();
                    peepsView.getTabel().setModel(new DefaultTableModel(dataUser, new String[]{
                        "Fullname", "Username", "Password", "Roles"
                    }) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });
                }
            }
        });

        peepsView.getUpdateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullname = peepsView.getFullnameTxt();
                String username = peepsView.getUsernameTxt();
                String password = peepsView.getPasswordTxt();
                String roles = peepsView.getRolesCmb();

//                if (marker.equals("")) {
//                    marker = username;
//                }

                if (peepsView.getFullnameTxt().equals("") && username.equals("") && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Cannot be empty");
                } else {
                    peepsModel.updateUser(fullname, username, password, roles, marker);
//                    marker = "";
                    String dataUser[][] = peepsModel.readAllUsers();
                    peepsView.getTabel().setModel(new DefaultTableModel(dataUser, new String[]{
                        "Fullname", "Username", "Password", "Roles"
                    }) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });
                }

            }
        });

        peepsView.getClearBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                peepsView.setUsernameTxt("");
                peepsView.setFullnameTxt("");
                peepsView.setPasswordTxt("");

//                marker = "";
            }
        });

        this.peepsView.getjMenuItemHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peepsView.dispose();
                new AdminController(new AdminView());
            }
        });

        this.peepsView.getjMenuItemLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peepsView.dispose();
                new LoginController(new LoginView(), new LoginModel());
            }
        });

        this.peepsView.getjMenuItemMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peepsView.dispose();
                new MenuController(new MenuView(), new MenuModel());
            }
        });
        
        peepsView.getjMenuItemReport().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peepsView.dispose();
                new ReportController(new ReportView(),new ReportModel());
            }
        });

    }
}
