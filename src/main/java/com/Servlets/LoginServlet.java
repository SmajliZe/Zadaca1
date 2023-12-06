package com.Servlets;

import com.DB.OrdersDataLoader;
import com.DB.ProductsDataLoader;
import com.Class.Order;
import com.Class.Products;
import com.Class.ProductUserOrderSet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.Class.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductsDataLoader pdl;
    private OrdersDataLoader odl;

    public LoginServlet() {
        this.pdl=new ProductsDataLoader();
        this.odl=new OrdersDataLoader();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputUsername=request.getParameter("username");
        String inputPassword=request.getParameter("password");
        HttpSession session=request.getSession();
        RequestDispatcher dispatcher=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zadaca?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "root");
            PreparedStatement pst=con.prepareStatement("select * from users where username = ? and password = ?");
            pst.setString(1, inputUsername);
            pst.setString(2, inputPassword);

            ResultSet rs=pst.executeQuery();
            if (rs.next()) {
                User loggedOnUser= new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("address"), rs.getInt("role"));
                List<Products> productsList=pdl.getAllProducts();
                List<Order> ordersList=odl.getAllOrders();
                ProductUserOrderSet productsUserSet=new ProductUserOrderSet(loggedOnUser, productsList, ordersList);
                session.setAttribute("data", productsUserSet);
                dispatcher=request.getRequestDispatcher("index.jsp");
            }else {
                request.setAttribute("status", "failed");
                dispatcher=request.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(request, response);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}

