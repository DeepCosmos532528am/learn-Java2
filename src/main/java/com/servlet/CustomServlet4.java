package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/customservlet4") //Url mapping through the annotation
public class CustomServlet4 extends HttpServlet {
    //in the container, for any servlet the service method run and will decide which
// one to call get or post!!, depending on the request type we have given from the
// Client side, look in the cutomservlet4.html file.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String user = req.getParameter("username");
        String register = req.getParameter("register");

        if (register.equals("Login")) {
            out.println(user + "Login Successful");
        } else {
            out.println(user + "SignUp Successful");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String user = req.getParameter("username");
        String gender = req.getParameter("Gender");

        out.printf("Saving Data for %s : %s", user, gender);

    }
}
