package dao;

import java.sql.SQLException;
import java.util.List;

import dao.model.Product;

public interface ProductDao {

	Product getProductWithCode(String code) throws SQLException;
	Product getProductWithCodeAndName(String code, String name) throws SQLException;
	List<Product> getAllProducts();
}
