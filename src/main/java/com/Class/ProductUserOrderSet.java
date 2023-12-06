package com.Class;

import java.util.List;

public class ProductUserOrderSet {
    private User user;
    private List<Products> productsList;
    private List<Order> ordersList;

    public ProductUserOrderSet() {}
    public ProductUserOrderSet(User user, List<Products> productsList, List<Order> ordersList) {
        this.user=user;
        this.productsList=productsList;
        this.ordersList=ordersList;
    }
    // Getter-i
    public User getUser() { return this.user;}
    public List<Products> getProductsList() { return this.productsList;}
    public List<Order> getOrdersList() { return this.ordersList;}
    // Setter-i
    public void setUser(User user) { this.user=user;}
    public void setProductsList(List<Products> productsList) { this.productsList=productsList;}
    public void setOrdersList(List<Order> ordersList) { this.ordersList=ordersList;}
}