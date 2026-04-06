package com.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class ServletDadaJi implements Servlet { //At the oldest time the Servlet interface was used to create servlet, but as the time passed
    //with the evolution the GenericServlet Class came into the picture and we left with in
//    overriding a method
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
} //We doesnot use this now.



