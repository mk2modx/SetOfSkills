package com.project.setofskills.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name = "image_link")
	private String imageLink;
	@Column(name = "video_link")
	private String videoLink;
	@Column(name = "site_link")
	private String siteLink;
	
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
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public String getSiteLink() {
		return siteLink;
	}
	public void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
	}
	public Resource(int id, String name, String imageLink, String videoLink, String siteLink) {
		super();
		this.id = id;
		this.name = name;
		this.imageLink = imageLink;
		this.videoLink = videoLink;
		this.siteLink = siteLink;
	}
	public Resource(String name, String imageLink, String videoLink, String siteLink) {
		super();
		this.name = name;
		this.imageLink = imageLink;
		this.videoLink = videoLink;
		this.siteLink = siteLink;
	}
	public Resource() {
		super();
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", imageLink=" + imageLink + ", videoLink=" + videoLink
				+ ", siteLink=" + siteLink + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((imageLink == null) ? 0 : imageLink.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((siteLink == null) ? 0 : siteLink.hashCode());
		result = prime * result + ((videoLink == null) ? 0 : videoLink.hashCode());
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
		Resource other = (Resource) obj;
		if (id != other.id)
			return false;
		if (imageLink == null) {
			if (other.imageLink != null)
				return false;
		} else if (!imageLink.equals(other.imageLink))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (siteLink == null) {
			if (other.siteLink != null)
				return false;
		} else if (!siteLink.equals(other.siteLink))
			return false;
		if (videoLink == null) {
			if (other.videoLink != null)
				return false;
		} else if (!videoLink.equals(other.videoLink))
			return false;
		return true;
	}
	
}
