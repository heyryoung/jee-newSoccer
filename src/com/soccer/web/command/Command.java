package com.soccer.web.command;

import javax.servlet.http.HttpServletRequest;
import com.soccer.web.pool.Constants;
import lombok.Data;

@Data
public class Command implements Order{

	protected  HttpServletRequest request; 
	protected String action, page, domain, view;
	
	@Override
	public void execute() {
		this.view = String.format(Constants.SINGLE_PATH, page);
	}
	
	public void execute(String a, String b) {
		this.view = String.format(Constants.DOUBLE_PATH, a,b);
	}

}
