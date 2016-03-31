package com.lab3.zad3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "/zad3_3", urlPatterns = {"/zad3_3"})
public class GuessNumber extends HttpServlet {

    int randomNumber() {
        return new Random().nextInt(100);
    }

    int compare(int a, int b) {
        return ((Integer)a).compareTo(b);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));


        response.sendRedirect("lab3/zad2/guestsBook.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number;
        int randomNumber;
        int numberOfGuess;


        if(request.getParameter("randomNumber").equals(""))
            randomNumber = randomNumber();
        else
            randomNumber = Integer.parseInt(request.getParameter("randomNumber"));

        if(request.getParameter("numberOfGuess").equals(""))
            numberOfGuess=1;
        else
            numberOfGuess=Integer.parseInt(request.getParameter("numberOfGuess")) + 1;

        request.setAttribute("randomNumber", Integer.toString(randomNumber));
        request.setAttribute("numberOfGuess", Integer.toString(numberOfGuess));



        if(!request.getParameter("number").equals("")) {
            number = Integer.parseInt(request.getParameter("number"));

            if (compare(number, randomNumber) > 0)
                request.setAttribute("result", "twoja liczba (" + number + ") jest wieksza niz zagadka");
            else if (compare(number, randomNumber) < 0)
                request.setAttribute("result", "twoja liczba (" + number + ") jest mniejsza niz zagadka");
            else
                request.setAttribute("result", "Zgadles po " + numberOfGuess + "probach.");
        } else {
            request.setAttribute("result", "Podaj liczbe");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("lab3/zad3/guessNumber.jsp");
        dispatcher.forward(request, response);
        return;

    }
}