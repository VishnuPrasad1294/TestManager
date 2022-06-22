package com.TestManager.TestManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projects implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long projectId;
	private String projectName;
	private String projectDescription;
	private String imageUrl;
	@Column(nullable = false, updatable = false)
	private String projectCode;
	
	public Projects() {}
	

	public Projects(Long projectId, String projectName, String projectDescription, String imageUrl, String projectCode) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.imageUrl = imageUrl;
		this.projectCode = projectCode;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", imageUrl=" + imageUrl + ", projectCode=" + projectCode + "]";
	}

}
