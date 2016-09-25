package com.indefsystems.dp.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;

import com.indefsystems.dp.dao.BaseDaoImpl;

public class JDBCProductDaoImplTest extends BaseDaoImpl {

	private static final String HSQLDB_JDBC_DRIVER_CLASS = "org.hsqldb.jdbc.JDBCDriver";
	private static final String HSQLDB_JDBC_URL_IN_MEMORY = "jdbc:hsqldb:mem:mymemdb";
	private static final String HSQLDB_USER = "SA";
	private static final String HSQLDB_PASSWORD = "";
	
	@BeforeClass
	public static void init() throws ClassNotFoundException{
		Class.forName(HSQLDB_JDBC_DRIVER_CLASS);
	}
	
	private static void initDatabase() throws SQLException, IOException{
		try(
				Connection connection = getConnection();
				Statement statement = connection.createStatement();
		){
			for(String sql : getSqlInitStatements().split(STATEMENT_SEPARATOR)){
				if(sql.length() > 0){
					try{
						statement.execute(sql);
					}catch(Exception ex){
						System.out.println("Failed to execute sql statement: " + sql);
						throw ex;
					}
				}
			}
		}
		
	}
	
	private static String getSqlInitStatements() throws IOException{
		try(
				final InputStream is = BaseDaoImpl.class.getResourceAsStream(INIT_DB_FILE_NAME);
		){
			final byte[] buf = new byte[4096];
			String retval = "";
			
			while(is.read(buf) > 0){
				retval += new String(buf);
			}
			
			return retval.trim();
		}
	}
	
	private static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(HSQLDB_JDBC_URL_IN_MEMORY, HSQLDB_USER, HSQLDB_PASSWORD);
	}
}
