package com.project.setofskills.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Achievement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "skill_id")
	private int skillId;
	@Column(name = "achiever_id")
	private int achieverId;
	@Column(name = "date_started")	
	private LocalDate dateStarted;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getAchieverId() {
		return achieverId;
	}
	public void setAchieverId(int achieverId) {
		this.achieverId = achieverId;
	}
	public LocalDate getDateStarted() {
		return dateStarted;
	}
	public void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}
	@Override
	public String toString() {
		return "Achievement [id=" + id + ", skillId=" + skillId + ", achieverId=" + achieverId + ", dateStarted="
				+ dateStarted + "]";
	}
	public Achievement(int id, int skillId, int achieverId, LocalDate dateStarted) {
		super();
		this.id = id;
		this.skillId = skillId;
		this.achieverId = achieverId;
		this.dateStarted = dateStarted;
	}
	public Achievement(int skillId, int achieverId, LocalDate dateStarted) {
		super();
		this.skillId = skillId;
		this.achieverId = achieverId;
		this.dateStarted = dateStarted;
	}
	public Achievement() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + achieverId;
		result = prime * result + ((dateStarted == null) ? 0 : dateStarted.hashCode());
		result = prime * result + id;
		result = prime * result + skillId;
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
		if (achieverId != other.achieverId)
			return false;
		if (dateStarted == null) {
			if (other.dateStarted != null)
				return false;
		} else if (!dateStarted.equals(other.dateStarted))
			return false;
		if (id != other.id)
			return false;
		if (skillId != other.skillId)
			return false;
		return true;
	}
	
}
