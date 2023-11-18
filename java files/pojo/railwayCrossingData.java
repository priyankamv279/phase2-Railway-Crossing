package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.*;
@Entity
public class railwayCrossingData
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int crossingId;
	
	private String crossingName;
	private String address;
	private String landmark;
	private LocalTime trainSchedule;
	private String personInCharge;
	private String statusCrossing;
	
	
	public int getCrossingId() {
		return crossingId;
	}
	public void setCrossingId(int crossingId) {
		this.crossingId = crossingId;
	}
	public String getCrossingName() {
		return crossingName;
	}
	public void setCrossingName(String crossingName) {
		this.crossingName = crossingName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public LocalTime getTrainSchedule() {
		return trainSchedule;
	}
	public void setTrainSchedule(LocalTime trainSchedule) {
		this.trainSchedule = trainSchedule;
	}
	public String getPersonInCharge() {
		return personInCharge;
	}
	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}
	public String getStatusCrossing() {
		return statusCrossing;
	}
	public void setStatusCrossing(String statusCrossing) {
		this.statusCrossing = statusCrossing;
	}
	
	
}
