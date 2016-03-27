package com.lab2.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "/adultWoman", urlPatterns = {"/zad2_1"})
public class AdultWoman extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String imie = request.getParameter("name");
        int wiek = Integer.parseInt(request.getParameter("age"));

        if(imie.charAt(imie.length()-1)=='a')
            out.println("woman");
        else
            out.println("man");

        if(wiek>17)
            out.println("adult");
        else
            out.println("underage");
        out.close();
    }

}
