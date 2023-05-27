package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LoginModel;
import model.MenuModel;
import model.PeepsModel;
import view.AdminView;
import view.LoginView;
import view.MenuView;
import view.PeepsView;

public class MenuController {

    private String dataf[][];
    private String datad[][];

    public MenuController(MenuView menuView, MenuModel menuModel) {
        dataf = menuModel.readAllFood();
        datad = menuModel.readAllDrink();

        menuView.getTabelmakan().setModel(new DefaultTableModel(dataf, new String[]{
            "Makanan", "Harga"
        }) {
            boolean[] canEdit = new boolean[]{
                false, false,};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        menuView.getTabelminum().setModel(new DefaultTableModel(datad, new String[]{
            "Minuman", "Harga"
        }) {
            boolean[] canEdit = new boolean[]{
                false, false,};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        menuView.getTabelmakan().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = menuView.getTabelmakan().getSelectedRow();
                String makanan = menuView.getTabelmakan().getValueAt(row, 0).toString();
                String harga = menuView.getTabelmakan().getValueAt(row, 1).toString();
//                marker = username;

                menuView.setInputmakan(makanan);
                menuView.setHargamakan(harga);
            }
        });

        menuView.getTabelminum().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = menuView.getTabelminum().getSelectedRow();
                String minuman = menuView.getTabelminum().getValueAt(row, 0).toString();
                String harga = menuView.getTabelminum().getValueAt(row, 1).toString();
//                marker = username;

                menuView.setInputminum(minuman);
                menuView.setHargaminum(harga);
            }

        });

        menuView.getAddmknBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String makanan = null;
                int harga = 0;
                try {

                    makanan = menuView.getInputmakan();
                    harga = menuView.getHargamakan();
                    String datam[]= menuModel.checkFood();
                    
                    for (int i = 0; i < menuModel.getTotalFood(); i++) {
                        datam[i] = datam[i].toLowerCase();
                    }
                    
                    if(makanan.equals("")){
                        JOptionPane.showMessageDialog(menuView, "Input Makanan Dahulu");
                    }else {
                        
                        for (int i = 0; i < menuModel.getTotalFood(); i++) {
                            if(makanan.toLowerCase().equals(datam[i])){
                                JOptionPane.showMessageDialog(menuView, "makanan sudah ada");
                                return;
                            }
                            
                        }
                        
                        menuModel.insertFood(makanan, harga);
                        String dataf[][] = menuModel.readAllFood();
                        menuView.getTabelmakan().setModel(new DefaultTableModel(dataf, new String[]{
                            "Makanan", "Harga"
                        }));
                        
                        
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(menuView, "Tolong Masukan Nama Makanan dan Harga Makanan", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        menuView.getAddmnmBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String minuman = null;
                int harga = 0;
                
                try {
                    minuman = menuView.getInputminum();
                    harga = menuView.getHargaminum();
                    String datam[] = menuModel.checkDrink();
                    
                    
                    
                    for (int i = 0; i < menuModel.getTotalDrink(); i++) {
                        datam[i] = datam[i].toLowerCase();
                    }
                    
                    if(minuman.equals("")){
                        JOptionPane.showMessageDialog(menuView, "Input Minuman Dahulu");
                    }
                    else{
                         
                        for (int i = 0; i < menuModel.getTotalDrink(); i++) {
                            if(minuman.toLowerCase().equals(datam[i])){
                                JOptionPane.showMessageDialog(menuView, "Minuman sudah ada");
                                return;
                            }
                        }
                        
                        menuModel.insertDrink(minuman, harga);
                        String datad[][] = menuModel.readAllDrink();
                        menuView.getTabelminum().setModel(new DefaultTableModel(datad, new String[]{
                            "Minuman", "Harga"
                        }));
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(menuView, "Tolong Masukan Nama Minuman dan Harga Minuman", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        menuView.getDeletemknBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String makanan = menuView.getInputmakan();

                if (menuView.getInputmakan().equals("")) {
                    JOptionPane.showMessageDialog(null, "Cannot be empty");
                } else {
                    menuModel.deleteMakan(makanan);
                    String dataf[][] = menuModel.readAllFood();
                    menuView.getTabelmakan().setModel(new DefaultTableModel(dataf, new String[]{
                        "Makanan", "Harga"
                    }));
                }
            }
        });

        menuView.getDeletemnmBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String minuman = menuView.getInputminum();

                if (menuView.getInputminum().equals("")) {
                    JOptionPane.showMessageDialog(null, "Cannot be empty");
                } else {
                    menuModel.deleteMinum(minuman);
                    String datad[][] = menuModel.readAllDrink();
                    menuView.getTabelminum().setModel(new DefaultTableModel(datad, new String[]{
                        "Makanan", "Harga"
                    }));
                }
            }
        });

        menuView.getClearMinuman().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuModel.clearMinum();
                String datad[][] = menuModel.readAllDrink();
                menuView.getTabelminum().setModel(new DefaultTableModel(datad, new String[]{
                    "Makanan", "Harga"
                }));
            }

        });

        menuView.getClearMakanan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuModel.clearMakan();
                String dataf[][] = menuModel.readAllFood();
                menuView.getTabelmakan().setModel(new DefaultTableModel(dataf, new String[]{
                    "Makanan", "Harga"
                }));
            }

        });

        //focus Listener
        menuView.getTxtMakanan().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                menuView.getTxtMakanan().setText("");
            }

        });

        menuView.getTxtInputMakanan().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                menuView.setInputmakan("");
            }
        });

        menuView.getTxtInputMinuman().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                menuView.setInputminum("");
            }
        });

        menuView.getTxtMinuman().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                menuView.getTxtMinuman().setText("");
            }
        });

        //actionPerform listener
        menuView.getMenuItemHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuView.dispose();
                new AdminController(new AdminView());
            }
        });

        menuView.getMenuitemLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuView.dispose();
                new LoginController(new LoginView(), new LoginModel());
            }
        });

        menuView.getClearMakanan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(menuView, "Are You Sure?");
//                if(a == 0)
//                    
            }
        });

        menuView.getClearMinuman().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(menuView, "Are You Sure?");
//               if(a == 0)
            }
        });

        menuView.getPeepsMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuView.dispose();;
                new PeepsController(new PeepsView(), new PeepsModel());
            }
        });

    }

}
