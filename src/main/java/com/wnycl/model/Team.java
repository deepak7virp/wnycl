package com.wnycl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="team")
public class Team {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer teamid;
	
	@NotEmpty
	@Column(name="name", nullable=false)
	private String name;
	
	@NotEmpty
	@Column(name="city", nullable=false)
	private String city;
	
	@NotEmpty
	@Column(name="captainid", nullable=false)
	private Integer captainid;

	public Integer getTeamid() {
		return teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCaptainid() {
		return captainid;
	}

	public void setCaptainid(Integer captainid) {
		this.captainid = captainid;
	}
	
	
}
