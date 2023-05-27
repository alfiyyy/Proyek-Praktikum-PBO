package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class PaymentModel extends Connector {
    
    public int getTotalFood(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `menu` WHERE category = 'Makanan'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    
       }
    
    public int getTotalDrink(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `menu` WHERE category = 'Minuman'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    
       }

    public String[] readAllFood(){
        String data[] = new String [getTotalFood()];
        try {
            int indexData = 0;  
            String query = "SELECT `name` FROM `menu` WHERE category = 'Makanan'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[indexData] = resultSet.getString("name");
                indexData++;
            }
            statement.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }
    
    public String[] readAllDrink(){
        String data[] = new String[getTotalDrink()];
        try {
            int indexData = 0;  
            String query = "SELECT * FROM `menu` WHERE category = 'Minuman'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[indexData] = resultSet.getString("name");
                indexData++;
            }
            statement.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }
    
    public int HargaMakanan(String makanan){
        int data =0;
        try{
            String query = "SELECT `price` FROM `menu` WHERE category = 'Makanan' and name = '"+ makanan +"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data = resultSet.getInt("price");
            }
            statement.close();
            return data;
        }
        catch(Exception e){
            System.out.println("Error : "+ e.getMessage());
            return data;
        }
        
    }
    
    public int HargaMinuman(String minuman){
        int data =0;
        try{
            String query = "SELECT `price` FROM `menu` WHERE category = 'Minuman' and name = '"+ minuman +"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data = resultSet.getInt("price");
            }
            statement.close();
            return data;
        }
        catch(Exception e){
            System.out.println("Error : "+ e.getMessage());
            return data;
        }
        
    }
    
    
    public void addToReport(String now,String username,ArrayList<CartModel> carts,int subTotal ){
        try{
                ArrayList<String> menuPilihanCarts = new ArrayList<>();
                int index=0;
            
                for(CartModel i : carts){
                    menuPilihanCarts.add(i.getPilihanMenu());
                    index++;
                }
                
                String menuPilihan = String.join(",", menuPilihanCarts);
            
//             String query = "INSERT INTO `report` (`id_report`, `date`, `username`, `total_harga`) "
//                    + "VALUES "
//                    + "( NULL ,'" + now + "'," + "'" + carts + "'," + "'" + username + "',"+ "'" + subTotal + "')";
             String query = "INSERT INTO `report` (`date`, `username`,`menu`,`total_harga`) "
                    + "VALUES "
                    + "(?,?,?,?)";
             
             
                pstmt = connection.prepareStatement(query);
            
            
                pstmt.setString(1, now);
                pstmt.setString(2, username);
                pstmt.setString(3, menuPilihan);
                pstmt.setInt(4, subTotal);
                pstmt.executeUpdate(); 
           
            
            statement.close();
        }
        catch(Exception e){
            System.out.println("Error : "+ e.getMessage());
        }
        
    }
    
    
    
    
    
    
    
    
}
