package com.ims.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Items {
	@Column(name = "itm_id")
	private String itmId; 
	@Column(name = "itm_desc")
	private String itmDesc;
	@Column(name = "itm_actv")
	private String itmActv;
	@Column(name = "itm_created_dt")
	private String itmCreatedDt;
	@Column(name = "itm_cat_id")
	private int itmCatId;
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
	public String getItmCreatedDt() {
		return itmCreatedDt;
	}
	public void setItmCreatedDt(String itmCreatedDt) {
		this.itmCreatedDt = itmCreatedDt;
	}
	public int getItmCatId() {
		return itmCatId;
	}
	public void setItmCatId(int itmCatId) {
		this.itmCatId = itmCatId;
	}
}
