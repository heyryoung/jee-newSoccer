package com.soccer.web.command;

import javax.servlet.http.HttpServletRequest;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceImpls.PlayerServiceImpl;

public class JoinCommand extends Command{
	
	public JoinCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		int userCnt = PlayerServiceImpl.getInstance().join(request);

		setDomain("facade"); 
		request.setAttribute("page", (userCnt ==1) ? "facade" : "fail" );
		super.execute(getDomain(),getPage());
	}
	
}
