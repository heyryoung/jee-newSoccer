package com.soccer.web.daoImpls;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.factory.DatabaseFactory;
import com.soccer.web.pool.Constants;
import com.soccer.web.daos.PlayerDao;

public class PlayerDaoImpl implements PlayerDao{
	
	private static PlayerDaoImpl instance = new PlayerDaoImpl();
	private  PlayerDaoImpl() {}
	public static PlayerDaoImpl getInstance() {return instance;}
	

	// 02 포지션 종류(중복제거,없으면 빈공간)
	@Override
	public List<String> selectPositions() {
		List<String> result = new ArrayList<String>(); 
		try {
			String sql = "SELECT DISTINCT (NVL(POSITION,'')) position\r\n" + 
						"FROM PLAYER WHERE POSITION IS NOT NULL";
			ResultSet rs = DatabaseFactory.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql)
					.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1)+"rs.getString(1)");
				result.add(rs.getString(1));
			}		
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	
	@Override
	public List<PlayerBean> selectByTeamIdPositions(PlayerBean param) {
		
		List<PlayerBean> result = new ArrayList<PlayerBean>(); 

		try {
				String sql  = "SELECT PLAYER_NAME , TEAM_ID , POSITION  FROM PLAYER WHERE TEAM_ID LIKE ?  AND POSITION LIKE ?";
				PreparedStatement stmt = DatabaseFactory.createDatabase(Constants.VENDOR).getConnection().prepareStatement(sql);
						stmt.setString(1, param.getTeamId());
						stmt.setString(2, param.getPosition());
						
				ResultSet rs = stmt.executeQuery();		
						
				while (rs.next()) {
					PlayerBean temp = new PlayerBean();
					temp.setPlayerName(rs.getString("PLAYER_NAME"));
					temp.setTeamId(rs.getString("TEAM_ID"));
					temp.setPosition(rs.getString("POSITION"));
					
					System.out.println(temp.toString()+"temp");
					
					result.add(temp);
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<PlayerBean> selectByTeamIdHeightName(PlayerBean param) {
		
		List<PlayerBean> result = new ArrayList<PlayerBean>(); 
		try {
				String sql = "SELECT PLAYER_NAME , TEAM_ID , POSITION, HEIGHT FROM PLAYER WHERE TEAM_ID LIKE '"+param.getTeamId()+"' AND HEIGHT >= '"+param.getHeight()+"'  AND PLAYER_NAME LIKE '"+param.getPlayerName()+"%'";
				ResultSet rs = DatabaseFactory.createDatabase(Constants.VENDOR)
						.getConnection()
						.prepareStatement(sql)
						.executeQuery();
				
				while (rs.next()) {
					PlayerBean temp = new PlayerBean();
					temp.setPlayerName(rs.getString(1));
					temp.setTeamId(rs.getString(2));
					temp.setPosition(rs.getString(3));
					temp.setHeight(rs.getString(4));
					
					System.out.println(temp.toString());
					result.add(temp);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public PlayerBean login(PlayerBean param) {
		
		PlayerBean result = new PlayerBean();
		
		try {
			String sql = "SELECT PLAYER_ID, PLAYER_NAME, TEAM_ID, E_PLAYER_NAME, NICKNAME, JOIN_YYYY, POSITION, BACK_NO, NATION, BIRTH_DATE, SOLAR, HEIGHT, WEIGHT FROM PLAYER WHERE PLAYER_ID LIKE '"+param.getPlayerId()+"' AND SOLAR LIKE '"+param.getSolar()+"' ";
			
			ResultSet rs =  DatabaseFactory.createDatabase(Constants.VENDOR).getConnection().prepareStatement(sql).executeQuery();
			
			while (rs.next()) {
				result.setPlayerId(rs.getString("PLAYER_ID"));
				result.setPlayerName(rs.getString("PLAYER_NAME"));
				result.setTeamId(rs.getString("TEAM_ID"));
				result.setPosition(rs.getString("POSITION"));
				result.setHeight(rs.getString("HEIGHT"));
				result.setWeight(rs.getString("WEIGHT"));
				result.setSolar(rs.getString("SOLAR"));
				System.out.println(result.toString());
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
		
	}
	@Override
	public List<PlayerBean> ss(PlayerBean param) {
		List<PlayerBean> pbList = new ArrayList<PlayerBean>();
		
		try {
			String sql ="select player_name from player where player_id like ?" ;
			PreparedStatement stmt = DatabaseFactory.createDatabase(Constants.VENDOR).getConnection().prepareStatement(sql);
			stmt.setString(1, "ddd");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PlayerBean temp = new PlayerBean();
				pbList.add( temp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return pbList;
	}
	
	public PlayerBean seletByPlayerIdSolar(PlayerBean param) {
		PlayerBean player = null;
		String sql = "SELECT * \n" + 
				"FROM PLAYER \n" + 
				"WHERE PLAYER_ID LIKE ? \n" + 
				"    AND SOLAR LIKE ?";
		try {
			PreparedStatement pstmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, param.getPlayerId().trim());
			pstmt.setString(2, param.getSolar().trim());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				player = new PlayerBean();
				player.setBackNo(rs.getString("BACK_NO"));
				player.setBirthDate(rs.getString("BIRTH_DATE"));
				player.setEPlayerName(rs.getString("E_PLAYER_NAME"));
				player.setHeight(rs.getString("HEIGHT"));
				player.setJoinYyyy(rs.getString("JOIN_YYYY"));
				player.setNation(rs.getString("NATION"));
				player.setNickname(rs.getString("NICKNAME"));
				player.setPlayerId(rs.getString("PLAYER_ID"));
				player.setPlayerName(rs.getString("PLAYER_NAME"));
				player.setPosition(rs.getString("POSITION"));
				player.setSolar(rs.getString("SOLAR"));
				player.setTeamId(rs.getString("TEAM_ID"));
				player.setWeight(rs.getString("WEIGHT"));
				System.out.println(player.toString()+"<<<seletByPlayerIdSolar");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}
	@Override
	public int insertPlayer(PlayerBean param) {
		int rs =0;
		String sql = "INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID, E_PLAYER_NAME, NICKNAME, JOIN_YYYY, POSITION, BACK_NO, NATION, BIRTH_DATE, SOLAR, HEIGHT,WEIGHT)\r\n" + 
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, param.getPlayerId());
			pstmt.setString(2, param.getPlayerName());
			pstmt.setString(3, param.getTeamId());
			pstmt.setString(4, param.getEPlayerName());
			pstmt.setString(5, param.getNickname());
			pstmt.setString(6, param.getJoinYyyy());
			pstmt.setString(7, param.getPosition());
			pstmt.setString(8, param.getBackNo());
			pstmt.setString(9, param.getNation());
			pstmt.setString(10, param.getBirthDate());
			pstmt.setString(11, param.getSolar());
			pstmt.setString(12, param.getHeight());
			pstmt.setString(13, param.getWeight());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
