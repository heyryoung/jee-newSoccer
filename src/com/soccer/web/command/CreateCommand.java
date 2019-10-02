package com.soccer.web.command;

import javax.servlet.http.HttpServletRequest;

public class CreateCommand extends Command{

	public CreateCommand(HttpServletRequest request) {
			setRequest(request);
			setAction(request.getParameter("action"));
			setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
			setPage(request.getParameter("page"));
	        execute(getDomain(),getPage());
	}
	
	@Override
	public void execute() {
        super.execute(getDomain(),getPage());
	}
	
}
