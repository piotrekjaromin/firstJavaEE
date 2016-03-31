package com.lab3.zad2;

import com.lab2.zad5.dto.Feedback;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

@WebServlet(name = "/zad3_2_edit", urlPatterns = {"/zad3_2_edit"})
public class EditMessage extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));
        Set<Integer> editMessages = (Set<Integer>)getServletContext().getAttribute("editMessages");

        if(editMessages == null){
            editMessages = new LinkedHashSet<>();
            editMessages.add(number);
            getServletContext().setAttribute("editMessages", editMessages);
            request.setAttribute("messageNumber", Integer.toString(number));
            RequestDispatcher dispatcher = request.getRequestDispatcher("lab3/zad2/editMessage.jsp");
            dispatcher.forward(request, response);
            return;
        } else {
            if(editMessages.contains(number)){
                response.sendRedirect("lab3/zad2/showMessagesFromFile.jsp");
                return;
            } else {
                editMessages.add(number);
                getServletContext().setAttribute("editMessages", editMessages);
                request.setAttribute("messageNumber", Integer.toString(number));
                RequestDispatcher dispatcher = request.getRequestDispatcher("lab3/zad2/editMessage.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));
        String newMessage = request.getParameter("editedMessage");
        PrintWriter out = response.getWriter();

        Set<Integer> editMessages = (LinkedHashSet<Integer>) getServletContext().getAttribute("editMessages");
        editMessages.remove(number);
        getServletContext().setAttribute("editMessages", editMessages);

        Vector<Feedback> feedbacks = (Vector<Feedback>)getServletContext().getAttribute("feedbacksFromFile");
        Feedback editedFeedback = feedbacks.get(number);
        editedFeedback.setComment(newMessage);
        feedbacks.remove(number);
        feedbacks.add(number, editedFeedback);
        getServletContext().setAttribute("feedbacksFromFile", feedbacks);

        PrintWriter writer = new PrintWriter("messages", "UTF-8");
        for(Feedback feedback : feedbacks){
            writer.println(feedback.getName() + ";" + feedback.getMail() + ";" + feedback.getComment());
        }
        writer.close();

        out.print("success");
    }
}