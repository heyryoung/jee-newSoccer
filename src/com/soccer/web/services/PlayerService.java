package com.soccer.web.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;

public interface PlayerService {
	
	public PlayerBean login(HttpServletRequest request);
	// 02 포지션 종류(중복제거,없으면 빈공간)
	public List<String> findPositions();	
	public List<PlayerBean> findByTeamIdPosition(HttpServletRequest request);
	public List<PlayerBean> findByTeamIdHeightName(HttpServletRequest request);

	public int join(HttpServletRequest request);
}
