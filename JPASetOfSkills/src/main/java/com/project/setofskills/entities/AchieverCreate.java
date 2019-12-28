package com.project.setofskills.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AchieverCreate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;	
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	private LocalDate age;
	@Column(name = "image_link")
	private String imageLink;
	private boolean enabled;
	private String password;
	private String username;
	private String role;
	private String email;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getAge() {
		return age;
	}
	public void setAge(LocalDate age) {
		this.age = age;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
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
	public AchieverCreate(int id, User user, String firstName, String lastName, LocalDate age, String imageLink,
			boolean enabled, String password, String username, String role, String email) {
		super();
		this.id = id;
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.imageLink = imageLink;
		this.enabled = enabled;
		this.password = password;
		this.username = username;
		this.role = role;
		this.email = email;
	}
	public AchieverCreate(User user, String firstName, String lastName, LocalDate age, String imageLink,
			boolean enabled, String password, String username, String role, String email) {
		super();
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.imageLink = imageLink;
		this.enabled = enabled;
		this.password = password;
		this.username = username;
		this.role = role;
		this.email = email;
	}
	public AchieverCreate() {
		super();
	}
	@Override
	public String toString() {
		return "AchieverCreate [id=" + id + ", user=" + user + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", imageLink=" + imageLink + ", enabled=" + enabled + ", password=" + password
				+ ", username=" + username + ", role=" + role + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((imageLink == null) ? 0 : imageLink.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		AchieverCreate other = (AchieverCreate) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (imageLink == null) {
			if (other.imageLink != null)
				return false;
		} else if (!imageLink.equals(other.imageLink))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
