package dao;

import static dao.JDBCDatabaseManager.HSQLDB_JDBC_URL_IN_MEMORY;
import static dao.JDBCDatabaseManager.HSQLDB_PASSWORD;
import static dao.JDBCDatabaseManager.HSQLDB_USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCDatabaseManager {

    public static final String HSQLDB_JDBC_DRIVER_CLASS = "org.hsqldb.jdbc.JDBCDriver";
    public static final String HSQLDB_JDBC_URL_IN_MEMORY = "jdbc:hsqldb:mem:mymemdb";
    public static final String HSQLDB_USER = "SA";
    public static final String HSQLDB_PASSWORD = "";

	private JDBCDatabaseManager() {
	}
	
	private static class JDBCDatabaseSingletonHelper{
		private static final JDBCDatabaseManager INSTANCE = new JDBCDatabaseManager();
	}
	
	public static JDBCDatabaseManager getInstance(){
		return JDBCDatabaseSingletonHelper.INSTANCE;
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(HSQLDB_JDBC_URL_IN_MEMORY, HSQLDB_USER, HSQLDB_PASSWORD);
	}
}
