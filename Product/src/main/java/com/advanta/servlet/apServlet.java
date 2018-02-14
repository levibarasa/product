/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanta.servlet;

/**
 *
 * @author Levi
 */  
import com.atvanta.web.product.ProductWeb; 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class apServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog("origlogger");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mod = request.getParameter("MOD");
        String act = request.getParameter("ACT");
        switch (mod) {
            case "BOK":
                switch (act) {
                    // client info
                    case "doLog":
                        ProductWeb.handleLogin(request, response);
                        break;
                    case "Logout":
                        ProductWeb.handleLogout(request, response);
                        break; 
                   case "doRegister":
                        ProductWeb.handleRegister(request, response);
                        break;
                    case "doAddProduct":
                        ProductWeb.handleaddProduct(request, response);
                        break;
                   case "doEdiProduct":
                        ProductWeb.handleeditProduct(request, response);
                        break;
                   }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
