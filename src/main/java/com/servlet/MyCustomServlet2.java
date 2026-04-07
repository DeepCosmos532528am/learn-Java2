package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/href-customServlet2")
public class MyCustomServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter ou = resp.getWriter();
        ou.append("<h1>Aa gya</h1>")
                .append("<h2>Hey</h2>");
        System.out.println("This is the MyCustomServlet2 called");
//        super.service(req, resp);
    }

    //Try commenting out the doGet(), doPost() and keep commented out the above super.service(req, resp), you would find doGet() or doPost() can only be invoked if the service parent version could run and perform it's by default version.
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter ou = resp.getWriter();
//        ou.append("<h1>Ye h MyCustom2 servlet ka Get Method</h1>")
//                .append("<h2>Hey</h2>");
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter ou = resp.getWriter();
//        ou.append("<h1>Ye h MyCustom2 servlet ka Post Method</h1>")
//                .append("<h2>Hey</h2>");
//    }
}
