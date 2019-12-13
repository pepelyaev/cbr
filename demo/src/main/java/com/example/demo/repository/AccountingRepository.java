package com.example.demo.repository;

import com.example.demo.model.AccountingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepository
			extends CrudRepository<AccountingEntity, Long> {
}
