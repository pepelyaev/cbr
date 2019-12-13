package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.AccountingEntity;
import com.example.demo.repository.AccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AccountingService {
	
	@Autowired
	AccountingRepository repository;

	public List<AccountingEntity> getAccountingFilter(Long id)
	{
		List<AccountingEntity> results = (List<AccountingEntity>) repository.findAll();
		if (results.size() > 0) {
			if (id != null && id > 0L) {
				Iterator<AccountingEntity> iterator = results.iterator();
				while (iterator.hasNext()) {
					AccountingEntity accounting = iterator.next();
					if (id != accounting.getWorkerId()) {
						iterator.remove();
					}
				}
			}
			return results;
		}
		return new ArrayList<AccountingEntity>();
	}
	
	public AccountingEntity getAccountingById(Long id) throws RecordNotFoundException
	{
		Optional<AccountingEntity> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		throw new RecordNotFoundException("No accounting record exist for given id");
	}
	
	public AccountingEntity accountingCreateOrUpdate(AccountingEntity entity)
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			return entity;
		} 
		else 
		{
			Optional<AccountingEntity> accounting = repository.findById(entity.getId());
			if(accounting.isPresent())
			{
				AccountingEntity newEntity = accounting.get();
				newEntity.setProjectId(entity.getProjectId());
				newEntity.setWorkerId(entity.getWorkerId());
				newEntity.setTask(entity.getTask());
				newEntity.setDate(entity.getDate());
				newEntity.setHms(entity.getHms());
				newEntity = repository.save(newEntity);
				return newEntity;
			}
			entity = repository.save(entity);
			return entity;
		}
	} 
	
	public void deleteAccountingById(Long id) throws RecordNotFoundException
	{
		Optional<AccountingEntity> result = repository.findById(id);
		
		if(result.isPresent())
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No accounting record exist for given id");
		}
	} 
}