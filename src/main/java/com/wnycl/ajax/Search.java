package com.wnycl.ajax;

public class Search {
	private boolean display;
    private boolean cdn;
    private boolean hosting;
    private boolean paas;
    private String whoisPattern;
    private long id;
    private String domain;
    private String name;
    private String desc;
    private String tags;
    private String affLink;
    private String imageUrl;
    private String favUrl;
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public boolean isCdn() {
		return cdn;
	}
	public void setCdn(boolean cdn) {
		this.cdn = cdn;
	}
	public boolean isHosting() {
		return hosting;
	}
	public void setHosting(boolean hosting) {
		this.hosting = hosting;
	}
	public boolean isPaas() {
		return paas;
	}
	public void setPaas(boolean paas) {
		this.paas = paas;
	}
	public String getWhoisPattern() {
		return whoisPattern;
	}
	public void setWhoisPattern(String whoisPattern) {
		this.whoisPattern = whoisPattern;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getAffLink() {
		return affLink;
	}
	public void setAffLink(String affLink) {
		this.affLink = affLink;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getFavUrl() {
		return favUrl;
	}
	public void setFavUrl(String favUrl) {
		this.favUrl = favUrl;
	}
}
