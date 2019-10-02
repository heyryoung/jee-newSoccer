package com.soccer.web.command;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.serviceImpls.PlayerServiceImpl;


public class SearchCommand extends Command{

	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}


	@Override
	public void execute() {
		
		
		request.setAttribute("searchResult",PlayerServiceImpl.getInstance().findPositions());
		switch (request.getParameter("searchCode")) {
		case "2_positions": 	
			break;
		case "4_find_by_teamid_position": 	
			request.setAttribute("searchResult",PlayerServiceImpl.getInstance().findByTeamIdPosition(request));
		break;
		case "5_find_by_teamid_height_name": 	request.setAttribute("searchResult",PlayerServiceImpl.getInstance().findByTeamIdHeightName(request));
		break;
		}
		request.setAttribute("searchCode", request.getParameter("searchCode"));
		super.execute(getDomain(),getPage());
	}
	
	
}
