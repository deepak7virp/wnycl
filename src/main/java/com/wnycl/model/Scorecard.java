package com.wnycl.model;

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
@Table(name="score")
public class Scorecard {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private Match match;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private Player player;
	
	@NotEmpty
	@Column(name="runs", nullable=false)
	private Integer runsScored;
	
	@NotEmpty
	@Column(name="balls", nullable=false)
	private Integer ballsFaced;
	
	@NotEmpty
	@Column(name="overs", nullable=false)
	private Integer oversBowled;
	
	@NotEmpty
	@Column(name="wickets", nullable=false)
	private Integer wicketsTaken;
	
	@NotEmpty
	@Column(name="catches", nullable=false)
	private Integer catchesTaken;
	
	@NotEmpty
	@Column(name="stumps", nullable=false)
	private Integer stumps;
	
	@NotEmpty
	@Column(name="runouts", nullable=false)
	private Integer runouts;
	
	@NotEmpty
	@Column(name="fours", nullable=false)
	private Integer foursHit;
	
	@NotEmpty
	@Column(name="sixes", nullable=false)
	private Integer sixesHit;
	
	@NotEmpty
	@Column(name="extras", nullable=false)
	private Integer extrasGiven;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private WicketType wicket;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(Integer runsScored) {
		this.runsScored = runsScored;
	}

	public Integer getBallsFaced() {
		return ballsFaced;
	}

	public void setBallsFaced(Integer ballsFaced) {
		this.ballsFaced = ballsFaced;
	}

	public Integer getOversBowled() {
		return oversBowled;
	}

	public void setOversBowled(Integer oversBowled) {
		this.oversBowled = oversBowled;
	}

	public Integer getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(Integer wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public Integer getCatchesTaken() {
		return catchesTaken;
	}

	public void setCatchesTaken(Integer catchesTaken) {
		this.catchesTaken = catchesTaken;
	}

	public Integer getStumps() {
		return stumps;
	}

	public void setStumps(Integer stumps) {
		this.stumps = stumps;
	}

	public Integer getRunouts() {
		return runouts;
	}

	public void setRunouts(Integer runouts) {
		this.runouts = runouts;
	}

	public Integer getFoursHit() {
		return foursHit;
	}

	public void setFoursHit(Integer foursHit) {
		this.foursHit = foursHit;
	}

	public Integer getSixesHit() {
		return sixesHit;
	}

	public void setSixesHit(Integer sixesHit) {
		this.sixesHit = sixesHit;
	}

	public Integer getExtrasGiven() {
		return extrasGiven;
	}

	public void setExtrasGiven(Integer extrasGiven) {
		this.extrasGiven = extrasGiven;
	}

	public WicketType getWicket() {
		return wicket;
	}

	public void setWicket(WicketType wicket) {
		this.wicket = wicket;
	}
}
