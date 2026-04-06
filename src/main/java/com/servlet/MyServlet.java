package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Success!</h1>");
        out.println("<p>MyServlet is running via web.xml mapping.</p>");
             }

    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("usernm");
        String pass = req.getParameter("passwd");



        resp.setContentType("text/html");
        PrintWriter ou = resp.getWriter();
        ou.append("<h1>Aa gya</h1>" + user + pass)
        .append("<h2>Hey</h2>");



    }

}

