package com.TestManager.TestManager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestManager.TestManager.exception.projectNotFoundException;
import com.TestManager.TestManager.model.Projects;
import com.TestManager.TestManager.repo.ProjectRepo;

@Service
public class ProjectService {
	private final ProjectRepo projectRepo;

	@Autowired
	public ProjectService(ProjectRepo projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	public Projects addProject(Projects project) {
		project.setProjectCode(UUID.randomUUID().toString());
		return projectRepo.save(project);
	}
	
	public List<Projects> findAllProjects(){
		return projectRepo.findAll();
	}
	
	public Projects updateProject(Projects project) {
		return projectRepo.save(project);
	}
	
	public Projects findProjectById(Long projectId) {
		return projectRepo.findProjectById(projectId).orElseThrow(() -> new projectNotFoundException ("Project by id " + projectId +" is not found"));
	}
	
	public void deleteProject(Long projectId) {
		projectRepo.deleteProjectById(projectId);
	}
	
	
}
