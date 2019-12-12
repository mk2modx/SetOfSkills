package com.project.setofskills.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "achievement_requirement")
public class AchievementRequirement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(name = "achievement_id")
//	private int achievementId;
//	@Column(name = "skill_requirement_id")
//	private int skillRequirementId;
	@Column(name = "date_started")
	private LocalDate dateStarted;
	@Column(name = "date_completed")
	private LocalDate dateCompleted;
	
	@ManyToOne
	@JoinColumn(name = "achievement_id")
	private Achievement achievement;
	
	@ManyToOne
	@JoinColumn(name = "skill_requirement_id")
	private SkillRequirement skillReqs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Achievement getAchievement() {
		return achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public SkillRequirement getSkillReqs() {
		return skillReqs;
	}

	public void setSkillReqs(SkillRequirement skillReqs) {
		this.skillReqs = skillReqs;
	}

	public AchievementRequirement(int id, LocalDate dateStarted, LocalDate dateCompleted, Achievement achievement,
			SkillRequirement skillReqs) {
		super();
		this.id = id;
		this.dateStarted = dateStarted;
		this.dateCompleted = dateCompleted;
		this.achievement = achievement;
		this.skillReqs = skillReqs;
	}

	public AchievementRequirement(LocalDate dateStarted, LocalDate dateCompleted, Achievement achievement,
			SkillRequirement skillReqs) {
		super();
		this.dateStarted = dateStarted;
		this.dateCompleted = dateCompleted;
		this.achievement = achievement;
		this.skillReqs = skillReqs;
	}

	public AchievementRequirement() {
		super();
	}

	@Override
	public String toString() {
		return "AchievementRequirement [id=" + id + ", dateStarted=" + dateStarted + ", dateCompleted=" + dateCompleted
				+ ", achievement=" + achievement + ", skillReqs=" + skillReqs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achievement == null) ? 0 : achievement.hashCode());
		result = prime * result + ((dateCompleted == null) ? 0 : dateCompleted.hashCode());
		result = prime * result + ((dateStarted == null) ? 0 : dateStarted.hashCode());
		result = prime * result + id;
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
		AchievementRequirement other = (AchievementRequirement) obj;
		if (achievement == null) {
			if (other.achievement != null)
				return false;
		} else if (!achievement.equals(other.achievement))
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
		if (skillReqs == null) {
			if (other.skillReqs != null)
				return false;
		} else if (!skillReqs.equals(other.skillReqs))
			return false;
		return true;
	}
	
	
}
