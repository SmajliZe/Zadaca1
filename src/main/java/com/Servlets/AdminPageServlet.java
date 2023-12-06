package com.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.DB.OrdersDataLoader;
import com.Class.Order;

/**
 * Servlet implementation class AdminPageServlet
 */
@WebServlet("/adminpage")
public class AdminPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrdersDataLoader odl;

    public AdminPageServlet() {
        this.odl=new OrdersDataLoader();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPerform(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputName=request.getParameter("name");
        String inputDescription=request.getParameter("description");
        double inputPrice=Double.parseDouble(request.getParameter("price"));
        Connection con=null;
        RequestDispatcher dispatcher=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zadaca?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "root");
            PreparedStatement pst=con.prepareStatement("insert into products(name,description,price) values(?,?,?) ");
            pst.setString(1, inputName);
            pst.setString(2, inputDescription);
            pst.setDouble(3, inputPrice);

            int rowCount=pst.executeUpdate();
            dispatcher=request.getRequestDispatcher("adminPage.jsp");
            if (rowCount>0) {
                List<Order> ordersList=odl.getAllOrders();
                request.setAttribute("ordersList", ordersList);
            }else {
                request.setAttribute("status", "failed");
            }
            dispatcher.forward(request, response);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void doPerform(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Order> ordersList=odl.getAllOrders();
            request.setAttribute("ordersList", ordersList);
            RequestDispatcher rd=request.getRequestDispatcher("adminPage.jsp");
            rd.forward(request, response);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}

