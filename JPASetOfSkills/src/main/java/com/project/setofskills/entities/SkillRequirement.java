package com.project.setofskills.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill_requirement")
public class SkillRequirement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "requirement_id")
	private int requirementId;
	@Column(name = "skill_id")
	private int skillId;
	@Column(name = "step_number")
	private int stepNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(int requirementId) {
		this.requirementId = requirementId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getStepNumber() {
		return stepNumber;
	}
	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}
	public SkillRequirement(int id, int requirementId, int skillId, int stepNumber) {
		super();
		this.id = id;
		this.requirementId = requirementId;
		this.skillId = skillId;
		this.stepNumber = stepNumber;
	}
	public SkillRequirement(int requirementId, int skillId, int stepNumber) {
		super();
		this.requirementId = requirementId;
		this.skillId = skillId;
		this.stepNumber = stepNumber;
	}
	public SkillRequirement() {
		super();
	}
	@Override
	public String toString() {
		return "SkillRequirement [id=" + id + ", requirementId=" + requirementId + ", skillId=" + skillId
				+ ", stepNumber=" + stepNumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + requirementId;
		result = prime * result + skillId;
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
		if (id != other.id)
			return false;
		if (requirementId != other.requirementId)
			return false;
		if (skillId != other.skillId)
			return false;
		if (stepNumber != other.stepNumber)
			return false;
		return true;
	}
	
}
