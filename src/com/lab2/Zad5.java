package com.lab2;

import com.lab2.model.Feedback;
import com.lab2.model.PersonalData;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;


@WebServlet(name = "/zad2_5", urlPatterns = {"/zad2_5"})
public class Zad5 extends HttpServlet {

    List<PersonalData> personalDatas = new Vector<PersonalData>(Arrays.asList(
            new PersonalData("login1", "password1", "name1", "surname1"),
            new PersonalData("login2", "password2", "name2", "surname2"),
            new PersonalData("login3", "password3", "name3", "surname3"),
            new PersonalData("login4", "password4", "name4", "surname4")
    ));


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        if(login.isEmpty()) {
            response.sendRedirect("lab2.html");
        } else if(password.isEmpty()) {
            response.sendRedirect("lab2/lab2.html");
        } else if(!personalDatas.contains(new PersonalData(login, password, "", ""))){
           response.sendRedirect("lab2/lab2.html");
        } else
            response.sendRedirect("lab2/lab2_5.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("name");
        String mail = request.getParameter("mail");
        String comment = request.getParameter("comment");
        String sth = getServletConfig().getInitParameter("login");
        System.out.println(sth);
        ServletContext servletContext = getServletContext();
        Vector  <Feedback> feedbacks = (Vector)servletContext.getAttribute("feetbacks");

        if(feedbacks==null){
            feedbacks = new Vector<>();
            feedbacks.add(new Feedback(login, mail, comment));
        } else {
            feedbacks.add(new Feedback(login, mail, comment));
        }

        servletContext.setAttribute("feetbacks", feedbacks);
        PrintWriter out= response.getWriter();
        out.println(feedbacks);
        out.close();
    }
}
