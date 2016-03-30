package com.lab3.zad2;

import com.lab2.zad5.dto.Feedback;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Vector;


@WebServlet(name = "/zad3_2_read", urlPatterns = {"/zad3_2_read"})
public class ReadMessagesFromFile extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        FileInputStream fstream = new FileInputStream("messages");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        Vector<Feedback> feedbacks = new Vector<>();

        while ((strLine = br.readLine()) != null){
            feedbacks.add(new Feedback(strLine.split(";")[0], strLine.split(";")[1], strLine.split(";")[2]));
        }
        br.close();

        getServletContext().setAttribute("feetbacksFromFile", feedbacks);
        response.sendRedirect("lab3/zad2/showMessagesFromFile.jsp");
    }

}
