package com.kh.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orderProduct.do")
public class OrderServlet extends HttpServlet {

   
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
		String name = req.getParameter("name");
		String blackPen = req.getParameter("blackPen");
		String redPen = req.getParameter("redPen");
		String bluePen = req.getParameter("bluePen");
		String white = req.getParameter("white");
	
		
	
		int blackPenAmount = Integer.parseInt(req.getParameter("blackPenAmount"));
		int redPenAmount = Integer.parseInt(req.getParameter("redPenAmount"));
		int bluePenAmount = Integer.parseInt(req.getParameter("bluePenAmount"));
		int whiteAmount = Integer.parseInt(req.getParameter("whiteAmount"));
		
		 int total = ((blackPenAmount*500) + (redPenAmount*700) + (bluePenAmount*700) + (whiteAmount*1000));
       
		int blackPenPrice = (blackPenAmount*500);
		int redPenPrice = (redPenAmount*700);
		int bluePenPrice = (bluePenAmount*700);
		int whitePrice = (whiteAmount*1000);
		
	
        
        if (total != 0) {
        	req.setAttribute("name", name);
        	req.setAttribute("blackPen", blackPen);
        	req.setAttribute("redPen", redPen);
        	req.setAttribute("bluePen", bluePen);
        	req.setAttribute("whitePen", white);
        	req.setAttribute("total", total);
        	req.setAttribute("blackPenAmount", blackPenAmount);
        	req.setAttribute("redPenAmount", redPenAmount);
        	req.setAttribute("bluePenAmount", bluePenAmount);
        	req.setAttribute("whiteAmount", whiteAmount);
        	req.setAttribute("blackPenPrice", blackPenPrice);
        	req.setAttribute("redPenPrice", redPenPrice);
        	req.setAttribute("bluePenPrice", bluePenPrice);
        	req.setAttribute("whitePrice", whitePrice);

        	
        	RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/resultPage.jsp");
        	
        	dispatcher.forward(req, resp);
        	
        } else {
        	req.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(req, resp);;
        	
        }
    }

}
