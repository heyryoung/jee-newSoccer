package com.soccer.web.command;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceImpls.PlayerServiceImpl;

public class LoginCommand extends Command{
	
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
        PlayerBean user = PlayerServiceImpl.getInstance().login(request);
        if(user==null) {
        request.setAttribute("page", "facade");
        }else {
    	setDomain("player");
        }
       	request.getSession().setAttribute("user", (user ==null) ? "" : user);
        super.execute(getDomain(),getPage());
}
	
}
