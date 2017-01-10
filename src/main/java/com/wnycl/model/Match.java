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
@Table(name="match")
public class Match {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private Tournament tournament;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private Team homeTeam;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private Team awayTeam;
	
	@NotEmpty
	@Column(name="toss", nullable=false)
	private Integer toss;
	
	@NotEmpty
	@Column(name="date", columnDefinition="DATETIME", nullable=false)
	private Date date;
	
	@NotEmpty
	@Column(name="time", columnDefinition="DATETIME", nullable=false)
	private Date time;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private Status status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Integer getToss() {
		return toss;
	}

	public void setToss(Integer toss) {
		this.toss = toss;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

}
