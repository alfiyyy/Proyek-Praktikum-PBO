/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


/**
 *
 * @author asus
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuView() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelmakan = new javax.swing.JTable();
        deletemnmBtn = new javax.swing.JButton();
        clearmnmBtn = new javax.swing.JButton();
        addmnmBtn = new javax.swing.JButton();
        hargamakan = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelminum = new javax.swing.JTable();
        deletemknBtn = new javax.swing.JButton();
        clearmknBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        hargaminum = new javax.swing.JTextField();
        addmknBtn = new javax.swing.JButton();
        inputmakan = new javax.swing.JTextField();
        inputminum = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 26, 27));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 63, 68));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Daftar Menu Tersedia");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(69, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 160));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Makanan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        tabelmakan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Makanan", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelmakan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelmakan.setFocusable(false);
        tabelmakan.setNextFocusableComponent(deletemknBtn);
        tabelmakan.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelmakan);
        tabelmakan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 240, 130));

        deletemnmBtn.setForeground(new java.awt.Color(0, 0, 0));
        deletemnmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        deletemnmBtn.setText("Delete");
        deletemnmBtn.setName(""); // NOI18N
        deletemnmBtn.setNextFocusableComponent(clearmnmBtn);
        deletemnmBtn.setOpaque(true);
        jPanel1.add(deletemnmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 115, 40));

        clearmnmBtn.setForeground(new java.awt.Color(0, 0, 0));
        clearmnmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        clearmnmBtn.setText("Clear");
        clearmnmBtn.setNextFocusableComponent(hargaminum);
        jPanel1.add(clearmnmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 115, 40));

        addmnmBtn.setText("Add");
        addmnmBtn.setNextFocusableComponent(deletemknBtn);
        jPanel1.add(addmnmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, -1, -1));

        hargamakan.setText("Harga Makanan");
        hargamakan.setNextFocusableComponent(addmknBtn);
        jPanel1.add(hargamakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 160, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 190, 10, 250));

        tabelminum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Minuman", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelminum.setFocusable(false);
        tabelminum.setNextFocusableComponent(deletemnmBtn);
        tabelminum.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelminum);
        tabelminum.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 240, 130));

        deletemknBtn.setForeground(new java.awt.Color(0, 0, 0));
        deletemknBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        deletemknBtn.setText("Delete");
        deletemknBtn.setNextFocusableComponent(clearmknBtn);
        jPanel1.add(deletemknBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 115, 40));

        clearmknBtn.setForeground(new java.awt.Color(0, 0, 0));
        clearmknBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        clearmknBtn.setText("Clear");
        clearmknBtn.setNextFocusableComponent(hargamakan);
        jPanel1.add(clearmknBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 115, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Minuman");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, -1));

        hargaminum.setText("Harga Minuman");
        hargaminum.setNextFocusableComponent(addmnmBtn);
        jPanel1.add(hargaminum, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 160, 30));

        addmknBtn.setText("Add");
        addmknBtn.setNextFocusableComponent(deletemnmBtn);
        jPanel1.add(addmknBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        inputmakan.setText("Nama Makanan");
        inputmakan.setNextFocusableComponent(addmknBtn);
        jPanel1.add(inputmakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 160, 30));

        inputminum.setText("Nama Minuman");
        inputminum.setNextFocusableComponent(addmnmBtn);
        jPanel1.add(inputminum, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 160, 30));

        jMenu1.setText("Admin");

        jMenuItem5.setText("Home");
        jMenu1.add(jMenuItem5);

        jMenuItem1.setText("Logout");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Page");

        jMenuItem2.setText("Peeps");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Menu");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Report");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public javax.swing.JTextField getTxtMakanan(){
       return hargamakan;
   }
   
   public javax.swing.JTextField getTxtMinuman(){
       return hargaminum;
   }
   
   public javax.swing.JMenuItem getMenuItemHome(){
       return jMenuItem5;
   }
   
   public javax.swing.JMenuItem getMenuitemLogout(){
       return jMenuItem1;
   }
   
   public javax.swing.JButton getClearMakanan(){
       return clearmknBtn;
   }
   
   public javax.swing.JButton getClearMinuman(){
       return clearmnmBtn;
   }

    public JButton getAddmknBtn() {
        return addmknBtn;
    }

    public JButton getAddmnmBtn() {
        return addmnmBtn;
    }

    public JButton getClearmknBtn() {
        return clearmknBtn;
    }

    public JButton getClearmnmBtn() {
        return clearmnmBtn;
    }

    public JButton getDeletemknBtn() {
        return deletemknBtn;
    }

    public JButton getDeletemnmBtn() {
        return deletemnmBtn;
    }

    public int getHargamakan() {
//        return hargamakan.getText();
        return Integer.parseInt(hargamakan.getText());
    }

    public int getHargaminum() {
//        return hargaminum.getText();
        return Integer.parseInt(hargaminum.getText());
    }

    public String getInputmakan() {
        return inputmakan.getText();
    }

    public String getInputminum() {
        return inputminum.getText();
    }

    public void setHargamakan(String hargamakan) {
        this.hargamakan.setText(hargamakan);
    }

    public void setHargaminum(String hargaminum) {
        this.hargaminum.setText(hargaminum);
    }

    public void setInputmakan(String inputmakan) {
        this.inputmakan.setText(inputmakan);
    }

    public void setInputminum(String inputminum) {
        this.inputminum.setText(inputminum);
    }

    public JTable getTabelmakan() {
        return tabelmakan;
    }

    public JTable getTabelminum() {
        return tabelminum;
    }
    
    public javax.swing.JTextField getTxtInputMakanan(){
        return inputmakan;
    }
    
    public javax.swing.JTextField getTxtInputMinuman(){
        return inputminum;
    }
    
    public javax.swing.JMenuItem getPeepsMenuItem(){
        return jMenuItem2;
    }
    
    
    
    
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addmknBtn;
    private javax.swing.JButton addmnmBtn;
    private javax.swing.JButton clearmknBtn;
    private javax.swing.JButton clearmnmBtn;
    private javax.swing.JButton deletemknBtn;
    private javax.swing.JButton deletemnmBtn;
    private javax.swing.JTextField hargamakan;
    private javax.swing.JTextField hargaminum;
    private javax.swing.JTextField inputmakan;
    private javax.swing.JTextField inputminum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabelmakan;
    private javax.swing.JTable tabelminum;
    // End of variables declaration//GEN-END:variables
}
