package com.lab3.zad5.controller;

import com.lab3.zad1.dto.User;
import com.lab3.zad5.dto.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotrek on 17.03.16.
 */
@WebServlet(name = "/zad3_5", urlPatterns = {"/zad3_5"})
public class MoviesController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("movies", Movie.getMovies());
        RequestDispatcher dispatcher = request.getRequestDispatcher("lab3/zad5/strona.jsp");
        dispatcher.forward(request, response);
        return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
