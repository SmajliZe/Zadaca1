package com.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Class.Products;
import com.DB.ProductsDataLoader;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductsDataLoader pdl;

    public ProductsServlet() {
        this.pdl=new ProductsDataLoader();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPerform(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPerform(request, response);
    }

    private void doPerform(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher=null;
        try {
            List<Products> productsList=pdl.getAllProducts();
            request.setAttribute("productsList", productsList);
            RequestDispatcher rd=request.getRequestDispatcher("guestIndex.jsp");
            rd.forward(request, response);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
