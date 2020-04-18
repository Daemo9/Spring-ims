package com.ims.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "items")
public class Items {
	@Id
	@Column(name = "itm_id")
	private String itmId;
	@Column(name = "itm_desc")
	private String itmDesc;
	@Column(name = "itm_actv")
	private String itmActv;
	@Column(name = "itm_created_dt")
	private Date itmCreatedDt;
	@Column(name = "itm_cat_id")
	private int itmCatId;
	@Transient
	private int srNo;
	@Transient
	private String catName;

	/*
	 * public Items(int srNo,String itmId, String itmDesc, String itmActv, Date
	 * itmCreatedDt, String catName) { super(); this.itmId = itmId; this.itmDesc =
	 * itmDesc; this.itmActv = itmActv; this.itmCreatedDt = itmCreatedDt;
	 * this.itmCatId = itmCatId; this.srNo = srNo; this.catName = catName; }
	 */

	public String getItmId() {
		return itmId;
	}

	public void setItmId(String itmId) {
		this.itmId = itmId;
	}

	public String getItmDesc() {
		return itmDesc;
	}

	public void setItmDesc(String itmDesc) {
		this.itmDesc = itmDesc;
	}

	public String getItmActv() {
		return itmActv;
	}

	public void setItmActv(String itmActv) {
		this.itmActv = itmActv;
	}

	public Date getItmCreatedDt() {
		return itmCreatedDt;
	}

	public void setItmCreatedDt(Date itmCreatedDt) {
		this.itmCreatedDt = itmCreatedDt;
	}

	public int getItmCatId() {
		return itmCatId;
	}

	public void setItmCatId(int itmCatId) {
		this.itmCatId = itmCatId;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

}
