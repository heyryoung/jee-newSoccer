package com.soccer.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.web.command.Receiver;
import com.soccer.web.command.Sender;
import com.soccer.web.pool.Constants;


@WebServlet("/facade.do")
public class FacadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	enum Resources{
		CTX, CSS, JS, IMG
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		for (Resources r : Resources.values()) {
			request.getSession().setAttribute(r.toString().toLowerCase(), request.getContextPath()+((r.toString().equalsIgnoreCase("ctx")) ?  
					""
					: "/RESOURCES/"+r.toString().toLowerCase())) ;
		}
		
		if(request.getParameter("page")==null) {
			request.getRequestDispatcher(
					String.format(Constants.DOUBLE_PATH, "facade", "facade"))
					.forward(request, response);
		}else {
			Receiver.init(request);
			Sender.forward(request, response);
		}
			
	}

}
