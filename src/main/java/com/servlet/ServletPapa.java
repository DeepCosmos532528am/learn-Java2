package com.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class ServletPapa extends GenericServlet {


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    } //It's the concrete method, that we have overridden here.
}//This too not used today, but HttpServlet is now used, which internally implements all these powers of the "Servlet Interface" and the "GenericServlet Class"
//look at the "MyServlet" we have created, it's the modern way. No need to override anything.
