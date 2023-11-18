package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class favouriteCrossing
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "crossingId ")	
	private railwayCrossingData railwayCrossing;
	public int getFavId() {
		return favId;
	}
	public void setFavId(int favId) {
		this.favId = favId;
	}
	public railwayCrossingData getRailwayCrossing() {
		return railwayCrossing;
	}
	public void setRailwayCrossing(railwayCrossingData railwayCrossing) {
		this.railwayCrossing = railwayCrossing;
	}
	
	
	
}
