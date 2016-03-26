package com.lab2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebServlet(name = "/zad2_3", urlPatterns = {"/zad2_3"})
public class Zad3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int n1 = Integer.parseInt(request.getParameter("n1"));
        int n2 = Integer.parseInt(request.getParameter("n2"));
        int n3 = Integer.parseInt(request.getParameter("n3"));
        int n4 = Integer.parseInt(request.getParameter("n4"));
        int n5 = Integer.parseInt(request.getParameter("n5"));
        double result = (double)(n1+n2+n3+n4+n5)/5;
        out.println(result);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ArrayList<Double> values = new ArrayList<Double>();
        Enumeration enumeration = request.getParameterNames();
        String parameterName;
        try{
        while (enumeration.hasMoreElements()) {
            parameterName = (String) enumeration.nextElement();
            values.add(Double.parseDouble(request.getParameter(parameterName)));
        }
            Collections.sort(values);
            out.println(values);
        }catch (NumberFormatException exception){
            out.println("not a number");
        }


    }
}