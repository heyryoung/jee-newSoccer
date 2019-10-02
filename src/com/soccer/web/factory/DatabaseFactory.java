package com.soccer.web.factory;

import com.soccer.web.enums.DB;

public class DatabaseFactory {
	public static Database createDatabase(String vendor){
		Database db = null;
		switch (DB.valueOf(vendor.toUpperCase())) {
		case ORACLE: db = new Oracle(); 
			break;
		case MARIADB:  db = new Mariadb(); 
			break;
		case H2:
			break;
		case DB2:
			break;
		}
		return db;
	}

}
