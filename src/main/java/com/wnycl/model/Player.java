package com.wnycl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="player")
public class Player {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer playerid;
	
	@NotEmpty
	@Column(name="firstname", nullable=false)
	private String firstname;
	
	@NotEmpty
	@Column(name="lastname", nullable=false)
	private String lastname;
	
	@NotEmpty
	@Column(name="dob", columnDefinition="DATE", nullable=false)
	private Date dob;
	
	public Integer getPlayerid() {
		return playerid;
	}

	public void setPlayerid(Integer playerid) {
		this.playerid = playerid;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonIgnoreProperties(value={"captain"})
	private Team team;
	
	@NotEmpty
	@Column(name="email", nullable=false)
	private String email;
	
	@NotEmpty
	@Column(name="phone", nullable=false)
	private String phone;
	
	@NotEmpty
	@Column(name="active", nullable=false)
	private Integer active;


	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
