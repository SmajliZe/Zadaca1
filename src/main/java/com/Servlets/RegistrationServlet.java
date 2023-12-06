package com.Servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;



@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String inputUsername=request.getParameter("username");
        String inputPassword=request.getParameter("password");
        String inputAddress=request.getParameter("address");
        RequestDispatcher dispatcher=null;

        PrintWriter out=response.getWriter();
        out.println(inputUsername);
        out.println(inputPassword);
        out.println(inputAddress);
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/zadaca?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "root");
            PreparedStatement pst=con.prepareStatement("insert into users(username, address, password, role) values(?, ?, ?, ?)");
            pst.setString(1, inputUsername);
            pst.setString(2, inputAddress);
            pst.setString(3, inputPassword);
            pst.setInt(4, 2);

            int rowCount=pst.executeUpdate();
            dispatcher=request.getRequestDispatcher("login.jsp");
            if (rowCount>0){
                request.setAttribute("status", "success");
            }else{
                request.setAttribute("status", "failed");
            }
            dispatcher.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


}