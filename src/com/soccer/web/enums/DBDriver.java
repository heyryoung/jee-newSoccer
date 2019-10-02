package com.soccer.web.enums;

public enum DBDriver {
	ORACLE_DRIVER,
	MYSQL_DRIVER,
	MARIADB_DRIVER;
	
	public String toString() {
		String driver ="";
		switch (this) {
		case ORACLE_DRIVER:
			driver = "oracle.jdbc.OracleDriver";
			break;
		case MYSQL_DRIVER:
			driver = "oracle.jdbc.OracleDriver";
			break;
		case MARIADB_DRIVER:
			driver = "oracle.jdbc.OracleDriver";
			break;
		}
		return driver;
	}
	
}
