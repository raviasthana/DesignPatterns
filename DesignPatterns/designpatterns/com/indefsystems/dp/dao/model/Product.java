package com.indefsystems.dp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String code;
    private String name;
    private Date entryDate;
    private BigDecimal amount;
    private String unit;
    private int quantity;
    private StdNutrition stdNutrition;
    private List<NutritionInfo> nutritionInfoList;
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public StdNutrition getStdNutrition() {
		return stdNutrition;
	}
	public void setStdNutrition(StdNutrition stdNutrition) {
		this.stdNutrition = stdNutrition;
	}
	public List<NutritionInfo> getNutritionInfoList() {
		return nutritionInfoList;
	}
	public void setNutritionInfoList(List<NutritionInfo> nutritionInfoList) {
		this.nutritionInfoList = nutritionInfoList;
	}
    
}
