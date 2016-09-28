package com.indefsystems.dp.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;

import static com.indefsystems.dp.dao.JDBCDatabaseManager.HSQLDB_JDBC_DRIVER_CLASS;
import static com.indefsystems.dp.dao.JDBCDatabaseManager.HSQLDB_JDBC_URL_IN_MEMORY;
import static com.indefsystems.dp.dao.JDBCDatabaseManager.HSQLDB_PASSWORD;
import static com.indefsystems.dp.dao.JDBCDatabaseManager.HSQLDB_USER;
/**
 * Used here just to load data in "in-memory" HSQLDB
 * 
 * @author RAsthana
 *
 */
public class BaseDaoImpl {

	/** Statement separator to get around HSQLDB's semicolon statement delimiter in procedures. */
    private static final String STATEMENT_SEPARATOR = ";;";

    /** Name of file containing SQL statements to initialise the database. */
    private static final String INIT_DB_FILE_NAME = "daoTest.sql";
        
	@BeforeClass
	public static void init() throws ClassNotFoundException, SQLException, IOException{
		Class.forName(HSQLDB_JDBC_DRIVER_CLASS);
		
		initDatabase();
	}

	private static void initDatabase() throws SQLException, IOException{
		try(
				Connection connection = JDBCDatabaseManager.getConnection();
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
    
}
