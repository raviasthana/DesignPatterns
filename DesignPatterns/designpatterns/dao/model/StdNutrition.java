package dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StdNutrition")
public class StdNutrition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id private String code;
	private String unit;
	private BigDecimal amount;

	public void setCode(String code) {
		this.code = code;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "StdNutrition [code=" + code + ", unit=" + unit + ", amount="
				+ amount + "]";
	}
	
	
}
