package com.project.setofskills.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "achievement_requirement")
public class AchievementRequirement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "achievement_id")
	private int achievementId;
	@Column(name = "skill_requirement_id")
	private int skillRequirementId;
	@Column(name = "date_started")
	private LocalDate dateStarted;
	@Column(name = "date_completed")
	private LocalDate dateCompleted;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAchievementId() {
		return achievementId;
	}
	public void setAchievementId(int achievementId) {
		this.achievementId = achievementId;
	}
	public int getSkillRequirementId() {
		return skillRequirementId;
	}
	public void setSkillRequirementId(int skillRequirementId) {
		this.skillRequirementId = skillRequirementId;
	}
	public LocalDate getDateStarted() {
		return dateStarted;
	}
	public void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}
	public LocalDate getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(LocalDate dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	public AchievementRequirement(int id, int achievementId, int skillRequirementId, LocalDate dateStarted,
			LocalDate dateCompleted) {
		super();
		this.id = id;
		this.achievementId = achievementId;
		this.skillRequirementId = skillRequirementId;
		this.dateStarted = dateStarted;
		this.dateCompleted = dateCompleted;
	}
	public AchievementRequirement(int achievementId, int skillRequirementId, LocalDate dateStarted,
			LocalDate dateCompleted) {
		super();
		this.achievementId = achievementId;
		this.skillRequirementId = skillRequirementId;
		this.dateStarted = dateStarted;
		this.dateCompleted = dateCompleted;
	}
	public AchievementRequirement() {
		super();
	}
	@Override
	public String toString() {
		return "AchievementRequirement [id=" + id + ", achievementId=" + achievementId + ", skillRequirementId="
				+ skillRequirementId + ", dateStarted=" + dateStarted + ", dateCompleted=" + dateCompleted + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + achievementId;
		result = prime * result + ((dateCompleted == null) ? 0 : dateCompleted.hashCode());
		result = prime * result + ((dateStarted == null) ? 0 : dateStarted.hashCode());
		result = prime * result + id;
		result = prime * result + skillRequirementId;
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
		AchievementRequirement other = (AchievementRequirement) obj;
		if (achievementId != other.achievementId)
			return false;
		if (dateCompleted == null) {
			if (other.dateCompleted != null)
				return false;
		} else if (!dateCompleted.equals(other.dateCompleted))
			return false;
		if (dateStarted == null) {
			if (other.dateStarted != null)
				return false;
		} else if (!dateStarted.equals(other.dateStarted))
			return false;
		if (id != other.id)
			return false;
		if (skillRequirementId != other.skillRequirementId)
			return false;
		return true;
	}
	
}
