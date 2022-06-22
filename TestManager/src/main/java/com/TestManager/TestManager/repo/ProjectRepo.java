package com.TestManager.TestManager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TestManager.TestManager.model.Projects;

public interface ProjectRepo extends JpaRepository<Projects, Long>{

	void deleteProjectById(Long projectId);

	Optional<Projects> findProjectById(Long projectId);

	

}
