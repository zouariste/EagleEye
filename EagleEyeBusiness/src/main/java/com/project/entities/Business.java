package com.project.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.Collection;
import java.util.Date;

/**
 * Product entity.
 */
@Entity

public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Version
	private Integer version;

    private String title;
	private String description;
	private String address;
	private String location;
	private Date startdate;
	private Date enddate;
	private Float cost;

	//title / description / address / location / startdate / enddate / cost / keywords
	@ElementCollection(targetClass = String.class)

	private Collection<String> keywords;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Float getCost() {
		return this.cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Collection<String> getKeywords() {
		return this.keywords;
	}

	public void setKeywords(Collection<String> keywords) {
		this.keywords = keywords;
	}


}
