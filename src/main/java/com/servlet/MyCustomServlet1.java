package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/href-customServlet1")
public class MyCustomServlet1 extends HttpServlet {
//dekho, kisi bhi servlet me lifecyle methods like init(), service(), destroy() are called mandatorily without any decision, as they are the significant part of a Servlet, run right after the class loading and instantiation
//now see if the servlet object is already there in the memory then the init() would be skipped, now sevice() is the method which is called on each request, as it decides whether to call doGet() or doPost() in the servlet.

//don't get confused, just by url mapping how this overridden service() method is called,
//but when we want to execute any doGet or doPost we specifically in the jsp or HTML need to mention there or in someway we have to send the type of request like Get or Post, on the basis of which the doGet or doPost methods are called,
//now see below the service method is overridden so due to dynamic dispatch(runtime polymorphism), this overridden version od service be called, and it does not also call the parent version of service, so no decision of whether to call doGet() or doPost()
//isliye dekho hamne likhe bhi nahi h, ab kya hoga servlet jese hi load hoga memory me instance banega turant hi service toh call hona hi h wo toh default behaviour h servlet lifecycle ka iske bina toh kabhi bhi servlet nahi chalega,
//dekho init() (if object of servlet is not already there in the memory then only), service() (each time the request comes), destroy(only on the servlet destroy, in the condition of server shutdown or any other heavy reason)
//ye 3 methods toh run karne hi h kucch karo na karo aur usme bhi service() ko toh har baar karna h on any request ab chahe uski power to identify the request type ko chheen lo ya rehne do (super.service(req, resp))

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp); //Default version invocation, no as here it is commented out, now we cannot work with doGet() or doPost() because,
//        default parent version of service(req, resp) method is responsible for the deciding which method to call out of doGet or doPost based on client request

        System.out.println("This is the MyCustomServlet1 called"); //jese hi url me /customServlet aaya, service() chal jayega

    }
}

//Ek kaam karo, MyCustomServlet2 ko explore karo thoda sa service ka default na run karane se ktya hoga demo dekho practical
