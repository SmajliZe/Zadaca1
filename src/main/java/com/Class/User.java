package com.Class;

public class User {
    private int id;
    private String username;
    private String password;
    private String address;
    private int role;

    public User() {}
    public User(int id, String username, String password, String address, int role) {
        this.id=id;
        this.username=username;
        this.password=password;
        this.address=address;
        this.role=role;
    }
    // Getter-i
    public int getId() { return this.id;}
    public String getUsername() { return this.username;}
    public String getPassword() { return this.password;}
    public String getAddress() { return this.address;}
    public int getRole() { return this.role;}
    // Setter-i
    public void setId(int id) { this.id=id;}
    public void setUsername(String username) { this.username=username;}
    public void setPassword(String password) { this.password=password;}
    public void setAddress(String address) { this.address=address;}
    public void setRole(int role) { this.role=role;}
}
