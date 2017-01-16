package dao.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.BaseDaoImpl;
import dao.DAOFactory;
import dao.ProductDao;
import dao.model.NutritionInfo;

public class JPAProductDaoImplTest extends BaseDaoImpl {

	@Test
	public void getNutrionInfoWithProductCode() throws SQLException {
		
		final ProductDao dao = DAOFactory.getProductDao(DAOFactory.JPA_DAO);
		
    	List<NutritionInfo> pnInfo = dao.getProductWithCode("CB1").
											getNutritionInfoList();
    	
    	System.out.println("nutrition info list size: " + pnInfo.size());
    	
    	assertThat("Product nutrition info list is not null.", pnInfo, notNullValue());
	}
}
