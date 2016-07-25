

package cart;

import entity.Girls;
import entity.Rooms;
import java.util.*;
import abstractProduct.Product;
/**
 *
 * @author gitler
 */
public class ShoppingCart {

//    List<ShoppingCartItem> itemsRooms;
    ShoppingCartItem itemsRooms;
     List<ShoppingCartItem> itemsGirls;
    int numberOfRoomItems;
      int numberOfGirlsItems;
    double total;

    public ShoppingCart() {
        itemsRooms=null;
//        itemsRooms = new ArrayList<ShoppingCartItem>();
        itemsGirls = new ArrayList<ShoppingCartItem>();
        numberOfRoomItems = 0;
         numberOfGirlsItems = 0;
        total = 0;
    }

    
    public synchronized void addItem(Product product) {

        boolean newItem = true;
        
        if(product instanceof Girls) {

        for (ShoppingCartItem scItem : itemsGirls) {

            if (scItem.getProduct().getId() == product.getId()) {

                newItem = false;
//                scItem.incrementQuantity();
            }
        }

        if (newItem) {
            ShoppingCartItem scItem = new ShoppingCartItem( product);
            itemsGirls.add(scItem);
        }
        }else {
            if(product instanceof Rooms) {

//         for (ShoppingCartItem scItem : itemsRooms) {
//
//            if (scItem.getProduct().getId() == product.getId()) {
//
//                newItem = false;
//                scItem.incrementQuantity();
//            }
//        }

//        if (newItem) {
              if (itemsRooms==null) {
            ShoppingCartItem scItem = new ShoppingCartItem( product);
//            itemsRooms.add(scItem);
                itemsRooms=scItem;
        }
        }
            
        }
            
    }
    public synchronized  List<ShoppingCartItem> getGirls (){
        return itemsGirls;
    }
//    public synchronized List<ShoppingCartItem> getRooms (){
//        return itemsRooms;
//    }
    public synchronized ShoppingCartItem getRooms (){
      return itemsRooms;
   }

   
    
    
    
//    public synchronized void update(Product product, String quantity) {
//
//        short qty = -1;
//
//        // cast quantity as short
//        qty = Short.parseShort(quantity);
//
//        if (qty >= 0) {
//
//            ShoppingCartItem item = null;
//
//            for (ShoppingCartItem scItem : items) {
//
//                if (scItem.getProduct().getId() == product.getId()) {
//
//                    if (qty != 0) {
//                        // set item quantity to new value
//                        scItem.setQuantity(qty);
//                    } else {
//                        // if quantity equals 0, save item and break
//                        item = scItem;
//                        break;
//                    }
//                }
//            }
//
//            if (item != null) {
//                // remove from cart
//                items.remove(item);
//            }
//        }
//    }

  
    
//    public synchronized List<ShoppingCartItem> getItems() {
//
//        return items;
//    }

   
    
//    public synchronized int getNumberOfRoomsItems() {
// numberOfRoomItems = 0;
//            
//        for (ShoppingCartItem scItem : itemsRooms) {
//
//            numberOfRoomItems += scItem.getQuantity();
//        }
//
//        return numberOfRoomItems;
//    }
    public synchronized int getNumberOfGirlsItems() {
        
       
         numberOfGirlsItems = 0;

        for (ShoppingCartItem scItem : itemsGirls) {

            numberOfGirlsItems += scItem.getQuantity();
        }
      

        return  numberOfGirlsItems;
    }

  
    
//    public synchronized double getSubtotal() {
//
//        double amount = 0;
//
//        for (ShoppingCartItem scItem : items) {
//
//            Girls girls = (Girls) scItem.getProduct();
//            amount += (scItem.getQuantity() * girls.getPrice().doubleValue());
//        }
//
//        return amount;
//    }

   
    
//    public synchronized void calculateTotal(String surcharge) {
//
//        double amount = 0;
//
//        // cast surcharge as double
//        double s = Double.parseDouble(surcharge);
//
//        amount = this.getSubtotal();
//        amount += s;
//
//        total = amount;
//    }

   
    
    public synchronized double getTotal() {

        return total;
    }

 
    
    
    public synchronized void clear() {
        itemsGirls.clear();
//         itemsRooms.clear();
        itemsRooms=null;
//        numberOfRoomItems = 0;
        numberOfGirlsItems = 0;
        total = 0;
    }

}