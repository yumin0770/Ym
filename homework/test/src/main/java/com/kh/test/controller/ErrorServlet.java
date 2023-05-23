package com.kh.test.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest reqs, HttpServletResponse rsp) throws ServletException, IOException {
        
    	reqs.getRequestDispatcher("errorPage.jsp").forward(reqs, rsp);
    }
}
