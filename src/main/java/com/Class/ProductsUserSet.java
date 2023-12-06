package com.Class;

import java.util.List;

public class ProductsUserSet {
    private User user;
    List<Products> productsList;

    public ProductsUserSet() {}
    public ProductsUserSet(User user, List<Products> productsList) {
        this.user=user;
        this.productsList=productsList;
    }
    // Getter-i
    public User getUser() { return this.user;}
    public List<Products> getProductsList() { return this.productsList;}
    // Setter-i
    public void setUser(User user) { this.user=user;}
    public void setProductsList(List<Products> productsList) { this.productsList=productsList;}
}
