package com.project.setofskills.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String summary;
	@Column(name = "prerequisite_skill_id")
	private int preReq;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getPreReq() {
		return preReq;
	}
	public void setPreReq(int preReq) {
		this.preReq = preReq;
	}
	public Skill(int id, String name, String description, String summary, int preReq) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.summary = summary;
		this.preReq = preReq;
	}
	public Skill(String name, String description, String summary, int preReq) {
		super();
		this.name = name;
		this.description = description;
		this.summary = summary;
		this.preReq = preReq;
	}
	public Skill() {
		super();
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", description=" + description + ", summary=" + summary
				+ ", preReq=" + preReq + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + preReq;
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (preReq != other.preReq)
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}
	
}
