package com.Servlets;

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
import java.sql.SQLException;

import com.Class.ProductUserOrderSet;

/**
 * Servlet implementation class OrderingServlet
 */
@WebServlet("/ordering")
public class OrderingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        ProductUserOrderSet productUserOrderSet=(ProductUserOrderSet) session.getAttribute("data");
        String orderUsername=productUserOrderSet.getUser().getUsername();
        String inputAddress=request.getParameter("address");
        double total=Double.parseDouble(request.getParameter("total"));
        String products=request.getParameter("products");
        Connection con=null;
        RequestDispatcher dispatcher=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zadaca?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "root");
            PreparedStatement pst=con.prepareStatement("insert into orders(username,address,total,products,status) values(?,?,?,?,?) ");
            pst.setString(1, orderUsername);
            pst.setString(2, inputAddress);
            pst.setDouble(3, total);
            pst.setString(4, products);
            pst.setInt(5, 1);

            int rowCount=pst.executeUpdate();
            dispatcher=request.getRequestDispatcher("orderConfirmed.jsp");
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

}
