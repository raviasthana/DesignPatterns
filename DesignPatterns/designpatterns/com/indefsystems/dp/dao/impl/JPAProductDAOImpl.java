package com.indefsystems.dp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.indefsystems.dp.dao.PersistenceManager;
import com.indefsystems.dp.dao.ProductDao;
import com.indefsystems.dp.dao.model.Product;

public class JPAProductDAOImpl implements ProductDao {

	@Override
	public Product getProductWithCode(String code) throws SQLException {
		
		Product ret = null;
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		ret = em.find(Product.class, code);
		
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
		
		return ret;
	}

	@Override
	public Product getProductWithCodeAndName(String code, String name)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
