package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Class.Order;

public class OrdersDataLoader {
    public List<Order> getAllOrders(){
        Connection con=null;
        List<Order> ordersList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zadaca?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "root");
            PreparedStatement pst=con.prepareStatement("select * from orders;");
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {
                Order order=new Order();
                order.setId(rs.getInt("id"));
                order.setUsername(rs.getString("username"));
                order.setAddress(rs.getString("address"));
                order.setTotal(rs.getDouble("total"));
                order.setProducts(rs.getString("products"));
                order.setDate(rs.getDate("date"));
                order.setStatus(rs.getInt("status"));
                ordersList.add(order);
            }
            for (int i=0; i<ordersList.size(); i++) {
                System.out.println(ordersList.get(i).getId());
                System.out.println(ordersList.get(i).getUsername());
                System.out.println(ordersList.get(i).getAddress());
                System.out.println(ordersList.get(i).getTotal());
                System.out.println(ordersList.get(i).getProducts());
                System.out.println(ordersList.get(i).getDate());
                System.out.println(ordersList.get(i).getStatus());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return ordersList;
    };
}