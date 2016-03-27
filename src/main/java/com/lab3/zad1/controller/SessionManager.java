package com.lab3.zad1.controller;

import com.lab3.zad1.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotrek on 17.03.16.
 */
@WebServlet(name = "/zad3_1", urlPatterns = {"/zad3_1"})
public class SessionManager extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User(login, password);

        List<User> users = (List<User>) getServletContext().getAttribute("users");

        if(users==null){
            users = new ArrayList<User>();
            users.add(user);
            getServletContext().setAttribute("users", users);
        } else {
            users.add(user);
            getServletContext().setAttribute("users", users);
        }
        session.setAttribute("user", new User(login, password));
        response.sendRedirect("lab3/zad1/sessionManager.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        User currentUser = (User) session.getAttribute("user");
        session.setAttribute("user", null);
//        List<User> users = (List<User>) getServletContext().getAttribute("users");
//        users.remove(currentUser);
//        getServletContext().setAttribute("users", users);
        response.sendRedirect("lab3/zad1/sessionManager.jsp");
    }
}
