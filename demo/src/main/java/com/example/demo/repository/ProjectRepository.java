package com.example.demo.repository;

import com.example.demo.model.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository
			extends CrudRepository<ProjectEntity, Long> {
}
