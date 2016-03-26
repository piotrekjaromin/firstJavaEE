package com.lab2;

import com.lab2.model.PapKamNoz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "/zad2_2", urlPatterns = {"/zad2_2"})
public class Zad2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PapKamNoz papKamNoz = new PapKamNoz();
        PrintWriter out = response.getWriter();
        String user = request.getParameter("value");
        String computer = papKamNoz.generate();
        out.println(computer);
        out.println(papKamNoz.compare(user, computer));

        out.close();
    }

}
