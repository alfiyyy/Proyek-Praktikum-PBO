package model;

import java.sql.*;

public class LoginModel extends Connector {



public boolean isAdmin(String username, String password){
    
    int totData= 0;
        try{
            String query = "SELECT * FROM `users` WHERE "
                    + "`username`='" + username + "' AND "
                    + "`password`='" + password + "' AND "
                    + "`roles`='Admin'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totData++;
            }
            
            statement.close();
            
            if(totData > 0){
                return true;
            }
            
            return false;
            
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
}

public boolean isEmployee(String username, String password){
    
    int totData= 0;
        try{
            String query = "SELECT * FROM `users` WHERE "
                    + "`username`='" + username + "' AND "
                    + "`password`='" + password + "' AND "
                    + "`roles`='employee'" ;
            
           statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totData++;
            }
            
            statement.close();
            
            if(totData > 0){
                return true;
            }
            
            return false;
            
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    
}    




    
}
