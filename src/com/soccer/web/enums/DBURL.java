package com.soccer.web.enums;

public enum DBURL {

	ORACLE_URL,
	MYSQL_URL,
	MARIADB_URL;
	
	public String toString() {
		String url ="";
		switch (this) {
		case ORACLE_URL:
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		case MYSQL_URL:
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		case MARIADB_URL:
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		}
		return url;
	}
}
