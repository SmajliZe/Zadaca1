package com.Class;

import java.util.Date;

public class Order {
    private int id;
    private String username;
    private String address;
    private double total;
    private String products;
    private Date date;
    private int status;

    public Order() {}
    public Order(String username, String address, double total, String products) {
        this.username=username;
        this.address=address;
        this.total=total;
        this.products=products;
    }
    // Getter-i
    public int getId() { return this.id;}
    public String getUsername() { return this.username;}
    public String getAddress() { return this.address;}
    public double getTotal() { return this.total;}
    public String getProducts() { return this.products;}
    public Date getDate() { return this.date;}
    public int getStatus() { return this.status;}
    // Setter-i
    public void setId(int id) { this.id=id;}
    public void setUsername(String username) { this.username=username;}
    public void setAddress(String address) { this.address=address;}
    public void setTotal(double total) { this.total=total;}
    public void setProducts(String products) { this.products=products;}
    public void setDate(Date date) { this.date=date;}
    public void setStatus(int status) { this.status=status;}
}