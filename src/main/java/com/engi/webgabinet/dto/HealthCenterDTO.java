package com.engi.webgabinet.dto;

public class HealthCenterDTO {
	private int healthCenterId;
	private String healthCenterName;
	private String address;
	private String cityCode;
	public int getHealthCenterId() { return healthCenterId; }
	public void setHealthCenterId(int id) {
		this.healthCenterId = id;
	}
	public String getHealthCenterName() {
		return healthCenterName;
	}
	public void setHealthCenterName(String name) {
		this.healthCenterName = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}
