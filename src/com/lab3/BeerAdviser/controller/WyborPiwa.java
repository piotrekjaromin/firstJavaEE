package com.lab3.BeerAdviser.controller;

import com.lab3.BeerAdviser.model.EkspertPiwny;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by piotrek on 17.03.16.
 */
@WebServlet(name = "Servlet_wybierzpiwo", urlPatterns = "/WybierzPiwo.do")
public class WyborPiwa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String c = request.getParameter("kolor");
        List marki = new EkspertPiwny(c).getMarki();
        out.println("Porada piwna<br/>");
        out.println("<br/>Wybor kolor piwa: "+c);
        out.println(new EkspertPiwny(c).getMarki());
        request.setAttribute("marki", marki);
        RequestDispatcher view = request.getRequestDispatcher("lab3/BeerAdviser/wyniki.jsp");
        view.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("lab3/BeerAdviser/form.html");
    }
}
