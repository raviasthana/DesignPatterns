package com.indefsystems.dp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id private String code;
    private String name;
    private Timestamp entryDate;
    private BigDecimal amount;
    private String unit;
    private int quantity;
    @OneToOne
    @JoinColumn(name="code")
    private StdNutrition stdNutrition;
    
    @OneToMany(fetch=FetchType.EAGER) //TODO remove EAGER and make it work for lazy loading
    @JoinColumn(name="ProductCode")
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
	public Timestamp getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Timestamp entryDate) {
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
