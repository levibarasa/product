/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atvanta.web.product;

import com.advant.user.*;
import com.advanta.security.Encode;
import java.io.IOException; 
import com.adavanta.dao.product.*;
import com.advant.user.*;
import com.atvanta.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
/**
 *
 * @author Levi
 */
public class ProductWeb {
     private static Logger logger = Logger.getLogger(ProductWeb.class);
    public static void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String username = request.getParameter("username");
        String password = request.getParameter("Password");
        String conPage=null;  
        Access access = new Access();
        if (!username.equalsIgnoreCase("") || !username.equalsIgnoreCase(null) && !password.equalsIgnoreCase("") || !password.equalsIgnoreCase(null))
        {
            boolean loggedin = access.handleLogin(username,Encode.EncodeUserPassword(username,password));
           if(loggedin){
            session.setAttribute("username", username);
            session.setAttribute("conPage", "index.jsp");
            response.sendRedirect("index.jsp");
            System.out.println("conPage => " + conPage);
           }
           else{
           session.setAttribute("userdnexists", true);
            response.sendRedirect("login.jsp");
           }
        } else {
            session.setAttribute("userdnexists", true);
            response.sendRedirect("login.jsp");
        }
    }

    public static void handleLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Access access = new Access();
        if (session.getAttribute("uname") != null) {
            access.logoutUser((String) session.getAttribute("uname"));
            //session.setAttribute("content_page", "login.jsp");
            response.sendRedirect("login.jsp");
            session.invalidate();
        } else {
            //session.setAttribute("content_page", "sessionexp.jsp");
            response.sendRedirect("login.jsp");
        }
    }
     public static void handleRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); 
        Access access = new Access();
        UserModel um = new UserModel();
        if (session.getAttribute("uname") != null) {
              String fullname = request.getParameter("fullname");
              String username = request.getParameter("username");
              String Password = request.getParameter("Password");
              String confirm_password = request.getParameter("confirm_password"); 
              System.out.println(fullname+" "+username);
               if(Password.equalsIgnoreCase(confirm_password)){
                   
                   um.setFullname(fullname);
                   um.setPassword(Password);
                   um.setUsername(username);
              access.createUser(um);
            response.sendRedirect("login.jsp");
            session.invalidate();
               }
        } else {
            //session.setAttribute("content_page", "sessionexp.jsp");
            response.sendRedirect("login.jsp");
        }
    }
      public static void handleaddProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Access access = new Access();
        if (session.getAttribute("uname") != null) {
            access.logoutUser((String) session.getAttribute("uname"));
            //session.setAttribute("content_page", "login.jsp");
            response.sendRedirect("login.jsp");
            session.invalidate();
        } else {
            //session.setAttribute("content_page", "sessionexp.jsp");
            response.sendRedirect("login.jsp");
        }
    }
       public static void handleeditProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Access access = new Access();
        if (session.getAttribute("uname") != null) {
            access.logoutUser((String) session.getAttribute("uname"));
            //session.setAttribute("content_page", "login.jsp");
            response.sendRedirect("login.jsp");
            session.invalidate();
        } else {
            //session.setAttribute("content_page", "sessionexp.jsp");
            response.sendRedirect("login.jsp");
        }
    }
      
}
