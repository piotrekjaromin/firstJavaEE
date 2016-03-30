package com.lab3.zad4.controller;

import com.lab3.zad4.dto.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "/zad3_4", urlPatterns = {"/zad3_4"})
public class Shop extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("lab3/zad4/showCart.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String quantity = request.getParameter("quantity");
        if(quantity.equals("")) quantity="1";

        Product product = new Product(id, Integer.parseInt(quantity));

        Map<Integer, Integer> cart;
        cart = (Map<Integer, Integer>) request.getSession().getAttribute("cart");

        if(cart == null) {
            cart = new TreeMap<>();
            cart.put(product.getId(), product.getQuantity());
        } else {
            if(cart.containsKey(id)){
                int currentQuantity = cart.get(id);
                cart.put(product.getId(), currentQuantity + product.getQuantity());
            } else {
                cart.put(product.getId(), product.getQuantity());
            }
        }

        request.getSession().setAttribute("cart", cart);

        response.sendRedirect("lab3/zad4/mainPage.jsp");
    }
}