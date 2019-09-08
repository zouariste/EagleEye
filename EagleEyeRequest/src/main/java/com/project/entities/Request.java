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

public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;


	
    private String name;	
	private String email;
	private String type;
	private Date dateexe;




	@ElementCollection(targetClass=String.class)

    private Collection<String> keywords;
	@ElementCollection(targetClass=String.class)

    private Collection<String> languages;
	public Date getDateexe() {
		return this.dateexe;
	}

	public void setDateexe(Date dateexe) {
		this.dateexe = dateexe;
	}
	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<String> getLanguages() {
		return this.languages;
	}

	public void setLanguages(Collection<String> languages) {
		this.languages = languages;
	}


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
    
    public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<String> getKeywords() {
		return this.keywords;
	}

	public void setKeywords(Collection<String> keywords) {
		this.keywords = keywords;
	}

	public Collection<String> getCountries() {
		return this.languages;
	}

	public void setCountries(Collection<String> languages) {
		this.languages = languages;
	}

	public String getName	() {
		return this.name	;
	}

	public void setName	(String name	) {
		this.name	 = name	;
	}
	public Request(Request r){
		this.dateexe=r.getDateexe();
		this.email=r.getEmail();
		this.name=r.getName();
		this.type=r.getType();
		this.id=r.getId();
		this.keywords=r.getKeywords();
		this.languages=r.getLanguages();
		this.version= r.getVersion();
	}

	public Request() {
	}

}
