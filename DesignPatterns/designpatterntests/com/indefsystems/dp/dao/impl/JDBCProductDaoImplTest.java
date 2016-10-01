package com.indefsystems.dp.dao.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.indefsystems.dp.dao.BaseDaoImpl;
import com.indefsystems.dp.dao.DAOFactory;
import com.indefsystems.dp.dao.ProductDao;
import com.indefsystems.dp.dao.model.NutritionInfo;

public class JDBCProductDaoImplTest extends BaseDaoImpl {

	@Test
	public void getNutrionInfoWithProductCode() throws SQLException {
		
		final ProductDao dao = DAOFactory.getProductDao(DAOFactory.JDBC_DAO);
		
    	List<NutritionInfo> pnInfo = dao.getProductWithCode("CB1").
				getNutritionInfoList();

    	System.out.println("nutrition info list size: " + pnInfo.size());
    	assertThat("Product nutrition info list is not null.", pnInfo, notNullValue());
	}

}
