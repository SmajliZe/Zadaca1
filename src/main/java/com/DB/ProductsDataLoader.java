package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Class.Products;

public class ProductsDataLoader {
    public List<Products> getAllProducts(){
        Connection con=null;
        List<Products> productsList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zadaca?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            PreparedStatement pst=con.prepareStatement("select * from products;");
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {
                Products product=new Products();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                productsList.add(product);
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
        return productsList;
    }
}

