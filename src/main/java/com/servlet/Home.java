package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/homepage")
public class Home extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //I have used the doPost Method because the password is private data not to be shown in the URL

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        Boolean authenticationState = ValidateUser.validate(username, password);//My custom validation class




        if (authenticationState) {

            HttpSession hs = req.getSession();
            hs.setAttribute("user_key", req.getParameter("username"));
            hs.setAttribute("password", req.getParameter("password"));
            //  req.getSession().setAttribute("user_key",username); shorthand way for session making and setting up the attribute.

            resp.sendRedirect("Home.jsp");

        } else {
            resp.getWriter().println("<h1> Invalid Credentials! </h1>");
        }

    }


}
