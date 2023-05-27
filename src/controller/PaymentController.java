package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CartModel;
import model.LoginModel;
import model.PaymentModel;
import view.LoginView;
import view.PaymentView;

public class PaymentController {


    private int jumlahMakanan = 0;
    private int jumlahMinuman = 0;
    private int subTotal = 0;
    private String pilihanMakanan;
    private String pilihanMinuman;
    private int hargaMakanan;
    private int hargaMinuman;
    private String datac[][];
    private String marker;

    public PaymentController(PaymentView paymentView, PaymentModel paymentModel) {


        paymentView.getCmbMakanan().setModel(new DefaultComboBoxModel<>(paymentModel.readAllFood()));
        paymentView.getCmbMinuman().setModel(new DefaultComboBoxModel<>(paymentModel.readAllDrink()));

        pilihanMakanan = paymentView.getCmbMakanan().getSelectedItem().toString();
        pilihanMinuman = paymentView.getCmbMinuman().getSelectedItem().toString();

        paymentView.getJlabelHargaMakanan().setText(Integer.toString(paymentModel.HargaMakanan(pilihanMakanan) * jumlahMakanan));
        paymentView.getJlabelHargaMinuman().setText(Integer.toString(paymentModel.HargaMakanan(pilihanMinuman) * jumlahMinuman));

        //cmbBoxHandler
        paymentView.getCmbMakanan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paymentView.getTxtJumlahMakanan().getText().toString() == "Jumlah") {
                    jumlahMakanan = 0;
                } else {
                    pilihanMakanan = paymentView.getCmbMakanan().getSelectedItem().toString();
                    hargaMakanan = paymentModel.HargaMakanan(pilihanMakanan) * jumlahMakanan;
                    paymentView.getJlabelHargaMakanan().setText(Integer.toString(hargaMakanan));
                }
            }
        });

        paymentView.getCmbMinuman().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paymentView.getTxtJumlahMinuman().getText().toString() == "Jumlah") {
                    jumlahMinuman = 0;
                } else {
                    pilihanMinuman = paymentView.getCmbMinuman().getSelectedItem().toString();
                    hargaMinuman = paymentModel.HargaMinuman(pilihanMinuman) * jumlahMinuman;
                    paymentView.getJlabelHargaMinuman().setText(Integer.toString(hargaMinuman));
                }
            }
        });

        //menuItem Handler
        paymentView.getMenuItemLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentView.dispose();
                new LoginController(new LoginView(), new LoginModel());
            }
        });

        //TextField Focus Handler
        paymentView.getTxtJumlahMakanan().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                paymentView.getTxtJumlahMakanan().setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    jumlahMakanan = Integer.parseInt(paymentView.getTxtJumlahMakanan().getText());
                    pilihanMakanan = paymentView.getCmbMakanan().getSelectedItem().toString();
                    hargaMakanan = paymentModel.HargaMakanan(pilihanMakanan) * jumlahMakanan;
                    paymentView.getJlabelHargaMakanan().setText(Integer.toString(hargaMakanan));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(paymentView, "Masukan Angka pada Input Jumlah Makanan");
                    paymentView.getTxtJumlahMakanan().setText("");
                    paymentView.getTxtJumlahMakanan().requestFocus();
                }
            }
        });

        paymentView.getTxtJumlahMinuman().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                paymentView.getTxtJumlahMinuman().setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    jumlahMinuman = Integer.parseInt(paymentView.getTxtJumlahMinuman().getText());
                    pilihanMinuman = paymentView.getCmbMinuman().getSelectedItem().toString();
                    hargaMinuman = paymentModel.HargaMinuman(pilihanMinuman) * jumlahMinuman;

                    paymentView.getJlabelHargaMinuman().setText(Integer.toString(hargaMinuman));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(paymentView, "Masukan Angka pada Input Jumlah Minuman");
                    paymentView.getTxtJumlahMinuman().setText("");
                    paymentView.getTxtJumlahMinuman().requestFocus();
                }
            }

        });

        paymentView.getTxtJumlahUang().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                paymentView.getTxtJumlahUang().setText("");
            }
        });

        paymentView.getjButtonAddMakanan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pilihanMakanan = paymentView.getCmbMakanan().getSelectedItem().toString();
                    jumlahMakanan = Integer.parseInt(paymentView.getTxtJumlahMakanan().getText());
                    hargaMakanan = paymentModel.HargaMakanan(pilihanMakanan) * jumlahMakanan;
                    subTotal += hargaMakanan;

                    paymentView.getjLabelSubTotal().setText(Integer.toString(subTotal));
                    CartModel carts = new CartModel(pilihanMakanan, jumlahMakanan, hargaMakanan);

                    CartModel.addToCart(carts);

                    datac = CartModel.readAllCarts();

                    paymentView.getjTableCart().setModel(new DefaultTableModel(datac, new String[]{
                        "Makanan/Minuman", "Jumlah", "Harga"
                    }) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });

                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(paymentView, "Mohon masukan jumlah Makanan");
                }
            }
        });

        paymentView.getjButtonAddMinuman().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pilihanMinuman = paymentView.getCmbMinuman().getSelectedItem().toString();
                    jumlahMinuman = Integer.parseInt(paymentView.getTxtJumlahMinuman().getText());
                    hargaMinuman = paymentModel.HargaMinuman(pilihanMinuman) * jumlahMinuman;
                    subTotal += hargaMinuman;
                    paymentView.getjLabelSubTotal().setText(Integer.toString(subTotal));

                    CartModel carts = new CartModel(pilihanMinuman, jumlahMinuman, hargaMinuman);

                    CartModel.addToCart(carts);

                    datac = CartModel.readAllCarts();

                    paymentView.getjTableCart().setModel(new DefaultTableModel(datac, new String[]{
                        "Makanan/Minuman", "Jumlah", "Harga"
                    }) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });

                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(paymentView, "Mohon masukan jumlah Minuman");
                }
            }
        });

        paymentView.getjButtonClear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int a = JOptionPane.showConfirmDialog(paymentView, "apakah Anda Yakin?");
                if (a == 0) {
                    CartModel.emptyCart();
                    subTotal = 0;

                    datac = CartModel.readAllCarts();

                    paymentView.getjTableCart().setModel(new DefaultTableModel(datac, new String[]{
                        "Makanan/Minuman", "Jumlah", "Harga"
                    }) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });

                    paymentView.getjLabelSubTotal().setText("SubTotal");
                    paymentView.getjTextFieldBayar().setText("Jumlah yang dibayarkan");
                    paymentView.getjLabelKembalian().setText("Kembalian");
                }

            }

        });

        paymentView.getjTableCart().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = paymentView.getjTableCart().getSelectedRow();
                String namaMenu = paymentView.getjTableCart().getValueAt(row, 0).toString();

                marker = namaMenu;
            }
        });

        paymentView.getjButtonDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartModel.deleteCartList(marker);

                datac = CartModel.readAllCarts();

                paymentView.getjTableCart().setModel(new DefaultTableModel(datac, new String[]{
                    "Makanan/Minuman", "Jumlah", "Harga"
                }) {
                    boolean[] canEdit = new boolean[]{
                        false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            }
        });

        paymentView.getjButtonBayar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int inputUang = 0;
                int kembalian = 0;

                try {

                    inputUang = Integer.parseInt(paymentView.getjTextFieldBayar().getText());
                    if (inputUang < subTotal) {
                        JOptionPane.showMessageDialog(paymentView, "Uang Kurang", "Info", JOptionPane.WARNING_MESSAGE);
                        paymentView.getjTextFieldBayar().requestFocus();
                    } else {
                        kembalian = subTotal - inputUang;
                        paymentView.getjLabelKembalian().setText(Integer.toString(Math.abs(kembalian)));

                        JOptionPane.showMessageDialog(paymentView, "Pembayaran Berhasil");
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();

                        paymentModel.addToReport(dtf.format(now), LoginController.getUsername(), CartModel.listOfCarts(), subTotal);
//               new ReportModel(dtf.format(now),CartModel.listOfCarts(),subTotal);

                        CartModel.emptyCart();
                        subTotal = 0;

                        datac = CartModel.readAllCarts();

                        paymentView.getjTableCart().setModel(new DefaultTableModel(datac, new String[]{
                            "Makanan/Minuman", "Jumlah", "Harga"
                        }));

                        paymentView.getjLabelSubTotal().setText("SubTotal");
                        paymentView.getjTextFieldBayar().setText("Jumlah yang dibayarkan");
                        paymentView.getjLabelKembalian().setText("Kembalian");

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(paymentView, "Uang Kurang", "Info", JOptionPane.WARNING_MESSAGE);
                }
//                System.out.println(inputUang);
//                System.out.println(subTotal);

            }
        });

    }

}
