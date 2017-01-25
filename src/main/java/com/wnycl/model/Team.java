package com.wnycl.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	@JsonIgnoreProperties(value={"team"})
	@OneToOne
    @JoinColumn(name="playerid")
	private Player captain;

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

	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player captain) {
		this.captain = captain;
	}
	
	
}
