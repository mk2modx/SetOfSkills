package com.project.setofskills.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skill_requirement")
public class SkillRequirement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(name = "requirement_id")
//	private int requirementId;
//	@Column(name = "skill_id")
//	private int skillId;
	@Column(name = "step_number")
	private int stepNumber;
	
	@OneToMany(mappedBy = "skillReqs")
	private List<AchievementRequirement> achievementReqs;
	
	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;
	
	@ManyToOne
	@JoinColumn(name = "requirement_id")
	private Requirement requirement;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}

	public List<AchievementRequirement> getAchievementReqs() {
		return achievementReqs;
	}

	public void setAchievementReqs(List<AchievementRequirement> achievementReqs) {
		this.achievementReqs = achievementReqs;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public SkillRequirement(int id, int stepNumber, List<AchievementRequirement> achievementReqs, Skill skill,
			Requirement requirement) {
		super();
		this.id = id;
		this.stepNumber = stepNumber;
		this.achievementReqs = achievementReqs;
		this.skill = skill;
		this.requirement = requirement;
	}

	public SkillRequirement(int stepNumber, List<AchievementRequirement> achievementReqs, Skill skill,
			Requirement requirement) {
		super();
		this.stepNumber = stepNumber;
		this.achievementReqs = achievementReqs;
		this.skill = skill;
		this.requirement = requirement;
	}

	public SkillRequirement() {
		super();
	}

	@Override
	public String toString() {
		return "SkillRequirement [id=" + id + ", stepNumber=" + stepNumber + ", achievementReqs=" + achievementReqs
				+ ", skill=" + skill + ", requirement=" + requirement + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achievementReqs == null) ? 0 : achievementReqs.hashCode());
		result = prime * result + id;
		result = prime * result + ((requirement == null) ? 0 : requirement.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + stepNumber;
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
		SkillRequirement other = (SkillRequirement) obj;
		if (achievementReqs == null) {
			if (other.achievementReqs != null)
				return false;
		} else if (!achievementReqs.equals(other.achievementReqs))
			return false;
		if (id != other.id)
			return false;
		if (requirement == null) {
			if (other.requirement != null)
				return false;
		} else if (!requirement.equals(other.requirement))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (stepNumber != other.stepNumber)
			return false;
		return true;
	}
	
	
	
}
