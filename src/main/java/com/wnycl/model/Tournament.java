package com.wnycl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tournament")
public class Tournament {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tourid;
	
	@NotEmpty
	@Column(name="name", nullable=false)
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "venueid")
	private Venue venue;
	
	@NotEmpty
	@Column(name="startdate", columnDefinition="DATE", nullable=false)
	private Date startTime;
	
	@NotEmpty
	@Column(name="enddate", columnDefinition="DATE", nullable=false)
	private Date endDate;
	
	@NotEmpty
	@Column(name="teamcount", nullable=false)
	private Integer teamCount;
	
	@NotEmpty
	@Column(name="playerscount", nullable=false)
	private Integer playersCount;

	

	public Integer getTourid() {
		return tourid;
	}

	public void setTourid(Integer tourid) {
		this.tourid = tourid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getTeamCount() {
		return teamCount;
	}

	public void setTeamCount(Integer teamCount) {
		this.teamCount = teamCount;
	}

	public Integer getPlayersCount() {
		return playersCount;
	}

	public void setPlayersCount(Integer playersCount) {
		this.playersCount = playersCount;
	}

	
}
