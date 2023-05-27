package model;

import java.util.ArrayList;

public class CartModel {

    private String pilihanMenu;
    private int jumlahMenu;
    private int hargaMenu;
    
    private static ArrayList<CartModel> carts = new ArrayList<>();

    public CartModel(String pilihanMenu, int jumlahMenu, int hargaMenu) {
        this.pilihanMenu = pilihanMenu;
        this.jumlahMenu = jumlahMenu;
        this.hargaMenu = hargaMenu;
    }
    
    public static void addToCart(CartModel cart){
       boolean newItem=true;
        for (int index = 0; index < carts.size(); index++) {
            if(carts.get(index).pilihanMenu == cart.pilihanMenu)
                newItem = false;
            }
        
        if(newItem){
            carts.add(cart);
        }
        else{
            for (int index = 0; index < carts.size(); index++) {
                if(carts.get(index).pilihanMenu == cart.pilihanMenu){
                    int hargaSatuan = carts.get(index).hargaMenu/carts.get(index).jumlahMenu;
                    carts.get(index).jumlahMenu += cart.jumlahMenu;
                    carts.get(index).hargaMenu = carts.get(index).jumlahMenu * hargaSatuan;
                }
            }
            
        }
    }
    
    public static String [][] readAllCarts(){
        
        String data[][] = new String[carts.size()][3];  
        int index = 0;
        
        for(CartModel i : carts ){
            data[index][0] = i.pilihanMenu;
            data[index][1] = Integer.toString(i.jumlahMenu) ;
            data[index][2]= Integer.toString(i.hargaMenu);
            index++;
        }
        return data;
    }
    
    public static void emptyCart(){
        carts.clear();
    }
    
    public static void deleteCartList(String marker){
         for (int index = 0; index < carts.size(); index++) {
            if(carts.get(index).pilihanMenu == marker)
                carts.remove(index);
            }
    }
    
    public static ArrayList<CartModel> listOfCarts(){
        return carts;
    }
    
    public static int getCartSize(){
        return carts.size();
    }
    
    public String getPilihanMenu(int index){
        return carts.get(index).pilihanMenu;
    }
    
    public String getPilihanMenu(){
        return pilihanMenu;
    }
    
    public int getHargaMenu(int index){
        return carts.get(index).hargaMenu;
    }
    
    
}
