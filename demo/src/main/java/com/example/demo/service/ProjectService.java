package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.ProjectEntity;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository repository;
	
	public List<ProjectEntity> getAllProjects()
	{
		List<ProjectEntity> result = (List<ProjectEntity>) repository.findAll();
		if(result.size() > 0) {
			return result;
		}
		return new ArrayList<ProjectEntity>();
	}
}