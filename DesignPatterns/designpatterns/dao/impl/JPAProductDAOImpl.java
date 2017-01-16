package dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import dao.ProductDao;
import dao.model.Product;

public class JPAProductDAOImpl implements ProductDao {

	/*
	 * TODO @PersistenceContext is not working with current setup.
	 * make it work in SE setup
	 */
	//@PersistenceContext(type=PersistenceContextType.EXTENDED) 
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Product getProductWithCode(String code) throws SQLException {
		
		Product ret = null;
		
		entityManager.getTransaction().begin();
		
		ret = entityManager.find(Product.class, code);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
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
