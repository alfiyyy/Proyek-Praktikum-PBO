package model;

import java.sql.*;
import javax.swing.JOptionPane;


public class PeepsModel extends Connector {
private String username;

    public PeepsModel() {
    }

    public PeepsModel(String username) {
        this.username = username;
    }
    
    

    public int getTotalUser(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `users`";
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
    
    public String[][] readAllUsers(){
        String data[][] = new String[getTotalUser()][4];
        try {
            int indexData = 0;  
            String query = "SELECT * FROM `users`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[indexData][0] = resultSet.getString("fullname");
                data[indexData][1] = resultSet.getString("username");
                data[indexData][2] = resultSet.getString("password");
                data[indexData][3] = resultSet.getString("roles");
                indexData++;
            }
            statement.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }
    
    public boolean checkUsername(String username){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `users` WHERE `username`='" + username + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            
            if(totalData>0){
                return true;
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }
    
    
    public void insertUser(String fullname, String username, String password, String roles){
        String role;
        if(roles.equals("Admin")){
            role = "Admin";
        }else{
            role = "Employee";
        }
        try {
            String query = "INSERT INTO `users` (`fullname`, `username`, `password`, `roles`) "
                    + "VALUES "
                    + "('"+ fullname + "'," + "'" + username + "'," + "'" + password + "',"+ "'" + roles + "')";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            JOptionPane.showMessageDialog(null, "Input Success");
            
        } catch (Exception e) { 
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Username Telah Digunakan","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteUser(String username){
        if(!checkUsername(username)){
            JOptionPane.showMessageDialog(null, "Username not Found");
            return;
        }
        
        if(this.username.equals(username) ){
            JOptionPane.showMessageDialog(null, "Cannot delete the user that has logged in","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String query = "DELETE FROM `users` WHERE `username`='" + username + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            
            JOptionPane.showMessageDialog(null, "Delete Success");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }
    
    public void updateUser(String fullname, String username, String password, String roles, String marker){
         if(!checkUsername(marker)){
            JOptionPane.showMessageDialog(null, "Username not Found");
            return;
        }
         
        String role;
        if(roles.equals("Admin")){
            role = "admin";
        }else{
            role = "employee";
        }
        try {
            String query = "UPDATE `users` "
                    + "SET "
                    + "`fullname`='" + fullname + "', "
                    + "`username`='" + username + "', "
                    + "`password`='" + password + "', "
                    + "`roles`='" + roles + "' "
                    + "WHERE `username`='" + marker + "'";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
        }
    }
}
