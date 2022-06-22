package com.TestManager.TestManager.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestManager.TestManager.exception.projectNotFoundException;
import com.TestManager.TestManager.model.Projects;
import com.TestManager.TestManager.repo.ProjectRepo;

@Service
@Transactional
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
	
	public Projects findProjectById(Long id) {
		return projectRepo.findProjectById(id).orElseThrow(() -> new projectNotFoundException ("Project by id " + id +" is not found"));
	}
	
	public void deleteProjectByID(Long id) {
		projectRepo.deleteProjectById(id);
	}
	
	
}
