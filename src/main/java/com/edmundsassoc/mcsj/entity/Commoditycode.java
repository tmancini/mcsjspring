package com.edmundsassoc.mcsj.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the commoditycode database table.
 * 
 */
@Entity
@NamedQuery(name="Commoditycode.findAll", query="SELECT c FROM Commoditycode c")
public class Commoditycode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String commodity_Code;

	private String descript;

	public Commoditycode() {
	}

	public String getCommodity_Code() {
		return this.commodity_Code;
	}

	public void setCommodity_Code(String commodity_Code) {
		this.commodity_Code = commodity_Code;
	}

	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}