package com.example.demo.service;

import com.example.demo.model.WorkerEntity;
import com.example.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerService {
	
	@Autowired
	WorkerRepository repository;
	
	public List<WorkerEntity> getAllWorkers()
	{
		List<WorkerEntity> result = (List<WorkerEntity>) repository.findAll();
		if(result.size() > 0) {
			return result;
		}
		return new ArrayList<WorkerEntity>();
	}
}