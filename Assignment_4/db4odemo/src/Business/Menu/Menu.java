/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Menu;

/**
 *
 * @author 12013
 */
public class Menu {
    
    private String itemName;
    private double price;
    private String restaurantName;
    private String cuisine;
    private String itemType;
    
    public Menu(String itemName, double price, String restaurantName, String cuisine, String itemType) {
        this.itemName = itemName;
        this.price = price;
        this.restaurantName = restaurantName;
        this.cuisine = cuisine;
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
       
    
    @Override
    public String toString() {
        return itemName;
    }
}
