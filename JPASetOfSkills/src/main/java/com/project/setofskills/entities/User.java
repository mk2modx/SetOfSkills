package com.project.setofskills.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean enabled;
	private String password;
	private String username;
	private String role;
	private String email;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private Achiever achiever;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Achiever getAchiever() {
		return achiever;
	}

	public void setAchiever(Achiever achiever) {
		this.achiever = achiever;
	}

	public User(int id, boolean enabled, String password, String username, String role, String email,
			Achiever achiever) {
		super();
		this.id = id;
		this.enabled = enabled;
		this.password = password;
		this.username = username;
		this.role = role;
		this.email = email;
		this.achiever = achiever;
	}

	public User(boolean enabled, String password, String username, String role, String email, Achiever achiever) {
		super();
		this.enabled = enabled;
		this.password = password;
		this.username = username;
		this.role = role;
		this.email = email;
		this.achiever = achiever;
	}

	public User() {
		super();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achiever == null) ? 0 : achiever.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (achiever == null) {
			if (other.achiever != null)
				return false;
		} else if (!achiever.equals(other.achiever))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", enabled=" + enabled + ", password=" + password + ", username=" + username
				+ ", role=" + role + ", email=" + email + "]";
	}
	
	
	
}
