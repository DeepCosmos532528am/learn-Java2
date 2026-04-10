package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginstatus")
public class LoginStatus extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String interest = req.getParameter("interest");



        if(username.equals("Sachin Sharma")){

             //resp.sendRedirect("loginStatusSuccess.jsp"); //jese abhi dekho yaha pe kisi page ne iss servlet pe redirect karwaya using the url mapping, matlab ek request aayi iss servlet ke paas, aur ab ye servlet browser ko pehle resp me ek page ka address bhejta h, firr browser usse new request banata h with exposing the fileName in the url, can be used for redirecting to either the file of the same project(another servlet or jsp or HTML or other file of the same this same project) or any other project like Google.com but generally used for redirecting to the other platform , like Google, Facebook, Instagram etc.
             // The new url formed by this  http://localhost:8080/myprojectname/loginStatusSuccess.html

            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("gender", gender);
            req.setAttribute("interest", interest); //Just to use them on JSP

         /* Agar response me kucch aur bhi bhejna ho jese ki hum loginStatusSuccess.jsp toh hum requestDispatcher aur forward() se bhej hi rahe h, ab saath hi saath out.println(...) html bhejna h ya kucch print karan h UI pe browser ke web page pe toh
         we woul dhave to use

         RequestDispatcher rd = req.getRequestDispatcher("/loginStatusSuccess.jsp");
            rd.include(req,resp); // Now the issue is the .include()  will return not the UI but the source code of the UI, the HTML code,
            to solve this we will have to specify the response type manually
              resp.setContentType("text/html");


           String mname = (String) req.getAttribute("username");
            PrintWriter out = resp.getWriter();
            out.println("Hello" + mname);

              resp.setContentType("text/html");

              RequestDispatcher rd = req.getRequestDispatcher("/loginStatusSuccess.jsp");
              rd.include(req,resp);

           */

            String mname = (String) req.getAttribute("username");
            PrintWriter out = resp.getWriter();
            out.println("Hello" + mname);

            resp.setContentType("text/html");

            RequestDispatcher rd = req.getRequestDispatcher("/loginStatusSuccess.jsp");
            rd.include(req,resp);



//            RequestDispatcher rd = req.getRequestDispatcher("/loginStatusSuccess.jsp");
//            rd.forward(req,resp); // One more diffrence from req.sendRedirect(), That the RequestDispatcher can also carry the request data to other file as here on /loginStatusSuccess.jsp
                                  //But sendRedirect does not carry any data of its previous requests. Data like (Parameter, requestType etc would be lost)

                                  // Samjho jese abhi yaha ek request aa rahi h Loginform se aur hamne usse req.getParameter se retrieve bhi kar liya h, firr hamne condition ke base pe RequestDispatcher ki madad se iss servlet ke request ka data targeted jsp ko bhi transfer kar diya
                                  // aur ab chahe toh wo jsp request.getParamter se value retirve bhi kar sakti h java likh ke scriptlet tag me <%...%>, <%=...%>
                                  //kyuki dikh hi raha h forward(req, resp) ki madad se same request and response obj ko pass kar diya jaa raha h jo iss servlet ko mila, h iss liye kehte h ki Request Dispatcher, previous request obj ki values ko yaad rakhta h.

                                  //But dekho resp.sendRedirect() jesa ki pata h ki fresh new request banti h, matlab new req and resp obj catalina banata h, toh previous request ka data lost, toh firr ab hum jsp me nahi kar sakte retrieve data ko
        }else{

                                  //resp.sendRedirect("loginStatusFailed.html");
                                  // The new url formed by this  http://localhost:8080/myprojectname/loginStatusFailed.html


            RequestDispatcher rd =  req.getRequestDispatcher("/loginStatusFailed.html");
            rd.forward(req,resp); //it redirects internally and does not create new request, hence obviously no new url would be created in the search bar of the browser

        }
                                    //URL change hone ka matlab hota hai ki ek naya HTTP request client (browser) se server ko gaya hai.
                                    // sendRedirect(): Server client ko bolta hai ki dusre URL par jao. Browser ek fresh request banata hai, isliye URL bar me naya address dikhta hai.
                                    // forward(): Request server ke andar hi forward hota hai, browser ko pata bhi nahi chalta. Isliye URL change nahi hota aur request same hi rehta hai.


     }
}
