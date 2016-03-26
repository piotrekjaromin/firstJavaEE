package com.lab2;

import com.lab2.car.CarChoiceHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "/zad2_4", urlPatterns = {"/zad2_4"})
public class Zad4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        CarChoiceHelper carChoiceHelper = new CarChoiceHelper();

        String typeOfCar = request.getParameter("typeOfCar");
        Double priceFrom = Double.parseDouble(request.getParameter("priceFrom"));
        Double priceTo = Double.parseDouble(request.getParameter("priceTo"));
        out.println(typeOfCar);
        out.println(priceFrom + " - " + priceTo);
        out.println(carChoiceHelper.getCars(typeOfCar, priceFrom, priceTo));
        out.close();
    }
}
