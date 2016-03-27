package com.lab2.zad2.controller;

import com.lab2.zad2.Service.Result;
import com.lab2.zad2.model.RockPaperScissorsModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "/zad2_2", urlPatterns = {"/zad2_2"})
public class RockPaperScissors extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RockPaperScissorsModel rockPaperScissors = new RockPaperScissorsModel();
        PrintWriter out = response.getWriter();
        String user = request.getParameter("value");
        String computer = rockPaperScissors.generate();
        out.println(computer);
        out.println(Result.compare(user, computer));

        out.close();
    }

}
