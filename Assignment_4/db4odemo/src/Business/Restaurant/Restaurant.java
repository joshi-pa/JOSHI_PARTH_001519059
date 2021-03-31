/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Menu.MenuDirectory;

/**
 *
 * @author harold
 */
public class Restaurant {
    
    private String restaurantName;
    private String address;
    private String restroManagerName;
    private String phoneNumber;
    private MenuDirectory MenuDirectory;
    private String restRating;
    
    public Restaurant(String restaurantName, String address, String managerName, String phoneNumber, String restRating) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.restroManagerName = managerName;
        this.phoneNumber = phoneNumber;
        this.restRating = restRating;
    }

    public MenuDirectory getMenuDirectory() {
        return MenuDirectory;
    }

    public void setMenuDirectory(MenuDirectory MenuDirectory) {
        this.MenuDirectory = MenuDirectory;
    }
    
    

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRestroManagerName() {
        return restroManagerName;
    }

    public void setRestroManagerName(String restroManagerName) {
        this.restroManagerName = restroManagerName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRestRating() {
        return restRating;
    }

    public void setRestRating(String restRating) {
        this.restRating = restRating;
    }
    
    
    @Override
    public String toString() {
        return restaurantName;
    }


    
}
