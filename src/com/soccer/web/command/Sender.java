package com.soccer.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {
	
	public  static void forward(HttpServletRequest request , HttpServletResponse response) {
		try {
			System.out.println(Receiver.cmd.view+"Receiver.cmd.view");
			request.getRequestDispatcher(Receiver.cmd.view).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void redirect(HttpServletRequest request , HttpServletResponse response) {
		try {
			request.getRequestDispatcher(Receiver.cmd.view).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
