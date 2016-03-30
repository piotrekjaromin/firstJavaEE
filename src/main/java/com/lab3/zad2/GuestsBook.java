package com.lab3.zad2;

import com.lab2.zad5.dto.Feedback;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;


@WebServlet(name = "/zad3_2", urlPatterns = {"/zad3_2"})
public class GuestsBook extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.sendRedirect("lab3/zad2/guestsBook.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("name");
        String mail = request.getParameter("mail");
        String comment = request.getParameter("comment");

        ServletContext servletContext = getServletContext();
        Vector  <Feedback> feedbacks = (Vector)servletContext.getAttribute("feetbacks");

        if(feedbacks==null){
            feedbacks = new Vector<>();
            feedbacks.add(new Feedback(login, mail, comment));
        } else {
            feedbacks.add(new Feedback(login, mail, comment));
        }

        servletContext.setAttribute("feetbacks", feedbacks);
        response.sendRedirect("lab3/zad2/guestsBook.jsp");
    }
}
