package com.lab2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "/zad2_1", urlPatterns = {"/zad2_1"})
public class Zad1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String imie = request.getParameter("imie");
        int wiek = Integer.parseInt(request.getParameter("wiek"));

        if(imie.charAt(imie.length()-1)=='a')
            out.println("kobieta");
        else
            out.println("facet");

        if(wiek>17)
            out.println("pelnoletni");
        else
            out.println("niepelnoletni");
        out.close();
    }

}
