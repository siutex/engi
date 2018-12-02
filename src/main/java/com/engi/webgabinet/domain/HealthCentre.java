package com.engi.webgabinet.domain;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="health_centre")
@NamedQueries({
		@NamedQuery(
				name = "findByHealthCenterName",
				query = "from HealthCentre u where u.name = :name"
		),
		@NamedQuery(
				name = "findAllHealthCenter",
				query = "from HealthCentre"
		),
		@NamedQuery(
				name = "findAllCountHealthCenter",
				query = "select count(d) from HealthCentre d"
		),
		@NamedQuery(
				name = "findByIdHealthCenter",
				query = "from HealthCentre h where h.id = :id"
		),
})

public class HealthCentre implements java.io.Serializable{

	private static final long serialVersionUID = 21L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "city_code")
	private String cityCode;
	@Column(name = "state_code")
	private String stateCode;
	@Column(name = "country_code")
	private String countryCode;
	@Column(name = "create_time")
	private Timestamp createTime;
	@Column(name = "last_updated")
	private Timestamp lastUpdated;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
