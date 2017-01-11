package com.wnycl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="venue")
public class Venue {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer venueid;
	
	@NotEmpty
	@Column(name="name", nullable=false)
	private String name;
	
	@NotEmpty
	@Column(name="location", nullable=false)
	private String location;
	
	@NotEmpty
	@Column(name="incharge", nullable=false)
	private String incharge;
	
	@NotEmpty
	@Column(name="phone", nullable=false)
	private String phone;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIncharge() {
		return incharge;
	}

	public void setIncharge(String incharge) {
		this.incharge = incharge;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

}
