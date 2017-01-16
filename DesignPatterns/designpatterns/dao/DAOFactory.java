package dao;

import java.sql.SQLException;

import dao.impl.JDBCProductDaoImpl;
import dao.impl.JPAProductDAOImpl;

public class DAOFactory {

	public static final int JDBC_DAO = 0;
	public static final int JPA_DAO = 1;
	
	private DAOFactory() {}
	
	public static ProductDao getProductDao(int daoType){
		switch(daoType){
			case JDBC_DAO: return getJDBCProductDao();
			case JPA_DAO: return getJPAProductDao();
			default: throw new IllegalArgumentException("Unsupported DAO request");
		}
	}
	
	private static ProductDao getJDBCProductDao(){
		JDBCProductDaoImpl dao = new JDBCProductDaoImpl();
		try{
			dao.setConnection(JDBCDatabaseManager.getConnection());
		}catch(SQLException sqlEx){
			throw new IllegalStateException("Not able to get connection to database.");
		}
		
		return dao;
	}
	
	private static ProductDao getJPAProductDao(){
		JPAProductDAOImpl dao = new JPAProductDAOImpl();
		dao.setEntityManager(JPAPersistenceManager.INSTANCE.getEntityManager());
		
		return dao;
	}
}
