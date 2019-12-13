package com.example.demo.repository;

import com.example.demo.model.WorkerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository
			extends CrudRepository<WorkerEntity, Long> {
}
