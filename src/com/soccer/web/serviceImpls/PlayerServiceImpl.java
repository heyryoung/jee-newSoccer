package com.soccer.web.serviceImpls;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.daoImpls.PlayerDaoImpl;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.services.PlayerService;

public class PlayerServiceImpl implements PlayerService{
	private static PlayerServiceImpl instance = new PlayerServiceImpl();
	private PlayerServiceImpl () {}
	public static PlayerServiceImpl getInstance() {return instance;}
	
	@Override
	public PlayerBean login(HttpServletRequest request) {
		PlayerBean param = new PlayerBean();
		param.setPlayerId(request.getParameter("playerId"));
		param.setSolar(request.getParameter("solar"));
		return PlayerDaoImpl.getInstance().seletByPlayerIdSolar(param);
	}

	@Override
	public List<String> findPositions() {
		return PlayerDaoImpl.getInstance().selectPositions();
	}

	@Override
	public List<PlayerBean> findByTeamIdPosition(HttpServletRequest request) {
		PlayerBean param = new PlayerBean();
		param.setTeamId(request.getParameter("teamId"));
		param.setPosition(request.getParameter("position"));
		
		return PlayerDaoImpl.getInstance().selectByTeamIdPositions(param);
	}

	@Override
	public List<PlayerBean> findByTeamIdHeightName(HttpServletRequest request) {
		PlayerBean param = new PlayerBean();
		param.setTeamId(request.getParameter("teamId"));
		param.setHeight(request.getParameter("height"));
		param.setPlayerName(request.getParameter("lastname"));
		return PlayerDaoImpl.getInstance().selectByTeamIdHeightName(param);
	}
	@Override
	public int join(HttpServletRequest request) {
		PlayerBean param = new PlayerBean();
		param.setPlayerId(request.getParameter("playerId"));
		param.setPlayerName(request.getParameter("playerName"));
		param.setTeamId(request.getParameter("teamId"));
		param.setEPlayerName(request.getParameter("ePlayerName"));
		param.setNickname(request.getParameter("nickname"));
		param.setJoinYyyy(request.getParameter("joinYyyy"));
		param.setPosition(request.getParameter("position"));
		param.setBackNo(request.getParameter("backNo"));
		param.setNation(request.getParameter("nation"));
		param.setBirthDate(request.getParameter("birthDate"));
		param.setSolar(request.getParameter("solar"));
		param.setHeight(request.getParameter("height"));
		param.setWeight(request.getParameter("weight"));
		
		System.out.println(param.toString()+"<<<<param");
		return PlayerDaoImpl.getInstance().insertPlayer(param);
	}




}
