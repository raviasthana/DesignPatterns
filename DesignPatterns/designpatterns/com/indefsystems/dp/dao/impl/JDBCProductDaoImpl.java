package com.indefsystems.dp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.indefsystems.dp.dao.ProductDao;
import com.indefsystems.dp.dao.model.NutritionInfo;
import com.indefsystems.dp.dao.model.Product;
import com.indefsystems.dp.dao.model.StdNutrition;

public class JDBCProductDaoImpl implements ProductDao {

	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Product getProductWithCode(String code) throws SQLException {
		
		String sql = "Select * from Product where code = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, code);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			Product product = new Product();
			
			product.setCode(rs.getString("code"));
			product.setName(rs.getString("name"));
			product.setEntryDate(rs.getDate("EntryDate"));
			product.setAmount(rs.getBigDecimal("amount"));
			product.setUnit(rs.getString("unit"));
			product.setQuantity(rs.getInt("Quantity"));
			
			product.setStdNutrition(getStdNutrition(rs.getString("StdNutritionCode")));
			product.setNutritionInfoList(getProductNutritionInfo(product.getCode()));
			
			return product;
		}
		
		return null;
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

	private StdNutrition getStdNutrition(String stdCode) throws SQLException{
		
		String sql = "Select * from StdNutrition where code = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, stdCode);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			StdNutrition stdNutrition = new StdNutrition();
			
			stdNutrition.setCode(rs.getString("code"));
			stdNutrition.setUnit(rs.getString("unit"));
			stdNutrition.setAmount(rs.getBigDecimal("amount"));
			
			return stdNutrition;
		}
		
		return null;
	}
	
	private List<NutritionInfo> getProductNutritionInfo(String productCode) 
		throws SQLException {
		
		String sql = "Select * from NutritionInfo where ProductCode = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, productCode);
		
		ResultSet rs = ps.executeQuery();
		
		List<NutritionInfo> productNutritionInfoList = new ArrayList<NutritionInfo>();
		NutritionInfo pnInfo = null;
		
		while(rs.next()){
			pnInfo = new NutritionInfo();
			
			pnInfo.setProductCode(productCode);
			pnInfo.setName(rs.getString("name"));
			pnInfo.setAmount(rs.getBigDecimal("amount"));
			pnInfo.setUnit(rs.getString("unit"));
			
			productNutritionInfoList.add(pnInfo);
		}
		
		return productNutritionInfoList;
	}
}
