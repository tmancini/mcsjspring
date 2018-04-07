package com.edmundsassoc.mcsj.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tracking database table.
 * 
 */
@Entity
@NamedQuery(name="Tracking.findAll", query="SELECT t FROM Tracking t")
public class Tracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tracking_Id;

	private String descript;

	@Temporal(TemporalType.DATE)
	private Date end_Date;

	private BigDecimal estimated_Amt;

	@Temporal(TemporalType.DATE)
	private Date start_Date;

	private String status;

	public Tracking() {
	}

	public String getTracking_Id() {
		return this.tracking_Id;
	}

	public void setTracking_Id(String tracking_Id) {
		this.tracking_Id = tracking_Id;
	}

	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Date getEnd_Date() {
		return this.end_Date;
	}

	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}

	public BigDecimal getEstimated_Amt() {
		return this.estimated_Amt;
	}

	public void setEstimated_Amt(BigDecimal estimated_Amt) {
		this.estimated_Amt = estimated_Amt;
	}

	public Date getStart_Date() {
		return this.start_Date;
	}

	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}