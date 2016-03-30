package com.lab3.zad4.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "/zad3_4_remove", urlPatterns = {"/zad3_4_remove"})
public class RemoveFromCart extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("lab3/zad4/showCart.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Map<Integer, Integer> cart;
        cart = (Map<Integer, Integer>) request.getSession().getAttribute("cart");

        if (cart.containsKey(id)) {
            cart.remove(id);
        } else {
            response.sendRedirect("lab3/zad4/mainPage.jsp");
            return;
        }

        request.getSession().setAttribute("cart", cart);

        response.sendRedirect("lab3/zad4/showCart.jsp");
    }
}
