package model;

import controller.LoginController;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReportModel extends Connector {
    
    private String now;
    private ArrayList<CartModel> carts;
    private int subTotal;
    
    private static ArrayList<ReportModel> reports = new ArrayList<>();
    
//    public ReportModel(String now,ArrayList<CartModel> carts,int subTotal){
//        this.now = now;
//        this.carts =carts;
//        this.subTotal = subTotal;
//        
//            addReport(this);
//
//    }

    public ReportModel() {

    }
    
    
    
    public int readAllReportData(){
         try {
            int totalData = 0;
            String query = "SELECT * FROM `report`";
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
    
    
    public static void addReport(ReportModel report){
         reports.add(report);
        
    }
    
    public static ArrayList<ReportModel> getReportList(){
        return reports;
    }
    
    public static int getSizeReportList(){
        return reports.size();
    }
    
    
    public String[][] readReport(){
        String data[][] = new String [readAllReportData()][4];
        try {
            int indexData = 0;  
            String query = "SELECT * FROM `report`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[indexData][0] = resultSet.getString("date");
                data[indexData][1] = resultSet.getString("username");
                data[indexData][2] = resultSet.getString("menu");
                data[indexData][3] = resultSet.getString("total_harga");
                indexData++;
            }
            statement.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
        
//        for(CartModel i : carts){
//            data[0][0]= LoginController.getUsername();
//            data[index][1] = i.getPilihanMenu(index);
//            data[index][2]= Integer.toString(i.getHargaMenu(index));
//            index++;
//        }
//        return data;
    }
    
    
    
    
}
