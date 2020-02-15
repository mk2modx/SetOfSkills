package com.project.setofskills.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToMany(mappedBy = "skill")
	@JsonIgnore
	private List<Achievement> achievements;
	@OneToMany(mappedBy = "skill")
	@JsonIgnore
	private List<SkillRequirement> skillReqs;
	@OneToMany(mappedBy = "skill")
	@JsonIgnore
	private List<Supplies> supplies;
	
	@ManyToMany(mappedBy = "skills")
	@JsonIgnore
	private List<Resource> resources;

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

	public List<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}

	public List<SkillRequirement> getSkillReqs() {
		return skillReqs;
	}

	public void setSkillReqs(List<SkillRequirement> skillReqs) {
		this.skillReqs = skillReqs;
	}

	public List<Supplies> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supplies> supplies) {
		this.supplies = supplies;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Skill(int id, String name, String description, String summary, int preReq, List<Achievement> achievements,
			List<SkillRequirement> skillReqs, List<Supplies> supplies, List<Resource> resources) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.summary = summary;
		this.preReq = preReq;
		this.achievements = achievements;
		this.skillReqs = skillReqs;
		this.supplies = supplies;
		this.resources = resources;
	}

	public Skill(String name, String description, String summary, int preReq, List<Achievement> achievements,
			List<SkillRequirement> skillReqs, List<Supplies> supplies, List<Resource> resources) {
		super();
		this.name = name;
		this.description = description;
		this.summary = summary;
		this.preReq = preReq;
		this.achievements = achievements;
		this.skillReqs = skillReqs;
		this.supplies = supplies;
		this.resources = resources;
	}

	public Skill() {
		super();
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", description=" + description + ", summary=" + summary
				+ ", preReq=" + preReq + ", achievements=" + achievements + ", skillReqs=" + skillReqs + ", supplies="
				+ supplies + ", resources=" + resources + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achievements == null) ? 0 : achievements.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + preReq;
		result = prime * result + ((resources == null) ? 0 : resources.hashCode());
		result = prime * result + ((skillReqs == null) ? 0 : skillReqs.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((supplies == null) ? 0 : supplies.hashCode());
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
		if (achievements == null) {
			if (other.achievements != null)
				return false;
		} else if (!achievements.equals(other.achievements))
			return false;
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
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		if (skillReqs == null) {
			if (other.skillReqs != null)
				return false;
		} else if (!skillReqs.equals(other.skillReqs))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (supplies == null) {
			if (other.supplies != null)
				return false;
		} else if (!supplies.equals(other.supplies))
			return false;
		return true;
	}
	
	
	
	
	
}
