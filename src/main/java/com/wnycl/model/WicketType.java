package com.wnycl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="wickettype")
public class WicketType {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer wicketid;
	
	@NotEmpty
	@Column(name="desc", nullable=false)
	private String desc;

	

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
