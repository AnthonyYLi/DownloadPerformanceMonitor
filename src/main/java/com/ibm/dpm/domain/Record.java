package com.ibm.dpm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dpm_record")
public class Record{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tested_by") 
	private String testedBy;
	
	@Column(name = "tested_on") 
	private Date testedOn;
	
	@Column(name = "country") 
	private String country;
	
	@Column(name = "location") 
	private String location;
	
	@Column(name = "isvpn") 
	private boolean isvpn;
	
	@Column(name = "download_type") 
	private String downloadType;
	
	@Column(name = "download_speed") 
	private Long downloadSpeed;
	
	public Record() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTestedBy() {
		return testedBy;
	}

	public void setTestedBy(String testedBy) {
		this.testedBy = testedBy;
	}

	public Date getTestedOn() {
		return testedOn;
	}

	public void setTestedOn(Date testedOn) {
		this.testedOn = testedOn;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isIsvpn() {
		return isvpn;
	}

	public void setIsvpn(boolean isvpn) {
		this.isvpn = isvpn;
	}

	public String getDownloadType() {
		return downloadType;
	}

	public void setDownloadType(String downloadtype) {
		this.downloadType = downloadtype;
	}

	public Long getDownloadSpeed() {
		return downloadSpeed;
	}

	public void setDownloadSpeed(Long downloadspeed) {
		this.downloadSpeed = downloadspeed;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", testedBy=" + testedBy + ", testedOn=" + testedOn + ", country=" + country
				+ ", location=" + location + ", isvpn=" + isvpn + ", downloadType=" + downloadType + ", downloadSpeed="
				+ downloadSpeed + "]";
	}
	
}
