package model;

import java.sql.*;
import javax.swing.JOptionPane;

public class MenuModel extends Connector {
//    public int getTotalMenu(){
//        try {
//            int totalData = 0;
//            String query = "SELECT * FROM `menu`";
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            
//            while(resultSet.next()){
//                totalData++;
//            }
//            statement.close();
//            return totalData;
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//            return 0;
//        }
//    
//       }

    public int getTotalFood() {
        try {
            int totalData = 0;
            String query = "SELECT * FROM `menu` WHERE category = 'Makanan'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }

    }

    public int getTotalDrink() {
        try {
            int totalData = 0;
            String query = "SELECT * FROM `menu` WHERE category = 'Minuman'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }

    }

    public String[][] readAllFood() {
        String data[][] = new String[getTotalFood()][4];
        try {
            int indexData = 0;
            String query = "SELECT * FROM `menu` WHERE category = 'Makanan'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[indexData][0] = resultSet.getString("name");
                data[indexData][1] = resultSet.getString("price");
                indexData++;
            }
            statement.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }

    public String[][] readAllDrink() {
        String data[][] = new String[getTotalDrink()][4];
        try {
            int indexData = 0;
            String query = "SELECT * FROM `menu` WHERE category = 'Minuman'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[indexData][0] = resultSet.getString("name");
                data[indexData][1] = resultSet.getString("price");
                indexData++;
            }
            statement.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }

    public String[] checkFood() {
        String data[] = new String[getTotalFood()];
        try {
            int index = 0;
            String query = "SELECT `name` FROM menu WHERE category = 'Makanan'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[index] = resultSet.getString("name");
                index++;
            }

            statement.close();
            return data;
//            JOptionPane.showMessageDialog(null, "Input Success");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
        return data;
        }
    }
    public String[] checkDrink() {
        String data[] = new String[getTotalDrink()];
        try {
            int index = 0;
            String query = "SELECT `name` FROM menu WHERE category = 'Minuman'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[index] = resultSet.getString("name");
                index++;
            }

            statement.close();
            return data;
//            JOptionPane.showMessageDialog(null, "Input Success");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
        return data;
        }
    }

    public void insertFood(String makanan, int harga) {
        try {
            String query = "INSERT INTO `menu` (`id`, `name`, `price`, `category`) "
                    + "VALUES "
                    + "(NULL," + "'" + makanan + "'," + "'" + harga + "'," + "'Makanan')";

            statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            JOptionPane.showMessageDialog(null, "Input Success");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
        }
    }

    public void insertDrink(String minuman, int harga) {
        try {
            String query = "INSERT INTO `menu` (`id`, `name`, `price`, `category`) "
                    + "VALUES "
                    + "(NULL," + "'" + minuman + "'," + "'" + harga + "'," + "'Minuman')";

            statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            JOptionPane.showMessageDialog(null, "Input Success");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
        }
    }

    public void deleteMakan(String makanan) {
        if (!checkmakanan(makanan)) {
            JOptionPane.showMessageDialog(null, "Food not Found");
            return;
        }

        try {
            String query = "DELETE FROM `menu` WHERE `name`='" + makanan + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();

            JOptionPane.showMessageDialog(null, "Delete Success");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }

    public void deleteMinum(String minuman) {
        if (!checkmakanan(minuman)) {
            JOptionPane.showMessageDialog(null, "Drink not Found");
            return;
        }

        try {
            String query = "DELETE FROM `menu` WHERE `name`='" + minuman + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();

            JOptionPane.showMessageDialog(null, "Delete Success");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }

    public boolean checkmakanan(String makanan) {
        try {
            int totalData = 0;
            String query = "SELECT * FROM `menu` WHERE `name`='" + makanan + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                totalData++;
            }
            statement.close();

            if (totalData > 0) {
                return true;
            }

            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }

    public boolean checkminuman(String minuman) {
        try {
            int totalData = 0;
            String query = "SELECT * FROM `menu` WHERE `name`='" + minuman + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                totalData++;
            }
            statement.close();

            if (totalData > 0) {
                return true;
            }

            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }

    public void clearMakan() {
        try {
            String query = "DELETE FROM `menu` WHERE `category`='Makanan'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();

            JOptionPane.showMessageDialog(null, "Delete Success");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }

    public void clearMinum() {
        try {
            String query = "DELETE FROM `menu` WHERE `category`='Minuman'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();

            JOptionPane.showMessageDialog(null, "Delete Success");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }
}
