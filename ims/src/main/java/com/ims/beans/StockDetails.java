package com.ims.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StockDetails")
public class StockDetails {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	
	@Column(name = "ItemId")
	private String itemId;
	
	@Column(name = "AddedDAte")
	private Timestamp addedDAte;
	
	@Column(name = "UpdatedDAte")
	private Timestamp updatedDAte;
	
	@Column(name = "AvailableStk")
	private Number availableStk;
	
	@Column(name = "ConsumedStk")
	private Number consumedStk;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Timestamp getAddedDAte() {
		return addedDAte;
	}
	public void setAddedDAte(Timestamp addedDAte) {
		this.addedDAte = addedDAte;
	}
	public Timestamp getUpdatedDAte() {
		return updatedDAte;
	}
	public void setUpdatedDAte(Timestamp updatedDAte) {
		this.updatedDAte = updatedDAte;
	}
	public Number getAvailableStk() {
		return availableStk;
	}
	public void setAvailableStk(Number availableStk) {
		this.availableStk = availableStk;
	}
	public Number getConsumedStk() {
		return consumedStk;
	}
	public void setConsumedStk(Number consumedStk) {
		this.consumedStk = consumedStk;
	}
	
}
