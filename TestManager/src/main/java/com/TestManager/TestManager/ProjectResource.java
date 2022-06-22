package com.TestManager.TestManager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TestManager.TestManager.model.Projects;
import com.TestManager.TestManager.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectResource {
	private final ProjectService projectService;

	public ProjectResource(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Projects>> getAllProjects() {
		List<Projects> projects = projectService.findAllProjects();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}

	@GetMapping("/find/{projectId}")
	public ResponseEntity<Projects> getProjectById(@PathVariable("projectId") Long projectId) {
		Projects project = projectService.findProjectById(projectId);
		return new ResponseEntity<>(project, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Projects> addProject(@RequestBody Projects project) {
		Projects newProject = projectService.addProject(project);
		return new ResponseEntity<>(newProject, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Projects> updateProject(@RequestBody Projects project) {
		Projects newProject = projectService.updateProject(project);
		return new ResponseEntity<>(newProject, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{projectId}")
	public ResponseEntity<Projects> deleteEmployee(@PathVariable("projectId") Long projectId) {
		projectService.deleteProject(projectId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
