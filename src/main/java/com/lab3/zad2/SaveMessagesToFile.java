package com.lab3.zad2;

import com.lab2.zad5.dto.Feedback;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;


@WebServlet(name = "/zad3_2_save", urlPatterns = {"/zad3_2_save"})
public class SaveMessagesToFile extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ServletContext servletContext = getServletContext();
        Vector  <Feedback> feedbacks = (Vector)servletContext.getAttribute("feedbacks");

        if(feedbacks!=null){
            PrintWriter writer = new PrintWriter("messages", "UTF-8");
            for(Feedback feedback : feedbacks){
                writer.println(feedback.getName() + ";" + feedback.getMail() + ";" + feedback.getComment());
            }
            writer.close();
            out.print("success");
        } else {
            out.print("No messages");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ServletContext servletContext = getServletContext();
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String comment = request.getParameter("comment");

        if(!name.equals("") && !mail.equals("") && !comment.equals("")){
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("messages", true)));
            writer.println(name + ";" + mail + ";" + comment);
            writer.close();
            out.print("success");
        } else {
            out.print("Error: one or more fields are empty");
        }
    }

}
