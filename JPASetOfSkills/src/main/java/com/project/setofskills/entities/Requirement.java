package com.project.setofskills.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Requirement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "requirement")
	private List<SkillRequirement> skillReqs;
	private int pointVal;
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
	public List<SkillRequirement> getSkillReqs() {
		return skillReqs;
	}
	public void setSkillReqs(List<SkillRequirement> skillReqs) {
		this.skillReqs = skillReqs;
	}
	public int getPointVal() {
		return pointVal;
	}
	public void setPointVal(int pointVal) {
		this.pointVal = pointVal;
	}
	public Requirement(int id, String name, String description, List<SkillRequirement> skillReqs, int pointVal) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.skillReqs = skillReqs;
		this.pointVal = pointVal;
	}
	public Requirement() {
		super();
	}
	public Requirement(String name, String description, List<SkillRequirement> skillReqs, int pointVal) {
		super();
		this.name = name;
		this.description = description;
		this.skillReqs = skillReqs;
		this.pointVal = pointVal;
	}
	@Override
	public String toString() {
		return "Requirement [id=" + id + ", name=" + name + ", description=" + description + ", skillReqs=" + skillReqs
				+ ", pointVal=" + pointVal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pointVal;
		result = prime * result + ((skillReqs == null) ? 0 : skillReqs.hashCode());
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
		Requirement other = (Requirement) obj;
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
		if (pointVal != other.pointVal)
			return false;
		if (skillReqs == null) {
			if (other.skillReqs != null)
				return false;
		} else if (!skillReqs.equals(other.skillReqs))
			return false;
		return true;
	}
	

	
}
