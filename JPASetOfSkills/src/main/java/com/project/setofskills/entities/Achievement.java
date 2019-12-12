package com.project.setofskills.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Achievement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(name = "skill_id")
//	private int skillId;
//	@Column(name = "achiever_id")
//	private int achieverId;
	@Column(name = "date_started")	
	private LocalDate dateStarted;
	
	@ManyToOne
	@JoinColumn(name = "achiever_id")
	private Achiever achiever;
	
	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;
	
	@OneToMany(mappedBy = "achievement")
	private List<AchievementRequirement> achievementReqs;

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

	public Achiever getAchiever() {
		return achiever;
	}

	public void setAchiever(Achiever achiever) {
		this.achiever = achiever;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public List<AchievementRequirement> getAchievementReqs() {
		return achievementReqs;
	}

	public void setAchievementReqs(List<AchievementRequirement> achievementReqs) {
		this.achievementReqs = achievementReqs;
	}

	public Achievement(int id, LocalDate dateStarted, Achiever achiever, Skill skill,
			List<AchievementRequirement> achievementReqs) {
		super();
		this.id = id;
		this.dateStarted = dateStarted;
		this.achiever = achiever;
		this.skill = skill;
		this.achievementReqs = achievementReqs;
	}

	public Achievement(LocalDate dateStarted, Achiever achiever, Skill skill,
			List<AchievementRequirement> achievementReqs) {
		super();
		this.dateStarted = dateStarted;
		this.achiever = achiever;
		this.skill = skill;
		this.achievementReqs = achievementReqs;
	}

	public Achievement() {
		super();
	}

	@Override
	public String toString() {
		return "Achievement [id=" + id + ", dateStarted=" + dateStarted + ", achiever=" + achiever + ", skill=" + skill
				+ ", achievementReqs=" + achievementReqs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achievementReqs == null) ? 0 : achievementReqs.hashCode());
		result = prime * result + ((achiever == null) ? 0 : achiever.hashCode());
		result = prime * result + ((dateStarted == null) ? 0 : dateStarted.hashCode());
		result = prime * result + id;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
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
		Achievement other = (Achievement) obj;
		if (achievementReqs == null) {
			if (other.achievementReqs != null)
				return false;
		} else if (!achievementReqs.equals(other.achievementReqs))
			return false;
		if (achiever == null) {
			if (other.achiever != null)
				return false;
		} else if (!achiever.equals(other.achiever))
			return false;
		if (dateStarted == null) {
			if (other.dateStarted != null)
				return false;
		} else if (!dateStarted.equals(other.dateStarted))
			return false;
		if (id != other.id)
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		return true;
	}
	
	
}
